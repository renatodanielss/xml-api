package br.com.xml.service.impl;

import br.com.xml.dto.AgenteDTO;
import br.com.xml.dto.AgentesDTO;
import br.com.xml.dto.RegiaoDTO;
import br.com.xml.mapper.AgentesMapper;
import br.com.xml.model.*;
import br.com.xml.repository.AgentesRepository;
import br.com.xml.repository.CompraValorRepository;
import br.com.xml.repository.GeracaoValorRepository;
import br.com.xml.repository.PrecoMedioValorRepository;
import br.com.xml.service.IAgentesService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AgentesService implements IAgentesService {

    private final AgentesRepository agentesRepository;
    private final GeracaoValorRepository geracaoValorRepository;
    private final CompraValorRepository compraValorRepository;
    private final PrecoMedioValorRepository precoMedioValorRepository;
    private final AgenteService agenteService;
    private final RegiaoService regiaoService;
    private final AgentesMapper agentesMapper;

    @Autowired
    public AgentesService(AgentesRepository agentesRepository, GeracaoValorRepository geracaoValorRepository,
                          CompraValorRepository compraValorRepository, PrecoMedioValorRepository precoMedioValorRepository,
                          AgenteService agenteService, RegiaoService regiaoService, AgentesMapper agentesMapper) {
        this.agentesRepository = agentesRepository;
        this.geracaoValorRepository = geracaoValorRepository;
        this.compraValorRepository = compraValorRepository;
        this.precoMedioValorRepository = precoMedioValorRepository;
        this.agenteService = agenteService;
        this.regiaoService = regiaoService;
        this.agentesMapper = agentesMapper;
    }

    @Transactional
    @Override
    public void processarXml(MultipartFile xmlMultipartFile) throws IOException {
        String xmlContent = new String(xmlMultipartFile.getBytes(), StandardCharsets.UTF_8);

        XmlMapper xmlMapper = new XmlMapper();
        AgentesDTO agentesDTO = xmlMapper.readValue(xmlContent, AgentesDTO.class);
        Agentes agentesEnt = new Agentes();
        this.agentesMapper.dtoToEntityIgnoreNullValues(agentesEnt, agentesDTO);
        agentesEnt = this.agentesRepository.save(agentesEnt);

        List<Agente> agentes = this.agenteService.saveAgentes(agentesDTO.getAgentes(), agentesEnt);

        List<RegiaoDTO> regiaoDTOs = new ArrayList<>();
        for (int i = 0; i < agentes.size(); i++) {
            AgenteDTO agenteDTO = agentesDTO.getAgentes().get(i);
            Agente agente = agentes.get(i);
            for (RegiaoDTO regiaoDTO : agenteDTO.getRegioes()) {
                regiaoDTO.setAgente(agente);
                regiaoDTOs.add(regiaoDTO);
            }
        }
        List<Regiao> regioes = this.regiaoService.saveRegioes(regiaoDTOs);

        List<GeracaoValor> geracaoValores = new ArrayList<>();
        List<CompraValor> compraValores = new ArrayList<>();
        List<PrecoMedioValor> precoMedioValores = new ArrayList<>();
        for (int i = 0; i < regiaoDTOs.size(); i++) {
            RegiaoDTO regiaoDTO = regiaoDTOs.get(i);
            Regiao regiao = regioes.get(i);
            for (Double valor : regiaoDTO.getGeracao().getValores()) {
                GeracaoValor geracaoValor = new GeracaoValor(regiaoDTO.getGeracao().getCodigo(), valor, regiao);
                geracaoValores.add(geracaoValor);
            }
            for (Double valor : regiaoDTO.getCompra().getValores()) {
                CompraValor compraValor = new CompraValor(regiaoDTO.getCompra().getCodigo(), valor, regiao);
                compraValores.add(compraValor);
            }
            for (Double valor : regiaoDTO.getPrecoMedio().getValores()) {
                PrecoMedioValor precoMedioValor = new PrecoMedioValor(regiaoDTO.getPrecoMedio().getCodigo(), valor, regiao);
                precoMedioValores.add(precoMedioValor);
            }
        }
        this.geracaoValorRepository.saveAll(geracaoValores);
        this.compraValorRepository.saveAll(compraValores);
        this.precoMedioValorRepository.saveAll(precoMedioValores);
    }
}

package br.com.xml.service.impl;

import br.com.xml.dto.AgenteDTO;
import br.com.xml.mapper.AgenteMapper;
import br.com.xml.model.Agente;
import br.com.xml.model.Agentes;
import br.com.xml.repository.AgenteRepository;
import br.com.xml.service.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AgenteService implements IAgenteService {

    private final AgenteRepository agenteRepository;
    private final AgenteMapper agenteMapper;

    @Autowired
    public AgenteService(AgenteRepository agenteRepository, AgenteMapper agenteMapper) {
        this.agenteRepository = agenteRepository;
        this.agenteMapper = agenteMapper;
    }

    @Transactional
    @Override
    public List<Agente> saveAgentes(List<AgenteDTO> agenteDTOs, Agentes agentesEnt) {
        List <Agente> agentes = new ArrayList<>();
        for (int i = 0; i < agenteDTOs.size(); i++) {
            AgenteDTO agenteDTO = agenteDTOs.get(i);
            System.out.println(String.format("Código do agente: %d", agenteDTO.getCodigo()));
            Agente agente = new Agente();

            this.agenteMapper.dtoToEntityIgnoreNullValues(agente, agenteDTO);

            agente.setAgentes(agentesEnt);
            agentes.add(agente);
        }
        return this.agenteRepository.saveAll(agentes);
    }
}

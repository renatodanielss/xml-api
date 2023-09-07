package br.com.xml.service.impl;

import br.com.xml.dto.RegiaoConsolidatedDTO;
import br.com.xml.dto.RegiaoDTO;
import br.com.xml.mapper.RegiaoMapper;
import br.com.xml.model.Regiao;
import br.com.xml.repository.RegiaoRepository;
import br.com.xml.service.IRegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RegiaoService implements IRegiaoService {

    private final RegiaoRepository regiaoRepository;
    private final RegiaoMapper regiaoMapper;

    @Autowired
    public RegiaoService(RegiaoRepository regiaoRepository, RegiaoMapper regiaoMapper) {
        this.regiaoRepository = regiaoRepository;
        this.regiaoMapper = regiaoMapper;
    }

    @Transactional
    @Override
    public List<RegiaoConsolidatedDTO> getConcolidatedByRegiao() {
        return regiaoRepository.getConcolidatedByRegiao();
    }

    @Transactional
    @Override
    public List<Regiao> saveRegioes(List<RegiaoDTO> regiaoDTOs) {
        List <Regiao> regioes = new ArrayList<>();
        for (int i = 0; i < regiaoDTOs.size(); i++) {
            RegiaoDTO regiaoDTO = regiaoDTOs.get(i);
            Regiao regiao = new Regiao();

            this.regiaoMapper.dtoToEntityIgnoreNullValues(regiao, regiaoDTO);
            regioes.add(regiao);
        }
        return this.regiaoRepository.saveAll(regioes);
    }
}

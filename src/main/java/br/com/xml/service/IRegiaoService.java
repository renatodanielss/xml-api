package br.com.xml.service;

import br.com.xml.dto.RegiaoConsolidatedDTO;
import br.com.xml.dto.RegiaoDTO;
import br.com.xml.model.Regiao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRegiaoService {
    List<RegiaoConsolidatedDTO> getConcolidatedByRegiao();
    List<Regiao> saveRegioes(List<RegiaoDTO> regiaoDTOs);
}

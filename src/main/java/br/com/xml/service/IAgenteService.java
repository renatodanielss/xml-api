package br.com.xml.service;

import br.com.xml.dto.AgenteDTO;
import br.com.xml.model.Agente;
import br.com.xml.model.Agentes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAgenteService {
    List<Agente> saveAgentes(List<AgenteDTO> agenteDTOs, Agentes agentesEnt);
}

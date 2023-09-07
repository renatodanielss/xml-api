package br.com.xml.repository;

import br.com.xml.model.Agentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentesRepository extends JpaRepository<Agentes, Integer> {

}

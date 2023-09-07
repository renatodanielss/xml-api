package br.com.xml.repository;

import br.com.xml.model.GeracaoValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeracaoValorRepository extends JpaRepository<GeracaoValor, Integer> {

}

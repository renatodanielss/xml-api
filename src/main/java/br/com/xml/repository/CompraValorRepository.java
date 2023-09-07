package br.com.xml.repository;

import br.com.xml.model.CompraValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraValorRepository extends JpaRepository<CompraValor, Integer> {

}

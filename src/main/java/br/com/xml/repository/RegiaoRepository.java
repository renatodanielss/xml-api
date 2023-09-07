package br.com.xml.repository;

import br.com.xml.dto.RegiaoConsolidatedDTO;
import br.com.xml.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {
    @Query("select new br.com.xml.dto.RegiaoConsolidatedDTO(r.sigla, avg(gv.valor), avg(cv.valor), avg(pmv.valor)) from Regiao r " +
            "inner join GeracaoValor gv on gv.regiao.codigo = r.codigo " +
            "inner join CompraValor cv on cv.regiao.codigo = r.codigo " +
            "inner join PrecoMedioValor pmv on pmv.regiao.codigo = r.codigo " +
            "group by r.sigla")
    List<RegiaoConsolidatedDTO> getConcolidatedByRegiao();
}

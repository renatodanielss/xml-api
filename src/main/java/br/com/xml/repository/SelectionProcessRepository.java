package br.com.xml.repository;

import br.com.xml.model.SelectionProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"unused", "SqlDialectInspection", "SqlNoDataSourceInspection", "SpringDataRepositoryMethodReturnTypeInspection"})
@Repository
public interface SelectionProcessRepository extends JpaRepository<SelectionProcess, Integer> {

    @Query("SELECT sp FROM SelectionProcess sp WHERE LOWER(sp.selectionProcessName) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<SelectionProcess> findAll(@Param("search") String search, Pageable pageable);
}

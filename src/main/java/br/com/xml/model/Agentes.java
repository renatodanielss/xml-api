package br.com.xml.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agentes")
    @JsonManagedReference
    private List<Agente> agentes;

    @Column(name = "versao")
    private String versao;
}

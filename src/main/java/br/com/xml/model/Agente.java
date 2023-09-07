package br.com.xml.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "agente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agente")
    @JsonManagedReference
    private List<Regiao> regioes;

    @ManyToOne
    @JoinColumn(name = "agentes_codigo")
    @JsonBackReference
    private Agentes agentes;
}

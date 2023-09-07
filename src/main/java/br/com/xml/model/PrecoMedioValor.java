package br.com.xml.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "preco_medio_valor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecoMedioValor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "regiao_codigo")
    @JsonBackReference
    private Regiao regiao;
}

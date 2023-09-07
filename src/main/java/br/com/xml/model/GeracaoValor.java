package br.com.xml.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "geracao_valor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeracaoValor {

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

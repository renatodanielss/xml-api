package br.com.xml.dto;

import br.com.xml.model.Agente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "regiao")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegiaoDTO {
    @JacksonXmlProperty(localName = "geracao")
    private GeracaoDTO geracao;

    @JacksonXmlProperty(localName = "compra")
    private CompraDTO compra;

    @JacksonXmlProperty(localName = "precoMedio")
    private PrecoMedioDTO precoMedio;

    @JacksonXmlProperty(localName = "sigla")
    private String sigla;

    @JsonIgnore
    private Agente agente;
}

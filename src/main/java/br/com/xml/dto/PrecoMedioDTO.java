package br.com.xml.dto;

import br.com.xml.model.PrecoMedioValor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "precoMedio")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrecoMedioDTO {
    @JacksonXmlProperty(localName = "codigo")
    private Integer codigo;

    @Transient
    @JacksonXmlProperty(localName = "valor")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Double> valores;
}

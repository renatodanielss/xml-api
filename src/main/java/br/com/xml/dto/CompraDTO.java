package br.com.xml.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "compra")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraDTO {
    @JacksonXmlProperty(localName = "codigo")
    private Integer codigo;

    @Transient
    @JacksonXmlProperty(localName = "valor")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Double> valores;
}

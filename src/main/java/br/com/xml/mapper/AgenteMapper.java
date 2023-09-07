package br.com.xml.mapper;

import br.com.xml.dto.AgenteDTO;
import br.com.xml.dto.AgentesDTO;
import br.com.xml.model.Agente;
import br.com.xml.model.Agentes;
import org.mapstruct.*;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface AgenteMapper {

	@Mappings({
			@Mapping(target = "codigo", ignore = true),
            @Mapping(target = "agentes", ignore = true),
			@Mapping(target = "regioes", ignore = true)
	})
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	void dtoToEntityIgnoreNullValues(@MappingTarget Agente agente, AgenteDTO agenteDTO);
}

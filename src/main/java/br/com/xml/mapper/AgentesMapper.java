package br.com.xml.mapper;

import br.com.xml.dto.AgentesDTO;
import br.com.xml.model.Agentes;
import org.mapstruct.*;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface AgentesMapper {

	@Mappings({
            @Mapping(target = "agentes", ignore = true)
	})
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	void dtoToEntityIgnoreNullValues(@MappingTarget Agentes agentes, AgentesDTO agentesDTO);
}

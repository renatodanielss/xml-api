package br.com.xml.mapper;

import br.com.xml.dto.RegiaoDTO;
import br.com.xml.model.Regiao;
import org.mapstruct.*;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface RegiaoMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	void dtoToEntityIgnoreNullValues(@MappingTarget Regiao regiao, RegiaoDTO regiaoDTO);
}

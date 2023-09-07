package br.com.xml.mapper;

import br.com.xml.dto.SelectionProcessFormDTO;
import br.com.xml.model.SelectionProcess;
import org.mapstruct.*;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface SelectionProcessMapper {

//	@Mappings({
//			@Mapping(target = "companyCountry.companyCountryId", source = "companyCountryId")
//	})
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
//	void dtoToEntityIgnoreNullValues(@MappingTarget SelectionProcess selectionProcess, SelectionProcessFormDTO selectionProcessFormDTO);
}

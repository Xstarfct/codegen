<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package <#include "/convert_path.include"/>;

import <#include "/DO_path.include"/>.${className}DO;
import <#include "/DTO_path.include"/>.${className}DTO;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

<#include "/java_imports.include">
@Mapper
public interface ${className}Convert {

    ${className}Convert INSTANCE = Mappers.getMapper(${className}Convert.class);

    ${className}DTO toDTO(${className}DO aDO);

    ${className}DO toDO(${className}DTO aDTO);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<${className}DTO> toDTOList(List<${className}DO> doList);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<${className}DO> toDOList(List<${className}DTO> dtoList);
}

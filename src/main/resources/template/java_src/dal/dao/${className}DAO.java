<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package <#include "/dao_path.include"/>;

import <#include "/DTO_path.include"/>.${className}DTO;

<#include "/java_imports.include">
public interface ${className}DAO{

    Long insert(${className}DTO dto);
    
    Long insertSelective(${className}DTO dto);
    
    Long batchInsert(List<${className}DTO> dtoList);

    Long update(${className}DTO dto);

    ${className}DTO getById(Long id);

    List<${className}DTO> getByIds(List<Long> id);
}
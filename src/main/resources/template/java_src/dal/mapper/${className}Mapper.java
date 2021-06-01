<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package <#include "/mapper_path.include"/>;

import <#include "/DO_path.include"/>.${className}DO;

import la.kaike.platform.common.log.digest.DigestLogAnnotated;
import la.kaike.platform.common.log.digest.ServiceTypeEnum;

<#include "/java_imports.include">
public interface ${className}Mapper {

    Long insert(${className}DO entity);

    Long insertSelective(${className}DO entity);
    
    Long insertOnDuplicateUpdate(${className}DO entity);

    Long batchInsert(List<${className}DO> list);

    Long update(${className}DO entity);

    ${className}DO getById(Long id);

    List<${className}DO> getByIds(List<Long> id);
}

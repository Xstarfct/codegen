<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package <#include "/DTO_path.include"/>;

import la.kaike.platform.common.result.ToString;
import lombok.Getter;
import lombok.Setter;

<#include "/java_imports.include">
@Getter
@Setter
public class ${className}DTO extends ToString {
    private static final long serialVersionUID = 1L;
    
    <#list table.columns as column>

    /**
     * ${column.remarks}
     */
        <#if column.sqlTypeName == "BIT">
    private Boolean ${column.columnNameFirstLower};
    	<#elseif column.sqlTypeName == "int">
    private Integer ${column.columnNameFirstLower};
    	<#elseif column.sqlTypeName == "bigint">
    private Long ${column.columnNameFirstLower};
    	<#elseif column.sqlTypeName == "BLOB">
    private byte[] ${column.columnNameFirstLower};
    	<#elseif column.sqlTypeName == "Timestamp">
    private ${column.simpleJavaType} ${column.columnNameFirstLower};
    	<#else>
    private ${column.simpleJavaType} ${column.columnNameFirstLower};
    	</#if>
    </#list>
}

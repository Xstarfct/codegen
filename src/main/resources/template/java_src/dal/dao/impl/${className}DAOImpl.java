<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package <#include "/dao_path.include"/>.impl;

import <#include "/DTO_path.include"/>.${className}DTO;
import <#include "/DO_path.include"/>.${className}DO;
import <#include "/dao_path.include"/>.${className}DAO;
import <#include "/mapper_path.include"/>.${className}Mapper;
import <#include "/convert_path.include"/>.${className}Convert;

import javax.annotation.Resource;
import la.kaike.platform.common.lang.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

<#include "/java_imports.include">
@Slf4j
@Repository
public class ${className}DAOImpl implements ${className}DAO {

    private final ${className}Convert convert = ${className}Convert.INSTANCE;
    
    @Resource
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public Long insert(${className}DTO dto) {
        if (dto == null) {
            return 0L;
        }

        ${className}DO aDO = convert.toDO(dto);

        Long result = ${classNameLower}Mapper.insert(aDO);

        return result > 0 ? aDO.getId() : Long.valueOf(0L);
    }

    @Override
    public Long insertSelective(${className}DTO dto) {
        if (dto == null) {
            return 0L;
        }
        
        ${className}DO aDO = convert.toDO(dto);
        
        Long result = ${classNameLower}Mapper.insertSelective(aDO);

        return result > 0 ? aDO.getId() : Long.valueOf(0L);
    }
    
    @Override
    public Long insertOnDuplicateUpdate(${className}DTO dto) {
        if (dto == null) {
            return 0L;
        }
        
        ${className}DO aDO = convert.toDO(dto);
        
        Long result = ${classNameLower}Mapper.insertOnDuplicateUpdate(aDO);

        return result > 0 ? aDO.getId() : Long.valueOf(0L);
    }

    @Override
    public Long batchInsert(List<${className}DTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return 0L;
        }

        return ${classNameLower}Mapper.batchInsert(convert.toDOList(dtoList));
    }

    @Override
    public Long update(${className}DTO dto) {
        if (dto == null || dto.getId() == null) {
            return 0L;
        }

        return ${classNameLower}Mapper.update(convert.toDO(dto));
    }

    @Override
    public ${className}DTO getById(Long id) {

        if(id == null) {
            return null;
        }

        return convert.toDTO(${classNameLower}Mapper.getById(id));
    }

    @Override
    public List<${className}DTO> getByIds(List<Long> ids) {

        if(CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }

        return convert.toDTOList(${classNameLower}Mapper.getByIds(ids));
    }
}

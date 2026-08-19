package com.eduardoamorim.agendadortarefas.business.mapper;

import com.eduardoamorim.agendadortarefas.business.dto.TarefasDTO;
import com.eduardoamorim.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDT0(TarefasEntity entity);
}

package com.eduardoamorim.agendadortarefas.business;

import com.eduardoamorim.agendadortarefas.business.dto.TarefasDTO;
import com.eduardoamorim.agendadortarefas.business.mapper.TarefasConverter;
import com.eduardoamorim.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.eduardoamorim.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.eduardoamorim.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.eduardoamorim.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDT0(tarefasRepository.save(entity));
    }
}

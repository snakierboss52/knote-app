package com.jorge.mappers;

import com.jorge.dtos.TaskDTO;
import com.jorge.entity.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ITaskMapper {

    @Mapping(target = "category", source = "categories")
    @Mapping(target = "label", source = "labels")
    TaskDTO taskEntityToTaskDTO(Task task);

    @Mapping(target = "categories", source = "category")
    @Mapping(target = "labels", source = "label")
    Task taskDTOToTaskEntity(TaskDTO taskDTO);

}

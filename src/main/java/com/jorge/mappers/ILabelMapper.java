package com.jorge.mappers;

import com.jorge.dtos.LabelDTO;
import com.jorge.entity.Label;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel= "Spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ILabelMapper {

    LabelDTO labelEntityToLabelDTO(Label labelEntity);

    Label labelDTOToLabelEntity(LabelDTO labelDTO);


}

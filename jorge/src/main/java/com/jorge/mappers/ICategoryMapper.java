package com.jorge.mappers;

import com.jorge.dtos.CategoryDTO;
import com.jorge.entity.Category;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel= "Spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ICategoryMapper {

    CategoryDTO categoryEntityToCategoryDTO(Category categoryEntity);

    Category categoryDTOToCategoryEntity(CategoryDTO categoryDTO);


}

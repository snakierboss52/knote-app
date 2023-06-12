package com.jorge.service;

import com.jorge.dtos.CategoryDTO;
import com.jorge.mappers.ICategoryMapper;
import com.jorge.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final ICategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, ICategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryDTO> findAll(){
        return categoryRepository.findAll().stream().map(categoryMapper::categoryEntityToCategoryDTO).toList();
    }

}

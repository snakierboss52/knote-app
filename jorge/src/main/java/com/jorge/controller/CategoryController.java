package com.jorge.controller;

import com.jorge.dtos.CategoryDTO;
import com.jorge.mappers.ICategoryMapper;
import com.jorge.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CategoryController {


    private final CategoryService categoryService;

    private final ICategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, ICategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories(){
        log.info("Getting all categories from controller request");
        return categoryService.findAll();
    }

}

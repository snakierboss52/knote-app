package com.jorge.service;

import com.jorge.mappers.ILabelMapper;
import com.jorge.repository.LabelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LabelService {

    private final LabelRepository labelRepository;

    private final ILabelMapper labelMapper;


    public LabelService(LabelRepository labelRepository, ILabelMapper labelMapper) {
        this.labelRepository = labelRepository;
        this.labelMapper = labelMapper;
    }
}

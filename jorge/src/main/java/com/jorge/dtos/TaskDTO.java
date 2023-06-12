package com.jorge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO implements Serializable {

    private Long id;

    private String title;

    private String content;

    private List<CategoryDTO> category;

    private List<LabelDTO> label;

    private String status;

}

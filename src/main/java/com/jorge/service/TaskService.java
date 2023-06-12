package com.jorge.service;

import com.jorge.dtos.TaskDTO;
import com.jorge.entity.Category;
import com.jorge.entity.Label;
import com.jorge.entity.Task;
import com.jorge.mappers.ITaskMapper;
import com.jorge.repository.CategoryRepository;
import com.jorge.repository.LabelRepository;
import com.jorge.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    private final CategoryRepository categoryRepository;

    private final LabelRepository labelRepository;

    private final ITaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository, LabelRepository labelRepository, ITaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.labelRepository = labelRepository;
        this.taskMapper = taskMapper;
    }


    public Optional<TaskDTO> getTaskById(Long id){
        return taskRepository.findById(id).map(taskMapper::taskEntityToTaskDTO);
    }

    public TaskDTO createTask(Task task){

        final List<Category> categories = new ArrayList<>();
        final List<Label> labels = new ArrayList<>();

        for (Category category : task.getCategories()){
            final String categoryName = category.getName();

            log.info("Category name received {}, going out to validate if category exists", categoryName);

            Optional<Category> categoryOptional = categoryRepository.findCategoryByName(categoryName);

            if (categoryOptional.isEmpty()){
                log.info("Category name not found, category with name {} is going to be created", categoryName);

                final Category categoryCompleted = Category
                        .builder()
                        .name(categoryName)
                        .build();

                categoryRepository.save(categoryCompleted);
                categories.add(categoryCompleted);
                task.setCategories(categories);
                log.info("Category whit name {} has been created, going out to create task {}", categoryName, task);

            }
            else {
                categories.add(categoryOptional.get());
                task.setCategories(categories);
                log.info("Category {} found it, going out to create task {}", categoryOptional, task);

            }

            log.info("Final categories add to task {}", categories);
        }


        log.info("Going out to validate labels");

        for (Label label : task.getLabels()){
            final String labelName = label.getName();

            log.info("Label name received {}, going out to validate if label exists", labelName);

            Optional<Label> labelOptional = labelRepository.findLabelByName(labelName);

            if (labelOptional.isEmpty()){
                log.info("Label name not found, label with name {} is going to be created", labelName);

                final Label labelCompleted = Label
                        .builder()
                        .name(labelName)
                        .build();

                labelRepository.save(labelCompleted);
                labels.add(labelCompleted);
                task.setLabels(labels);
                log.info("Label whit name {} has been created, going out to create task {}", labelName, task);

            }
            else {
                labels.add(labelOptional.get());
                task.setLabels(labels);
                log.info("Label {} found it, going out to create task {}", labelOptional, task);

            }

            log.info("Final labels add to task {}", categories);
        }

        taskRepository.save(task);
        log.info("Task has been created successfully {}", task);
        return taskMapper.taskEntityToTaskDTO(task);
    }

    public List<TaskDTO> findAll(){
        log.info("Getting all tasks from service request");
        return taskRepository.findAll().stream().map(taskMapper::taskEntityToTaskDTO).toList();
    }

    /*public ResponseEntity<Task> deleteTaskById(Long id){
        return  taskRepository.deleteTaskById(id);
    }

    public ResponseEntity<Optional<Task>> updateTaskById(
            Long id,
            Task taskUpdated
    ){
        return  taskRepository.findTaskById(id).flatMap(task -> {
                    taskUpdated.setId(task.getId());
                    return taskRepository.save(taskUpdated);
                }
        );
    }*/

}

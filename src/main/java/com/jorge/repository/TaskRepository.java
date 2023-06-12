package com.jorge.repository;

import com.jorge.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> deleteTaskById(Long id);


}


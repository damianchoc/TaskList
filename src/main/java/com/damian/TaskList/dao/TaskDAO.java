package com.damian.TaskList.dao;

import com.damian.TaskList.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface TaskDAO extends CrudRepository<Task, Serializable> {
//    @Query("select p from Task p where p.user='admin'")
//    public List<Task> zapytanieExyta()
}

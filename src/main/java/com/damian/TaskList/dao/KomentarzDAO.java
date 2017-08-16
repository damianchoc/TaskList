package com.damian.TaskList.dao;


import com.damian.TaskList.model.Komentarz;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface KomentarzDAO extends CrudRepository<Komentarz,Serializable>{
}

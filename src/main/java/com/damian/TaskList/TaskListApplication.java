package com.damian.TaskList;

import com.damian.TaskList.dao.TaskDAO;
import com.damian.TaskList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskListApplication implements CommandLineRunner{

	@Autowired
	private TaskDAO taskDao;

	public static void main(String[] args) {
		SpringApplication.run(TaskListApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		for(int i=0;i<5;i++){
			Task task = new Task();
			task.setMessage("Task nr "+i);
			taskDao.save(task);
		}
	}
}

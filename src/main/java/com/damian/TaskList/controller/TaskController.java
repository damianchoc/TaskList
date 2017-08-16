package com.damian.TaskList.controller;

import com.damian.TaskList.dao.TaskDAO;
import com.damian.TaskList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController()
public class TaskController {

    @Autowired
    private TaskDAO taskDao;

    @RequestMapping(value="/listaTaskow")
    public String listaTaskow(Model model){
        List<Task> listaTaskow = new ArrayList<>();
        listaTaskow = (List<Task>)taskDao.findAll();
        model.addAttribute("listaTaskow",listaTaskow);
//        Task t = new Task(1, "32");

        return "lista";
    }

    @RequestMapping(value="/update/{id}")
    public ModelAndView update(ModelAndView model, @PathVariable Long id){
//        taskDao.save(task);
        Task task = taskDao.findOne(id);
        model.addObject("task",task);
        model.setViewName("/update");
        return model;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update2(@Valid Task task){
        taskDao.save(task);

        return new ModelAndView("redirect:/listaTaskow");
    }

}

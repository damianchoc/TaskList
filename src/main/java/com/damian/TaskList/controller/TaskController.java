package com.damian.TaskList.controller;

import com.damian.TaskList.dao.KomentarzDAO;
import com.damian.TaskList.dao.TaskDAO;
import com.damian.TaskList.model.Komentarz;
import com.damian.TaskList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController()
public class TaskController {

    @Autowired
    private TaskDAO taskDao;
    @Autowired
    private KomentarzDAO komentarzDao;

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
    public ModelAndView update2(@Valid Task task, Errors errors){
        if(errors.hasErrors()){
//            redirectAttributes.addFlashAttribute("org.spingframework.validation.BindingResult.task", bind);
//            redirectAttributes.addFlashAttribute("task",task);
        return new ModelAndView("redirect:/update/"+task.getId());
        }
        taskDao.save(task);
        return new ModelAndView("redirect:/listaTaskow");
    }

    @RequestMapping(value="/task/{id}")
    public String task(Model model, @PathVariable Long id){
        Task task = taskDao.findOne(id);
        List<Komentarz> komentarze = new ArrayList<>();
        komentarze = task.getKomentarze();
        model.addAttribute("task",task);
        model.addAttribute("komentarze", komentarze);
        return "task";
    }

    @RequestMapping(value="/addKomentarz/{id}")
    public String dodajKomentarz(Model model, @PathVariable Long id){
        Task task = taskDao.findOne(id);
        model.addAttribute("task",task);
        Komentarz komentarz = new Komentarz();
        model.addAttribute("komentarz", komentarz);
        return "addKomentarz";
    }
//modelandview
    @RequestMapping(value="/saveKomentarz/{id}", method=RequestMethod.POST)
    public ModelAndView saveKomentarz(@PathVariable Long id, Komentarz komentarz){
//        model.
        Task t = taskDao.findOne(id);
        komentarz.setTask(t);
        t.dodajKomentarz(komentarz);
        taskDao.save(t);
        komentarzDao.save(komentarz);
        return new ModelAndView("redirect:/task/"+id);
    }


}

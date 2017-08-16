package com.damian.TaskList.model;

import javax.persistence.*;

@Entity
public class Komentarz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String komentarz;

    @ManyToOne
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }
}

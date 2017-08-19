package com.damian.TaskList.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public List<Komentarz> getKomentarze() {
        return komentarze;
    }

    public void setKomentarze(List<Komentarz> komentarze) {
        this.komentarze = komentarze;
    }

    public void dodajKomentarz(Komentarz komentarz){
       komentarz.setTask(this);
       komentarze.add(komentarz);
    }

    @OneToMany(mappedBy = "task")
    private List<Komentarz> komentarze;

    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

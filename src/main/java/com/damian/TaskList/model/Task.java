package com.damian.TaskList.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(min=3, max=20, message = "Musi zawierac od 3 do 20 znakow")
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

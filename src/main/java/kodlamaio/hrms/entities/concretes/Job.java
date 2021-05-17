package kodlamaio.hrms.entities.concretes;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "job_titles")
@Data
public class Job {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public Job(){

    }

    public Job(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

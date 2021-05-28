package com.example.novelreview.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "novel")
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private Writer writer;

    @ManyToMany
    private List<Reviewer> reviewed_by;

    @OneToMany(mappedBy = "novel")
    private List<Review> reviews;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

}

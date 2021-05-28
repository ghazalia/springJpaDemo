package com.example.novelreview.model;

import javax.persistence.*;

@Entity
@Table(name = "writer")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name = "email")
    private String email;


    public Writer() {}

    public Writer(String name, String phone, String email) {
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

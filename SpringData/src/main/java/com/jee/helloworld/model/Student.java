package com.jee.helloworld.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private Integer id;
    private String lastName;
    private String firstName;
    private Float grade;
}

package com.dio.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity// entity BD
@Data //getters and setters
@Builder //objects
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //constructor with no argument
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key generator
    private long id;

    @Column(nullable = false)//mandatory data = not null
    private String firstName;

    @Column (nullable = false)//mandatory data = not null
    private String lastName;

    @Column (nullable = false, unique = true)//mandatory data = not null - cpf unique number
    private String cpf;


    private LocalDate birthDate;

    //One person many phones
    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}

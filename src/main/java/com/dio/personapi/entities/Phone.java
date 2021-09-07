package com.dio.personapi.entities;


import com.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity// entity BD
@Data //getters and setters
@Builder //objects
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //constructor with no argument
public class Phone {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //primary key generator
    private long id;

    @Enumerated(EnumType.STRING)//Enum type string
    @Column (nullable = false)//mandatory data = not null
    private PhoneType type;

    @Column (nullable = false)//mandatory data = not null
    private String number;
}

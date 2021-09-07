package com.dio.personapi.dto.request;

import com.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data //getters and setters
@Builder //objects
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //constructor with no argument
public class PhoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min=13, max=14)
    private String number;
}
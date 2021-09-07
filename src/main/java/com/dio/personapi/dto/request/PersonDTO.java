package com.dio.personapi.dto.request;

import com.dio.personapi.entities.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Data //getters and setters
@Builder //objects
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //constructor with no argument
public class PersonDTO {

    private long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String firstName;

    @NotEmpty
    @Size(min=2, max=100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;


}

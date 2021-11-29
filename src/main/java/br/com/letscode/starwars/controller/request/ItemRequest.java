package br.com.letscode.starwars.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ItemRequest {

    @NotBlank(message = "Nome do item deve ser informado.")
    private String name;

    @Min(value = 1, message = "O valor do item deve ser igual ou maior que 1.")
    @Max(value = 4, message = "O valor do item não pode ser maior que 4.")
    private int point;

}

package br.com.letscode.starwars.controller.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRebelRequest {

    @NotBlank(message = "Nome do rebelde deve ser informado.")
    private String name;

    @Min(value = 18, message = "Para ser rebelde você deve ser maior de 18+.")
    @Max(value = 1000, message = "Nenhuma espécie viveu tanto! Sua idade está inválida.")
    private int age;

    @NotNull(message = "O gênero deve ser informado.")
    private GenderRequest gender;

    @NotNull(message = "A localização deve ser informado.")
    private LocateRequest locate;

    @NotNull(message = "O inventário deve ser informado.")
    private InventoryRequest inventory;

}

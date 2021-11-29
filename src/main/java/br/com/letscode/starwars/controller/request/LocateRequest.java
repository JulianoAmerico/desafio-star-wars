package br.com.letscode.starwars.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocateRequest {

    @NotBlank(message = "Nome da localização deve ser informado.")
    private String name;

    @NotBlank(message = "Latitude deve ser informado.")
    private String latitude;

    @NotBlank(message = "Longitude deve ser informado.")
    private String longitude;
}

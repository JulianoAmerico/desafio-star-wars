package br.com.letscode.starwars.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RebelResponse {

    private long id;

    private String name;

    private int age;

    private GenderResponse gender;

    private LocateResponse locate;

    private InventoryResponse inventory;

}

package br.com.letscode.starwars.controller.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryRequest {

    @NotEmpty(message = "Os itens do seu inventário deve ser informado.")
    private List<ItemRequest> items;
}

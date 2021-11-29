package br.com.letscode.starwars.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RebelTradeRequest {

    private long id;

    private List<ItemRequest> items;
}

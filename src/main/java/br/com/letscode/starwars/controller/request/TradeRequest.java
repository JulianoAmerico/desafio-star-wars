package br.com.letscode.starwars.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TradeRequest {

    private RebelTradeRequest rebelRequester;

    private RebelTradeRequest rebelReceiver;
}

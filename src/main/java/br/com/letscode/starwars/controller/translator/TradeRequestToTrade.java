package br.com.letscode.starwars.controller.translator;

import br.com.letscode.starwars.controller.request.TradeRequest;
import br.com.letscode.starwars.domain.Inventory;
import br.com.letscode.starwars.domain.Item;
import br.com.letscode.starwars.domain.Rebel;
import br.com.letscode.starwars.domain.Trade;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class TradeRequestToTrade {

    public Trade translate(final TradeRequest request) {
        final var rebelRequestRequester = request.getRebelRequester();
        final var rebelRequestReceiver = request.getRebelReceiver();

        return Trade.builder()
                .rebelRequester(Rebel.builder()
                        .id(rebelRequestRequester.getId())
                        .inventory(Inventory.builder()
                                .items(rebelRequestRequester.getItems()
                                        .stream()
                                        .map(e -> Item.builder()
                                                .name(e.getName())
                                                .point(e.getPoint())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .build())
                .rebelReceiver(Rebel.builder()
                        .id(rebelRequestReceiver.getId())
                        .inventory(Inventory.builder()
                                .items(rebelRequestReceiver.getItems()
                                        .stream()
                                        .map(e -> Item.builder()
                                                .name(e.getName())
                                                .point(e.getPoint())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .build())
                .build();

    }
}

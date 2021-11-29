package br.com.letscode.starwars.controller;

import br.com.letscode.starwars.controller.request.TradeRequest;
import br.com.letscode.starwars.controller.response.SuccessMessageResponse;
import br.com.letscode.starwars.controller.translator.TradeRequestToTrade;
import br.com.letscode.starwars.usecase.TradeUseCase;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeController {

    private final TradeUseCase tradeUseCase;

    @PostMapping("/items")
    public SuccessMessageResponse tradeItemsBetweenRebels(@Valid @RequestBody TradeRequest request) throws UseCaseException {
        final var trade = TradeRequestToTrade.translate(request);
        return new SuccessMessageResponse(tradeUseCase.trade(trade));
    }
}

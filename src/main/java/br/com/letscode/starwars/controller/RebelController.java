package br.com.letscode.starwars.controller;

import br.com.letscode.starwars.controller.request.AddRebelRequest;
import br.com.letscode.starwars.controller.request.LocateRequest;
import br.com.letscode.starwars.controller.response.RebelResponse;
import br.com.letscode.starwars.controller.response.SuccessMessageResponse;
import br.com.letscode.starwars.controller.translator.AddRebelRequestToRebel;
import br.com.letscode.starwars.controller.translator.LocateRequestToLocate;
import br.com.letscode.starwars.controller.translator.RebelToRebelResponse;
import br.com.letscode.starwars.usecase.RebelUseCase;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rebels")
@RequiredArgsConstructor
public class RebelController {

    private final RebelUseCase rebelUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RebelResponse addRebel(@Valid @RequestBody AddRebelRequest request) throws UseCaseException {
        final var rebel = AddRebelRequestToRebel.translate(request);
        final var rebelAdded = rebelUseCase.addRebel(rebel);
        return RebelToRebelResponse.translate(rebelAdded);
    }

    @PutMapping("/{rebelId}/location")
    public SuccessMessageResponse updateRebelLocation(@PathVariable final long rebelId,
                                                      @Valid @RequestBody final LocateRequest request) throws UseCaseException {
        final var locate = LocateRequestToLocate.translate(request);
        final var message = rebelUseCase.updateRebelLocation(rebelId, locate);
        return new SuccessMessageResponse(message);
    }

    @PutMapping("/{rebelId}/traitor")
    public void reportRebelAsTraitor(@PathVariable final long rebelId) throws UseCaseException {
        rebelUseCase.reportRebelAsTraitor(rebelId);
    }

    @GetMapping("/{rebelId}")
    public RebelResponse getRebelById(@PathVariable final long rebelId) throws UseCaseException {
        return RebelToRebelResponse.translate(rebelUseCase.getRebelById(rebelId));
    }

}

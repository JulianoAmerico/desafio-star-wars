package br.com.letscode.starwars.controller;

import br.com.letscode.starwars.usecase.ReportUseCase;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {

    private final ReportUseCase reportUseCase;

    @GetMapping("/traitors")
    public Map<String, String> percentageTraitors() throws UseCaseException {
        final var traitors = reportUseCase.percentageTraitors();
        return Collections.singletonMap("percentageTraitors", traitors + "%");
    }

    @GetMapping("/rebels")
    public Map<String, String> percentageRebels() throws UseCaseException {
        final var rebels = reportUseCase.percentageRebels();
        return Collections.singletonMap("percentageRebels", rebels + "%");
    }

    @GetMapping("/resources")
    public void quantityAverageOfResourcesByRebels() {

    }

    @GetMapping("/points/lost")
    public Map<String, String> pointsLostByTraitors() throws UseCaseException {
        final var pointsLost = reportUseCase.pointsLostByTraitors();
        return Collections.singletonMap("pointsLost", String.valueOf(pointsLost));
    }
}

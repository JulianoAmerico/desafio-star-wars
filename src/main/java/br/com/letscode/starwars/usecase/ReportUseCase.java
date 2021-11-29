package br.com.letscode.starwars.usecase;

import br.com.letscode.starwars.repository.RebelRepository;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReportUseCase {

    private final RebelRepository rebelRepository;

    public double percentageTraitors() throws UseCaseException {
        try {
            final var totalRebels = rebelRepository.count();
            final var totalTraitors = rebelRepository.countByTraitor(true) * 100;
            return (double) totalTraitors / totalRebels;
        } catch (Exception e) {
            log.error("Error when try to get percentage traitors", e);
            throw new UseCaseException("Erro ao tentar buscar a porcentagem de traidores", e);
        }
    }

    public double percentageRebels() throws UseCaseException {
        try {
            final var totalRebels = rebelRepository.count();
            final var totalIsNotTraitors = rebelRepository.countByTraitor(false) * 100;
            return (double) totalIsNotTraitors / totalRebels;
        } catch (Exception e) {
            log.error("Error when try to get percentage rebels", e);
            throw new UseCaseException("Erro ao tentar buscar a porcentagem de rebeldes", e);
        }
    }

    public void quantityAverageOfResourcesByRebels() throws UseCaseException {
        try {

        } catch(Exception e) {
            log.error("Error when try to get quantity average of resources by rebels", e);
            throw new UseCaseException("Erro ao tentar buscar a quantidade média de recursos por rebeldes", e);
        }
    }

    public long pointsLostByTraitors() throws UseCaseException {
        try {
            return rebelRepository.pointsLost(true);
        } catch (Exception e) {
            log.error("Error when try to get points lost by traitors", e);
            throw new UseCaseException("Erro ao tentar buscar os pontos perdidos por traidores", e);
        }
    }
}

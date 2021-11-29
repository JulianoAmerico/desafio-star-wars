package br.com.letscode.starwars.usecase;

import br.com.letscode.starwars.domain.Locate;
import br.com.letscode.starwars.domain.Rebel;
import br.com.letscode.starwars.repository.RebelRepository;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RebelUseCase {

    private final RebelRepository rebelRepository;

    public Rebel addRebel(final Rebel rebel) throws UseCaseException {
        try {
            return rebelRepository.save(rebel);
        } catch (Exception e) {
            log.error("Error when try to add rebel");
            throw new UseCaseException("Erro ao tentar cadastrar um rebelde", e);
        }
    }

    public String updateRebelLocation(final long rebelId, final Locate locate) throws UseCaseException {
        try {
            final var rebel = rebelRepository.getById(rebelId);
            rebel.setLocate(locate);
            rebelRepository.save(rebel);
            return "Localização atualizada com sucesso!";
        } catch (Exception e) {
            log.error("Error when try to update rebel location");
            throw new UseCaseException("Erro ao tentar atualizar a localização do rebelde", e);
        }
    }

    public void reportRebelAsTraitor(final long rebelId) throws UseCaseException {
        try {
            final var rebel = rebelRepository.getById(rebelId);
            rebel.setReportTraitor();
            rebelRepository.save(rebel);
        } catch (Exception e) {
            log.error("Error when try report rebel as traitor", e);
            throw new UseCaseException("Erro ao tentar reportar um rebelde como traidor", e);
        }
    }

    public Rebel getRebelById(final long rebelId) throws UseCaseException {
        try {
            return rebelRepository.getById(rebelId);
        } catch (Exception e) {
            log.error("Error when try to get rebel", e);
            throw new UseCaseException("Erro ao tentar buscar um rebelde", e);
        }
    }
}

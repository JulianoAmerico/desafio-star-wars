package br.com.letscode.starwars.usecase;

import br.com.letscode.starwars.domain.Item;
import br.com.letscode.starwars.domain.Rebel;
import br.com.letscode.starwars.domain.Trade;
import br.com.letscode.starwars.repository.ItemRepository;
import br.com.letscode.starwars.repository.RebelRepository;
import br.com.letscode.starwars.usecase.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class TradeUseCase {

    private final RebelRepository rebelRepository;
    private final ItemRepository itemRepository;

    public String trade(final Trade trade) throws UseCaseException {
        try {

            final var rebelRequester = trade.getRebelRequester();
            final var rebelReceiver = trade.getRebelReceiver();

            final var rebelRequesterPoints = getItemsPoints(rebelRequester.getInventory().getItems());
            final var rebelReceiverPoints = getItemsPoints(rebelReceiver.getInventory().getItems());

            final var rebelRequesterDatabase = rebelRepository.getById(rebelRequester.getId());
            final var rebelReceiverDatabase = rebelRepository.getById(rebelReceiver.getId());

            if (rebelRequesterDatabase.isTraitor() || rebelReceiverDatabase.isTraitor()) {
                log.error("Unable to trade one of rebels is traitor.");
                throw new UseCaseException("Não é possível fazer a negociação um dos rebeldes é traidor.");
            }

            if (rebelRequesterPoints == rebelReceiverPoints) {
                updateInventory(rebelRequester, rebelRequesterDatabase, rebelReceiver.getInventory().getItems());
                updateInventory(rebelReceiver, rebelReceiverDatabase, rebelRequester.getInventory().getItems());
                return "Negociação realizada com sucesso";
            } else {
                log.error("The points of items are differents between rebels.");
                throw new UseCaseException("Os pontos dos itens são diferentes entre os rebeldes");
            }
        } catch (UseCaseException e) {
            throw new UseCaseException(e.getMessage());
        } catch (Exception e) {
            log.error("Error when try to trade between rebels", e);
            throw new UseCaseException("Erro ao tentar negociar entre os rebeldes", e);
        }
    }

    private int getItemsPoints(final List<Item> items) {
        return items.stream()
                .mapToInt(Item::getPoint)
                .sum();
    }

    private void updateInventory(final Rebel rebel, final Rebel rebelDatabase, final List<Item> items) {
        rebelDatabase.getInventory().getItems().removeIf(
                e -> {
                    for (Item item : rebel.getInventory().getItems()) {
                        if (Objects.equals(e.getName(), item.getName())) {
                            itemRepository.deleteById(e.getId());
                            return true;
                        }
                    }
                    return false;
                }
        );
        rebelDatabase.getInventory().getItems().addAll(items);
        rebelRepository.save(rebelDatabase);
    }
}

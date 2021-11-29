package br.com.letscode.starwars.repository;

import br.com.letscode.starwars.domain.Rebel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RebelRepository extends JpaRepository<Rebel, Long> {
    long countByTraitor(boolean traitor);

    @Query(value = "select SUM(item.point) from rebel " +
            "inner join inventory_items i " +
            "on rebel.inventory_id = i.inventory_id " +
            "inner join item " +
            "on item.id = i.items_id " +
            "where traitor = ?1",
            nativeQuery = true)
    long pointsLost(boolean isTraitor);


}

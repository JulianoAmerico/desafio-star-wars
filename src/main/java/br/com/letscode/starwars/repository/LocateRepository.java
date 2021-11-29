package br.com.letscode.starwars.repository;

import br.com.letscode.starwars.domain.Locate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocateRepository extends JpaRepository<Locate, Long> {
}

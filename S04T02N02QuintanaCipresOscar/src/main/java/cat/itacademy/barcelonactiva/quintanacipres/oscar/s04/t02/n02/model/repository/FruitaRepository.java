package cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n02.model.domain.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
}

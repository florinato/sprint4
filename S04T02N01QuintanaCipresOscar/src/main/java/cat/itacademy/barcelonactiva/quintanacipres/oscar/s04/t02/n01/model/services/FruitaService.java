package cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n01.model.repository.FruitaRepository;

@Service
public class FruitaService {
    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita addFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    public Fruita updateFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    public void deleteFruita(int id) {
        fruitaRepository.deleteById(id);
    }

    public Optional<Fruita> getFruita(int id) {
        return fruitaRepository.findById(id);
    }

    public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }
}


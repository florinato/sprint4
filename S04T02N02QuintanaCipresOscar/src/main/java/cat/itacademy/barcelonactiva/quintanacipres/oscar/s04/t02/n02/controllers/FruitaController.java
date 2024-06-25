package cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.quintanacipres.oscar.s04.t02.n02.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
    @Autowired
    private FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        Fruita newFruita = fruitaService.addFruita(fruita);
        return new ResponseEntity<>(newFruita, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita) {
        if (fruita.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Fruita> existingFruita = fruitaService.getFruita(fruita.getId());
        if (existingFruita.isPresent()) {
            Fruita updatedFruita = fruitaService.updateFruita(fruita);
            return new ResponseEntity<>(updatedFruita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable int id) {
        fruitaService.deleteFruita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruita(@PathVariable int id) {
        Optional<Fruita> fruita = fruitaService.getFruita(id);
        return fruita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        List<Fruita> fruites = fruitaService.getAllFruites();
        return new ResponseEntity<>(fruites, HttpStatus.OK);
    }
    
}
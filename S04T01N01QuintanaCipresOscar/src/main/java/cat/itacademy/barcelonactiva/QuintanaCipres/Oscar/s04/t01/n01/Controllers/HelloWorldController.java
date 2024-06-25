package cat.itacademy.barcelonactiva.QuintanaCipres.Oscar.s04.t01.n01.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(name = "nom", defaultValue = "Desconocido") String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String saluda2(@PathVariable(name = "nom", required = false) String nom) {
        if (nom == null) {
            nom = "Desconocido";
        }
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }
}
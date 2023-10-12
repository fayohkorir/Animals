package net.javaguides.spring.animals.Controller;

import jakarta.validation.Valid;
import net.javaguides.spring.animals.Model.Animals;
import net.javaguides.spring.animals.Service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalsController {

    private final AnimalsService animalsService;

    @Autowired
    public AnimalsController(AnimalsService animalsService){
        this.animalsService = animalsService;
    }

    @PostMapping("/create")
    public Animals createAnimals(@RequestBody Animals animals){
        return animalsService.createAnimals(animals);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Animals> updateAnimals(@PathVariable ("id") long id, @RequestBody Animals animals) {
        return new ResponseEntity<Animals>(animalsService.createAnimals(animals),HttpStatus.OK);
    }

    @GetMapping
    public List<Animals> getAllAnimals() {
        return animalsService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animals> getAnimalsId(@PathVariable long id) {
        return ResponseEntity.ok().body(this.animalsService.getAnimalsId(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable long id) {
        animalsService.deleteAnimal(id);
    }
}


package net.javaguides.spring.animals.Service;

import net.javaguides.spring.animals.Model.Animals;

import java.util.List;
import java.util.Optional;

public interface AnimalsService {
    Animals createAnimals(Animals animals);
    Animals updateAnimals(Animals animals);
    List<Animals> getAllAnimals();
    Animals getAnimalsId(long animalsId);
    void deleteAnimal(Long animalsId);

}

package net.javaguides.spring.animals.Service;

import net.javaguides.spring.animals.Exception.ResourceNotFoundException;
import net.javaguides.spring.animals.Model.Animals;
import net.javaguides.spring.animals.Repository.AnimalsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalsServiceImpl implements AnimalsService {
    private final AnimalsRepository animalsRepository;

    public AnimalsServiceImpl(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Override
    public Animals createAnimals(Animals animals) {
        return animalsRepository.save(animals);
    }

    @Override
    public Animals updateAnimals(Animals animals) {
        Optional<Animals> animalsDb = this.animalsRepository.findById(animals.getId());

        if (animalsDb.isPresent()) {
            Animals updateAnimals = animalsDb.get();
            updateAnimals.setId(updateAnimals.getId());
            updateAnimals.setName(updateAnimals.getName());
            updateAnimals.setAge(updateAnimals.getAge());
            updateAnimals.setDescription(updateAnimals.getDescription());
            animalsRepository.save(updateAnimals);
            return updateAnimals;
        } else {
            throw new RuntimeException("Animal not found");
        }
    }

    @Override
    public List<Animals> getAllAnimals() {
        return animalsRepository.findAll();
    }

    @Override
    public Animals getAnimalsId(long animalsId) {
        Optional<Animals> animalsDb = this.animalsRepository.findById(animalsId);
        if (animalsDb.isPresent()) {
            return animalsDb.get();
        } else {
            throw new RuntimeException("Animal not found");
        }

    }

    @Override
    public void deleteAnimal(Long animalsId) {
        animalsRepository.deleteById(animalsId);
    }
}

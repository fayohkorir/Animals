package net.javaguides.spring.animals.Repository;

import net.javaguides.spring.animals.Model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {

}

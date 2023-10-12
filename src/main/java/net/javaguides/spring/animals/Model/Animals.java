package net.javaguides.spring.animals.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Animals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, message= "name should have at least 2 characters")
    private String name;

    @NotBlank
    @Size(min = 2, message= "description should have at least 2 characters")
    private  String description;


    @NotNull
    @Min(0)  // Minimum age value
    @Max(150)  // Maximum age value
    private Integer age;

    public Animals(String lupin, String number, String slim) {

    }

    public Animals() {
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}

package net.javaguides.spring.animals.Controller;

import net.javaguides.spring.animals.Model.Animals;
import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestClient {
    public static final String GET_ALL_ANIMALS_API = "http://localhost:8082/api/v1/animals";
    public static final String GET_ANIMALS_BY_ID_API = "http://localhost:8082/api/v1/animals/{id}";
    public static final String CREATE_ANIMALS_API = "http://localhost:8082/api/v1/animals";
    public static final String UPDATE_ANIMALS_API = "http://localhost:8082/api/v1/animals/{id}";
    public static final String DELETE_ANIMALS_BY_API = "http://localhost:8082/api/v1/animals/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        callGetALLAnimalsAPI();
        callGetAnimalsByIdAPI();
        callCreateAnimalsAPI();
        callUpdateAnimalsAPI();
        callDeleteAnimalsAPI();
    }

    private static void callGetALLAnimalsAPI() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_ANIMALS_API, HttpMethod.GET, entity, String.class);
        System.out.print(result);
    }

    private static void callGetAnimalsByIdAPI() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 2);

        Animals animals = restTemplate.getForObject(GET_ANIMALS_BY_ID_API, Animals.class, param);

        System.out.println(animals.getId());
        System.out.println(animals.getAge());
        System.out.println(animals.getDescription());
        System.out.println(animals.getName());

    }

    public static void callCreateAnimalsAPI() {
        Animals animals = new Animals("Lupin","43","Slim");

        ResponseEntity<Animals> animals1 = restTemplate.postForEntity(CREATE_ANIMALS_API, animals, Animals.class);
        System.out.println(animals1.getBody());
    }

    private static void callUpdateAnimalsAPI() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 7);

        Animals updateAnimals = new Animals("Denzel", "48", "tender");

        restTemplate.put(UPDATE_ANIMALS_API, updateAnimals, param);
    }

    private static void callDeleteAnimalsAPI() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 7);
        restTemplate.delete(DELETE_ANIMALS_BY_API, param);

    }

}

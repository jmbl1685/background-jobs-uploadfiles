package springboot.controllers;

import java.util.ArrayList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import springboot.entities.Fruit;

@Controller
public class FruitController {
    
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public HttpEntity<Fruit> AddFruit(@RequestBody Fruit fruit) {
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<String> GetFruitByID(@PathVariable String Id) {
        return new ResponseEntity<>(Id, HttpStatus.OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit")
    public HttpEntity<Fruit> GetFruits() {
        Fruit fruit = new Fruit(
            "F001", 
            "Orange", 
            "https://coldstorage.com.sg/assets/easyimage/3/3247386308b90ba227813a2e306d13ee.jpg"
        );
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<String> RemoveFruit(@PathVariable String Id) {
        return new ResponseEntity<>(Id, HttpStatus.OK);
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<Fruit> UpdateFruit(@PathVariable String Id, @RequestBody Fruit fruit) {
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }
    
}

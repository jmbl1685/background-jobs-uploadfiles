package springboot.controllers;

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

import springboot.entities.CustomResponse;
import springboot.entities.Fruit;
import java.util.ArrayList;

@Controller
public class FruitController {
    
	private static ArrayList<Fruit> FruitList = new ArrayList<>();
	
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit")
    public HttpEntity<ArrayList<Fruit>> GetFruits() {
        return new ResponseEntity<>(FruitList, HttpStatus.OK);
    }
    
    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit")
    public HttpEntity<Fruit> AddFruit(@RequestBody Fruit fruit) {
    	FruitList.add(fruit);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<Object> GetFruitByID(@PathVariable String Id) {
    	
    	 Object _fruit = new CustomResponse("Fruit not found", 404);
    	
    	 for (Fruit item : FruitList) {    
    		 if (item.getId().equals(Id)) {
				_fruit = item;   	    	
     		}
    	 }
    	 
        return new ResponseEntity<>(_fruit, HttpStatus.OK);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<Object> RemoveFruit(@PathVariable String Id) {
        
		 Object _fruit = new CustomResponse("Fruit not found", 404);
	 	
	   	 for (Fruit item : FruitList) {  
	   		 if (item.getId().equals(Id)) {
	   			_fruit = item;   			
			}  	    	
	   	 }
  	 
	   	 FruitList.remove(_fruit);
	   	 return new ResponseEntity<>(_fruit, HttpStatus.OK);
    	
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, path = "/fruit/{Id}")
    public HttpEntity<Object> UpdateFruit(@PathVariable String Id, @RequestBody Fruit fruit) {
     
		 int index = -1;
		 Object _fruit = new CustomResponse("Fruit not found", 404);
	 	
	   	 for (Fruit item : FruitList) {  
	   		 index++;
	   		 if (item.getId().equals(Id)) {
	   			_fruit = FruitList.get(index).setFruit(fruit);
			}  	    	
	   	 }
   	 
	   	 return new ResponseEntity<>(_fruit, HttpStatus.OK);
	   	 
    }
    
}

package com.example.OnlineGrocery.Controller;

import java.util.List;

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

import com.example.OnlineGrocery.Entity.GroceryItem;
import com.example.OnlineGrocery.Service.GroceryItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/groceryitems")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping 
    public List<GroceryItem> getAllGroceryItems(){
        return groceryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id){
        return ResponseEntity.ok(groceryItemService.getItemById(id));
    }

    @PostMapping  
    public ResponseEntity<GroceryItem> createGroceryItem(@Valid @RequestBody GroceryItem groceryItem){
        return new ResponseEntity<>(groceryItemService.createItem(groceryItem),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateDetails(@PathVariable Long id,@Valid @RequestBody GroceryItem item){
        return ResponseEntity.ok(groceryItemService.updateItem(item, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id){
        groceryItemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}

package com.example.OnlineGrocery.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineGrocery.Entity.GroceryItem;
import com.example.OnlineGrocery.Exception.ResourceNotFoundException;
import com.example.OnlineGrocery.Repository.GroceryItemRepository;
import com.example.OnlineGrocery.Service.GroceryItemService;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getItemById(Long id) {
        return groceryItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not found"));
    }

    @Override
    public GroceryItem createItem(GroceryItem groceryItem) {
       return groceryItemRepository.save(groceryItem);
    }

    @Override
    public GroceryItem updateItem(GroceryItem groceryItem, Long id) {
        GroceryItem g=getItemById(id);
        g.setName(groceryItem.getName());
        g.setPrice(groceryItem.getPrice());
        g.setCategory(groceryItem.getCategory());
        g.setQuantity(groceryItem.getQuantity());
        return groceryItemRepository.save(g);
    }

    @Override
    public void deleteItem(Long id) {
        GroceryItem g=getItemById(id);
        groceryItemRepository.delete(g);
    }

}

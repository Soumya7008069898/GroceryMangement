package com.example.OnlineGrocery.Service;

import java.util.List;

import com.example.OnlineGrocery.Entity.GroceryItem;

public interface GroceryItemService {
    List<GroceryItem> getAllItems();
    GroceryItem getItemById(Long id);
    GroceryItem createItem(GroceryItem groceryItem);
    GroceryItem updateItem(GroceryItem groceryItem,Long id);
    void deleteItem(Long id);
}

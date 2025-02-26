package com.example.OnlineGrocery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineGrocery.Entity.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem,Long> {

}

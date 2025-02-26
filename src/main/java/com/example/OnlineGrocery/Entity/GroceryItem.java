package com.example.OnlineGrocery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="GroceryItems")
public class GroceryItem {
    private String name;
    private String category;
    private Integer quantity;
    private Double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

package com.example.OnlineGrocery.Entity;

import jakarta.persistence.Column;
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
@Table(name="customers")
public class Customer {
    private String name;
    @Column(unique=true,nullable=false)
    private String email;
    private String address;
    private String phone;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

package com.example.OnlineGrocery.DTO;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
    private Long customerId;
    private List<Long> groceryIds;
}

package com.example.db.store;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stores {
    @Id
    private Long storeId;
    private String storeName;
    private String storeAddress;

}

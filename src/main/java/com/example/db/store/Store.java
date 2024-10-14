package com.example.db.store;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long Id;
    @Column(name = "store_name", nullable = false)
    private String storeName;
    @Column(name = "store_address")
    private String storeAddress;

}

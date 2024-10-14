package com.example.db.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT s FROM Store s WHERE s.name LIKE %?1%")
    List<Store> findByNameContain(String name);

    @Modifying //파라미터만 가지고 쿼리를 수정할 수 있게 하는 어노테이션
    @Query("delete from Store s where s.name = ?1")
    void deleteByName(String name);

    @Query("select s from Store s where s.id >= 5")
    List<Store> findStoreById(Long id);

    @Query("select s from Store s where s.name || s.address like %?1%")
    List<Store> findStoreByNameOrAddress(String str);
}
package com.example.db.store;

import ch.qos.logback.core.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public void saveStore(@RequestBody Store store){
        storeService.save(store);
    }

    @PutMapping("{id}")
    public void updateStore(
            @PathVariable Long id,@RequestBody Store store){
        storeService.update(id, store);
    }

    @GetMapping
    public List<Store> getAllStores(
            @RequestParam(
                    name = "name",
                    required = false
            ) String name
    ){
        if(!StringUtil.isNullOrEmpty(name)) return storeService.getByContainName(name);
        return storeService.getAll();
    }

    @GetMapping("{id}")
    public Store getById(@PathVariable Long id){
        return storeService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        storeService.deleteById(id);
    }
}

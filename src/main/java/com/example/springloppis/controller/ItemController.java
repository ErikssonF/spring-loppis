package com.example.springloppis.controller;

import com.example.springloppis.entity.ItemEntity;
import com.example.springloppis.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService){

        this.itemService = itemService;
    }

    @PostMapping("")
    public ItemEntity createItem(@RequestBody ItemEntity item){
        return itemService.createItem(item);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

    @GetMapping("{id}")
    public Optional<ItemEntity> findItemById(@PathVariable Long id){
        return itemService.findItemById(id);
    }

    @GetMapping("")
    public Iterable<ItemEntity> findAllItems(){
        return itemService.findAllItems();
    }

}

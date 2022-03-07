package com.example.springloppis.controller;

import com.example.springloppis.entity.ItemEntity;
import com.example.springloppis.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity itemEntity){
        ItemEntity createdItem = itemService.createItem(itemEntity);

        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){

        itemService.deleteItem(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ItemEntity>> findItemById(@PathVariable Long id){
        Optional<ItemEntity> foundItem = itemService.findItemById(id);
        return new ResponseEntity<>(foundItem, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<ItemEntity>> findAllItems(){
        Iterable<ItemEntity> allItems = itemService.findAllItems();
        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }

}

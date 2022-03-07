package com.example.springloppis.controller;

import com.example.springloppis.entity.ItemEntity;
import com.example.springloppis.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {

    ItemService itemService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);


    public ItemController(ItemService itemService){

        this.itemService = itemService;
    }

    @PostMapping("")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity itemEntity){
        ItemEntity createdItem = itemService.createItem(itemEntity);

        logger.trace("vi loggar på TRACE-nivå");
        logger.debug("vi loggar på debug-nivå");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

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

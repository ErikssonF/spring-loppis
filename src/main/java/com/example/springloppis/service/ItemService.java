package com.example.springloppis.service;

import com.example.springloppis.entity.ItemEntity;
import com.example.springloppis.repository.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }

    public ItemEntity createItem(ItemEntity item){

        return itemRepo.save(item);
    }

    public void deleteItem(Long id){

        Optional<ItemEntity> foundItem = itemRepo.findById(id);
        itemRepo.deleteById(foundItem.get().getId());
    }

    public Optional<ItemEntity> findItemById(Long id){
        return itemRepo.findById(id);
    }

    public Iterable<ItemEntity> findAllItems(){
        return itemRepo.findAll();
    }
}

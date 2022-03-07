package com.example.springloppis.service;

import com.example.springloppis.entity.ItemEntity;
import com.example.springloppis.repository.ItemRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ItemService {

    ItemRepo itemRepo;
    BeanScopesDemo beanScopesDemo;

    public ItemService(ItemRepo itemRepo, BeanScopesDemo beanScopesDemo){
        this.itemRepo = itemRepo;
        this.beanScopesDemo = beanScopesDemo;
    }

    public ItemEntity createItem(ItemEntity item){

        return itemRepo.save(item);
    }

    public void deleteItem(Long id){

        ItemEntity foundItem = itemRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        itemRepo.deleteById(foundItem.Id());
    }

    public Optional<ItemEntity> findItemById(Long id){
        return itemRepo.findById(id);
    }

    public Iterable<ItemEntity> findAllItems(){
        return itemRepo.findAll();
    }
}

package com.example.springloppis.repository;

import com.example.springloppis.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<ItemEntity, Long> {



}

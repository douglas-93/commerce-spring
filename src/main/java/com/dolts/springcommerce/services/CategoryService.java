package com.dolts.springcommerce.services;

import com.dolts.springcommerce.entities.Category;
import com.dolts.springcommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> user = repository.findById(id);
        return user.get();
    }
}

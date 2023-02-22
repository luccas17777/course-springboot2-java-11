package com.ibm.course.services;

import com.ibm.course.entities.Category;
import com.ibm.course.entities.Order;
import com.ibm.course.repositories.CategoryRepository;
import com.ibm.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRep;

    public List<Category> findAll(){
        return categoryRep.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRep.findById(id);
        return obj.get();
    }
}

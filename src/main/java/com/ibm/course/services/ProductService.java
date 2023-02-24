package com.ibm.course.services;

import com.ibm.course.entities.Product;
import com.ibm.course.entities.User;
import com.ibm.course.repositories.ProductRepository;
import com.ibm.course.repositories.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRep;

    public List<Product> findAll(){
        return productRep.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = productRep.findById(id);
        return obj.get();
    }
}

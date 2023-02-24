package com.ibm.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@Transient //Essa notação impede que o JPA tente interpretar essa linha
    @JsonIgnore //Porque senão vai ficar com looping infinito quando chamarmos a rota no insomnia
    @ManyToMany(mappedBy = "categories") //O nome que colocamos no mappedBy, é o nome da coleção que temos na classe product, ou seja, categories.
    private Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

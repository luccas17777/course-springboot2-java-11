package com.ibm.course.entities;

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
@Table(name = "tb_product")
public class Product implements Serializable {
       private static final long serialVersionUID=1L;
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;
       private String description;
       private Double price;
       private String imgUrl;

       //@Transient //Essa notação impede que o JPA tente interpretar essa linha
       @ManyToMany //Associação muitos para muitos. Quando isto acontece é criado uma tabela no banco que é simplesmente a junção de duas entidades.
       @JoinTable(name = "tb_product_category", //name: o nome da tabela de a associação no banco de dados
               joinColumns = @JoinColumn(name = "product_id"), //joinColumns: estamos falando qual o nome da chave estrangeira referente a tabela de produto, ou em termos técnicos, a classe dominate.
               inverseJoinColumns = @JoinColumn(name = "category_id") //inverseJoinColumns: serve para definir qual a chave estrangeira da outra entidade, no caso, categoria.
       )
       private Set<Category> categories = new HashSet<>();

       public Product(Long id, String name, String description, Double price, String imgUrl) {
              this.id = id;
              this.name = name;
              this.description = description;
              this.price = price;
              this.imgUrl = imgUrl;
       }
}

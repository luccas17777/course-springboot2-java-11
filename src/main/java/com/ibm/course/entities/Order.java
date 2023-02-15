package com.ibm.course.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne //Muitos para um. Essa notação indica para o JPA que esse atributo é uma chave estrangeira no meu banco
    @JoinColumn(name = "client_id") //@JoinColumn é utilizado para nomearmos a coluna que possui a chave-estrangeira requerida pela associação.
    private User client;
}

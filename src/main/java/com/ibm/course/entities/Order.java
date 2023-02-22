package com.ibm.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //Essa notação garante que este atributo do tipo Instant, seja mostrado, no Json de resposta, no formato de String do ISO 8601.
    private Instant moment;

    @ManyToOne //Muitos para um. Essa notação indica para o JPA que esse atributo é uma chave estrangeira no meu banco
    @JoinColumn(name = "client_id") //@JoinColumn é utilizado para nomearmos a coluna que possui a chave-estrangeira requerida pela associação.
    private User client;
}

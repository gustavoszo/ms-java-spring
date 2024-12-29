package br.com.alurafood.pedidos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Order {

    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<OrderItem> itens;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Status status;

}

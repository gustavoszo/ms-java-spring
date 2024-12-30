package br.com.alurafood.pedidos.repositories.projection;

import br.com.alurafood.pedidos.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public interface OrderProjection {

    Long getId();
    LocalDateTime getDate();
    Status getStatus();

}

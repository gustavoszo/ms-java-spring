package br.com.alurafood.pedidos.web.dto;

import br.com.alurafood.pedidos.entities.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ResponseOrderDto {

    private Long id;

    private LocalDateTime date;

    private Status status;

}

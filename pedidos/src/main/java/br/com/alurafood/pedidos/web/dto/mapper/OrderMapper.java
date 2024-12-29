package br.com.alurafood.pedidos.web.dto.mapper;

import br.com.alurafood.pedidos.entities.Order;
import br.com.alurafood.pedidos.web.dto.OrderItemDto;
import br.com.alurafood.pedidos.web.dto.RequestOrderDto;
import br.com.alurafood.pedidos.web.dto.ResponseOrderDto;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    public static Order toOrder(RequestOrderDto dto) {
        return new ModelMapper().map(dto, Order.class);
    }

    public static ResponseOrderDto toResponseOrderDto(Order order) {
        return new ModelMapper().map(order, ResponseOrderDto.class);
    }

}

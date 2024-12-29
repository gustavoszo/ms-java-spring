package br.com.alurafood.pedidos.web.dto.mapper;

import br.com.alurafood.pedidos.entities.Order;
import br.com.alurafood.pedidos.web.dto.RequestOrderDto;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    public static Order toOrder(RequestOrderDto dto) {
        return new ModelMapper().map(dto, Order.class);
    }

}

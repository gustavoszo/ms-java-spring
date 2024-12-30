package br.com.alurafood.pedidos.web.dto.mapper;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.alurafood.pedidos.entities.Order;
import br.com.alurafood.pedidos.web.dto.RequestOrderDto;
import br.com.alurafood.pedidos.web.dto.ResponseOrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OrderMapper {

    public static Order toOrder(RequestOrderDto dto) {
        return new ModelMapper().map(dto, Order.class);
    }

    public static ResponseOrderDto toResponseOrder(Order order) {
        ResponseOrderDto orderDto =  new ModelMapper().map(order, ResponseOrderDto.class);
        orderDto.setItens(OrderItemMapper.toResponseOrderItemList(order.getItens()));
        return orderDto;
    }

}

package br.com.alurafood.pedidos.web.dto.mapper;

import br.com.alurafood.pedidos.entities.OrderItem;
import br.com.alurafood.pedidos.web.dto.OrderItemDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemMapper {

    public static OrderItem toOrderItem(OrderItemDto dto) {
        return new ModelMapper().map(dto, OrderItem.class);
    }

    public static List<OrderItem> toOrderItemList(List<OrderItemDto> dto) {
        return dto.stream()
                .map(i -> toOrderItem(i))
                .collect(Collectors.toList());
    }

}

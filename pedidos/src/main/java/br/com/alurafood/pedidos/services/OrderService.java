package br.com.alurafood.pedidos.services;

import br.com.alurafood.pedidos.entities.Order;
import br.com.alurafood.pedidos.entities.Status;
import br.com.alurafood.pedidos.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order create(Order order)
    {
        order.setDate(LocalDateTime.now());
        order.setStatus(Status.REALIZED);
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Page<Order> findAll(Pageable pageable)
    {
        return orderRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Order findById(Long id)
    {
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id)
    {
        orderRepository.deleteById(id);
    }
}

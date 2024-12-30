package br.com.alurafood.pagamentos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pedidos", url = "http://gustavo:8082/pedidos")
// @FeignClient(name = "pedidos") // Usando a anotação @FeignClient com o nome do microserviço registrado no service discovery(Eureka), não é necessário especificar explicitamente o endereço URL do serviço, pois o Spring Cloud usa o service discovery para localizar dinamicamente o serviço no cluster de microserviços.
public interface OrderClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}/paid")
    void updateOrderStatus(@PathVariable Long id);

    /* Exemplo se fosse necessário mandar body
    @RequestMapping(method = RequestMethod.PATCH, value = "/orders/{id}/paid", consumes = "application/json", produces = "application/json")
    Order updateOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatusUpdate update);
    */
}
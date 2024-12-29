package br.com.alurafood.pedidos.repositories;

import br.com.alurafood.pedidos.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    /*
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(Status status, Pedido pedido);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);
    */

}

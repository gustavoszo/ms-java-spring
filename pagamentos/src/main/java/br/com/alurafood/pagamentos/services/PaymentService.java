package br.com.alurafood.pagamentos.services;

import br.com.alurafood.pagamentos.clients.OrderClient;
import br.com.alurafood.pagamentos.entities.Payment;
import br.com.alurafood.pagamentos.entities.Status;
import br.com.alurafood.pagamentos.exceptions.EntityNotFoundException;
import br.com.alurafood.pagamentos.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderClient orderClient;

    @Transactional(readOnly = true)
    public Page<Payment> findAll(Pageable pageable)
    {
        return paymentRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Payment findById(Long id)
    {
        return paymentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Payment create(Payment payment)
    {
        return paymentRepository.save(payment);
    }

    @Transactional
    public void delete(Long id)
    {
        paymentRepository.deleteById(id);
    }

    @Transactional
    public void confirmPayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Order com id '%s' não encontrado", id)));
        payment.setStatus(Status.CONFIRMED);

        // chamada para o microserviço de pedidos
        orderClient.updateOrderStatus(payment.getOrderId());
    }
}

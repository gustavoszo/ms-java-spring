package br.com.alurafood.pagamentos.services;

import org.springframework.transaction.annotation.Transactional;
import br.com.alurafood.pagamentos.clients.OrderClient;
import br.com.alurafood.pagamentos.entities.Payment;
import br.com.alurafood.pagamentos.entities.enums.Status;
import br.com.alurafood.pagamentos.exceptions.EntityNotFoundException;
import br.com.alurafood.pagamentos.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return paymentRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(String.format("Payment com id '%s' não encontrado", id)));
    }

    @Transactional
    public Payment create(Payment payment)
    {
        var orderExists = orderClient.orderExists(payment.getOrder());
        if (!orderExists.getExists()) throw new EntityNotFoundException(String.format("Order com id '%s' não encontrado", payment.getOrder()));
        payment.setStatus(Status.CREATED);
        return paymentRepository.save(payment);
    }

    @Transactional
    public void delete(Long id)
    {
        findById(id);
        paymentRepository.deleteById(id);
    }

    @Transactional
    public void confirmPayment(Long id) {
        Payment payment = findById(id);
        payment.setStatus(Status.CONFIRMED);

        // chamada para o microserviço de pedidos
        orderClient.updateOrderStatus(payment.getOrder());
    }

    @Transactional
    public void statusChange(Long id) {
        Payment payment = findById(id);
        payment.setStatus(Status.CONFIRMED_WITHOUT_INTEGRATION);
    }
}

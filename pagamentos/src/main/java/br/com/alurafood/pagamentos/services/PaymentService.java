package br.com.alurafood.pagamentos.services;

import br.com.alurafood.pagamentos.entities.Payment;
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

}

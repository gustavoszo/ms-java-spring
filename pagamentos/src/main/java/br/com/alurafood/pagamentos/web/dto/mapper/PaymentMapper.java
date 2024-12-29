package br.com.alurafood.pagamentos.web.dto.mapper;

import br.com.alurafood.pagamentos.entities.Payment;
import br.com.alurafood.pagamentos.web.dto.RequestPaymentDto;
import org.modelmapper.ModelMapper;

public class PaymentMapper {

    public static Payment toPayment(RequestPaymentDto dto) {
        return new ModelMapper().map(dto, Payment.class);
    }

}

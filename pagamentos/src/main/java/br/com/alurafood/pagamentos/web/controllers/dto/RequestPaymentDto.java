package br.com.alurafood.pagamentos.web.controllers.dto;

import br.com.alurafood.pagamentos.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class RequestPaymentDto {

    @NotNull
    private BigDecimal value;

    @NotBlank
    @Size(min = 5, max = 150)
    private String name;

    @NotBlank
    @Positive
    private String number;

    @NotBlank
    private String expire;

    @NotBlank
    private String code;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentTypeId;

}

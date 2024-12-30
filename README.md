# **Microserviços - Gerenciamento de Pedidos e Pagamentos**

O projeto implementa uma arquitetura de microserviços para gerenciar pedidos e pagamentos. O sistema realiza a comunicação síncrona entre os microserviços de **Pedidos** e **Pagamentos** usando **OpenFeign** e **Service Discovery** com **Eureka**.

### **Tecnologias Utilizadas**

- Java 21
- Spring Boot (Spring Web, Spring Data JPA, Validation)
- Spring Cloud:
  - Service Discovery com Eureka
  - Spring Cloud Gateway
  - Spring Cloud OpenFeign
  - Spring Cloud Circuit Breaker
- Banco de Dados: MySQL

## **Visão Geral dos Microserviços**

O sistema é composto pelos microserviços:

1. **Serviço de Pagamentos**: Responsável por gerenciar o processamento de pagamentos e a comunicação com o serviço de pedidos quando um pagamento é aprovado.
2. **Serviço de Pedidos**: Responsável pelo gerenciamento de pedidos e interação com o serviço de pagamentos para registrar a aprovação dos pagamentos.


## **Arquitetura**

A arquitetura do sistema utiliza **Spring Cloud** para a comunicação entre os microserviços e o gerenciamento de falhas:

- **Eureka Server**: Usado para registrar e localizar microserviços.
- **Gateway**: Usado para os serviços possuirem um ponto de entrada único

# 0331-kotlin-payment-event-tracker

Este projeto é uma aplicação que gerencia o fluxo de pagamento de pedidos, registrando os eventos de cada etapa do processo. Ele usa o Spring Boot com AOP (Aspect-Oriented Programming) e Reflection para interceptar e registrar as etapas do pagamento, como validação, processamento e finalização. 

O sistema utiliza um banco de dados em memoria para persistir os eventos de pagamento.

## Funcionalidades

- **Validação do pagamento**: Verifica se o pagamento pode ser processado.
- **Processamento do pagamento**: Realiza o processamento real do pagamento (simulado com delay).
- **Finalização do pagamento**: Conclui o pagamento e registra o evento.

A cada etapa do processo de pagamento, um evento é registrado no banco de dados, o que permite um rastreamento detalhado do fluxo de pagamento.

## Tecnologias

- **Spring Boot**: Framework para desenvolvimento de aplicativos Java com foco em configuração mínima.
- **Spring AOP (Aspect-Oriented Programming)**: Usado para interceptar a execução de métodos e registrar eventos.
- **JPA/Hibernate**: Para persistência dos dados no banco de dados.
- **H2** (ou outro banco relacional): Para armazenamento dos dados de eventos de pagamento.

## Estrutura do Projeto

    src/
    ├── main/
    │   ├── kotlin/
    │   │   └── br/
    │   │       └── devbean/
    │   │           └── paymenteventtracker/
    │   │               ├── controllers/           # Controladores REST
    │   │               ├── datasources/           # Entidades e repositórios
    │   │                   ├── entities/          # Entidades 
    │   │                   ├── repository/        # Repositórios JPA
    │   │               ├── services/              # Lógica de negócios
    │   │               └── aspects/               # Aspectos para interceptar e registrar eventos
    │   │               └── enums/                 # Enum para controle dos steps
    │   ├── resources/
    │   │   └── application.properties              # Configurações da aplicação
    └── test/                                        # Testes da aplicação


## Endpoints

A aplicação expõe o seguinte endpoint para o processamento de pagamentos:

### `POST /api/payments`

- **Descrição**: Processa o pagamento de um pedido.
- **Parâmetros**:
    - `order`: O identificador do pedido (do tipo `Long`).
- **Resposta**:
    - **200 OK**: Retorna "Payment Processed" se o pagamento for processado com sucesso.
    - **500 Internal Server Error**: Retorna uma mensagem de erro caso algum problema ocorra durante o processamento.

### Exemplo de Requisição:

```bash
curl -X GET "http://localhost:8080/api/payments?order=12345"
```

### Exemplo de Resposta:
```bash
  "Payment Processed"
```

## Dependências
-	Spring Boot Starter Web: Para criar o servidor web e expor os endpoints REST.
-	Spring Boot Starter Data JPA: Para integração com o banco de dados e uso de JPA.
-	H2 Driver: Para se conectar ao banco de dados H2.
-	Spring AOP: Para aplicar aspectos, como o registro de eventos durante o processo de pagamento.


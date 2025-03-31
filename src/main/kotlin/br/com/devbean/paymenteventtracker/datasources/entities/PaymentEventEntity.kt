package br.com.devbean.paymenteventtracker.datasources.entities

import jakarta.persistence.*

/**
 * Entidade que representa um evento de pagamento no banco de dados.
 * Cada instância dessa classe corresponde a um registro na tabela 'payment_event'.
 */
@Entity
@Table(name = "payment_event")
data class PaymentEventEntity(

    /**
     * Identificador único do evento de pagamento.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    /**
     * Nome da etapa do pagamento (ex: VALIDATE, PROCESS, FINALIZE).
     */
    @Column(name = "step")
    val step: String,

    /**
     * Descrição do evento ocorrido nesta etapa.
     */
    @Column(name = "description")
    val description: String,

    /**
     * Identificador do pedido associado ao evento.
     */
    @Column(name = "num_order")
    val order: Long
)
package br.com.devbean.paymenteventtracker.datasources.repository

import br.com.devbean.paymenteventtracker.datasources.entities.PaymentEventEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repositório responsável por gerenciar operações de banco de dados para eventos de pagamento.
 * Extende JpaRepository para fornecer métodos CRUD automáticos.
 *
 * @see JpaRepository
 */
interface PaymentEventRespository : JpaRepository<PaymentEventEntity, Long>
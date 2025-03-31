package br.com.devbean.paymenteventtracker.services

import br.com.devbean.paymenteventtracker.annotations.EventStep
import br.com.devbean.paymenteventtracker.enums.StepData
import org.springframework.stereotype.Service

/**
 * Serviço responsável pelo fluxo de pagamento.
 * Cada método representa uma etapa do processo de pagamento e
 * é interceptado por aspectos para registro de eventos.
 */
@Service
class PaymentService {

    /**
     * Valida o pagamento antes do processamento.
     * Anotado com @EventStep para rastrear a execução desta etapa.
     */
    @EventStep(StepData.VALIDATE)
    fun validatePayment(order: Long) {
        println("Validating Payment...")
    }

    /**
     * Processa o pagamento.
     * A execução inclui uma simulação de tempo de processamento com Thread.sleep().
     */
    @EventStep(StepData.PROCESS)
    fun processPayment(order: Long) {
        println("Processing Payment...")
        Thread.sleep(10 * 1000) // Simula um tempo de processamento de 10 segundos
    }

    /**
     * Finaliza o pagamento após o processamento.
     * Última etapa do fluxo de pagamento.
     */
    @EventStep(StepData.FINALIZE)
    fun finalizePayment(order: Long) {
        println("Finalizing Payment...")
    }
}

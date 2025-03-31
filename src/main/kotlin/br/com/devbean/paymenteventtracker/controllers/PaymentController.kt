package br.com.devbean.paymenteventtracker.controllers

import br.com.devbean.paymenteventtracker.services.PaymentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Controlador REST responsável por gerenciar o fluxo de pagamentos.
 * Este controlador expõe um endpoint que processa o pagamento de um pedido.
 */
@RestController
@RequestMapping("api/payments")
class PaymentController(private val service: PaymentService) { // Injeta a dependência do serviço de pagamento

    /**
     * Método para processar o pagamento de um pedido.
     *
     * @param order O identificador do pedido (order) que será processado.
     * @return Uma mensagem indicando o status do pagamento (sucesso ou erro).
     */
    @GetMapping
    fun processPayment(@RequestParam order: Long): String {

        return try {
            // Valida o pagamento
            service.validatePayment(order)
            // Processa o pagamento
            service.processPayment(order)
            // Finaliza o pagamento
            service.finalizePayment(order)
            // Retorna mensagem de sucesso
            "Payment Processed"
        } catch (ex: Exception) {
            // Retorna mensagem de erro com detalhes da exceção
            "Error processing payment ${ex.message}"
        }
    }
}
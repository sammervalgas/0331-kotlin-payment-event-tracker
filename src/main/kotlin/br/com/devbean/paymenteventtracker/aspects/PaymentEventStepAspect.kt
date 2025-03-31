package br.com.devbean.paymenteventtracker.aspects

import br.com.devbean.paymenteventtracker.annotations.EventStep
import br.com.devbean.paymenteventtracker.datasources.entities.PaymentEventEntity
import br.com.devbean.paymenteventtracker.datasources.repository.PaymentEventRespository
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * A classe PaymentEventStepAspect é um aspecto do Spring AOP que intercepta métodos
 * anotados com @EventStep e registra eventos de pagamento antes e depois de sua execução.
 *
 * O uso da anotação @Around("@annotation(eventStep)") permite que o método handleEventStep
 * execute lógica antes e depois do método interceptado, garantindo que cada etapa do
 * pagamento seja devidamente registrada no banco de dados.
 *
 * Como funciona:
 * 1. Interceptação: Captura métodos anotados com @EventStep.
 * 2. Extração de parâmetros: Obtém o identificador do pedido (order).
 * 3. Execução antes do método original: Pode registrar logs e validar dados.
 * 4. Execução do método original: Chama joinPoint.proceed() para continuar.
 * 5. Execução após o método original: Cria e salva um evento de pagamento.
 * 6. Retorno do resultado: O retorno do método original é repassado adiante.
 *
 * Esse aspecto melhora a rastreabilidade e auditoria do fluxo de pagamento.
 */
@Aspect
@Component
class PaymentEventStepAspect(private val repository: PaymentEventRespository) {

    /**
     * Intercepta a execução de métodos anotados com @EventStep e registra o evento no banco.
     */
    @Around("@annotation(eventStep)")
    fun handleEventStep(
        joinPoint: ProceedingJoinPoint,
        eventStep: EventStep
    ): Any? {

        // Obtém os argumentos do método interceptado
        val args = joinPoint.args
        // Extrai o identificador do pedido (order) a partir dos argumentos
        val order = args[0] as Long
        // Obtém o nome da etapa do evento a partir da anotação
        val stepName = eventStep.step.value

        // Log da execução do evento
        println("Executing EventStep: $stepName for order: $order")

        // Executa o método original
        val result = joinPoint.proceed()

        // Cria um objeto de evento de pagamento para armazenar os detalhes
        val event = PaymentEventEntity(
            step = stepName,
            description = "Event executed: $stepName",
            order = order
        )

        // Salva o evento no banco de dados
        repository.save(event)

        // Retorna o resultado da execução do método original
        return result
    }
}
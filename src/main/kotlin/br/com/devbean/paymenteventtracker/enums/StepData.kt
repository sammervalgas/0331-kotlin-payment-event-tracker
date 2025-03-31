package br.com.devbean.paymenteventtracker.enums

/**
 * Enumeração que representa as etapas do processo de pagamento.
 * Cada etapa é associada a uma string que descreve o nome da etapa.
 *
 * As etapas são usadas para rastrear o progresso do pagamento e são utilizadas em conjunto
 * com a anotação @EventStep para gerar eventos no fluxo de pagamento.
 */
enum class StepData(val value: String) {

    /**
     * Etapa de validação do pagamento.
     * Usada para indicar que o pagamento está sendo validado.
     */
    VALIDATE("STEP > VALIDATE"),

    /**
     * Etapa de processamento do pagamento.
     * Usada quando o pagamento está sendo processado.
     */
    PROCESS("STEP > PROCESS"),

    /**
     * Etapa de finalização do pagamento.
     * Usada para indicar que o pagamento foi finalizado.
     */
    FINALIZE("STEP > FINALIZE");

}
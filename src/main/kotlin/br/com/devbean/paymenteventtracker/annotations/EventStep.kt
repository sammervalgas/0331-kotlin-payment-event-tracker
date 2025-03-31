package br.com.devbean.paymenteventtracker.annotations

import br.com.devbean.paymenteventtracker.enums.StepData

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventStep(val step: StepData)

package net.elau.example.debeziumcdckafka.event.stream

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.messaging.Sink.INPUT
import org.springframework.messaging.SubscribableChannel

interface StreamBinding {

    @Input(INPUT)
    fun subscriber(): SubscribableChannel
}
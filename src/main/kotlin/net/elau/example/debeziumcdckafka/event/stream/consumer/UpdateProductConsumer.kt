package net.elau.example.debeziumcdckafka.event.stream.consumer

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink.INPUT
import org.springframework.stereotype.Component

@Component
class UpdateProductConsumer {

    companion object {
        private val log = LoggerFactory.getLogger(UpdateProductConsumer::class.java)
    }

    @StreamListener(INPUT)
    fun consume(payload: String) {
        log.debug("Kafka stream event received: {}", payload)
    }
}
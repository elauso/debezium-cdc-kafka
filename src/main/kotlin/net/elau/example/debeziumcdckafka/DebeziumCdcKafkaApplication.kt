package net.elau.example.debeziumcdckafka

import net.elau.example.debeziumcdckafka.event.stream.StreamBinding
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
@EnableBinding(StreamBinding::class)
class DebeziumCdcKafkaApplication

fun main(args: Array<String>) {
    runApplication<DebeziumCdcKafkaApplication>(*args)
}

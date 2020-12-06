package net.elau.example.debeziumcdckafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DebeziumCdcKafkaApplication

fun main(args: Array<String>) {
	runApplication<DebeziumCdcKafkaApplication>(*args)
}

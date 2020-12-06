package net.elau.example.debeziumcdckafka.repository

import net.elau.example.debeziumcdckafka.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}
package net.elau.example.debeziumcdckafka.dto

import net.elau.example.debeziumcdckafka.model.ProductType

data class CreateProductDto(

    val name: String,

    val description: String?,

    val type: ProductType
)
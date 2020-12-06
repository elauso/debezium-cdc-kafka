package net.elau.example.debeziumcdckafka.dto

import net.elau.example.debeziumcdckafka.model.ProductType

data class UpdateProductDto(

    val id: Long,

    val name: String? = null,

    val description: String? = null,

    val type: ProductType? = null
)
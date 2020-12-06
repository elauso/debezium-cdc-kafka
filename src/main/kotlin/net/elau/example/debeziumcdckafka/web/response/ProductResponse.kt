package net.elau.example.debeziumcdckafka.web.response

import net.elau.example.debeziumcdckafka.model.ProductType

data class ProductResponse(

    val id: Long,

    val name: String,

    val description: String?,

    val type: ProductType
)
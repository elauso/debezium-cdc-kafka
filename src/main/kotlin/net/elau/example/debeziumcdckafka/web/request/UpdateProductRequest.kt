package net.elau.example.debeziumcdckafka.web.request

import net.elau.example.debeziumcdckafka.model.ProductType

data class UpdateProductRequest(

    val name: String?,

    val description: String?,

    val type: ProductType?
)
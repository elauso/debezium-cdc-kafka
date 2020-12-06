package net.elau.example.debeziumcdckafka.web.request

import net.elau.example.debeziumcdckafka.model.ProductType
import javax.validation.constraints.NotBlank

data class CreateProductRequest(

    @field:NotBlank
    val name: String,

    val description: String?,

    @field:NotBlank
    val type: ProductType
)
package net.elau.example.debeziumcdckafka.mapper

import net.elau.example.debeziumcdckafka.dto.ProductDto
import net.elau.example.debeziumcdckafka.model.Product
import net.elau.example.debeziumcdckafka.web.response.ProductResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProductMapper {

    fun toDto(productList: List<Product>): List<ProductDto>

    fun toResponse(productDtoList: List<ProductDto>): List<ProductResponse>
}
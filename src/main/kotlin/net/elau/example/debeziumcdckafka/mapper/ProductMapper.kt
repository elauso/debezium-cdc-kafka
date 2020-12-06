package net.elau.example.debeziumcdckafka.mapper

import net.elau.example.debeziumcdckafka.dto.CreateProductDto
import net.elau.example.debeziumcdckafka.dto.ProductDto
import net.elau.example.debeziumcdckafka.dto.UpdateProductDto
import net.elau.example.debeziumcdckafka.model.Product
import net.elau.example.debeziumcdckafka.web.request.CreateProductRequest
import net.elau.example.debeziumcdckafka.web.request.UpdateProductRequest
import net.elau.example.debeziumcdckafka.web.response.ProductResponse
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.NullValuePropertyMappingStrategy.IGNORE

@Mapper(componentModel = "spring")
interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    fun updateFromDto(updateProductDto: UpdateProductDto, @MappingTarget product: Product)

    fun toModel(createProductDto: CreateProductDto): Product

    fun toDto(productList: List<Product>): List<ProductDto>

    fun toDto(product: Product): ProductDto

    fun toDto(createProductRequest: CreateProductRequest): CreateProductDto

    @Mapping(target = "id", source = "productId")
    fun toDto(updateProductRequest: UpdateProductRequest, productId: Long): UpdateProductDto

    fun toResponse(productDtoList: List<ProductDto>): List<ProductResponse>

    fun toResponse(productDto: ProductDto): ProductResponse
}
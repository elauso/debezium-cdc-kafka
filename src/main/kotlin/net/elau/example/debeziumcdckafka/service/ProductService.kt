package net.elau.example.debeziumcdckafka.service

import net.elau.example.debeziumcdckafka.dto.CreateProductDto
import net.elau.example.debeziumcdckafka.dto.ProductDto
import net.elau.example.debeziumcdckafka.dto.UpdateProductDto
import net.elau.example.debeziumcdckafka.mapper.ProductMapper
import net.elau.example.debeziumcdckafka.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productMapper: ProductMapper,
    private val productRepository: ProductRepository
) {

    @Transactional(propagation = NOT_SUPPORTED)
    fun findAll() = productMapper.toDto(productRepository.findAll())

    @Transactional(propagation = NOT_SUPPORTED)
    fun find(id: Long) = productMapper.toDto(productRepository.findById(id).orElseThrow())

    @Transactional
    fun create(createProductDto: CreateProductDto): ProductDto {
        val product = productRepository.save(productMapper.toModel(createProductDto))
        return productMapper.toDto(product)
    }

    @Transactional
    fun update(updateProductDto: UpdateProductDto): ProductDto {
        val product = productRepository.findById(updateProductDto.id).orElseThrow()
        productMapper.updateFromDto(updateProductDto, product)
        productRepository.save(product)
        return productMapper.toDto(product)
    }

    @Transactional
    fun delete(id: Long) = productRepository.deleteById(id)
}
package net.elau.example.debeziumcdckafka.service

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
}
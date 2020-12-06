package net.elau.example.debeziumcdckafka.web.controller

import net.elau.example.debeziumcdckafka.mapper.ProductMapper
import net.elau.example.debeziumcdckafka.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productMapper: ProductMapper,
    private val productService: ProductService
) {

    @GetMapping
    fun findAll() = productMapper.toResponse(productService.findAll())
}
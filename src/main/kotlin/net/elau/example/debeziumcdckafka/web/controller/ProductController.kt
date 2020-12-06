package net.elau.example.debeziumcdckafka.web.controller

import net.elau.example.debeziumcdckafka.mapper.ProductMapper
import net.elau.example.debeziumcdckafka.service.ProductService
import net.elau.example.debeziumcdckafka.web.request.CreateProductRequest
import net.elau.example.debeziumcdckafka.web.request.UpdateProductRequest
import net.elau.example.debeziumcdckafka.web.response.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productMapper: ProductMapper,
    private val productService: ProductService
) {

    @GetMapping
    fun findAll() = productMapper.toResponse(productService.findAll())

    @GetMapping(value = ["/{id}"])
    fun find(@PathVariable("id") id: Long) = productMapper.toResponse(productService.find(id))

    @PostMapping
    fun create(
        @RequestBody @Valid createProductRequest: CreateProductRequest,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Void> {
        val productDto = productService.create(productMapper.toDto(createProductRequest))
        val uriComponents = uriComponentsBuilder.path("/api/products/{id}").buildAndExpand(productDto.id)
        return ResponseEntity.created(uriComponents.toUri()).build()
    }

    @PatchMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody updateProductRequest: UpdateProductRequest): ProductResponse {
        val productDto = productService.update(productMapper.toDto(updateProductRequest, id))
        return productMapper.toResponse(productDto)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Long) = productService.delete(id)
}
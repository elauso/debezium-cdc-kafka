package net.elau.example.debeziumcdckafka.model

import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Enumerated(STRING)
    @Column(name = "type")
    var type: ProductType? = null
)
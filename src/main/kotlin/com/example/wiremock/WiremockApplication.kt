package com.example.wiremock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WiremockApplication

fun main(args: Array<String>) {
    runApplication<WiremockApplication>(*args)
}

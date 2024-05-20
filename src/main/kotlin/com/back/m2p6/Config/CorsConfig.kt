package com.back.m2p6.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://172.16.0.3:3000")
        //configuration.allowedOrigins = listOf("http://direcionIpContenedor:3000")
        configuration.allowedMethods = listOf("HEAD",
            "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        configuration.allowCredentials = true
        configuration.allowedHeaders = listOf("*")
        configuration.exposedHeaders = listOf("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/", configuration)
        return source
    }
}
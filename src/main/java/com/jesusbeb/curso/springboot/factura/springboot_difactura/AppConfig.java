package com.jesusbeb.curso.springboot.factura.springboot_difactura;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Esta clase es la encargada de cargar el archivo data.properties, que contiene las propiedades client.name y client.lastname, que son inyectadas en la clase Client
@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

}

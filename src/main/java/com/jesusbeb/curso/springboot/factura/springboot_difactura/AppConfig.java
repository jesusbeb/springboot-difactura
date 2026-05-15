package com.jesusbeb.curso.springboot.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jesusbeb.curso.springboot.factura.springboot_difactura.models.Item;
import com.jesusbeb.curso.springboot.factura.springboot_difactura.models.Product;

// Esta clase es la encargada de cargar el archivo data.properties, que contiene las propiedades client.name y client.lastname, que son inyectadas en la clase Client
@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    // Este método es el encargado de cargar la lista de items, que es inyectada en la clase Invoice
    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony", 800.0);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200.0);

        // Retorna una lista de items (invoice), donde cada item tiene un producto y una cantidad
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

}

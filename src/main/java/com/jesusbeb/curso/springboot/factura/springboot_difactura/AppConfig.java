package com.jesusbeb.curso.springboot.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

    @Bean
    @Primary
    List<Item> itemsInvoiceOficina() {
        Product p1 = new Product("Monitor Asus 24", 700.0);
        Product p2 = new Product("Notebook Racer", 2400.0);
        Product p3 = new Product("Impresora HP", 800.0);
        Product p4 = new Product("Escritorio Oficina", 900.0);

        // Retorna una lista de items (invoice), donde cada item tiene un producto y una cantidad
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6) , new Item(p3, 1) , new Item(p4, 4));
    }

}

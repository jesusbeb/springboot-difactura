package com.jesusbeb.curso.springboot.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// @RequestScope: El alcance de este bean es por petición, es decir, se crea una nueva instancia de Invoice para cada petición HTTP que se realice al servidor. Esto es útil cuando queremos que cada cliente tenga su propia factura durante la duración de la petición.
// @JsonIgnoreProperties({"targetSource", "advisors"}): Esta anotación se utiliza para evitar problemas de serialización al convertir el objeto Invoice a JSON. En este caso, se ignoran las propiedades targetSource y advisors que son utilizadas internamente por Spring para la gestión de proxies y aspectos, y que no son relevantes para la representación JSON de la factura.
@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    // Para la lista de items, inyectamos la lista de items que se encuentra en el método itemsInvoice() de la clase AppConfig
    @Autowired
    private List<Item> items;


    // Si intentamos mostrar el cliente y la descripción en el constructor, veremos que el cliente y la descripción son null, ya que las dependencias aún no han sido inyectadas.
    public Invoice() {
        System.out.println("Creando el componente de la factura con el constructor vacio");
        System.out.println(client);
        System.out.println(description);
    }

    // El método init() se ejecuta después de que se hayan inyectado las dependencias, es decir, después de que se haya creado el bean y se hayan inyectado las dependencias.
    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura usando PostConstruct");
        client.setName(client.getName().concat(" Pepe")); // Estas modificaciones son visibles al hacer la peticion con el controller
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }

    // El método destroy() se ejecuta antes de que el bean sea destruido, es decir, antes de que el contenedor de Spring lo elimine de la memoria.
    // Este método es útil para liberar recursos o realizar tareas de limpieza antes de que el bean sea destruido.
    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente de la factura");
    }

    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
    public Double getTotal() {
        //Double total = 0.0;
        // Para cada Item llamado item de la lista items.
        //for (Item item : items) {
        //    total += item.getImport();
        //}
        //return total;

        // Otro metodo con stream y lambda 
        return items.stream().mapToDouble(item -> item.getImport()).sum();
    }

}

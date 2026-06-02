package com.jesusbeb.curso.springboot.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {

    // Para los atributos name y lastname inyectamos los valores de las propiedades client.name y client.lastname respectivamente, que se encuentran en el archivo data.properties

    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastname;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}

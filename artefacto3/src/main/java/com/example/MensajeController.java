package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MensajeController {

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @GetMapping("/mensaje")
    public String obtenerMensaje() {
        return mensajeBienvenida;
    }
}

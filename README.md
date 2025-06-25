# Demo Spring Cloud Server

Este repositorio muestra un ejemplo sencillo de uso de Spring Cloud Config con dos servicios que consumen la configuraci\u00f3n expuesta por un servidor centralizado.

## Modulos

El proyecto est\u00e1 compuesto por varios m\u00f3dulos de Maven independientes:

- **launcher**: implementa el servidor de configuraci\u00f3n de Spring Cloud. Se inicia en el puerto `8888` y obtiene los archivos de configuraci\u00f3n desde un repositorio Git remoto definido en `application.properties`.
- **artefacto1**, **artefacto2** y **artefacto3**: aplicaciones Spring Boot que act\u00faan como clientes del servidor de configuraci\u00f3n. Cada una expone un endpoint REST `/mensaje` que devuelve el valor de `mensaje.bienvenida` recuperado del servidor.

## Requisitos

- Java 17
- Maven Wrapper inclu\u00eddo en el proyecto (`./mvnw`)

## Ejecuci\u00f3n

1. Clona el proyecto y posicionate en la ra\u00edz del repositorio.
2. Inicia el servidor de configuraci\u00f3n:

```bash
cd launcher
../mvnw spring-boot:run
```

3. En terminales separadas, inicia cada uno de los artefactos:

```bash
cd artefacto1
../mvnw spring-boot:run
```

```bash
cd artefacto2
../mvnw spring-boot:run
```

```bash
cd artefacto3
../mvnw spring-boot:run
```

4. Accede a `http://localhost:8080/mensaje`, `http://localhost:8081/mensaje` y `http://localhost:8082/mensaje` (o el puerto configurado) para ver el mensaje proporcionado por el servidor de configuraci\u00f3n.

Los cambios en la configuraci\u00f3n pueden recargarse en caliente invocando el endpoint `/actuator/refresh` de cada servicio.

## Notas

Cada m\u00f3dulo define su propio `pom.xml` y se puede construir o empaquetar de forma independiente. El servidor de configuraci\u00f3n utiliza el repositorio Git indicado en `launcher/src/main/resources/application.properties` para obtener los archivos de configuraci\u00f3n.


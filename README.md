# Foro API REST

El proyecto consiste en crear un foro API REST con Spring Boot. Este foro permite a los usuarios crear, actualizar y eliminar tópicos, así como realizar validaciones para evitar duplicados y gestionar el estado de los tópicos.

## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Capturas de Pantalla](#capturas-de-pantalla)
- [Autores](#autores)


## Características

- Creación de tópicos.
- Actualización de tópicos.
- Eliminación lógica de tópicos.
- Autenticacion de usuario por medio de tokens JWT.
- Validación para evitar duplicados de topicos.
- Gestión del estado de los tópicos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- Tokens JWT
- Spring Data JPA
- PostgreSQL
- Flyway
- Maven
- Insomnia

## Configuración del proyecto

Para usarlo debes crear una base de datos llamada challenge_foro y puedes crear variables de entorno para poner tu user y password o cambiarlos en el propierties


## Capturas del proyecto

#### Tabla de topicos en la base de datos

![Tabla topicos de la base de datos](foro-api/assets/base%20de%20datos.png)

#### Metodos http

![metodos http](foro-api/assets/metodos%20http.png)

#### Registro de topicos con el json y su respuesta

![Registro topicos](foro-api/assets/Registro%20topicos.png)

#### Lista de topicos 

![metodo get.png](foro-api/assets/metodo%20get.png)



## Autores

Darien Tejedor - https://github.com/DarienTejedor
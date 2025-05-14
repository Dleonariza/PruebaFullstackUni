# 🛒 PruebaFullstackUni - Backend de Sistema de Adquisición de Productos

Este proyecto representa el backend de un sistema de adquisición de productos mediante pedidos, desarrollado como parte de mi portafolio profesional. 
Implementado con Java y Spring Boot, el sistema ofrece autenticación segura utilizando JWT, gestión de usuarios y operaciones CRUD para usuarios, productos y pedidos.

## Características Principales

- **Desarrollo en Java 17** utilizando **Spring Boot**.
- **Autenticación y autorización** con **JWT**.
- Endpoints para **registro** y **inicio de sesión** de usuarios.
- Gestión de **usuarios**, **productos** y **pedidos**.
- Seguridad implementada con **Spring Security**.
- Arquitectura organizada por capas (controladores, servicios, repositorios).
- Manejo centralizado de excepciones.
- Conexión a base de datos mediante **JPA/Hibernate**.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- PostgreSQL (configurable)
- Maven

## Seguridad

La aplicación implementa autenticación y autorización utilizando **JWT**. Los endpoints protegidos requieren un token válido para su acceso. Las funcionalidades incluyen:

- **Registro de usuarios**: `/auth/signup`
- **Inicio de sesión**: `/auth/login`
- **Generación y validación** de tokens JWT
- **Roles de usuario** (por ejemplo, ADMIN, USER)

## Instalación y Ejecución

**Clonar el repositorio**:

```bash
git clone https://github.com/Dleonariza/PruebaFullstackUni.git
cd PruebaFullstackUni



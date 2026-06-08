# NewProject Microservices

Migración del monolito **NewProject** a una arquitectura de microservicios con **Spring Boot 4.0.6**, **Spring Cloud 2025.1.1**, **Eureka**, **Gateway**, **JWT** y **MySQL**.

---

## Arquitectura

```
Cliente (HTTP)
    │
    ▼
New-Proyect-Gateway (puerto 8090) ─── Spring Cloud Gateway (WebFlux)
    │
    ├── lb://APP-AUTH-SERVICE         (8091)
    ├── lb://APP-CLIENTE-SERVICE      (8092)
    ├── lb://APP-CATALOGO-SERVICE     (8093)
    ├── lb://APP-CARRITO-SERVICE      (8094)
    ├── lb://APP-PEDIDO-SERVICE       (8095)
    ├── lb://APP-VENTA-SERVICE        (8096)
    └── lb://APP-NOTIFICACION-SERVICE (8097)

    NEW-PROJECT-GATEWAY ───┐
    TODOS LOS SERVICIOS  ──┤──► New-Proyect-Server (Eureka, 8761)
                           │
                           ▼
                   MySQL (localhost:3306/newproject)
```

**Base de datos única:** Todos los microservicios apuntan a la misma base de datos `newproject` (23 tablas, ya existente con seed data). No se crean schemas separados por servicio.

---

## Estructura del Proyecto

```
📦 Microservicios Java Spring/
├── 📄 README.md
├── 📁 NewProject/                           # Monolito original (NO TOCAR)
├── 📁 New-Proyect-Server/                   # Eureka Server
│   ├── pom.xml
│   └── src/main/java/.../NewProyectServerApplication.java
│
├── 📁 New-Proyect-Gateway/                  # API Gateway
│   ├── pom.xml
│   └── src/main/java/.../NewProyectGatewayApplication.java
│
├── 📁 app-auth-service/                     # Autenticación JWT
│   ├── pom.xml
│   └── src/main/java/.../
│       ├── model/    (Usuario, Rol)
│       ├── dto/      (LoginRequest, JwtResponse, etc.)
│       ├── repository/ (UsuarioRepository, RolRepository)
│       ├── security/  (JwtUtil, JwtFilter, SecurityConfig)
│       ├── service/    (AuthService)
│       └── controller/ (AuthController)
│
├── 📁 app-cliente-service/                  # Gestión de clientes
│   ├── pom.xml
│   └── src/main/java/.../model, dto, repository, service, controller
│
├── 📁 app-catalogo-service/                 # Catálogo de productos
│   ├── pom.xml
│   └── src/main/java/.../model, dto, repository, service, controller
│
├── 📁 app-carrito-service/                  # Carrito de compras
│   ├── pom.xml
│   └── src/main/java/.../model, dto, repository, service, controller
│
├── 📁 app-pedido-service/                   # Pedidos
│   ├── pom.xml
│   └── src/main/java/.../model, dto, repository, service, controller
│
├── 📁 app-venta-service/                    # Ventas
│   ├── pom.xml
│   └── src/main/java/.../model, dto, repository, service, controller
│
└── 📁 app-notificacion-service/             # Notificaciones
    ├── pom.xml
    └── src/main/java/.../model, dto, repository, service, controller
```

Cada servicio sigue la misma estructura interna:

```
src/main/java/idat/pe/<service>/
├── model/          → Clases JPA (entidades)
├── dto/            → Objetos de transferencia de datos
├── repository/     → Interfaces JpaRepository
├── service/        → Lógica de negocio
├── controller/     → Endpoints REST
└── <Service>Application.java → Clase principal

src/main/resources/application.properties → Configuración
```

---

## Tecnologías y Dependencias

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Cloud | 2025.1.1 |
| Spring Cloud Gateway (WebFlux) | 5.0.1 |
| Eureka Client/Server | Netflix |
| MySQL | 8.0 |
| JWT (jjwt) | 0.12.3 |
| Swagger (springdoc) | 2.2.0 |
| Maven | 3.9+ |

### Dependencias comunes

| Dependencia | Propósito |
|---|---|
| `spring-boot-starter-web` | REST APIs (MVC) |
| `spring-boot-starter-data-jpa` | Persistencia JPA/Hibernate |
| `spring-cloud-starter-netflix-eureka-client` | Registro en Eureka |
| `mysql-connector-j` | Conector MySQL |
| `springdoc-openapi-starter-webmvc-ui` | Swagger UI individual |
| `io.jsonwebtoken:jjwt-api/impl/jackson` | JWT (solo auth-service) |
| `spring-boot-starter-security` | Seguridad (solo auth-service) |

### Gateway

| Dependencia | Propósito |
|---|---|
| `spring-boot-starter-webflux` | Servidor reactivo Netty |
| `spring-cloud-starter-gateway-server-webflux` | Spring Cloud Gateway |
| `spring-cloud-starter-netflix-eureka-client` | Load balancing con Eureka |

---

## Puertos y Servicios

| Servicio | Puerto | Application Name |
|---|---|---|
| Eureka Server | 8761 | `new-proyect-server` |
| API Gateway | 8090 | `new-project-gateway` |
| Auth Service | 8091 | `app-auth-service` |
| Cliente Service | 8092 | `app-cliente-service` |
| Catálogo Service | 8093 | `app-catalogo-service` |
| Carrito Service | 8094 | `app-carrito-service` |
| Pedido Service | 8095 | `app-pedido-service` |
| Venta Service | 8096 | `app-venta-service` |
| Notificación Service | 8097 | `app-notificacion-service` |

---

## Endpoints y Enlaces

### Gateway (ruteo centralizado)

El Gateway corre en `http://localhost:8090` y reenvía las rutas:

```
/app-auth-service/**        → APP-AUTH-SERVICE (8091)
/app-cliente-service/**     → APP-CLIENTE-SERVICE (8092)
/app-catalogo-service/**    → APP-CATALOGO-SERVICE (8093)
/app-carrito-service/**     → APP-CARRITO-SERVICE (8094)
/app-pedido-service/**      → APP-PEDIDO-SERVICE (8095)
/app-venta-service/**       → APP-VENTA-SERVICE (8096)
/app-notificacion-service/**→ APP-NOTIFICACION-SERVICE (8097)
```

Cada ruta aplica `StripPrefix=1` (ej. `/app-auth-service/auth/login` → `/auth/login` en el servicio destino).

### Eureka Dashboard

```
http://localhost:8761/
```

### Swagger UI (individual por servicio)

| Servicio | Swagger UI | OpenAPI JSON |
|---|---|---|
| Auth | http://localhost:8091/swagger-ui.html | http://localhost:8091/api-docs |
| Cliente | http://localhost:8092/swagger-ui.html | http://localhost:8092/api-docs |
| Catálogo | http://localhost:8093/swagger-ui.html | http://localhost:8093/api-docs |
| Carrito | http://localhost:8094/swagger-ui.html | http://localhost:8094/api-docs |
| Pedido | http://localhost:8095/swagger-ui.html | http://localhost:8095/api-docs |
| Venta | http://localhost:8096/swagger-ui.html | http://localhost:8096/api-docs |
| Notificación | http://localhost:8097/swagger-ui.html | http://localhost:8097/api-docs |

### Endpoints de ejemplo (Auth)

| Método | Ruta | Descripción |
|---|---|---|
| POST | `/auth/login` | Iniciar sesión (JWT) |
| POST | `/auth/register` | Registrar usuario |
| GET | `/auth/me` | Obtener usuario actual |
| GET | `/auth/usuarios` | Listar usuarios |

---

## Base de Datos

- **Motor:** MySQL 8.0 (Laragon)
- **Host:** `localhost:3306`
- **Base de datos:** `newproject`
- **Usuario:** `root` (sin contraseña)
- **DDL:** `spring.jpa.hibernate.ddl-auto=validate` (no se modifica el esquema existente)

---

## Cómo Ejecutar

### Requisitos

- Java 17+
- Maven 3.9+ (o usar `mvnw` incluido)
- MySQL 8.0 corriendo en `localhost:3306` con la base `newproject` creada

### Orden de inicio

```bash
# 1. Eureka Server
cd New-Proyect-Server
mvn spring-boot:run

# 2. Gateway
cd New-Proyect-Gateway
mvn spring-boot:run

# 3. Microservicios (pueden iniciarse en paralelo)
cd app-auth-service     && mvn spring-boot:run
cd app-cliente-service  && mvn spring-boot:run
cd app-catalogo-service && mvn spring-boot:run
cd app-carrito-service  && mvn spring-boot:run
cd app-pedido-service   && mvn spring-boot:run
cd app-venta-service    && mvn spring-boot:run
cd app-notificacion-service && mvn spring-boot:run
```

### Compilar todo

```bash
mvn clean install -DskipTests
```

---

## Flujo de Autenticación

1. `POST /app-auth-service/auth/login` con `{ "username": "admin", "password": "123456" }`
2. El Auth Service valida contra la BD y devuelve un JWT.
3. El JWT debe enviarse en el header `Authorization: Bearer <token>` en las requests a otros servicios.
4. Cada servicio valida el JWT internamente mediante un filtro de seguridad.

---

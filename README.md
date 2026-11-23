# bibliotecas-backend

API REST en Spring Boot para gestionar bibliotecas y sus libros.
Una biblioteca tiene varios libros y cada libro pertenece a una sola biblioteca.

## Requisitos

- JDK 17 o superior
- No necesita base de datos instalada: usa H2 en memoria

## Ejecutar

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

La API queda en <http://localhost:8080/bibliotecas>

## Endpoints

| Método | Ruta           | Acción                                     |
|--------|----------------|--------------------------------------------|
| POST   | `/bibliotecas` | Registrar biblioteca                       |
| GET    | `/bibliotecas` | Consultar bibliotecas con sus libros       |

Ejemplo de POST:

```json
{ "nombre": "Biblioteca Sur", "direccion": "Calle 1 # 2-3", "ciudad": "Cali" }
```

## Datos de prueba

Al arrancar se cargan 2 bibliotecas y 4 libros con un `CommandLineRunner`
(`config/DataInitializer`).

Consola H2: <http://localhost:8080/h2-console>
(JDBC URL `jdbc:h2:mem:bibliotecas_db`, usuario `sa`, sin contraseña)

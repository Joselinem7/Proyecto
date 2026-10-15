# Recomendación de mejores asientos

Proyecto Spring Boot preparado para integrar el requisito funcional de
recomendación de asientos con el mapa existente.

## Ejecutar en macOS

```bash
cd spring
bash ./mvnw clean spring-boot:run
```

Abrir:

- Mapa: http://localhost:8080/
- Recomendador: http://localhost:8080/recomendacion.html
- API de prueba: http://localhost:8080/api/recomendaciones/mejores?cantidad=2

## Archivos de la parte de Joseline

- `servicio/RecomendadorAsientos.java`
- `controlador/RecomendacionController.java`
- `static/recomendacion.html`
- `RecomendadorAsientosTest.java`

Las clases `Asiento`, `Sala` y `AsientoController` se incluyen para que la
copia pueda ejecutarse de forma independiente y mantenga la estructura del
proyecto grupal.

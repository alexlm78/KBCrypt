# 🔐 KBCrypt - BCrypt Hash Generator & Validator

Una aplicación web moderna y completa para generar y validar hashes BCrypt de forma segura. Desarrollada con Spring Boot y diseñada para desarrolladores y profesionales de seguridad.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen?style=flat-square&logo=spring)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-MVP-success?style=flat-square)

## ✨ Características

### 🔒 Funcionalidades Principales
- **Generación de Hashes BCrypt** con rounds configurables (4-31)
- **Validación de Contraseñas** contra hashes existentes
- **Historial de Operaciones** con enmascaramiento de contraseñas por seguridad
- **Interfaz Web Responsive** con diseño moderno y profesional
- **API REST** completa para integración con otras aplicaciones

### 🎨 Interfaz de Usuario
- **Diseño Moderno** con paleta de colores personalizada
- **Responsive Design** optimizado para desktop y móvil
- **Feedback Visual** con indicadores de carga y alertas
- **Funcionalidad de Clipboard** para copiar hashes generados
- **Validación en Tiempo Real** con mensajes informativos

### 🛡️ Seguridad
- **Enmascaramiento de Contraseñas** en el historial
- **Validación de Entrada** robusta en frontend y backend
- **Manejo Seguro de Excepciones** sin exposición de información sensible
- **Límite de Historial** (100 entradas) para gestión de memoria

## 🚀 Inicio Rápido

### Prerrequisitos
- Java 21 o superior
- Gradle 8.x (incluido wrapper)

### Instalación y Ejecución

1. **Clonar el repositorio**
   ```bash
   git clone <repository-url>
   cd kbcrypt
   ```

2. **Ejecutar la aplicación**
   ```bash
   ./gradlew bootRun
   ```

3. **Acceder a la aplicación**
   ```
   http://localhost:8080
   ```

### Construcción del Proyecto

```bash
# Compilar el proyecto
./gradlew build

# Ejecutar tests
./gradlew test

# Generar JAR ejecutable
./gradlew bootJar
```

## 📖 Uso

### Interfaz Web

1. **Generar Hash**
   - Ingresa tu contraseña
   - Selecciona el número de rounds (recomendado: 12)
   - Haz clic en "Generar Hash"
   - El hash se puede copiar al portapapeles

2. **Validar Hash**
   - Ingresa la contraseña original
   - Pega el hash BCrypt a validar
   - Haz clic en "Validar Hash"
   - Verifica si la contraseña coincide

3. **Ver Historial**
   - Haz clic en "Mostrar Historial"
   - Revisa todas las operaciones realizadas
   - Las contraseñas aparecen enmascaradas por seguridad

### API REST

#### Generar Hash
```bash
POST /generate
Content-Type: application/json

{
  "password": "miPassword123",
  "rounds": 12
}
```

**Respuesta:**
```json
{
  "success": true,
  "hash": "$2a$12$...",
  "message": "Hash generado exitosamente",
  "matches": null
}
```

#### Validar Hash
```bash
POST /validate
Content-Type: application/json

{
  "password": "miPassword123",
  "hash": "$2a$12$..."
}
```

**Respuesta:**
```json
{
  "success": true,
  "hash": null,
  "message": "La contraseña coincide con el hash",
  "matches": true
}
```

#### Ver Historial
```bash
GET /history
```

#### Limpiar Historial
```bash
POST /history/clear
```

## 🏗️ Arquitectura

### Stack Tecnológico
- **Backend**: Spring Boot 3.5.4, Java 21
- **Seguridad**: Spring Security Crypto (BCrypt)
- **Frontend**: Thymeleaf, Bootstrap 5.3.7, jQuery 3.7.1
- **Build**: Gradle 8.x
- **Testing**: JUnit 5

### Estructura del Proyecto
```
src/
├── main/
│   ├── java/dev/kreaker/kbcrypt/
│   │   ├── controller/     # Controladores REST y Web
│   │   ├── service/        # Lógica de negocio
│   │   ├── dto/           # Objetos de transferencia de datos
│   │   └── KbcryptApplication.java
│   └── resources/
│       ├── templates/      # Plantillas Thymeleaf
│       └── application.properties
└── test/                   # Tests unitarios
```

### Componentes Principales

- **BcryptController**: Maneja las peticiones HTTP y renderizado de vistas
- **BcryptService**: Lógica de negocio para operaciones BCrypt
- **DTOs**: Objetos para requests/responses (HashRequest, ValidateRequest, etc.)
- **Frontend**: Interfaz web interactiva con JavaScript/jQuery

## ⚙️ Configuración

### Rounds de BCrypt
- **4-8**: Muy rápido (desarrollo/testing)
- **10-12**: Recomendado para producción
- **14-16**: Alta seguridad (aplicaciones críticas)
- **20+**: Extrema seguridad (muy lento)

### Propiedades de la Aplicación
```properties
# Puerto del servidor
server.port=8080

# Configuración de Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true
```

## 🧪 Testing

```bash
# Ejecutar todos los tests
./gradlew test

# Ejecutar tests con reporte
./gradlew test --info

# Test de cobertura
./gradlew jacocoTestReport
```

## 🎨 Personalización

### Paleta de Colores
La aplicación utiliza una paleta de colores cálida y profesional:
- **Primario**: #955130 (Marrón Terracota)
- **Secundario**: #F8F6BE (Amarillo Crema)
- **Variantes**: #7a3f26, #e8e2a8

### Modificar Estilos
Los estilos CSS se encuentran en `src/main/resources/templates/index.html` dentro de la etiqueta `<style>`.

## 📝 Roadmap

### Versión Actual (MVP)
- ✅ Generación y validación de hashes BCrypt
- ✅ Interfaz web responsive
- ✅ API REST completa
- ✅ Historial de operaciones

### Próximas Versiones
- [ ] Autenticación de usuarios
- [ ] Persistencia de datos (base de datos)
- [ ] Exportación de historial
- [ ] Configuración de temas
- [ ] API de métricas y monitoreo
- [ ] Dockerización
- [ ] Tests de integración

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Estándares de Código
- Usar Conventional Commits
- Mantener cobertura de tests > 80%
- Seguir las convenciones de Spring Boot
- Documentar APIs con comentarios JavaDoc

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**Alejandro López Monzón**  
*Kreaker Developments*

- GitHub: [@kreaker](https://github.com/kreaker)
- Email: contacto@kreaker.dev

## 🙏 Agradecimientos

- [Spring Boot](https://spring.io/projects/spring-boot) por el framework robusto
- [Bootstrap](https://getbootstrap.com/) por los componentes UI
- [BCrypt](https://en.wikipedia.org/wiki/Bcrypt) por el algoritmo de hashing seguro

---

⭐ Si este proyecto te resulta útil, ¡no olvides darle una estrella!
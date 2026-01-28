# Talos-II Archive - Backend Spring Boot

## 📋 Descripción
Backend para aplicación de Talos-II Archive con panel administrativo y API REST.

## 🚀 Ejecutar la Aplicación

### Requisitos
- Java 17+
- MySQL 8.0+

### Pasos
1. **Crear base de datos:**
```sql
CREATE DATABASE talosii_archive;
```

2. **Configurar conexión** (`application.properties`):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/talosii_archive
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

3. **Ejecutar:**
```bash
./gradlew bootRun
```

### Acceso
- Panel Admin: `http://localhost:8080/endfield/admin`
- API REST: `http://localhost:8080/endfield/api/`

## 🗄️ Replicar Base de Datos

1. Exportar desde servidor original:
```bash
mysqldump -u usuario -p talosii_archive > backup.sql
```

2. En nuevo servidor:
```bash
mysql -h nuevo_servidor -u usuario -p nueva_db < backup.sql
```

3. Actualizar credenciales en `application.properties`

## 📊 Modelo Entidad-Relación
![Modelo ER de la Base de Datos](src/main/resources/static/images/database.png)

**Relaciones principales:**
- `team` → `team_operator` (1 a 4)
- `operator` → `team_operator` (N a N)
- `team_operator` → `team_operator_equipment` (1 a 1)
- `weapon`/`gear` → `team_operator_equipment`

**Tablas de referencia:**
- `weapon_type`, `element`, `operator_class`, `rarity`, `gear_type`, `gear_set`

## 🎯 Endpoints API

### Consultas
- `GET /api/operators` - Personajes
- `GET /api/weapons` - Armas
- `GET /api/gear` - Equipamiento
- `GET /api/teams` - Equipos públicos

### Creaciones
- `POST /api/teams` - Crear equipo
- `POST /api/blueprints` - Compartir configuración

## ⚙️ Reglas de Validación
- Equipos: 4 operadores únicos
- Por operador: 1 arma + 4 piezas de equipamiento (Armor, Gloves, 2 Kits)
- Sets: 3+ piezas del mismo set activan bonificación

---

*Proyecto académico. Arknights © Hypergryph/Yostar.*
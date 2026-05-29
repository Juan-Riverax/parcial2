# 🎮 Sistema de Gestión y Préstamo de Videojuegos

Proyecto desarrollado en Java para la administración de videojuegos, control de stock y gestión de préstamos utilizando conexión a base de datos SQL.

## Descripción

Este sistema permite gestionar un catálogo de videojuegos mediante consola interactiva.  
El usuario puede consultar videojuegos, filtrarlos por diferentes criterios, administrar préstamos y controlar las unidades disponibles de cada juego.

El proyecto implementa una arquitectura basada en:
- Modelos (`Model`)
- Operaciones DAO (`Operations`)
- Conexión a Base de Datos (`DB`)
- Menús interactivos (`Menu`)

---

## Tecnologías utilizadas

- Java
- JDBC
- PostgreSQL
- DotEnv
- Programación Orientada a Objetos (POO)
  
>[!IMPORTANT]
>Para el uso de la tecnologia DotEnv se debe crear un archivo ".env" en el cual se van a guardar las credenciales de la base de datos.\
>Copia y pega esto en tu archivo reemplazando lo que esta despues del igual: \
>URLSUPERSECRETA= Tu URL\
>USUARIOSUPERSECRETO= Tu User\
>KEYSUPERSECRETA= Tu Key
---

## Estructura del proyecto

```bash
src/
│
├── DB/
│   └── DBConnection.java
│
├── Menu/
│   └── Menu.java
│
├── Model/
│   ├── Desarrollador.java
│   ├── DesarrolladorYJuego.java
│   ├── Genero.java
│   ├── Prestamo.java
│   └── Videogame.java
│
├── Operations/
│   ├── DesarrolladorDAO.java
│   ├── PrestamoDAO.java
│   └── VideogameDAO.java
│
└── Main.java

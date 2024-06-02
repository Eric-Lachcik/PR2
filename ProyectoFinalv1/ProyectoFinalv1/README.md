# Proyecto: Aplicación de Información de Fórmula 1

## Descripción General

Este proyecto es una aplicación de escritorio desarrollada en Java que proporciona información detallada sobre la Fórmula 1. La aplicación permite a los usuarios ver datos sobre la clasificación de pilotos, equipos, pilotos y circuitos. La interfaz gráfica de usuario (GUI) está construida utilizando Swing y se conecta a una base de datos MySQL para obtener la información relevante.

## Estructura del Proyecto

El proyecto consta de una sola clase principal `App` que maneja toda la funcionalidad de la aplicación. Aquí está el desglose de las principales funciones y componentes:

### Clase Principal: `App`

#### Método `main`

El método principal configura la ventana inicial (`JFrame`) con cuatro botones: "top 10", "equipos", "pilotos" y "circuitos". Cada botón está vinculado a un método que muestra una ventana con la información correspondiente.

#### Componentes de la Ventana Principal

- **Botón "top 10"**: Llama al método `Top10` para mostrar la clasificación de los 10 mejores pilotos.
- **Botón "equipos"**: Llama al método `Equipos` para mostrar la información de los equipos.
- **Botón "pilotos"**: Llama al método `Pilotos` para mostrar la información de los pilotos.
- **Botón "circuitos"**: Llama al método `circuitos` para mostrar la información de los circuitos.

### Métodos Detallados

#### Método `Top10`

Muestra una ventana (`JFrame`) con una tabla (`JTable`) que contiene la clasificación de los 10 mejores pilotos. La información se obtiene de la tabla `clasificacion` en la base de datos MySQL.

- **Tabla `clasificacion`**:
  - Columnas: `Posicion`, `Puntos`, `Piloto_Id`, `Equipo_Nombre`
  
- **Funcionalidad Adicional**:
  - Botón "Ordenar Puntos": Permite ordenar la tabla por la columna de puntos en orden ascendente o descendente.

#### Método `Equipos`

Muestra una ventana con una tabla que contiene información sobre los equipos. La información se obtiene de la tabla `equipo` en la base de datos.

- **Tabla `equipo`**:
  - Columnas: `Nombre`, `Director_Deportivo`
  
- **Funcionalidad Adicional**:
  - Botón "Añadir Equipo": Abre una nueva ventana donde el usuario puede añadir un nuevo equipo ingresando el nombre del equipo y el nombre del director deportivo. Los datos ingresados se insertan en la base de datos.

#### Método `Pilotos`

Muestra una ventana con una tabla que contiene información sobre los pilotos. La información se obtiene de la tabla `pilotos` en la base de datos.

- **Tabla `pilotos`**:
  - Columnas: `Id`, `Nombre`, `Equipo_Nombre`
  
#### Método `circuitos`

Muestra una ventana con una tabla que contiene información sobre los circuitos. La información se obtiene de la tabla `circuitos` en la base de datos.

- **Tabla `circuitos`**:
  - Columnas: `Id`, `Nombre`, `Fecha`, `Piloto_Id`

## Base de Datos

La aplicación se conecta a una base de datos MySQL llamada `basejava`. A continuación se detallan las tablas utilizadas:

### Tabla `clasificacion`

| Columna       | Tipo     |
| ------------- | -------- |
| Posicion      | INT      |
| Puntos        | INT      |
| Piloto_Id     | INT      |
| Equipo_Nombre | VARCHAR  |

### Tabla `equipo`

| Columna            | Tipo     |
| ------------------ | -------- |
| Nombre             | VARCHAR  |
| Director_Deportivo | VARCHAR  |

### Tabla `pilotos`

| Columna       | Tipo     |
| ------------- | -------- |
| Id            | INT      |
| Nombre        | VARCHAR  |
| Equipo_Nombre | VARCHAR  |

### Tabla `circuitos`

| Columna    | Tipo     |
| ---------- | -------- |
| Id         | INT      |
| Nombre     | VARCHAR  |
| Fecha      | DATE     |
| Piloto_Id  | INT      |

## Requisitos Previos

- Java Development Kit (JDK) instalado.
- MySQL Database Server instalado y corriendo.
- Base de datos `basejava` configurada con las tablas mencionadas.
- Dependencias de JDBC (Java Database Connectivity) incluidas en el proyecto.

## Compilación y Ejecución

1. **Compilar el código**:
   ```bash
   javac App.java

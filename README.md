[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/GxFB-nwe)

# Asignación: Proyecto 1 de Análisis de Algoritmos - Grupo B

**Fecha:** 18/10/2025
**Curso:** Análisis y Diseño de Algoritmos II

---

## 👥 Integrantes del Grupo

| Nombre Completo           | Código  | Rol          | Correo Electrónico                 |
|---------------------------|---------|--------------|------------------------------------|
| Jhojan Serna Henao        | 2259504 | Colaborador | [jhojan.serna@correounivalle.edu.co] |
| Edwar Yamir Forero Blanco | 2559741  | Colaborador  | edwar.forero@correounivalle.edu.co |
| Faber Alexis Solis Gamboa |   | [Colaborador] | [correo3@institucion.edu]          |
|  |   | [Colaborador] | [correo3@institucion.edu]          |

---

## 📌 Descripción del Taller

En este taller, exploraremos diversas estrategias para resolver el problema de riego de tablones en una finca, evaluando sus complejidades temporales y espaciales. Se implementarán tres enfoques principales: fuerza bruta, programación dinámica y un algoritmo voraz basado en la razón 
valor/peso. A través de este análisis, se pretende comprender las ventajas y limitaciones de cada método, así como su aplicabilidad en diferentes escenarios.

## Cómo ejecutar el proyecto:
Ejecuta la clase: [Main](src/main/java/edu/univalle/riegooptimo/Main.java). Alli aparecera un "un file chooser" para seleccionar el archivo de entrada, el cual debe tener la siguiente estructura:
```
n
ts0,tr0,p0
ts1,tr1,p1
...
ts(n-1),tr(n-1),p(n-1)
```
## Cómo ejecutar las pruebas unitarias:
Las pruebas unitarias están organizadas en tres clases de prueba, cada una correspondiente a una de las estrategias implementadas para resolver el problema de riego de tablones:
- [Carpeta Test](src/test/java/edu/univalle/riegooptimo/algoritmos)
  - [DinamicaTest](src/test/java/edu/univalle/riegooptimo/algoritmos/DinamicaTest.java)
  - [FuerzaBrutaTest](src/test/java/edu/univalle/riegooptimo/algoritmos/FuerzaBrutaTest.java)
  - [VorazTest](src/test/java/edu/univalle/riegooptimo/algoritmos/VorazTest.java)

## Documentación
La documentación esta dividida en 4 Markdown:
- [Carpeta documentacion](docs/adaII)
  - [Fuerza_Bruta](docs/adaII/Fuerza_Bruta.md) contiene la descripción de la implementación del algoritmo de fuerza bruta.
  - [Dinamica](docs/adaII/Dinamica.md) contiene la descripción de la implementación del algoritmo de programación dinámica.
  - [SolVoraz](docs/adaII/SolVoraz.md) contiene la descripción de la implementación del algoritmo voraz.
  - [complejidades](docs/adaII/complejidades.md) contiene el análisis de complejidades temporales y espaciales de los algoritmos implementados.
# Evaluación Parcial: Procesamiento Concurrente de Matrices
en Java
Objetivo: Implementar una aplicación en Java que procese una matriz de cadenas de texto
(Strings) para calcular, de manera concurrente, la frecuencia de aparición de un término
específico.
## Enunciado del Problema
Se requiere desarrollar un programa que determine cuántas veces aparece una palabra X
dentro de una matriz de datos. Para optimizar el rendimiento, el procesamiento no debe
realizarse de forma secuencial. Usted podrá definir la estrategia de paralelización, ya sea
dividiendo el trabajo fila por fila o columna por columna.
## Requerimientos Técnicos
1. Implementación de hilos: Se permite utilizar la clase Thread, la interfaz Runnable o
programación funcional con Lambdas para definir las unidades de trabajo.
2. Sincronización: El hilo principal debe esperar a que todos los hilos finalicen antes de
consolidar el resultado global.
3. Comunicación y resultados: Cada hilo debe recibir los datos necesarios (fila/columna
y palabra buscada) y devolver su conteo parcial. El hilo principal será responsable de
sumar los resultados y mostrar el total.
4. Gestión de excepciones: Se debe implementar el manejo adecuado de excepciones.
## Ejemplo de Resultado Esperado
Salida sugerida en consola:
Modalidad de Trabajo y Entrega

<img width="730" height="373" alt="image" src="https://github.com/user-attachments/assets/4a494d52-b535-49c9-adbe-d10739786cc8" />

La evaluación se desarrollará en dos momentos diferenciados, cada uno con sus propias reglas
de trabajo. La solución debe alojarse en un repositorio público de GitHub, del cual se enviará
el enlace como evidencia de entrega.
Primera hora — Trabajo individual sin asistencia
Durante la primera hora, el estudiante deberá resolver el problema de manera estrictamente
individual, sin apoyo de herramientas de inteligencia artificial generativa ni consulta de
apuntes de clase. El objetivo es evidenciar el dominio conceptual y técnico adquirido a lo largo
del componente teórico y práctico.
Al finalizar este tiempo, la solución debe subirse a una rama (branch) del repositorio
denominada sin-ia.
Segunda hora — Trabajo con IA generativa
En la segunda hora se permite el uso de herramientas de inteligencia artificial generativa
para mejorar, completar o refactorizar la solución. Adicionalmente, el estudiante deberá adjuntar
un archivo de texto (por ejemplo, ia-utilizada.txt) que contenga la siguiente información:
• Nombre de la herramienta de IA generativa empleada.
• Indicación de si se utilizó una cuenta gratuita o de pago.
• Listado completo de los prompts utilizados durante el desarrollo.
Esta versión, junto con el archivo de descripción, debe subirse a una rama denominada con-
ia.
⚠ Importante: la única diferencia que debe existir entre las ramas sin-ia y con-ia es el
archivo de texto con la descripción de la IA utilizada y los prompts. Cualquier otra
modificación al código fuente entre ramas se considerará una inconsistencia en la entrega.

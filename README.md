# Solucionador del Juego Tic-Tac

Este programa resuelve el juego del Tic-Tac, que consiste en rellenar una matriz cuadrada de manera que no haya más de dos 'x's ni más de dos 'o's consecutivos en sentido horizontal o vertical, y que haya el mismo número de 'o's en cada fila y columna.

## Ejercicio de Programación

Este programa es el tercer ejercicio de programación de la asignatura de Programación 2 de 2º año de Ingeniería Informática de la Universidad de León.

## Requisitos

- Java (versión 8 o superior)

## Uso

El programa toma como entrada una matriz parcialmente rellenada del juego Tic-Tac y proporciona una solución si existe. Si no hay solución, indicará que no la hay.

### Entrada

El programa espera como entrada un conjunto de líneas que definen la matriz del juego utilizando tres caracteres:

- 'o' para indicar un círculo.
- 'x' para indicar una cruz.
- '_' para indicar una posición vacía.

Habrá tantas líneas como caracteres en cada una de ellas, ya que la matriz del juego es cuadrada y se define el contenido de la matriz por filas. Se puede asumir que la entrada siempre estará bien formada.

### Salida

La salida del programa será la matriz completamente rellena de 'o's o 'x's, una fila por línea, con los caracteres seguidos sin espacios, si existe una solución. Si no hay solución, se imprimirá el texto "No hay solución." en una línea única y completa (terminada en final de línea).

## Ejemplo

### Entrada 1
_x_<br>
xoo<br>
o__
### Salida 1
OXO<br>
XOO<br>
OOX

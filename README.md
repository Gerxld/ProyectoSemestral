# ProyectoSemestral
--Proyecto semestral de Desarrollo de Software en Java--
Utilizando todos los elementos desarrollados durante el semestre de clases, usted deberá investigar y desarrollar
una aplicación que simule el registro de un juego de BattleShip, donde dos jugadores deberán establecer coordenadas para 4 barcos.

Es un juego de 2 jugadores en el que cada jugador tiene 2 tableros de coordenadas, uno para ubicar su flota de naves y el otro para 
apuntar las coordenadas de ataque a la flota enemiga y así tener un control de no repetir las mismas coordenadas.

Para este juego los tableros de cada jugador tendrán una dimensión de 9 x 9, y el juego debe permitirle a cada jugador ubicar su flota de naves. 
Esta flota está compuesta por 2 barcos de tamaño 2, 1 barco de tamaño 3 y 1 barco de tamaño 4; los barcos pueden colocarse de manera horizontal o vertical, 
no es posible colocar las naves de forma diagonal.

Se juega por turnos alternando entre el jugador 1 y el jugador 2. El juego finaliza cuando uno de los jugadores haya hundido toda la flota de barcos de su oponente.

Su tarea es desarrollar un programa en Java que permita jugar Battleship, debe permitirle a cada jugador posicionar sus naves indicando el tamaño de la nave, 
la orientación de esta (vertical u horizontal) y las coordenadas para ubicarla. Debe cuidar que no se pueda colocar una nave fuera del tablero.

Para posicionar las naves y para realizar los ataques, las coordenadas se deben indicar con letras y números de la siguiente manera A,5 B,7 D,4. 
No puede ubicarse un barco sobre otro por lo que debe realizar las validaciones pertinentes para no permitir que esto ocurra.

Debe permitirle a cada jugador colocar su nombre para identificar que jugador está en cada turno, considere limpiar las pantallas para evitar que los 
oponentes visualicen los tableros del adversario.


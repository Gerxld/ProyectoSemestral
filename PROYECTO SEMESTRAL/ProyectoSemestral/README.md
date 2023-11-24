# Tareas
> [!IMPORTANTE] Estas son las tareas a completar, realizar en orden, si completas marca con [x]. PD: puede que se agregan más tareas

## Bienvenida y creación
- [x] Dar bienvenida y explicar instrucciones
- [ ] Crear logica 2 jugadores, cambios de turnos
- [x] Declarar objetos y definir clases
- [x] Crear 2 tableros 9x9 para cada jugador (tablero1: ubicar flota, tablero2: atacar)

## Ubicar flota
> [!IMPORTANTE] las coordenadas se indican asi: A,5 B,7 D,4 (letras filas, num columnas)
- [x] Permitir a los jugadores ubicar su flota: 4 barcos (2 tamaño 2 (crucero y submarino), 1 tamaño 3 (buque), 1 tamaño 4 (portaaviones))
- [x] Indica el tamaño de la nave , orientación (vertical u horizontal) y coordenadas para ubicarla. 
- [x] Debe cuidar que no se pueda colocar una nave fuera del tablero. 
- [x] Validacion: No puede ubicarse un barco sobre otro

## Juego por Turnos
- [x] Permitirle a cada jugador colocar su nombre
- [ ] identificar que jugador está en cada turno
- [x] Limpiar pantallas para evitar que los oponentes visualicen los tableros adversarios
- [ ] Finalizar cuando un jugador hunda la flota enemiga
- [ ] Metodo que cambie turnos

## Ataque
- [ ] Cada vez que un jugador indique una coordenada, el programa debe indicarle si atinó o no a una de las naves del oponente

## Game Over
- [ ] Si el jugador de turno ingresa 'EXIT', la partida termina y se considera que ese jugador se ha rendido, haciendo al otro jugador el ganador de la partida

> [!IMPRIMIR]
- [ ] Nombre del jugador ganador
- [ ] Coordenadas de las naves de cada jugador
ejemplo:
Jugador 1   Nave de 4 A1 horizontal
            Nave de 3 G2 vertical
            Nave de 2 I2 horizontal
            Nave de 2 E4 vertical

Jugador 2   Nave de 4 A1 horizontal
            Nave de 3 G2 vertical
            Nave de 2 I2 horizontal
            Nave de 2 E4 vertical
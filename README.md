# SpaceInvaders
Probamos la herencia y el polimorfismo programando libremente algún juego.

Hemos construido el framework simple [gameframe](https://github.com/vjfernandez/GameFrame) para representar sprites con detección de colisiones rectangulares,basado en la librería de dibujo [stddraw](https://github.com/vjfernandez/stddrawsound-netbeans). 

En el juego hay cuatro tipos de sprites: Nave, Aliens, FuegoNave y FuegoAlien. La nave se mueve con eventos de teclado (izquierda, derecha y disparo), que son obtenidos en la clase principal (game), en el método principal (run()) que es el que contiene el bucle de eventos. Los objetos de los otros tres tipos se mueven autónomamente.

Necesitamos un acceso facil de los sprites al resto de los objetos (Ej: un objeto de tipo FuegoNave necesita acceso a los Aliens, para saber si colisiona con ellos). Aunque la inyección de dependencias hubiera sido una buena idea, como hicimos en el Pong, en esta ocasión  propongo una clase Global, que mantenga datos en el contexto estático: una referencia a la Nave, y una lista de los otros tipos de objeto.

El chequeo de colisiones y acciones posteriores lo podemos programar tras mover cada objeto.
**NOTA**: No se pueden añadir objetos a una Lista mientras se está recorriendo con un foreach: para lograr el mismo efecto yo he implementado en mi código una segunda Lista en la que se guardan los objetos que se quieren añadir a la lista de Sprites, y se fusiona con la lista de sprites una vez fuera de los bucles foreach.
Igualmente, no se pueden eliminar objetos de una lista mientras se recorre, a menos que se haga utilizando un iterador. Para eliminar un Sprite de la lista, la clase Sprite cuenta con un booleano que indica si el sprite debe ser eliminado.

El diagrama de clases siguiente sólo muestra una posible estructura para el juego. No incluye constructores, ni accesores triviales. Puedes y debes incluir las variables y métodos que te convengan, o hacer las modificaciones que estimes oportunas.

![](https://raw.githubusercontent.com/vjfernandez/SpaceInvaders/master/uml-clases.png)

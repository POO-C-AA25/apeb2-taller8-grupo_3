/**
 * Problema 1 - Juego de roles
En un juego de rol, se desea implementar un sistema de combate en el que participen diferentes tipos de personajes: guerreros, magos y arqueros.
Cada personaje tiene atributos y habilidades únicas, así como diferentes métodos de ataque y defensa.

El objetivo del juego es enfrentar a los personajes en batallas y determinar el ganador en función de sus habilidades, estrategias y atributos.
Los guerreros se destacan por su fuerza y habilidades cuerpo a cuerpo, los magos por sus hechizos y poderes mágicos, y los arqueros por su precisión y habilidades a distancia.

El sistema debe permitir crear nuevos personajes de cada tipo, asignarles atributos iniciales, como puntos de vida
y nivel de experiencia, y permitirles subir de nivel a medida que ganan batallas. Además, se debe implementar un algoritmo de combate que evalúe
las habilidades de cada personaje y determine el resultado de la batalla.

Utilizando programación orientada a objetos, herencia y polimorfismo, implementa el sistema de
combate y las clases necesarias para representar a los diferentes tipos de personajes. Asegúrate de que cada tipo de
personaje tenga sus propias habilidades y métodos de ataque y defensa, y que puedan interactuar entre sí en las batallas.

Note

Para solucionar lo anterior se debe generar lo siguiente:

Un diagrama exclusivo que involucren las funcionalidades principales del juego.
Una solución en lenguaje de programación Java. Usar Polimorfismo en la solución.
Clase de prueba/ejecutor, que demuestre la funcionalidad del juego.
 */
public class Problema1_EjecutorJuegoRoles {
    public static void main(String[] args) {
        Personaje guerrero = new Guerrero(5, 12, 0, 0, "Fuerza Bruta", "Ataque Directo");
        Personaje mago = new Mago(6, 10, 0, 0, "Hechizos Poderosos", "Estrategia Magica");
        Personaje arquero = new Arquero(4, 8, 0, 0, "Disparo Certero", "Ataque a Distancia");

        while (guerrero.vidas > 0 && mago.vidas > 0) {
            if (guerrero.atacar(mago)) {
                guerrero.experiencia += 1;
                guerrero.batallasGanadas += 1;
                System.out.println("El guerrero ha derrotado al mago.");
                break;
            } else {
                System.out.println("El mago sigue en pie con " + mago.vidas + " vidas.");
            }

            if (mago.atacar(guerrero)) {
                mago.experiencia += 1;
                mago.batallasGanadas += 1;
                System.out.println("El mago ha derrotado al guerrero.");
                break;
            } else {
                System.out.println("El guerrero sigue en pie con " + guerrero.vidas + " vidas.");
            }
        }

        System.out.println(guerrero);
        System.out.println(mago);
    }
}

abstract class Personaje {
    public int vidas;
    public int experiencia;
    public int batallasGanadas;
    public String habilidad;
    public String estrategia;

    public Personaje(int vidas, int experiencia, int batallasGanadas, String habilidad, String estrategia) {
        this.vidas = vidas;
        this.experiencia = experiencia;
        this.batallasGanadas = batallasGanadas;
        this.habilidad = habilidad;
        this.estrategia = estrategia;
    }

    public abstract boolean atacar(Personaje personaje);
    public abstract int defender();

    public String toString() {
        return "Vidas: " + vidas + ", Experiencia: " + experiencia + ", Batallas Ganadas: " + batallasGanadas +
                ", Habilidad: " + habilidad + ", Estrategia: " + estrategia;
    }
}

class Guerrero extends Personaje {
    public int fuerza;

    public Guerrero(int fuerza, int vidas, int experiencia, int batallasGanadas, String habilidad, String estrategia) {
        super(vidas, experiencia, batallasGanadas, habilidad, estrategia);
        this.fuerza = fuerza;
    }

    public boolean atacar(Personaje personaje) {
        int danio = this.fuerza - personaje.defender();
        personaje.vidas -= danio > 0 ? danio : 0;
        return personaje.vidas <= 0;
    }

    public int defender() {
        return 2;
    }

    public String toString() {
        return "Guerrero{" +
                "fuerza=" + fuerza + ", " + super.toString() +
                '}';
    }
}

class Mago extends Personaje {
    public int poderMagico;

    public Mago(int poderMagico, int vidas, int experiencia, int batallasGanadas, String habilidad, String estrategia) {
        super(vidas, experiencia, batallasGanadas, habilidad, estrategia);
        this.poderMagico = poderMagico;
    }

    public boolean atacar(Personaje personaje) {
        int danio = this.poderMagico - personaje.defender();
        personaje.vidas -= danio > 0 ? danio : 0;
        return personaje.vidas <= 0;
    }

    public int defender() {
        return 1;
    }

    public String toString() {
        return "Mago{" +
                "poderMagico=" + poderMagico + ", " + super.toString() +
                '}';
    }
}

class Arquero extends Personaje {
    public int precision;

    public Arquero(int precision, int vidas, int experiencia, int batallasGanadas, String habilidad, String estrategia) {
        super(vidas, experiencia, batallasGanadas, habilidad, estrategia);
        this.precision = precision;
    }

    public boolean atacar(Personaje personaje) {
        int danio = this.precision - personaje.defender();
        personaje.vidas -= danio > 0 ? danio : 0;
        return personaje.vidas <= 0;
    }

    public int defender() {
        return 3;
    }

    public String toString() {
        return "Arquero{" +
                "precision=" + precision + ", " + super.toString() +
                '}';
    }
}


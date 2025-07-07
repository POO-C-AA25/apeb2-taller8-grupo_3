/**
 * Problema 3 - Juego de fútbol "Estadísticas"
Se desea realizar una aplicación que permita a un periodista deportivo llevar las estadísticas de los jugadores de un equipo de fútbol para poder valorar su actuación en el partido.

Cada jugador se identifica por su nombre, número de dorsal y Rut

Los jugadores se dividen en tres categorías:

Atacantes
Defensores
Porteros
Para todos los jugadores se desea contabilizar el número de goles marcados,
además en el caso de los jugadores de campo se contabilizan los pases realizados con éxito y el número de balones recuperados.
En el caso de los porteros se contabilizan las atajadas realizadas.

Valoración del jugador
Cálculo base para todos los jugadores:

valor_goles = goles * 30
Valor adicional según tipo de jugador:

Atacantes

valor += recuperaciones * 3
Defensores

valor += recuperaciones * 4
Porteros

valor += atajadas * 5
Note

Se debe aplicar polimorfismo mediante la aplicación de herencia, encapsulamiento de atributos y comportamientos comunes, y especializar comportamiento según el tipo de jugador.
 */

public class Problema3_JuegoFutbol {
    public static void main(String[] args) {

        Jugador atacante = new Atacante("Messi", "10", "1234567890", 2, 5);
        Jugador defensor = new Defensor("Pique", "3", "0987654321", 1, 10);
        Jugador portero = new Portero("Ter Stegen", "1", "1122334455", 0, 8);

        atacante.determinarValoracion();
        defensor.determinarValoracion();
        portero.determinarValoracion();

        System.out.println(atacante);
        System.out.println(defensor);
        System.out.println(portero);
    }
}

abstract class Jugador {
    public String nombre;
    public String num_Jugador;
    public String RUT;
    public int num_Goles;
    public int valor_goles;
    public int valoracion;

    public Jugador(String nombre, String num_Jugador, String RUT, int num_Goles) {
        this.nombre = nombre;
        this.num_Jugador = num_Jugador;
        this.RUT = RUT;
        this.num_Goles = num_Goles;
        this.valoracion = 0;
        this.valor_goles = 0;
    }

    public int calcularValorGoles() {
        valor_goles = num_Goles * 30;
        return valor_goles;
    }

    public abstract int determinarValoracion();

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Numero de Jugador: " + num_Jugador + ", RUT: " + RUT +
                ", Goles: " + num_Goles + ", Valoración: " + valoracion;
    }
}

class Atacante extends Jugador {
    public int recuperaciones;

    public Atacante(String nombre, String num_Jugador, String RUT, int num_Goles, int recuperaciones) {
        super(nombre, num_Jugador, RUT, num_Goles);
        this.recuperaciones = recuperaciones;
    }

    @Override
    public int determinarValoracion() {
        calcularValorGoles();
        valoracion = valor_goles + recuperaciones * 3;
        return valoracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Recuperaciones: " + recuperaciones;
    }
}

class Defensor extends Jugador {
    public int recuperaciones;

    public Defensor(String nombre, String num_Jugador, String RUT, int num_Goles, int recuperaciones) {
        super(nombre, num_Jugador, RUT, num_Goles);
        this.recuperaciones = recuperaciones;
    }

    @Override
    public int determinarValoracion() {
        calcularValorGoles();
        valoracion = valor_goles + recuperaciones * 4;
        return valoracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Recuperaciones: " + recuperaciones;
    }
}

class Portero extends Jugador {
    public int atajadas;

    public Portero(String nombre, String num_Jugador, String RUT, int num_Goles, int atajadas) {
        super(nombre, num_Jugador, RUT, num_Goles);
        this.atajadas = atajadas;
    }

    @Override
    public int determinarValoracion() {
        calcularValorGoles();
        valoracion = valor_goles + atajadas * 5;
        return valoracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Atajadas: " + atajadas;
    }
}


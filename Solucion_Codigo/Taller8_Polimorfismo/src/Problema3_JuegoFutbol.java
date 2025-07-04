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


public class Problema3_JuegoFutbol {
    public static void main(String[] args) {

        Jugador atacante = new Atacante("Messi", "10", "1234567890", 30);
        Jugador defensor = new Defensor("Pique", "3", "0987654321", 20);
        Jugador portero = new Portero("Ter Stegen", "1", "1122334455", 10);

        atacante.calcularValorGoles();
        atacante.determinarValoracion();
        defensor.calcularValorGoles();
        defensor.determinarValoracion();
        portero.calcularValorGoles();
        portero.determinarValoracion();
        System.out.println(atacante + "\n" + defensor + "\n" + portero);
    }

}
abstract class Jugador{
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
    }

    public int calcularValorGoles(){
        return valor_goles  = num_Goles* 30;
    }
    public abstract int determinarValoracion();

    public String toString() {
        return "Nombre: " + nombre + ", Numero de Jugador: " + num_Jugador + ", RUT: " + RUT + ", Numero de Goles: " + num_Goles + ", Valoracion: " + valoracion;
    }

}

class Atacante extends Jugador{

    public Atacante(String nombre, String num_Jugador, String RUT, int num_goles) {
        super(nombre, num_Jugador, RUT, num_goles);
    }

    public int determinarValoracion(){
        return valoracion +=  valor_goles * 3;

    } 

    public String toString() {
        return super.toString() + ", Valor Goles: " + valor_goles;
    }

}

class Defensor extends Jugador{

    public Defensor(String nombre, String num_Jugador, String RUT, int num_goles) {
        super(nombre, num_Jugador, RUT, num_goles);
    }    

    public int determinarValoracion(){
        return valoracion += valor_goles * 4;
    }    

    public String toString() {
        return super.toString() + ", Valor Goles: " + valor_goles;
    }

}

class Portero extends Jugador{

    public Portero(String nombre, String num_Jugador, String RUT, int num_goles) {
        super(nombre, num_Jugador, RUT, num_goles);
    }

    public int determinarValoracion(){
        return valoracion += valor_goles * 5;
    }    

    public String toString() {
        return super.toString() + ", Valor Goles: " + valor_goles;
    }

}

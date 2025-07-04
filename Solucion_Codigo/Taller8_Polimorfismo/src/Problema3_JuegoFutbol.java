public class Problema3_JuegoFutbol {
    public static void main(String[] args) {

        Jugador atacante = new Atacante("Messi", "10", "1234567890", 30);
        Jugador defefensor = new Defensor("Pique", "3", "0987654321", 20);
        Jugador portero = new Portero("Ter Stegen", "1", "1122334455", 10);
    }

    

}

abstract class Jugador{
    public String nombre;
    public String num_Jugador;
    public String RUC;
    public int num_Goles;
    public int valor_goles;
    public int valoracion;

    public Jugador(String nombre, String num_Jugador, String RUC, int num_Goles) {
        this.nombre = nombre;
        this.num_Jugador = num_Jugador;
        this.RUC = RUC;
        this.num_Goles = num_Goles;
    }

    public int calcularGoles(){
        return valor_goles  = num_Goles* 30;
    }
    public abstract int determinarValoracion();

}

class Atacante extends Jugador{

    public Atacante(String nombre, String num_Jugador, String RUC, int num_goles) {
        super(nombre, num_Jugador, RUC, num_goles);
    }

    public int determinarValoracion(){
        return valoracion +=  valor_goles * 3;

    } 

}

class Defensor extends Jugador{

    public Defensor(String nombre, String num_Jugador, String RUC, int num_goles) {
        super(nombre, num_Jugador, RUC, num_goles);
    }    

    public int determinarValoracion(){
        return valoracion += valor_goles * 4;
    }    

}

class Portero extends Jugador{

    public Portero(String nombre, String num_Jugador, String RUC, int num_goles) {
        super(nombre, num_Jugador, RUC, num_goles);
    }

    public int determinarValoracion(){
        return valoracion += valor_goles * 5;
    }    

}

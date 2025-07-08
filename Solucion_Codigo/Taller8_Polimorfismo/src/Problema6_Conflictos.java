
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problema6_Conflictos {

    public static void main(String[] args) {
        Conflicto simulador = new Conflicto();
        Nacion n1 = new NacionDesarrollada("USA", 300_000_000, 15000.0, 85, true);
        Nacion n2 = new NacionEnDesarrollo("Nigeria", 200_000_000, 500.0, 40);
        Nacion n3 = new NacionDesarrollada("Alemania", 83_000_000, 7000.0, 75, true);
        Nacion n4 = new NacionEnDesarrollo("Perú", 33_000_000, 800.0, 55);
        n1.agregarAliados(n3);
        n2.agregarAliados(n4);

        simulador.agregarNacion(n1);
        simulador.agregarNacion(n2);
        simulador.agregarNacion(n3);
        simulador.agregarNacion(n4);

        for (int i = 0; i < 3; i++) {
            simulador.iniciarConflicto();
        }

        simulador.mostrarReporteFinal();
    }
}

abstract class Nacion {

    public String nombre;
    public int poblacion;
    public double recursos;
    public int poderMilitar;
    public boolean enConflicto;
    public List<Nacion> aliados;

    public Nacion(String nombre, int poblacion, double recursos, int poderMilitar) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.recursos = recursos;
        this.poderMilitar = Math.min(poderMilitar, 100);
        this.enConflicto = false;
        this.aliados = new ArrayList<>();
    }

    public void agregarAliados(Nacion nacion) {
        aliados.add(nacion);
    }

    public void declararConflictos(Nacion n) {
        this.enConflicto = true;
        n.enConflicto = true;
    }

    public abstract void calcularImpacto();

    @Override
    public String toString() {
        return String.format(
                "Nación: %s | Población: %d | Recursos: %.2f | Poder Militar: %d | En Conflicto: %s",
                nombre, poblacion, recursos, poderMilitar, enConflicto ? "Sí" : "No"
        );
    }

}

class NacionDesarrollada extends Nacion {

    public boolean tecnologiaAvanzada;

    public NacionDesarrollada(String nombre, int poblacion, double recursos, int poderMilitar, boolean tecnologiaAvanzada) {
    super(nombre, poblacion, recursos, poderMilitar);
    this.tecnologiaAvanzada = tecnologiaAvanzada;
}


    public void calcularImpacto() {
        if (tecnologiaAvanzada) {
            poderMilitar += 15;
            if (!aliados.isEmpty()) {
                poderMilitar += 10;
            }
            if (poderMilitar > 100) {
                poderMilitar = 100;
            }
        }
    }

    @Override
    public String toString() {
        return "NacionDesarrollada{" + "tecnologiaAvanzada=" + tecnologiaAvanzada + "}" + super.toString();
    }
}

class NacionEnDesarrollo extends Nacion {

    public NacionEnDesarrollo(String nombre, int poblacion, double recursos, int poderMilitar) {
        super(nombre, poblacion, recursos, poderMilitar);
    }

    public double factorLimitante() {
        return (recursos / poblacion) + (poderMilitar / (double) poblacion);
    }

    public void calcularImpacto() {
        double factor = factorLimitante();
        poderMilitar -= (int) (10 * (1.0 - factor));
        if (!aliados.isEmpty()) {
            poderMilitar += 5;
        }
        if (poderMilitar < 1) {
            poderMilitar = 1;
        }
        if (poderMilitar > 100) {
            poderMilitar = 100;
        }
       
    }

    @Override
    public String toString() {
        return "NacionEnDesarrollo{" + "}" + super.toString();
    }
}

class Conflicto {

    public List<Nacion> naciones;
    public int conflictos;

    public Conflicto() {
        this.naciones = new ArrayList<>();
        this.conflictos = 0;
    }

    public void agregarNacion(Nacion n) {
        naciones.add(n);
    }

    public void iniciarConflicto() {
        if (naciones.size() < 2) {
            return;
        }
        Random random = new Random();
        Nacion n1 = naciones.get(random.nextInt(naciones.size()));
        Nacion n2;
        do {
            n2 = naciones.get(random.nextInt(naciones.size()));
        } while (n1 == n2);
        n1.calcularImpacto();
        n2.calcularImpacto();
        n1.declararConflictos(n2);
        resolverConflicto(n1, n2);
        conflictos++;
    }

    public void resolverConflicto(Nacion n1, Nacion n2) {
        int diferencia = Math.abs(n1.poderMilitar - n2.poderMilitar);
        if (n1.poderMilitar > n2.poderMilitar) {
            n2.poblacion -= (int) (n2.poblacion * 0.05 * diferencia);
            n2.recursos *= 0.90;
        } else if (n1.poderMilitar < n2.poderMilitar) {
            n1.poblacion -= (int) (n1.poblacion * 0.05 * diferencia);
            n1.recursos *= 0.90;
        } else {
            n1.recursos *= 0.95;
            n2.recursos *= 0.95;
        }
        n1.poblacion = Math.max(0, n1.poblacion);
        n2.poblacion = Math.max(0, n2.poblacion);
        n1.recursos = Math.max(0, n1.recursos);
        n2.recursos = Math.max(0, n2.recursos);

    }

    public void mostrarReporteFinal() {
        System.out.println("\n--- REPORTE FINAL ---");
        for (Nacion n : naciones) {
            System.out.println(n);
        }
        System.out.println("Total de conflictos simulados: " + conflictos);
    }

}

public class Problema1_JuegoRoles{
    static guerrero;
    static mago;
    static arquero;
    public static void main(String[] args) {
        guerrero = new Guerrero();
        mago = new Mago();
        arquero = new Arquero();
        boolean resultBatalla = guerrero.atacar(mago);
        if (resultBatalla) {
            guerrero.experiencia += 1;
            guerrero.batallasGanadas += 1;
            mago.vidas -= 1;
        } else {
            mago.experiencia += 1;
            mago.batallasGanadas += 1;
            guerrero.vidas -= 1;
        }
        sout.println("Guerrero: " + guerrero + "Mago"+ mago);

}
abstract class Personaje {
    public int vidas;
    public int experiencia;
    public int batallasGanadas;

    public abstract boolean atacar(Personaje personaje);
    public abstract int defender();

    public String toString() {
        return "Vidas: " + vidas + ", Experiencia: " + experiencia + ", Batallas Ganadas: " + batallasGanadas;
    }
}

class Guerrero extends Personaje{
    public String hablilidad;

    public boolean atacar(Personaje personaje) {
        int bandera;
        return ((int) math.random() * 2) == 1 ? true : false;
    }
    public int defender() {
        public boolean defender() {
            return 0;
        }
    }

    public String toString() {
        return super.toString() + ", Habilidad: " + hablilidad + super.toString();
    }

}

class Mago extends Personaje{
        public boolean atacar() {
        return false;
    }
    public int defender() {
        public boolean defender() {
            return 0;
        }
    }

}

class Arquero extends Personaje{
        public boolean atacar() {
        return false;
    }
    public int defender() {
        public boolean defender() {
            return 0;
        }
    }

}   
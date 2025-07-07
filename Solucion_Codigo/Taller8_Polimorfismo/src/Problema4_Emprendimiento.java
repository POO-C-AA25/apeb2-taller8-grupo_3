/**
 * Problema 5 - Plataforma de apoyo a emprendimientos en Loja
Una organización local ha creado una plataforma digital para registrar y promover emprendimientos de la ciudad de Loja.
Los emprendimientos pueden clasificarse por tipo (tecnológico, artesanal, agrícola, gastronómico, etc.),
y cada uno presenta información detallada sobre su misión, productos o servicios, y datos de contacto.
Algunos emprendimientos requieren acompañamiento técnico por parte de mentores especializados, quienes brindan asesoría en áreas como marketing,
contabilidad o desarrollo de software. Además, los emprendimientos pueden participar en ferias locales, donde presentan sus productos y compiten por reconocimientos.
Existen emprendimientos que evolucionan a lo largo del tiempo y extienden sus líneas de productos o abren nuevas sedes.

Requisitos funcionales:
Diferenciar los distintos tipos de emprendimientos mediante herencia.
Asociar uno o más mentores a los emprendimientos que lo requieran.
Implementar comportamientos polimórficos en función del tipo de feria o actividad en la que participan.
Permitir registrar productos o servicios que ofrece cada emprendimiento.
Simular la evolución de un emprendimiento con el tiempo (crecimiento, diversificación, expansión).
Note

Plantee una solución polimórfica dada una jerarquía de clases con ventajas de herencia. Para la visualización de resultados use los toString() base.
 */

import java.util.ArrayList;

public class Problema4_Emprendimiento {
    public static void main(String[] args) {
        Tecnologico tecnologico = new Tecnologico("TechStart", "Innovar en tecnologia");
        tecnologico.productos.add(new Producto("Software educativo"));
        tecnologico.contactos.add(new Contacto("Juan Perez", "Av. Principal 123", "0998765432"));
        tecnologico.mentores.add(new Mentor("Ana Gomez"));

        Artesanal artesanal = new Artesanal("Artesanias del Valle", "Preservar la tradicion artesanal");
        artesanal.productos.add(new Producto("Jarrones de barro"));
        artesanal.contactos.add(new Contacto("Maria Lopez", "Calle 45", "0987654321"));
        artesanal.mentores.add(new Mentor("Carlos Ruiz"));

        mostrarEmprendimiento(tecnologico);
        tecnologico.evolucionar();
        System.out.println();

        mostrarEmprendimiento(artesanal);
        artesanal.evolucionar();
        System.out.println();
    }

    public static void mostrarEmprendimiento(Emprendimiento emprendimiento) {
        System.out.println(emprendimiento.toString());
        System.out.println("Actividad: " + emprendimiento.actividadParticipar());
    }
}

abstract class Emprendimiento {
    public String nombre;
    public String mision;
    public ArrayList<Producto> productos;
    public ArrayList<Contacto> contactos;
    public ArrayList<Mentor> mentores;

    public Emprendimiento(String nombre, String mision) {
        this.nombre = nombre;
        this.mision = mision;
        this.productos = new ArrayList<>();
        this.contactos = new ArrayList<>();
        this.mentores = new ArrayList<>();
    }

    public abstract String actividadParticipar();

    public void evolucionar() {
        System.out.println("El emprendimiento " + nombre + " esta creciendo y ampliando sus productos.");
    }

    public String toString() {
        return "Emprendimiento{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contactos=" + contactos +
                ", mentores=" + mentores +
                '}';
    }
}

class Tecnologico extends Emprendimiento {
    public Tecnologico(String nombre, String mision) {
        super(nombre, mision);
    }

    public String actividadParticipar() {
        return "Participando en actividades tecnologicas";
    }

    public String toString() {
        return "Tecnologico{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contactos=" + contactos +
                ", mentores=" + mentores +
                '}';
    }
}

class Artesanal extends Emprendimiento {
    public Artesanal(String nombre, String mision) {
        super(nombre, mision);
    }

    public String actividadParticipar() {
        return "Participando en actividades artesanales";
    }

    public String toString() {
        return "Artesanal{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contactos=" + contactos +
                ", mentores=" + mentores +
                '}';
    }
}

class Agricola extends Emprendimiento {
    public Agricola(String nombre, String mision) {
        super(nombre, mision);
    }

    public String actividadParticipar() {
        return "Participando en actividades agricolas";
    }

    public String toString() {
        return "Agricola{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contactos=" + contactos +
                ", mentores=" + mentores +
                '}';
    }
}

class Gastronómico extends Emprendimiento {
    public Gastronómico(String nombre, String mision) {
        super(nombre, mision);
    }

    public String actividadParticipar() {
        return "Participando en actividades gastronomicas";
    }

    public String toString() {
        return "Gastronomico{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contactos=" + contactos +
                ", mentores=" + mentores +
                '}';
    }
}

class Producto {
    public String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

class Mentor {
    public String nombre;

    public Mentor(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Mentor{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

class Contacto {
    public String nombre;
    public String direccion;
    public String telefono;

    public Contacto(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}



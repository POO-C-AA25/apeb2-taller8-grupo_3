import java.util.Arrays;
import java.util.List;
public class Problema4_Monitoreo {
    public static void main(String[] args) {
        Dispositivo n1 = new DispositivoCosta( Arrays.asList(1.0, 2.0), 1, "Guayaquil", Arrays.asList(35.0, 60.0));//1. sequia, 2. calor extremo, 35. temperatura, 60. humedad
        Dispositivo n2 = new DispositivoSierra( Arrays.asList(3.0, 4.0), 2, "Quito", Arrays.asList(90.0, 14.0));//3. deslizamento, 4. cambio termico, 90. lluvia, 14. temperatura 
        Dispositivo n3 = new DispositivoOriente(Arrays.asList(5.0, 6.0), 3, "Zamora", Arrays.asList(20.0, 25.0));//5. contaminacion, 6. incendios, 40. calidad de aire, 25. humedad del suelo
        List<Dispositivo> dispositivos = Arrays.asList(n1, n2, n3);

        for (Dispositivo d : dispositivos) {
            System.out.println(d.procesarDatos());
            System.out.println(d); 
            System.out.println("------------");
        }
    }
}
abstract class Dispositivo{
    public int id;
    public String ubicacion;
    public List<Double> indicadores;

    public Dispositivo(int id, String ubicacion, List<Double> indicadores) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.indicadores = indicadores;
    }
    public abstract String procesarDatos();

    @Override
    public String toString() {
        return "Dispositivo{" + "id=" + id + ", ubicacion=" + ubicacion + ", indicadores=" + indicadores + '}';
    }
    
}
class DispositivoSierra extends Dispositivo{
    public List<Double> riesgos;

    public DispositivoSierra(List<Double> riesgos, int id, String ubicacion, List<Double> indicadores) {
        super(id, ubicacion, indicadores);
        this.riesgos = riesgos;
    }
    public String procesarDatos(){
        return "Procesando datos de deslizamientos y variación térmica en la sierra";
    }

    @Override
    public String toString() {
        return "DispositivoSierra{" + "riesgos=" + riesgos + "}" + super.toString();
    }
}
class DispositivoCosta extends Dispositivo{
    public List<Double> riesgos;

    public DispositivoCosta(List<Double> riesgos, int id, String ubicacion, List<Double> indicadores) {
        super(id, ubicacion, indicadores);
        this.riesgos = riesgos;
    }
    public String procesarDatos(){
        return "Procesando datos de sequía y calor extremo en la costa";
    }

    @Override
    public String toString() {
        return "DispositivoCosta{" + "riesgos=" + riesgos + "}" + super.toString();
    }
}
class DispositivoOriente extends Dispositivo{
    public List<Double> riesgos;

    public DispositivoOriente(List<Double> riesgos, int id, String ubicacion, List<Double> indicadores) {
        super(id, ubicacion, indicadores);
        this.riesgos = riesgos;
    }
    public String procesarDatos(){
        return "Procesando datos de humedad y calidad del aire en el oriente";
    }

    @Override
    public String toString() {
        return "DiapositivoOriente{" + "riesgos=" + riesgos + "}" + super.toString();
    }
    
}

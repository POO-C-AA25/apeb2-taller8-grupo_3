/***
 * Una red de monitoreo ambiental tiene como objetivo registrar, analizar y reportar los impactos del cambio climático en diferentes 
 * regiones. En cada ubicación se instalan dispositivos capaces de medir distintos indicadores climáticos como temperatura, precipitación, 
 * calidad del aire, y humedad del suelo. Dependiendo de la región (costa, sierra y oriente), los dispositivos pueden variar en capacidades 
 * y protocolos de recolección.
 * Los datos recolectados deben almacenarse y analizarse periódicamente. Además, ciertas ubicaciones requieren generar reportes personalizados 
 * que destaquen riesgos ambientales como sequías, deslizamientos o contaminación del aire. Algunos dispositivos pueden comportarse de forma 
 * especializada para detectar únicamente ciertos tipos de indicadores dependiendo de la región (costa, sierra y oriente).
 * Requisitos funcionales:
 * Representar diferentes tipos de dispositivos y sus especializaciones, para la costa, sierra y oriente.
 * Implementar métodos polimórficos que permitan procesar los datos según los tipos de dispositivos y sus especializaciones, para la costa, 
 * sierra y oriente.
 * Generar reportes dinámicos en función del tipo de riesgo ambiental detectado según la región
 * Note
 * Plantee una solución polimórfica dada una jerarquía de clases con ventajas de herencia. Y para la generación de reportería, use los toString() base.
 */
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

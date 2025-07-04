import java.util.ArrayList;
public class Problema2_Menu {
    public static void main(String[] args) {
        ArrayList<Menu> menus = new ArrayList<>();
        Menu m1 = new MenuCarta(2.5, 1.5, 0.5, "Parrillada", 10.0);
        Menu m2 = new MenuDia(2.5, 1.5, "Almuerzo", 8.0);
        Menu m3 = new MenuNiño(0.5, 2.5, "Hamburguesa", 4.50);
        Menu m4 = new MenuEconomico(0.20, "Arroz con pollo", 3.5);
        menus.add(m1);
        menus.add(m2);
        menus.add(m3);
        menus.add(m4);
        Cuenta cuenta = new Cuenta("Diego Armando", menus, 0.12);
        System.out.println("---Cuenta cliente---");
        System.out.println("Cliente: " + "Diego Armando");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
        cuenta.calcularSubtotal();
        System.out.printf("Subtotal: %.2f\n", cuenta.getSubtotal());
    }       
}
abstract class Menu{
    public String nombrePlato;
    public double valorMenu;
    public double valorInicial;
    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }
    public abstract void calcularValorMenu();
    public double getValorMenu(){
        return this.valorMenu;
    }

    @Override
    public String toString() {
        return "Menu{" + "nombrePlato=" + nombrePlato + ", valorMenu=" + valorMenu + ", valorInicial=" + valorInicial + '}';
    }
    
}
class MenuCarta extends Menu{
    public double valorGuarnicion;
    public double valorBebida;
    public double porcentajeBebida;

    public MenuCarta(double valorGuarnicion, double valorBebida, double porcentajeBebida, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeBebida = porcentajeBebida;
    }
    @Override
    public void calcularValorMenu(){
        this.valorMenu = valorInicial + valorGuarnicion + valorBebida + (valorInicial * valorBebida/100);
    }

    @Override
    public String toString() {
        return "MenuCarta{" + "valorGuarnicion=" + valorGuarnicion + ", valorBebida=" + valorBebida + ", porcentajeBebida=" + porcentajeBebida + "}" + super.toString();
    }
    
}
class MenuDia extends Menu{
    public double valorPostre;
    public double valorBebida;

    public MenuDia(double valorPostre, double valorBebida, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }
    @Override
    public void calcularValorMenu(){
        this.valorMenu = valorInicial + valorBebida + valorPostre;
    }

    @Override
    public String toString() {
        return "MenuDia{" + "valorPostre=" + valorPostre + ", valorBebida=" + valorBebida + "}" + super.toString();
    }
    
}
class MenuNiño extends Menu{
    public double valorHelado;
    public double valorPastel;

    public MenuNiño(double valorHelado, double valorPastel, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    public void calcularValorMenu(){
        this.valorMenu = valorInicial + valorHelado + valorPastel;
    }

    @Override
    public String toString() {
        return "MenuNi\u00f1o{" + "valorHelado=" + valorHelado + ", valorPastel=" + valorPastel + "}" + super.toString();
    }
    
}
class MenuEconomico extends Menu{
    public double descuento;

    public MenuEconomico(double descuento, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.descuento = descuento;
    }
    
    @Override
    public void calcularValorMenu(){
        this.valorMenu = valorInicial - (valorInicial * descuento/100);
    }

    @Override
    public String toString() {
        return "MenuEconomico{" + "descuento=" + descuento + "}" + super.toString();
    }
    
}
class Cuenta{
    public String nombreCliente;
    public ArrayList<Menu> listaMenu;
    public double valorCancelar;
    public double subtotal;
    public double iva;

    public Cuenta(String nombreCliente, ArrayList<Menu> listaMenu, double iva) {
        this.nombreCliente = nombreCliente;
        this.listaMenu = listaMenu;
        this.iva = iva;
    }
    public void calcularSubtotal(){
        this.subtotal = 0;
        for (Menu n : listaMenu){
            n.calcularValorMenu();
            this.subtotal += n.getValorMenu();
        }
        this.valorCancelar = subtotal + (subtotal * iva);
    }
    public double getSubtotal(){
        return subtotal;
    }
    @Override
    public String toString() {
        return "Cuenta{" + "nombreCliente=" + nombreCliente + ", listaMenu=" + listaMenu + ", valorCancelar=" + valorCancelar + ", subtotal=" + subtotal + ", iva=" + iva + '}';
    }
    
}
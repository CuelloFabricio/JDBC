
package tienda;

import java.util.Scanner;
import tienda.servicios.ServicioFabricante;
import tienda.servicios.ServicioProducto;


public class Main {

    public static void main(String[] args) {
        try{
            ServicioFabricante sf = new ServicioFabricante();
            ServicioProducto sp = new ServicioProducto();
            menuDeOpciones(sp, sf);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
    }
    
    public static void menuDeOpciones(ServicioProducto sp, ServicioFabricante sf) throws Exception {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("1.Listar el nombre de todos los productos");
        System.out.println("2.Listar el nombre y precio de todos los productos");
        System.out.println("3.Listar aquellos productos cuyo precio este entre 120 y 202");
        System.out.println("4.Listar todos los productos 'Portatiles'");
        System.out.println("5.Mostrar el producto mas barato");
        System.out.println("6.Ingresar un producto");
        System.out.println("7.Ingresar un fabricante");
        System.out.println("8.cambiar un precio");
        System.out.println("9.salir");
        try {
            Integer op = 0;
            do {
                sc.nextLine();
                System.out.print("Opcion:");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        sp.mostrarProdutosNombres();
                        break;
                    case 2:
                        sp.mostrarProductoNombresyPrecios();
                        break;
                    case 3:
                        sp.mostrarProductosPrecioEntre();
                        break;
                    case 4:
                        sp.mostrarNombre();
                        break;
                    case 5:
                        sp.mostrarBarato();
                        break;
                    case 6:
                        System.out.print("Nombre:");
                        String nombre = sc.next();
                        System.out.print("Precio:");
                        Double precio = sc.nextDouble();
                        System.out.print("Codigo Fabricante:");
                        Integer codigoFabricante = sc.nextInt();
                        sp.crearProducto(nombre, precio, codigoFabricante);
                        break;
                    case 7:
                        System.out.print("Nombre:");
                        String nom = sc.next();
                        sf.crearFabricante(nom);
                        break;
                    case 8:
                        System.out.println("Codigo del Producto A Cambiar");
                        sp.modificarPrecioProducto(sc.nextInt());
                        break;
                    case 9:
                        System.out.println("-------------------------------------");
                        System.out.println("Saliendo...");
                        System.out.println("-------------------------------------");
                        break;
                    default:
                        System.out.println("1.Listar el nombre de todos los productos");
                        System.out.println("2.Listar el nombre y precio de todos los productos");
                        System.out.println("3.Listar aquellos productos cuyo precio este entre 120 y 202");
                        System.out.println("4.Listar todos los productos 'Portatiles'");
                        System.out.println("5.Mostrar el producto mas barato");
                        System.out.println("6.Ingresar un producto");
                        System.out.println("7.Ingresar un fabricante");
                        System.out.println("8.cambiar un precio");
                        System.out.println("9.salir");
                }
            } while (op != 9);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Error en menuDeOpciones()");
            throw e;
        }
    }

}

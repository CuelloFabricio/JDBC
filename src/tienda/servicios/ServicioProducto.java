package tienda.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDao;


public class ServicioProducto {
    ProductoDao dao = new ProductoDao();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public void crearProducto(String nombre, Double precio, Integer codigo_fabricante) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Error Nombre");
            }
            if (precio == null) {
                throw new Exception("Error precio");
            }
            if (codigo_fabricante == null || dao.buscarCodigoFabricante(codigo_fabricante)) {
                throw new Exception("Error codigo fabricante");
            }
            Producto p = new Producto(nombre, precio, codigo_fabricante);
            dao.ingresarProducto(p);
        } catch (Exception e) {
            System.out.println("Error en crearProducto()");
            throw e;
        }
    }
   
    public void modificarPrecioProducto(int codigo) throws Exception{
        try{
            if (dao.buscarCodigo(codigo)==null){
                throw new Exception("No Existe el producto");
            }
            Producto p = dao.buscarCodigo(codigo);
            System.out.println("Que precio decea ponerle? al Producto"+p.getNombre());
            p.setPrecio(sc.nextDouble());
            dao.modificarProducto(p);
        }catch(Exception e){
            System.out.println("Error en modificarPrecioProducto()");
            throw e; 
        }
    }
    
    public void mostrarProdutosNombres() throws Exception {
        try {
            ArrayList<Producto> lp = dao.listaProductos();
            if(lp.isEmpty()){
                throw new Exception("Lista Vacia");
            }
            
            for (Producto p : lp) {
                System.out.println("Nombre: " + p.getNombre());
            }
        } catch (Exception e) {
            System.out.println("Error en mostrarProductosNombres()");
            throw e;
        }
    }
    
    public void mostrarProductoNombresyPrecios() throws Exception {
        try {
            ArrayList<Producto> lp = dao.listaProductos();
            if(lp.isEmpty()){
                throw new Exception("Lista Vacia");
            }
            
            for (Producto p : lp) {
                System.out.println("Nombre: " + p.getNombre() + " Precio: $" + p.getPrecio());
            }
        } catch (Exception e) {
            System.out.println("Error en mostrarProductosNombresyPrecio()");
            throw e;
        }
    }
    
    public void mostrarProductosPrecioEntre() throws Exception {
        try {
            ArrayList<Producto> lp = dao.listaPrecioEntre(120, 202);
            if(lp.isEmpty()){
                throw new Exception("Lista Vacia");
            }
            
            for (Producto p : lp) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println("Error en mostrarProductosPrecioEntre()");
            throw e;
        }
    }
    
    public void mostrarNombre() throws Exception {
        try {
            ArrayList<Producto> lp = dao.listaNombre("Portatil");
            
            if(lp.isEmpty()){
                throw new Exception("Lista Vacia");
            }
            
            for (Producto p : lp) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println("Error en mostrarNombre()");
            throw e;
        }
    }
    
    public void mostrarBarato() throws Exception{
        try{
            Producto p = dao.precioMin();
            if (p==null){
              throw new Exception("Nesecita Producto");
            }

        System.out.println("El Producto Mas Barato es:");
        System.out.println(p.toString());
        }catch(Exception e){
            System.out.println("Error en mostrarBarato()");
            throw e;
        }
    }
}



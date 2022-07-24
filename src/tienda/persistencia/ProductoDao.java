package tienda.persistencia;

import java.util.ArrayList;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

public class ProductoDao extends Dao{

    public void ingresarProducto(Producto p) throws Exception{
        try{
            if (p == null){
                throw new Exception("Necesita un Producto");
            }
            String sql = "INSERT INTO Producto(nombre, precio, codigo_fabricante)"
                    +"VALUES('"+p.getNombre()+"', "+p.getPrecio()+", "+p.getCodigo_fabricante()+");";
            super.insertarModificarEliminar(sql);
        }catch(Exception e){
            System.out.println("Error en ingresarProducto()");
            throw e;
        }
    }
    
    public void modificarProducto(Producto p) throws Exception{
        try{
            if (p == null){
                throw new Exception("Necesita un Producto");
            }
            String sql = "UPDATE Producto SET "
                 +"precio = " + p.getPrecio()
                 + "WHERE codigo = " + p.getCodigo()+";";
            super.insertarModificarEliminar(sql);
        }catch(Exception e){
            System.out.println("Error en modificarProducto()");
            throw e;
        }
    }
    
    public Producto buscarCodigo(int codigo) throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE codigo = "+codigo+";";
            super.consultarBase(sql);
            Producto p =null;
            while (super.resultado.next()){
                p = new Producto();
                p.setCodigo(codigo);
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
            }
            super.desconectarBase();
            return p;
        }catch(Exception e){
            System.out.println("Error en buscarCodigo()");
            super.desconectarBase();
            throw e;
        }
    }
    
    public ArrayList<Producto> listaProductos() throws Exception {
      try{
            String sql = "SELECT * FROM producto;";
            super.consultarBase(sql);
            ArrayList<Producto> lp = new ArrayList<>();
            Producto p =null;
            while (super.resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                lp.add(p);
            }
            super.desconectarBase();
            return lp;
        }catch(Exception e){
            System.out.println("Error en listaProductos()");
            super.desconectarBase();
            throw e;
        }  
    }
    
    public ArrayList<Producto> listaPrecioEntre(int a, int b) throws Exception{
      try{
            String sql = "SELECT * FROM producto WHERE precio BETWEEN "+a+" AND "+b+";";
            super.consultarBase(sql);
            ArrayList<Producto> lp = new ArrayList<>();
            Producto p =null;
            while (super.resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                lp.add(p);
            }
            super.desconectarBase();
            return lp;
        }catch(Exception e){
            System.out.println("Error en listaPrecioEntre()");
            super.desconectarBase();
            throw e;
        }    
    }
    
   public ArrayList<Producto> listaNombre(String string) throws Exception{
       try{
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%"+string+"%';";
            super.consultarBase(sql);
            ArrayList<Producto> lp = new ArrayList<>();
            Producto p =null;
            while (super.resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                lp.add(p);
            }
            super.desconectarBase();
            return lp;
        }catch(Exception e){
            System.out.println("Error en listaNombre()");
            super.desconectarBase();
            throw e;
        }
   }
   
    public Producto precioMin() throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE precio = (SELECT MIN(precio) FROM producto);";
            super.consultarBase(sql);
            Producto p =null;
            while (super.resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
            }
            super.desconectarBase();
            return p;
        }catch(Exception e){
            System.out.println("Error en precioMin()");
            super.desconectarBase();
            throw e;
        }
    }
    
    public boolean buscarCodigoFabricante(Integer codigo_fabricante) throws Exception{
        try{
            String sql = "SELECT * FROM fabricante WHERE codigo = "+codigo_fabricante+";";
            super.consultarBase(sql);
            Fabricante p =null;
            while (super.resultado.next()){
                p = new Fabricante();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
            }
            super.desconectarBase();
            Boolean b = (p==null);
            return b;
        }catch(Exception e){
            System.out.println("Error en buscarCodigoFabricante()");
            super.desconectarBase();
            throw e;
        }
    }
}



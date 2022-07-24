package tienda.persistencia;

import tienda.entidades.Fabricante;

public class FabricanteDao extends Dao{

    public void ingresarFabricante(Fabricante f) throws Exception{
        try{
            if (f == null){
                throw new Exception("Necesita un Fabricante");
            }
            super.conectarBase();
            String sql = "INSERT INTO Fabricante(nombre)"+
                    "VALUES('"+f.getNombre()+"');";
            super.insertarModificarEliminar(sql);
        }catch(Exception e){
            System.out.println("Error en ingresarFabricante()");
            throw e;
        }
    }
    
     public Boolean buscarNombre(String n) throws Exception{
        try{
            String sql = "SELECT * FROM fabricante WHERE nombre = '"+n+"';";
            super.consultarBase(sql);
            Fabricante p = null;
            while (super.resultado.next()){
                p = new Fabricante();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
            }
            super.desconectarBase();
            Boolean b = (p!=null);
            return b;
        }catch(Exception e){
            System.out.println("Error en buscarNombre()");
            super.desconectarBase();
            throw e;
        }
    }
}


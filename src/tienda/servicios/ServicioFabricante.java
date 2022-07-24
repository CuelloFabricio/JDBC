package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDao;

public class ServicioFabricante {
    FabricanteDao dao = new FabricanteDao();
    public void crearFabricante(String nombre) throws Exception{
        try{
            if (nombre == null || nombre.trim().isEmpty()){
             throw new Exception("Necesita un nombre");   
            }
            if (dao.buscarNombre(nombre)){
                throw new Exception("Ya existe ese Fabricante"); 
            }
            Fabricante f = new Fabricante();
            f.setNombre(nombre);
            dao.ingresarFabricante(f);
        }catch(Exception e){
            System.out.println("Error en crearFabricante()");
            throw e;
        }
    }
}


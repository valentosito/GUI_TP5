
package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class DirectorioTelefonico {
    
    // Atributo de DirectorioTelefonico:
    private TreeMap<Long, Contacto> mapaDelDirectorio;
    
    // Relación de agregación: DirectorioTelefonico (todo) ◇───> Contacto (parte):
    private ArrayList <Contacto> listaDeContactos; // Declaro referencia e incializo en constructor

    
    // El constructor no recibe nada, y se encarga de inicializar las estructuras del DirectorioTelefonico.
    public DirectorioTelefonico() {
        this.mapaDelDirectorio = new TreeMap<>();
        this.listaDeContactos = new ArrayList<>();
    }
    
    // Después, los métodos van agregando/modificando los datos:
    
    public boolean agregarContacto(Long telefono, Contacto contacto){
        
        if (mapaDelDirectorio.putIfAbsent(telefono, contacto) == null){
            
            listaDeContactos.add(contacto);
            return true;
        }
        else {
            return false;          
        }      
    }
    
    public Contacto buscarContacto(Long telefono){
        
        return mapaDelDirectorio.get(telefono); 
        // Devuelve una referencia a un objeto de tipo Contacto
        // o ninguna referencia a ningún objeto, o sea un null.
        
    }
    
    public Set<Long> buscarTelefono(String apellido){
    
        TreeSet<Long> telefonos = new TreeSet<>();
        
        Iterator <Map.Entry<Long, Contacto>> it = mapaDelDirectorio.entrySet().iterator();
        
        while (it.hasNext()){
            
            Map.Entry <Long, Contacto> par = it.next();
            
            if (par.getValue().getApellido().trim().equals(apellido.trim())){
                
                telefonos.add(par.getKey());
            }        
        }
        
        return telefonos; 
        
        
    /*  ALTERNATIVA MÁS SENCILLA CON UN FOR EACH:
        
        TreeSet<Long> telefonos = new TreeSet<>();
         
        for (Map.Entry<Long, Contacto> par : mapaDelDirectorio.entrySet()){
             
            Contacto c = par.getValue();
             
            if (c.getApellido().trim().equals(apellido.trim())){  // Comparar ambos apellidos sin espacios accidentales en los extremos.
             
                telefonos.add(par.getKey());
             
            }            
        }
        
        return telefonos;      
    */
    }
    
    public ArrayList<Contacto> buscarContacto(String ciudad){
        
        ArrayList<Contacto> contactosEncontrados = new ArrayList<>();
        
        for (Map.Entry<Long, Contacto> par : mapaDelDirectorio.entrySet()){
            
            Contacto c = par.getValue();
            
            if (c.getCiudad().trim().equals(ciudad.trim())){
                
                contactosEncontrados.add(c);
            }
        }
        
        return contactosEncontrados;
    }
    
    public boolean borrarContacto(Long telefono){
        
        if (mapaDelDirectorio.containsKey(telefono)){
        
            Contacto c = mapaDelDirectorio.get(telefono);
            
            listaDeContactos.remove(c);
            mapaDelDirectorio.remove(telefono);
            
            return true;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "DirectorioTelefonico{" + "mapaDelDirectorio=" + mapaDelDirectorio + ", listaDeContactos=" + listaDeContactos + '}';
    }
          
    
}

package clases;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class test {
    
    
    public static void main (String[] args){
       
        Scanner sc = new Scanner (System.in);
                
        // main usa DirectorioTelefonico, el cual tiene Contactos. 
        
        DirectorioTelefonico directorio = new DirectorioTelefonico();
        
        
        // Contacto/Cliente
        
        Contacto c1 = new Contacto(39393601, "Valentina", "Toso", "San Luis", "San Fernando 4");
        Contacto c2 = new Contacto (36363901, "Melisa", "Rodriguez", "San Luis", "Las Flores 5");
        Contacto c3 = new Contacto (40404501, "Aime", "Olivares", "San Luis", "Toro Negro 6");
        Contacto c4 = new Contacto (12345678, "Paola", "Gimenez", "San Luis", "San Fernando 3");
        Contacto c5 = new Contacto (78945612, "Pedro", "Gimenez", "San Juan", "Pringles 555");
        
        
        // A
        System.out.println(
                directorio.agregarContacto(2665034630L, c1)
                ? "Cliente agregado."
                : "Denegado. Ya existe un cliente asociado al número de teléfono."
        );
        
        System.out.println(
                directorio.agregarContacto(2664389450L, c2)
                ? "Cliente agregado."
                : "Denegado. Ya existe un cliente asociado al numero de telefono"
        );
        
        System.out.println(
                directorio.agregarContacto(2664526481L, c3)
                ? "Cliente agregado."
                : "Denegado. Ya existe un cliente asociado al numero de telefono"
        );

        System.out.println(
                directorio.agregarContacto(2664785412L, c4)
                ? "Cliente agregado."
                : "Denegado. Ya existe un cliente asociado al numero de telefono"
        );
        
        System.out.println(
                directorio.agregarContacto(254124578L, c5)
                ? "Cliente agregado."
                : "Denegado. Ya existe un cliente asociado al numero de telefono"
        );
        
        /* Reemplazo del código:
        test = directorio.agregarContacto(2665034630L, c1);
        if (test = true){
            System.out.println("Contacto agregado.\n");
        }
        else{
            System.out.println("Denegado. Ya existe cliente asociado al numero de telefono.\n");
        }
        */
        
        // B
        System.out.print("\nBuscar cliente por numero de telefono. Ingrese numero de telefono: ");
        Long nro = sc.nextLong(); // Autoboxing automático de long a Long. 
        sc.nextLine(); // limpio buffer
        
        if (directorio.buscarContacto(nro) == null){
            
            System.out.println("\nNo existe cliente asociado al numero de telefono.");    
        }
        else{
            System.out.println("\nEl cliente es: " + directorio.buscarContacto(nro));
        }
        
        // C
        System.out.print("\nBuscar telefonos por apellido. Ingrese apellido: ");
        String ap = sc.nextLine();
        
        TreeSet<Long> telefonosEncontrados = directorio.buscarTelefono(ap);
        
        System.out.println("\nLista de telefonos encontrados\n");
        System.out.println(telefonosEncontrados);
        
        
        // D
        System.out.print("\nBuscar clientes por ciudad. Ingrese ciudad: ");
        String ciudad = sc.nextLine();
        
        ArrayList <Contacto> contactosEncontrados = directorio.buscarContactos(ciudad);
        
        System.out.println("\nLista de contactos encontrados\n");
        
        for (Contacto c : contactosEncontrados) {
            System.out.println(c);
        }
        
        // E
        System.out.print("\nIngrese el numero de telefono del cliente que desea borrar: ");
        nro = sc.nextLong();
        sc.nextLine(); // limpio buffer
        
        if (directorio.borrarContacto(nro) == false){
            
            System.out.println("\nCliente con numero de telefono " +nro+ " borrado exitosamente.");
        }
        else{
            System.out.println("\nDenegado. No existe cliente asociado al numero de telefono " +nro);
        }
        
   
    }
}

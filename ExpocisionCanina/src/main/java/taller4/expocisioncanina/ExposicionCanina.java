
package taller4.expocisioncanina;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author David Pasaje - German Tulcan
 */
public class ExposicionCanina {
     
         ArrayList<Perro> misPerros = new ArrayList<>();
         Scanner sc = new Scanner (System.in);
         public static void main(String[] args) {
 
             ExposicionCanina expo = new ExposicionCanina();
                 expo.mostrarMenu();
     }
         
         
public void mostrarMenu(){
    boolean activo = true;
    do{
        System.out.println(" ");
        System.out.println("========================================");
        System.out.println("===Exposicion Canina===");
        System.out.println("1.Agregar perro");
        System.out.println("2.Mostar lista de perros");     
        System.out.println("3.Localizar perro por su nombre y mostrar su informacion");
        System.out.println("4.Buscar perro ganador");
        System.out.println("5.Buscar perro con menor puntaje");
        System.out.println("6.Buscar perro con mayor edad");
        System.out.println("7.Cerrar programa");
        System.out.println("========================================");
        System.out.println(" ");
     
          int opcion = sc.nextInt();
          
                  switch(opcion ){
                      case 1:
                          try{
                              agregarPerro();
                          } catch (NombreDuplicadoExcepcion e) {
                              System.out.println(e.getMessage());
                          }
                          break;
                      case 2:
                          menuListar();
                       
                          break;
                      case 3:
                          localizarPerro() ;
                          
                          break;
                      case 4 :
                          buscarPerroMayorPuntaje();
                          break;
                      case 5:
                          buscarPerroMenorPuntaje() ;
                          break;
                      case 6:
                          buscarPerroMasViejo();
                                 
                          break;
                             case 7:
                          activo = false;
                    System.out.println("programa finalizado");
                            break;

                    
                default:
                    System.out.println("opcion no valida");

            }
    }while(activo);
}
public void agregarPerro() throws NombreDuplicadoExcepcion{
    
    
    System.out.println("Ingrese el nombre del perro");
    sc.nextLine();
    String nombre = sc.nextLine();
    if(!misPerros.isEmpty()){
    for(Perro p : misPerros){
        if(p.getNombre().equalsIgnoreCase(nombre)){
            throw new NombreDuplicadoExcepcion();
        } 
    }    
    }
    System.out.println("Ingrese la raza del perro");  
    String raza = sc.nextLine();  
    
    System.out.println("Ingrese la edad del perro ");
    int edad = sc.nextInt();
    
    System.out.println("Ingrese los puntos del perro");
    int puntos = sc.nextInt();
    
    System.out.println("Ingrese la foto del perro");
    String foto = sc.next();
    
     Perro nuevoPerro = new Perro(nombre,raza,edad,puntos,foto);
     misPerros.add(nuevoPerro);
      System.out.println("Perro agregado con exito");
      System.out.println("========================================");
    }
 
    
    public void listarPorPuntaje(){
                       for (int i = 0; i <misPerros.size()  - 1 ;i++){
             for(int j = i ; j < misPerros.size(); j++){
                 
                  Perro p1 = misPerros.get(i);
                  Perro p2 = misPerros.get(j);
                 if(p1.getPuntos()< p2.getPuntos()) {
                     misPerros.set(i, p2);
                     misPerros.set(j, p1);
                     
                 }
             }
         }
         
             System.out.println("lista Organizada Por puntaje de mayor a menor");
           for (Perro p : misPerros){
             System.out.println("nombre: " + p.getNombre());
             System.out.println("raza: " + p.getRaza());
             System.out.println("edad: " + p.getEdad());
             System.out.println("puntos: " + p.getPuntos());
             System.out.println("foto: " + p.getFoto());
             System.out.println("========================================");
     }
    }
    public void listarPorEdad(){
               for (int i = 0; i <misPerros.size()  - 1 ;i++){
             for(int j = i ; j < misPerros.size(); j++){
                 
                  Perro p1 = misPerros.get(i);
                  Perro p2 = misPerros.get(j);
                 if(p1.getEdad() < p2.getEdad()) {
                     misPerros.set(i, p2);
                     misPerros.set(j, p1);
                     
                 }
             }
         }
         
             System.out.println("lista Organizada del mas viejo al mas joven");
           for (Perro p : misPerros){
             System.out.println("nombre: " + p.getNombre());
             System.out.println("raza: " + p.getRaza());
             System.out.println("edad: " + p.getEdad());
             System.out.println("puntos: " + p.getPuntos());
             System.out.println("foto: " + p.getFoto());
             System.out.println("========================================");
     }
  
}
        public void listarPorRaza() {               
            
        Comparator<Perro> comparadorRaza = new Comparator<Perro>() {
            @Override
            public int compare(Perro p1, Perro p2) {
                return p1.getRaza().compareTo(p2.getRaza());
            }
        }; 
        Collections.sort(misPerros, comparadorRaza);
        System.out.println("lista organizada por raza en orden alfabetico");
        for(Perro p: misPerros) {
            System.out.println("nombre: " + p.getNombre());
            System.out.println("raza: "+p.getRaza());
            System.out.println("edad: "+p.getEdad());
            System.out.println("Puntos: "+p.getPuntos());
            System.out.println("foto: " + p.getFoto());
            System.out.println("========================================");
        }     
                
    }
    
    public void menuListar(){
        if (!misPerros.isEmpty()) {
        
            boolean active = true;
    do{
        System.out.println("===opciones de lista===");
        System.out.println("1.Listar perros por edad");
        System.out.println("2.Listar perros por puntaje");
        System.out.println("3.Listar perros por raza");
        System.out.println("4.Volver al menu principal");
        System.out.println("========================================");
     
          int opcion = sc.nextInt();
          
                  switch(opcion ){
   
                   case 1:
                           listarPorEdad();
                            break;
                   case 2:
                           listarPorPuntaje();
                                 
                            break;
                   case 3: listarPorRaza();
                            break;
                   case 4 :
                      mostrarMenu();
                      active = false;
                      break;

                   
                default:
                    System.out.println("opcion no valida");

            }
    }while(active);
        } 
        else{
            System.out.println("todavia no hay perros registrados");
        }
    }

    

    public void localizarPerro() {
        if (!misPerros.isEmpty()) {
        
    boolean perroEncontrado = false;
    System.out.println("Ingresa el nombre del perro que deseas buscar ");
    sc.nextLine();
    String nombreB = sc.nextLine();
    
    for(Perro p: misPerros) {
        if(p.getNombre().equals(nombreB)) {
            
            System.out.println("Perro encontrado con exito");
            System.out.println("nombre: " + p.getNombre());
            System.out.println("raza: " + p.getRaza());
            System.out.println("edad: " + p.getEdad());
            System.out.println("puntos: " + p.getPuntos());
            System.out.println("foto: " + p.getFoto());
            System.out.println("========================================");
            perroEncontrado = true;
         
        }
    }
    
    if(!perroEncontrado) {
        System.out.println("No se encontro el perro con el nombre ingresado");
    }
}
         else{
         System.out.println("todavia no hay perros registrados");
        }
}
   public void buscarPerroMayorPuntaje() {
    if (!misPerros.isEmpty()) {
    Perro perroMasPuntos = misPerros.get(0);
    for (Perro perro : misPerros) {
        if (perro.getPuntos() > perroMasPuntos.getPuntos()) {
            perroMasPuntos = perro;
        }
    }

    System.out.println("El perro con el mayor puntaje es:");
    System.out.println("nombre: " + perroMasPuntos.getNombre());
    System.out.println("raza: " + perroMasPuntos.getRaza());
    System.out.println("edad: " + perroMasPuntos.getEdad());
    System.out.println("puntos: " + perroMasPuntos.getPuntos());
    System.out.println("foto: " + perroMasPuntos.getFoto());
     System.out.println("========================================");
}
    else{
        System.out.println("todavia no hay perros registrados");
    }
   }
       public void buscarPerroMenorPuntaje(){
        if (!misPerros.isEmpty()) {
        Perro perroM = misPerros.get(0);
        for (Perro perro : misPerros) {
            if (perro.getPuntos() < perroM.getPuntos()) {
                perroM = perro;
        }
    }

    System.out.println("El perro con el menor puntaje es:");
    System.out.println("nombre: " + perroM.getNombre());
    System.out.println("raza: " + perroM.getRaza());
    System.out.println("edad: " + perroM.getEdad());
    System.out.println("puntos: " + perroM.getPuntos());
    System.out.println("foto: " + perroM.getFoto());
    System.out.println("========================================");
}
  else{
        System.out.println("todavia no hay perros registrados");
    }      
         
     }
         public void buscarPerroMasViejo(){
         if (!misPerros.isEmpty()) {
            Perro perroV = misPerros.get(0);
                for (Perro perro : misPerros) {
                    if (perro.getEdad() > perroV.getEdad()) {
                        perroV = perro;
        }
    }

    System.out.println("El perro con mayor edad es:");
    System.out.println("nombre: " + perroV.getNombre());
    System.out.println("raza: " + perroV.getRaza());
    System.out.println("edad: " + perroV.getEdad());
    System.out.println("puntos: " + perroV.getPuntos());
    System.out.println("foto: " + perroV.getFoto());
    System.out.println("========================================");
}
  else{
        System.out.println("todavia no hay perros registrados");
    }
         
     }
  
}
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {

    
    public static int mostrarMenu(Scanner consola){
        int opcion;
        
        
        
        System.out.printf("""
                Opciones------------>
                1. Reservar asiento.
                2. Mostrar Reserva
                3. Salir
                Elija una opción:\s""");
        opcion = Integer.parseInt(consola.nextLine());        
        return opcion;
    
    }

    public static boolean ejecutarOpciones(Scanner consola,int opcion,sala sala,List<String> reserva){

        boolean salir = false;
        switch (opcion) {
            case 1->reservarSala(sala,consola,reserva);
            case 2->mostrarReserva(reserva);             
            case 3->{salir=true;
                    System.out.println("Gracias por usar el sistema de reservas.");}         
                
        }
            
        
        return salir;
        
    }


    

    public static void reservarSala(sala Sala, Scanner consola,List<String> lista){
        var flag = false;
        int fila,asiento;
        

        while (!flag) {
            System.out.println("Ingrese la fila y el asiento a reservar");


            System.out.print("\tFila = ");
            fila = Integer.parseInt(consola.nextLine());
            System.out.print("\tAsiento = ");
            asiento = Integer.parseInt(consola.nextLine());
                
            if(Sala.getEstadoAsiento(fila, asiento)!='L'){
                System.out.print("\nEl asiento se encuentra reservado"+
                                 "\nDesea ver los asientos disponibles (Si/No): ");
                char respuesta = consola.nextLine().toLowerCase().charAt(0);
                 
                if(respuesta=='s'){
                    Sala.mostrarSala();
                    System.out.println("Ingrese una nueva reserva.");
                }
            }else{
                Sala.setReservarAsiento(fila, asiento);
                System.out.println("\t!Asiento reservado.!");
                var reservaOrden = "Fila ["+fila+"]"+" Asiento["+asiento+"]";
                main.guardarReserva(lista,reservaOrden);
                System.out.print("Desea hacer otra reserva (Si/No): ");
                char masReservas = consola.nextLine().toLowerCase().charAt(0);
                                  
                    if(masReservas=='n'){
                                          
                        System.out.println("\nElija una nueva opción.");
                        flag=true;
                        
                    }else
                        System.out.println("\nIngrese una nueva reserva");
                    
            }
            
            
        }
    

       
        
    }    
        
    
    
    public static void mostrarReserva(List<String> reservas) {
        
        if(reservas.isEmpty()){
            System.out.println("\nNo a realizado ningúna reserva.\n");
        }else{
            System.out.println("\nLos asientos reservados de la orden son: ");
            for (String reserva : reservas) {
                System.out.println(reserva);
            }
            
            System.out.println("\n");

        }
        
      
      
              
    }

    public static void guardarReserva(List<String> lista,String reserva){

        lista.add(reserva);


    }

    public static void main(String[] args) {
        
        var salir = false;
        var sala1=new sala();
        var consola = new Scanner(System.in);
        List<String> listaRereservas= new ArrayList<>();
        
        
        sala1.crearSala();
        System.out.println("************** BIENVENIDO AL SISTEMA DE RESERVAS ************");
        while (!salir) {

            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, sala1, listaRereservas);
       
            }catch(Exception e){
                System.out.println("\nOcurrio un error: "+e);
            }
            
        }
        

        
    }    
    
}

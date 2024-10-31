import java.security.PublicKey;

import javax.print.attribute.standard.DialogOwner;

public class sala {
    
    private char matriz[][];
    private int filas,asientos,IdSala;
    private static int numSala;

    

    public void crearSala(){

        this.IdSala=++sala.numSala;
        this.matriz= new char[10][10];
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz.length;j++){
                this.matriz[i][j]='L';
            }
        }       
    }

    public void mostrarSala(){
        System.out.println("Sala de cine = "+this.IdSala);

        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz.length;j++){
                System.out.print(this.matriz[i][j]+" ");   
            }
            System.out.println();
        } 
        


    }

    public char getEstadoAsiento(int fila, int asiento){
        var resultado = this.matriz[fila][asiento];
        return resultado;
    
    }
    
    public int getFilaSala(){
        var resultado  = this.matriz.length;
        return resultado;
    }

    public void setReservarAsiento(int fila,int asiento){
        this.matriz[fila][asiento]='R';
    
    }

    public void getAsientosReservados(){
        System.out.println("Los asientos reservados son: ");
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz.length;j++){
                if(this.matriz[i][j]=='R'){
                    System.out.println("Fila ["+i+"]"+" Asiento["+j+"]");
                }
            }
        }
    }

 


}

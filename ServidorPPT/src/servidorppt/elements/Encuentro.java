/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorppt.elements;

/**
 *
 * @author andres
 */
public class Encuentro extends Thread {

    private Jugador jugador1 = null;
    private Jugador jugador2 = null;
    
    private String opcionJ1 = "NULL";
    private String opcionJ2 = "NULL";

    public Encuentro() {

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public boolean ingresarJugador(Jugador j) {
        if (this.jugador1 == null) {
            this.jugador1 = j;
            System.out.println(j.getUserName()+" Ingresado en J1");
            return true;
        } else {
            if (this.jugador2 == null) {
                System.out.println(j.getUserName()+" Ingresado en J2");
                this.jugador2 = j;
                return true;
            } else {
                return false;
            }
        }
    }
    
    @Override
    public void run(){
        boolean band = false;
        while (true) {    
            System.out.println(opcionJ1);
            System.out.println(opcionJ2);
           if(this.jugador1!=null && this.jugador2!=null){
               if(!band){
                   System.out.println("Juego iniciado");
                   this.jugador1.enviarMensaje("RIVAL::"+jugador2.getUserName());
                   this.jugador2.enviarMensaje("RIVAL::"+jugador1.getUserName());
                   band = true;
               }
               if(!this.opcionJ1.equals("NULL")&&!this.opcionJ2.equals("NULL")){
                   System.out.println("SIIIII");
                   play();
               }else
               {
                   //System.out.println("Esperando opciones de los jugadores");
               }
           } 
        } 
    }
    
    public boolean getGame(){
        return (this.jugador1!=null && this.jugador2!=null);
    }
    
    public boolean agregarOp(String opt){
        if (this.opcionJ1.equals("NULL")) {
            this.opcionJ1 = opt;
            System.out.println("opcion agregada en opcion 1"+opt);
            return true;
        } else {
            if (this.opcionJ2.equals("NULL")) {
                this.opcionJ2 = opt;
                System.out.println("opcion agregada en opcion2"+opt);
            return true;
            } else {
                return false;
            }
        }
        
    }
    
    public void play(){
        //System.out.println("Que pasó amiguito");
        String OjugadorA;
        String OjugadorB;
        
        Jugador jugadorA;
        Jugador jugadorB;
        
        if(Integer.parseInt(this.opcionJ1.split("::")[0])==this.jugador1.getIden()){
            OjugadorA = this.opcionJ1.split("::")[2];
            OjugadorB = this.opcionJ2.split("::")[2];
            jugadorA = this.jugador1;
            jugadorB = this.jugador2;
        }else{
            OjugadorA = this.opcionJ2.split("::")[2];
            OjugadorB = this.opcionJ1.split("::")[2];
            jugadorA = this.jugador2;
            jugadorB = this.jugador1;
        }
        
        if(OjugadorA.equals("PIEDRA")&&OjugadorB.equals("PIEDRA")){
          jugadorA.enviarMensaje("RESULTADO::EMPATE");
          jugadorB.enviarMensaje("RESULTADO::EMPATE");
          this.reset();
        }
        if(OjugadorA.equals("PIEDRA")&&OjugadorB.equals("PAPEL")){
          jugadorA.enviarMensaje("RESULTADO::PERDER");
          jugadorB.enviarMensaje("RESULTADO::GANAR");
          this.reset();
        }
        if(OjugadorA.equals("PIEDRA")&&OjugadorB.equals("TIJERA")){
          jugadorA.enviarMensaje("RESULTADO::GANAR");
          jugadorB.enviarMensaje("RESULTADO::PERDER");
          this.reset();
        }
        if(OjugadorA.equals("PAPEL")&&OjugadorB.equals("PIEDRA")){
          jugadorA.enviarMensaje("RESULTADO::GANAR");
          jugadorB.enviarMensaje("RESULTADO::PERDER");
          this.reset();
        }
        if(OjugadorA.equals("PAPEL")&&OjugadorB.equals("PAPEL")){
          jugadorA.enviarMensaje("RESULTADO::EMPATE");
          jugadorB.enviarMensaje("RESULTADO::EMPATE");
          this.reset();
        }
        if(OjugadorA.equals("PAPEL")&&OjugadorB.equals("TIJERA")){
          jugadorA.enviarMensaje("RESULTADO::PERDER");
          jugadorB.enviarMensaje("RESULTADO::GANAR");
          this.reset();
        }
        if(OjugadorA.equals("TIJERA")&&OjugadorB.equals("PIEDRA")){
          jugadorA.enviarMensaje("RESULTADO::PERDER");
          jugadorB.enviarMensaje("RESULTADO::GANAR");
          this.reset();
        }
        if(OjugadorA.equals("TIJERA")&&OjugadorB.equals("PAPEL")){
          jugadorA.enviarMensaje("RESULTADO::GANAR");
          jugadorB.enviarMensaje("RESULTADO::PERDER");
          this.reset();
        }
        if(OjugadorA.equals("TIJERA")&&OjugadorB.equals("TIJERA")){
          jugadorA.enviarMensaje("RESULTADO::EMPATE");
          jugadorB.enviarMensaje("RESULTADO::EMPATE");
          this.reset();
        }
        
        
    }
    public void reset(){
        
        this.opcionJ1 = "NULL";
        this.opcionJ2 = "NULL";
    }
    public int[] getIdJugadores(){
        
        int[] ids = {this.jugador1.getIden(), this.jugador2.getIden()};
        return ids;
    
    }

}

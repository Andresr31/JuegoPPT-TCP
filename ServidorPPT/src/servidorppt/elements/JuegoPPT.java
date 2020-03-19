
package servidorppt.elements;

import java.net.Socket;
import java.util.ArrayList;
import servidorppt.red.Servidor;

/**
 *
 * @author Carlos Andrés Rojas Parra
 * @author David Salgado Ospina
 * 
 */
public class JuegoPPT {
    
    private Servidor servidor;
    private ArrayList<Jugador> jugadores;
    
    private ArrayList<Encuentro> encuentros;
    private Encuentro temp;

    public JuegoPPT() {
        this.servidor = new Servidor(this);
        
        this.jugadores = new ArrayList<>();
        this.encuentros = new ArrayList<>();
        
        this.temp = new Encuentro();
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////
    public void iniciar(){
        this.servidor.encender();
    }
    
    public boolean agreagarJugador(Socket conexion){
        Jugador jugador = new Jugador(conexion, this, this.jugadores.size()+1);
        jugador.start();
        return this.jugadores.add(jugador);
    }
    
    //////////////////////////////////////////////////////////////////////////
    public void procesar(String mensaje, Jugador jugador){
        System.out.println(mensaje);
        //System.out.println(this.jugadores.size());
        boolean opcion = this.temp.ingresarJugador(jugador);
        if(opcion){
            jugador.setEncuentro(temp);
            if(this.temp.getGame()){
                this.temp.start();
                this.encuentros.add(temp);
                System.out.println(this.encuentros.size());
            }
            //jugador.enviarMensaje("200");
            
        }else{
            this.temp = new Encuentro();
            this.temp.ingresarJugador(jugador);
            jugador.setEncuentro(temp);
        }
        
    }

    public Servidor getServidor() {
        return servidor;
    }
}

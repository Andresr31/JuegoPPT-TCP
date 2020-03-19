/*
 * Se encarga de la administracion de conexiones
 */
package servidorppt.red;

import java.net.Socket;
import servidorppt.elements.JuegoPPT;



/**
 *
 * @author Carlos Andres Rojas Parra
 * @author David Salgado Ospina
 */
public class Servidor {
    
    private RedServidor red;
    private JuegoPPT juego;
    public static String mensajes = "";
    
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public Servidor( JuegoPPT juego) {
        this.red = new RedServidor(4400, this);
        this.juego = juego;
    }

    public RedServidor getRed() {
        return red;
    }

    public void setRed(RedServidor red) {
        this.red = red;
    }

    public JuegoPPT getJuego() {
        return juego;
    }

    public void setJuego(JuegoPPT juego) {
        this.juego = juego;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public void agregarJugador(Socket conexion){
        this.juego.agreagarJugador(conexion);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public void encender(){
        this.red.procesar();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
}

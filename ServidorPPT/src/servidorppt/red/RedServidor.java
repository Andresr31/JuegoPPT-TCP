/*
 * Realiza la recepción de jugadores
 */
package servidorppt.red;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos Andrés Rojas Parra
 * @author David Salgado Ospina
 *
 */
public class RedServidor {

    /**
     * Puerto por el cual permitirá la recepción de jugadores
     */
    private int port;
    /**
     * Servidor tcp quien permite la comunicación
     */
    private ServerSocket listenSocket = null;
    /**
     * Servidor al cual pertenece la red
     */
    private Servidor servidor;

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Constructor de la clase red
     *
     * @param port
     * @param servidor
     */
    public RedServidor(int port, Servidor servidor) {
        this.port = port;
        this.servidor = servidor;

        iniciar();
    }

    ///////////////////////////////////////////////////////////////////////////
    public final void iniciar() {
        try {
            this.listenSocket = new ServerSocket(this.port);
            System.out.println("SERVIDOR ENCENDIDO");
            this.servidor.mensajes += "SERVIDOR ENCENDIDO" + "\n";
        } catch (IOException ex) {
            System.out.println("Error al iniciar " + ex.getMessage());
            this.servidor.mensajes += "Error al iniciar" + ex.getMessage() + "\n";
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public void procesar() {
        try {
            while (true) {
                servidor.mensajes += "SERVER: Esperando jugador nuevo" + "\n";
                System.out.println("SERVER: Esperando jugador nuevo");

                Socket clientSocket = listenSocket.accept();

                servidor.mensajes += "SERVER: cliente recibido" + "\n";
                System.out.println("SERVER: cliente recibido");
                
                this.servidor.agregarJugador(clientSocket);

            }
        } catch (IOException e) {               
            servidor.mensajes += "Error connecting a client: " + e.getMessage() + "\n";
            System.out.println("Error connecting a client: " + e.getMessage());
        }
    }
}



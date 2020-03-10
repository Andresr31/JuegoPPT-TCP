package jugadorppt.red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Rojas Parra
 * @author David Salgado Ospina
 *
 */
public class RedJugador {

    private Socket conexion;
    private int puertoServidor;
    private InetAddress ipServidor;
    private String userName;
    private DataInputStream in;
    private DataOutputStream out;
    

    public RedJugador(int puertoServidor, String ip, String nombre) {

        try {

            this.ipServidor = InetAddress.getByName(ip);
            this.puertoServidor = puertoServidor;
            this.userName = nombre;
            iniciarConexion();

        } catch (UnknownHostException ex) {
            Logger.getLogger(RedJugador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public final void iniciarConexion() {
        try {

            this.conexion = new Socket(this.ipServidor, this.puertoServidor);
            in = new DataInputStream(conexion.getInputStream());
            out = new DataOutputStream(conexion.getOutputStream());
            String comandoInicial = "NAME::" + this.userName;
            out.writeUTF(comandoInicial);
            out.flush();
            System.out.println("Jugador " + this.userName + " conectado con el servidor: " + this.ipServidor.getHostName());

        } catch (UnknownHostException ex) {
            Logger.getLogger(RedJugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RedJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String enviarComando(String comando) {

        try {
            System.out.println(this.userName + ": enviando comando al servidor: " + comando);
            
            out.writeUTF(comando);
            
            out.flush();
            
            if (comando.equals("BYE")) {
                System.out.println("RESPONSE: Hasta la próxima!");
                this.cerrar();
                return "Hasta la próxima";
                
            }
            System.out.println(this.userName+": recibiendo mensaje del servidor");
            String output = in.readUTF();
            System.out.println("RESPONSE: " + output);
            return output;
        } catch (IOException ex) {
            Logger.getLogger(RedJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERROR";
    }

    public void cerrar() throws IOException {
        conexion.close();
    }

}

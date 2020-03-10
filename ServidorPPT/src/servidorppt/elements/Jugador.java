package servidorppt.elements;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Rojas Parra
 * @author David Salgado Ospina
 *
 */
public class Jugador extends Thread {

    private final Socket conexion;
    private String userName;

    private DataInputStream in;
    private DataOutputStream out;
    
    private Encuentro encuentro;
    
    private int iden;
    private Jugador rival;
    
    private JuegoPPT juego;

    public Jugador(Socket conexion, JuegoPPT j, int id) {
        this.conexion = conexion;
        this.userName = "NAME";
        this.juego = j;
        this.iden = id;
        try {
            in = new DataInputStream(this.conexion.getInputStream());
            out = new DataOutputStream(this.conexion.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public Jugador getRival() {
        return rival;
    }

    public void setRival(Jugador rival) {
        this.rival = rival;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    
    

    ////////////////////////////////////////////////////////////////////////
    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("JUGADOR: Esperando mensaje de: "+this.userName);

                String data = in.readUTF();

                System.out.println("JUGADOR: Envió " + data);

                if (data.equals("BYE")) {
                    System.out.println("RESPONSE: Goodbye!");

                    break;
                }
                if(data.split("::")[0].equals("NAME"))
                {
                    this.userName = data.split("::")[1];
                    System.out.println("Nombre del jugador actualizado: "+this.userName);
                }else
                {
                    if(data.split("::")[1].equals("INICIAR")){
                        //this.enviarMensaje("200");
                        this.juego.procesar(data,this);
                    }else{
                        
                        this.encuentro.agregarOp(this.iden+"::"+data);
                        
                    }
                    
                    
                }

//                out.writeUTF(output);
//
//                out.flush();
            } catch (EOFException e) {
                System.out.println("EOF: " + e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage());
                break;
            }
        } // end of while

        ////////////////////////////////////////////////////////////////////////
    }
    
    public void enviarMensaje(String mensaje){
        try {
            out.writeUTF(mensaje);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


package jugadorppt.elemts;

import jugadorppt.red.RedJugador;

/**
 *
 * @author Carlos Andrés Rojas Parra
 * @author David Salgado Ospina
 * 
 */
public class Jugador {
    
    private String userName;
    private RedJugador red;

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public Jugador(String userName) {
        
        this.userName = userName;
        this.red = new RedJugador(4400, "127.0.0.1", this.userName);
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public String seleccionarRival(int id){
        
        String comando;
        if(id == 0){
            comando = "RIVAL::MAQUINA";
        }else{
            comando = "RIVAL::"+id;
        }
        
        return this.red.enviarComando(comando);
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public String jugar(String seleccion){
        switch (seleccion){
            
            case "INICIAR":
                String comandoIniciar = this.userName+"::INICIAR";
                return this.red.enviarComando(comandoIniciar);
            
            case "PIEDRA":
                String comandoPiedra = this.userName+"::PIEDRA";
                return this.red.enviarComando(comandoPiedra);
                
            case "PAPEL":
                String comandoPapel = this.userName+"::PAPEL";
                return this.red.enviarComando(comandoPapel);
                
            case "TIJERA":
                String comandoTijera = this.userName+"::TIJERA";
                return this.red.enviarComando(comandoTijera);
            
            case "SALIR":
                
                String comandoSalir = "BYE";
                return this.red.enviarComando(comandoSalir);
                
        }
        return "ERROR";
    }
    
    
    
}

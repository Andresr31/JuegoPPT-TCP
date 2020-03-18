

package jugadorppt.audio;

import java.applet.AudioClip;

/**
 *
 * Descripcion de la clase Efectos
 * 
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public class Efectos {
    
    private AudioClip sonidoIntro;
    private AudioClip sonidoFondo;
    private AudioClip sonidoGanar;
    private AudioClip sonidoPerder;

     
    

    public Efectos() {
        
        sonidoIntro = java.applet.Applet.newAudioClip(getClass().getResource("/jugadorppt/audio/intro.wav"));
        sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResource("/jugadorppt/audio/fondo.wav"));
        sonidoGanar = java.applet.Applet.newAudioClip(getClass().getResource("/jugadorppt/audio/ganar.wav"));
        sonidoPerder = java.applet.Applet.newAudioClip(getClass().getResource("/jugadorppt/audio/perder.wav"));
        
    }
    
    
    /////////////////////////////////////////////////////////////////////////////
    
    public void reproducirSonidoIntro()
    {
        //sonidoIntro.play();
        sonidoIntro.loop();
    }
    
    public void detenerSonidoIntro()
    {
        sonidoIntro.stop();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
     public void reproducirSonidoFondo()
    {
        sonidoFondo.play();
        //sonidoFondo.loop();
    }
    
    public void detenerSonidoFondo()
    {
        sonidoFondo.stop();
        //sonidoFondo.loop();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public void reproducirSonidoGanar()
    {
        sonidoGanar.play();
        //sonidoGanar.loop();
    }
    
    public void detenerSonidoGanar()
    {
        sonidoGanar.stop();
        //sonidoFondo.loop();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public void reproducirSonidoPerder()
    {
        sonidoPerder.play();
        //sonidoPerder.loop();
    }
    
    public void detenerSonidoPerde()
    {
        sonidoPerder.stop();
        //sonidoFondo.loop();
    }
    
    ////////////////////////////////////////////////////////////////////////////
   
}

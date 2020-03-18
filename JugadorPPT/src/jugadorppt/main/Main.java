/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorppt.main;

import jugadorppt.GUI.Intro;
import jugadorppt.GUI.Menu;
import jugadorppt.audio.Efectos;

/**
 *
 * @author andres
 */
public class Main {
    
    public static void main(String[] args) {
        Efectos efectos = new Efectos();
        Menu menu = new Menu(efectos);
        Intro intro = new Intro(menu, true,menu);
        intro.setVisible(true);
        
    }
    
}

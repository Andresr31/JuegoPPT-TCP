/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorppt.main;

import servidorppt.elements.JuegoPPT;

/**
 *
 * @author andres
 */
public class Main {
    
    public static void main(String[] args) {        
        JuegoPPT juego = new JuegoPPT();
        servidorppt.GUI.MainGUI mainGUI = new servidorppt.GUI.MainGUI(juego);
    }
    
}

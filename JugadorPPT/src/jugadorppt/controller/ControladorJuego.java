/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorppt.controller;

import java.util.Scanner;
import jugadorppt.elemts.Jugador;

/**
 *
 * @author andres
 */
public class ControladorJuego {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor ingrese su nombre:  ");
        String nombre = sc.next();
        Jugador jugador = new Jugador(nombre);

        do {

            System.out.print("Por favor ingrese su accion: ");
            String accion = sc.next();

            String response = jugador.jugar(accion);
            System.out.println(response);
            
            System.out.print("Deseas jugar de nuevo? S/N");
            String opt = sc.next();
            
            if(opt.equals("N")){
                String response1 = jugador.jugar("SALIR");
                System.out.println(response);
                break;
            }
            

        } while (true);
        
    }

}

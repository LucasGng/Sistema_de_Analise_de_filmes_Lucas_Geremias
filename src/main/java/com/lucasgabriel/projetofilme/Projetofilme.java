/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lucasgabriel.projetofilme;

/**
 *
 * @author lgng
 */
public class Projetofilme {

    public static void main(String[] args) {
     Menu menus = new Menu();
//    menu.run();
      user_interface menu = new user_interface(menus);
      menu.setVisible(true);
    
    }
    
}

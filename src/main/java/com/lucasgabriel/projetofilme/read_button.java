/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasgabriel.projetofilme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author lgng
 */
public class read_button implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
    JButton origem = (JButton) e.getSource();
    JOptionPane.showMessageDialog(origem, origem.getText() + " foi realizado!");
    }
}
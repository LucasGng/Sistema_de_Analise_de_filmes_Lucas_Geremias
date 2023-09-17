/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasgabriel.projetofilme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user_interface extends JFrame implements ActionListener {
    private final Menu sistema;

    public user_interface(Menu sistema) {
        this.sistema = sistema;

        setTitle("Sistema de Análise de Filmes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("SISTEMA DE ANÁLISE DE FILMES");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btn1 = new JButton("1. Cadastrar filmes");
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.addActionListener(this);
        panel.add(btn1);

        JButton btn2 = new JButton("2. Ranking de ocorrências do país na tabela");
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.addActionListener(this);
        panel.add(btn2);

        JButton btn3 = new JButton("3. Total de visualizações realizadas em um país");
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn3.addActionListener(this);
        panel.add(btn3);

        JButton btn4 = new JButton("4. Valor total arrecadado em um país");
        btn4.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn4.addActionListener(this);
        panel.add(btn4);

        JButton btn5 = new JButton("5. Media de avaliações por Genero");
        btn5.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn5.addActionListener(this);
        panel.add(btn5);

        JButton btn6 = new JButton("6. Ranking Filmes mais bem avaliados");
        btn6.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn6.addActionListener(this);
        panel.add(btn6);

        JButton btn7 = new JButton("7. Sair");
        btn7.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn7.addActionListener(this);
        panel.add(btn7);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      switch (command) {
          case "1. Cadastrar filmes":
              sistema.cadastrarFilmes();
              break;
          case "2. Ranking de ocorrências do país na tabela":
              sistema.rankingPaises();
              break;
          case "3. Total de visualizações realizadas em um país":
              sistema.totalVisualizacoes();
              break;
          case "4. Valor total arrecadado em um país":
              sistema.valorTotalArrecadado();
              break;
          case "5. Media de avaliações por Genero":
              sistema.mediaAvaliacoesPorGenero();
              break;
          case "6. Ranking Filmes mais bem avaliados":
              sistema.filmesMaisBemAvaliados();
              break;
          case "7. Sair":
              System.exit(0);
              break;
      }
    }
/*
    public static void main(String[] args) {
      Menu sistema = new Menu();
      EventQueue.invokeLater(() -> {
          user_interface ex = new user_interface(sistema);
          ex.setVisible(true);
      });
    }
*/
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Lucas Gabriel Nunes Geremias
 */

package com.lucasgabriel.projetofilme;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lgng
 */
public class Menu implements menu_base{
    @Override
    public void run(){
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        while(opcao!=8){
            JOptionPane.showMessageDialog(null, "-----------------------------------------------------------------------\n"
                    + "SISTEMA DE ANÁLISE DE FILMES\n"
                    + "-----------------------------------------------------------------------\n"
                    + "1. Cadastrar filmes\n"
                    + "2. Ranking de ocorrências do país na tabela\n"
                    + "3. Total de visualizações realizadas pelos assinantes daquele país\n"
                    + "4. Valor total arrecadado com as visualizações realizadas pelos assinantes daquele país\n"
                    + "5. Media de avaliações por Genero\n"
                    + "6. Filmes mais bem avaliados\n"
                    + "8. Sair\n"
                    + "-----------------------------------------------------------------------");

            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção:"));

            switch (opcao) {
                case 1:
                    cadastrarFilmes();
                    break;
                case 2:
                    rankingPaises();
                    break;
                case 3:
                    totalVisualizacoes();
                    break;
                case 4:
                    valorTotalArrecadado();
                    break;
                case 5:
                    mediaAvaliacoesPorGenero();
                    break;
                case 6:
                    filmesMaisBemAvaliados();
                    break;
                default:
                    break;
            }
        }
    }

    public void cadastrarFilmes() {
        Scanner input = new Scanner(System.in);

        // Implementar a leitura de dados de um arquivo csv contendo dados correspondentes a uma tabela de, no mínimo, 100 linhas e 3 colunas.
        csv table = new csv("filmes.csv");
        Filmes filmes = table.read();
        //filmes.mostrar();

        // Implementar a leitura de dados de um arquivo txt contendo dados textuais ou numéricos de, no mínimo, 1000 caracteres
        txt file = new txt("filmes.txt");
        Filmes filmes1 = file.read();

        // Adicionar os filmes lidos na lista de filmes

        JOptionPane.showMessageDialog(null, "-----------------------------\n"
                + "CADASTRO DE FILMES\n"
                + "-----------------------------");

        String title = JOptionPane.showInputDialog("Digite o Título do filme que você deseja cadastrar:");
        String country = JOptionPane.showInputDialog("Digite o País do filme que você deseja cadastrar:");
        int views = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de Visualizações do filme que você deseja cadastrar:"));
        int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor Arrecadado do filme que você deseja cadastrar:"));
        String genre = JOptionPane.showInputDialog("Digite o Gênero do filme que você deseja cadastrar:");
        int rating = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de Avaliação do filme que você deseja cadastrar:"));

        String newfilme = "" + title + "," + country + "," + views + "," + value + "," + genre + "," + rating + "";
        file.write(newfilme);
        Filmes filmes2 = file.read();

        JOptionPane.showMessageDialog(null, "---------------------------------\n"
                + "Criando Persistência...\n"
                + "Persistência criada com sucesso!!\n"
                + "---------------------------------");

        filmes2.salvar("filme.dat");
    }

    public void rankingPaises() {
        // Implementar o ranking de ocorrências do país na tabela
        txt file = new txt("filmes.txt");
        Filmes filmes = file.read();
        filmes.rankingPaises();
    }

    public void totalVisualizacoes() {
        // Implementar o total de visualizações realizadas pelos assinantes daquele país
        Scanner input = new Scanner(System.in);
        // Implementar o valor total arrecadado com as visualizações realizadas pelos assinantes daquele país
        txt file = new txt("filmes.txt");
        Filmes filmes = file.read();

        String pais = JOptionPane.showInputDialog("Digite o nome do País que você deseja ver o Total de Visualizações:");
        filmes.TotalVisualizacoes(pais);
    }

    public void valorTotalArrecadado() {
        Scanner input = new Scanner(System.in);
        // Implementar o valor total arrecadado com as visualizações realizadas pelos assinantes daquele país
        txt file = new txt("filmes.txt");
        Filmes filmes = file.read();

        String pais = JOptionPane.showInputDialog("Digite o nome do País que você deseja ver o Total Arrecadado:");
        filmes.TotalArrecadado(pais);
    }

    public void mediaAvaliacoesPorGenero() {
        // Implementar a media de avaliações por Gênero
        txt file = new txt("filmes.txt");
        Filmes filmes = file.read();
        filmes.mediaAvaliacoesPorGenero();
    }

    public void filmesMaisBemAvaliados() {
        // Implementar os Filmes mais bem avaliados
        txt file = new txt("filmes.txt");
        Filmes filmes = file.read();
        filmes.rankingFilmesPorAvaliacao();
    }
}

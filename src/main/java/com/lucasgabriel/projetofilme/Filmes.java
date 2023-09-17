/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasgabriel.projetofilme;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Filmes implements Serializable{
    private List<Filme> filmes;
    
    public Filmes(){
    filmes = new ArrayList<Filme>();
    }
    
    public void adicionar(Filme f){
    filmes.add(f);
    
    }
    public void mostrar(){
        for(Filme filme : filmes){
            JOptionPane.showMessageDialog(null, filme.getTitulo() + "\n" + filme.getPais() + "\n" + filme.getVisualizacoes() + "\n" + filme.getValorArrecadado() + "\n" + filme.getGenero() + "\n" + filme.getAvaliacao());
        }
    }
    
    public void rankingPaises() {
    Map<String, Integer> contagemPaises = new HashMap<>();
    for (Filme filme : filmes) {
        String pais = filme.getPais();
        contagemPaises.put(pais, contagemPaises.getOrDefault(pais, 0) + 1);
    }

    List<Map.Entry<String, Integer>> listaPaises = new ArrayList<>(contagemPaises.entrySet());
    listaPaises.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    
    JOptionPane.showMessageDialog(null, "------------------------------" + "\n" + "Ranking de países:" + "\n" + "------------------------------");
    
    String print = "";
    for (Map.Entry<String, Integer> pais : listaPaises) {
        print += pais.getKey() + ": " + pais.getValue() + "\n";
    }
    JOptionPane.showMessageDialog(null,  print);
}

    public void TotalArrecadado(String pais){
        int Total = 0;
        for(Filme filme : filmes){
            if(filme.getPais().equals(pais)){
            Total += filme.getValorArrecadado();
            }
        }
        JOptionPane.showMessageDialog(null, "---------------------------" + "\n" + "TOTAL ARRECADADO PAÍS " + pais + "---------------------------" + "\n" + "Pais: " + pais + " Total: " + Total);
 
    }
    

    public void TotalVisualizacoes(String pais) {
        int Total = 0;
        int totalarrecadado = 0;
        for (Filme filme : filmes) {
            if (filme.getPais().equals(pais)) {
                Total += filme.getVisualizacoes();
                totalarrecadado += filme.getValorArrecadado();
            }
        }
        StringBuilder message = new StringBuilder();
        message.append("---------------------------\n");
        message.append("TOTAL DE VISUALIZAÇÕES PAÍS: ").append(pais).append("\n");
        message.append("---------------------------\n");
        message.append("Pais: ").append(pais).append(" Total de Visualizações: ").append(Total).append(" Total arrecadado: ").append(totalarrecadado).append("\n");
        JOptionPane.showMessageDialog(null, message.toString());
    }

    public void rankingFilmesPorAvaliacao() {
        List<Filme> listaFilmes = new ArrayList<>(filmes);
        listaFilmes.sort(Comparator.comparing(Filme::getAvaliacao).reversed());

        StringBuilder message = new StringBuilder();
        message.append("---------------------------------\n");
        message.append("Ranking de filmes por avaliação:\n");
        message.append("---------------------------------\n");
        for (Filme filme : listaFilmes) {
            message.append(filme.getTitulo()).append(": ").append(filme.getAvaliacao()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    public void mediaAvaliacoesPorGenero() {
        Map<String, List<Double>> avaliacoesPorGenero = new HashMap<>();
        for (Filme filme : filmes) {
            String genero = filme.getGenero();
            if (!avaliacoesPorGenero.containsKey(genero)) {
                avaliacoesPorGenero.put(genero, new ArrayList<>());
            }
            avaliacoesPorGenero.get(genero).add((double) filme.getAvaliacao());
        }

        Map<String, Double> mediaAvaliacoesPorGenero = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : avaliacoesPorGenero.entrySet()) {
            String genero = entry.getKey();
            List<Double> avaliacoes = entry.getValue();
            double mediaAvaliacoes = avaliacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            mediaAvaliacoesPorGenero.put(genero, mediaAvaliacoes);
        }

        List<Map.Entry<String, Double>> listaGeneros = new ArrayList<>(mediaAvaliacoesPorGenero.entrySet());
        listaGeneros.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder message = new StringBuilder();
        message.append("---------------------------------\n");
        message.append("Média de avaliações por gênero:\n");
        message.append("---------------------------------\n");
        for (Map.Entry<String, Double> genero : listaGeneros) {
            message.append(genero.getKey()).append(": ").append(genero.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    public void salvar(String nomeArquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Persistência criada com sucesso!!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Filmes carregar(String nomeArquivo) {
        Filmes filmes = null;
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            filmes = (Filmes) in.readObject();
            in.close();
            fileIn.close();
            JOptionPane.showMessageDialog(null, "Conteúdo lido do Objeto persistente criado:");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return filmes;
    }
}

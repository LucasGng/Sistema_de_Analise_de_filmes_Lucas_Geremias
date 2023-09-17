package com.lucasgabriel.projetofilme;
import java.io.*;
import java.util.*;

public class csv implements filereader{
    private String filename;
    
    public csv(String file){
        filename = "C:\\Users\\lgng\\OneDrive\\Documentos\\NetBeansProjects\\projetofilme\\src\\main\\java\\com\\lucasgabriel\\projetofilme\\" + file;
    }
    
    public Filmes read(){

    String separador = ",";
    Filmes tabela = new Filmes();
    try{
    File arquivo = new File(filename);
    Scanner scanner_arquivo = new Scanner(arquivo);
    String cabecalho = scanner_arquivo.nextLine();
    //System.out.println(cabecalho);
    while(scanner_arquivo.hasNextLine()){
        String linha = scanner_arquivo.nextLine();
        Scanner scanner_linha = new Scanner(linha);
        scanner_linha.useDelimiter(separador);
        String titulo = scanner_linha.next();
        String pais = scanner_linha.next();
        int visualizacoes = scanner_linha.nextInt();
        int valorArrecadado = scanner_linha.nextInt();
        String genero = scanner_linha.next();
        int avaliacao = scanner_linha.nextInt();
        Filme registro = new Filme(titulo, pais, visualizacoes, valorArrecadado, genero, avaliacao);
        tabela.adicionar(registro);
    }
    return tabela;
    }
    catch(IOException e){
        e.printStackTrace();
        return null;
    }
    }
}

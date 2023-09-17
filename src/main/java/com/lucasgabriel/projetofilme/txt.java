/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasgabriel.projetofilme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lgng
 */
public class txt implements filereader{
    
 private String namefile;
 
 public txt(String file){
    namefile = "C:\\Users\\lgng\\OneDrive\\Documentos\\NetBeansProjects\\projetofilme\\src\\main\\java\\com\\lucasgabriel\\projetofilme\\" + file;
 }
 
    public Filmes read(){

    String separador = ",";
    Filmes tabela = new Filmes();
    try{
    File arquivo = new File(namefile);
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
 
 public void write(String content){
    try{
    File fl = new File(this.namefile);
    //fl.createNewFile();
    
    FileWriter writer = new FileWriter(fl, true);
    writer.write("\n"+content);
    writer.flush();
    writer.close();
    
 }
    catch(IOException e){
        e.printStackTrace();
 }
}

 public void create(String content){
    try{
    File fl = new File(this.namefile);
    fl.createNewFile();
    
    FileWriter writer = new FileWriter(fl);
    writer.write(content);
    writer.flush();
    writer.close();
    
 }
    catch(IOException e){
        e.printStackTrace();
 }
} 
}

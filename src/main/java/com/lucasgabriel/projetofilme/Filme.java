/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasgabriel.projetofilme;
import java.io.*;
public class Filme implements Serializable{
    private String titulo;
    private String pais;
    private int visualizacoes;
    private int valorArrecadado;
    private String genero;
    private int avaliacao;
    
    public Filme(String titulo, String pais, int visualizacoes, int valorArrecadado, String genero, int avaliacao) {
        this.titulo = titulo;
        this.pais = pais;
        this.visualizacoes = visualizacoes;
        this.valorArrecadado = valorArrecadado;
        this.genero = genero;
        this.avaliacao = avaliacao;
    }
    
        public String getTitulo() {
        return titulo;
    }

    public String getPais() {
        return pais;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public int getValorArrecadado() {
        return valorArrecadado;
    }

    public String getGenero() {
        return genero;
    }

    public int getAvaliacao() {
        return avaliacao;
    }
}

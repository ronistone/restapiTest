/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapi.models;

import java.io.Serializable;

/**
 *
 * @author ronistone
 */

public class Curso implements Serializable{
    private String nome;
    private String duracao;
    public Curso(){}
    public Curso(String nome, String duracao){
        this.nome = nome;
        this.duracao = duracao;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDuracao(String duracao){
        this.duracao = duracao;
    }
    public String getNome() {
        return nome;
    }
    public String getDuracao() {
        return duracao;
    }
}
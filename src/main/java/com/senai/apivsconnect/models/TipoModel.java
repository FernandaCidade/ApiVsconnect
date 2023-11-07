package com.senai.apivsconnect.models;

public enum TipoModel {
    ADMIN("admin"), //a constante admin é 0, sempre que passar uma string para ela vai valer
    DESENVOLVEDOR("dev"),
    CLIENTE("clientes");

    private String tipo;
    //toda vez que criar um tipo model, tera que criar um metodo

    TipoModel(String tipo){
        this.tipo = tipo;
    }
    public String getRole(){
        return tipo;
    }
}

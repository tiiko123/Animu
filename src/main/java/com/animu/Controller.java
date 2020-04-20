package com.animu;

public class Controller {

    App app = new App();
    CargarArchivos cargarArchivos = new CargarArchivos();


    public void ingresar(){
        System.out.println("ola");
        app.pantallaPrincipal();
        cargarArchivos.abrir();
    }
}

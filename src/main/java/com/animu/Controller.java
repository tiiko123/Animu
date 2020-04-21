package com.animu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.management.loading.MLetContent;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    App app = new App();
    CargarArchivos cargarArchivos = new CargarArchivos();
    ArrayList<Cuentas> cuentas = new ArrayList<>();

    //login
    @FXML
    TextField usuario;
    @FXML
    PasswordField password;
    @FXML
    Button botonIngresar;

    //Extras
    @FXML
    Label mensajeDeError;



    //////////////////Login
    public void ingresar() throws IOException {
        cuentas = cargarArchivos.cargarCuentas();
        for(int i = 0; i < cuentas.size(); i++){
            if(usuario.getText().equals(cuentas.get(i).getUsuario())){
                if(password.getText().equals(cuentas.get(i).getPassword())){
                    app.pantallaPrincipal();
                    Stage stage = (Stage)this.botonIngresar.getScene().getWindow();
                    stage.close();
                }else{
                    mensajeDeError();
                }
            }else{
                mensajeDeError();
            }
        }
    }

    public void presionarEnter(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            cuentas = cargarArchivos.cargarCuentas();
            for(int i = 0; i < cuentas.size(); i++){
                if(usuario.getText().equals(cuentas.get(i).getUsuario())){
                    if(password.getText().equals(cuentas.get(i).getPassword())){
                        app.pantallaPrincipal();
                        Stage stage = (Stage)this.botonIngresar.getScene().getWindow();
                        stage.close();
                    }else{
                        mensajeDeError();
                    }
                }else{
                    mensajeDeError();
                }
            }
        }
    }
    //////////////////

    public void mensajeDeError(){
        mensajeDeError.setText("Usuario o contraseña no validos");
    }


}

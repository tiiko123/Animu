package com.animu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    App app = new App();
    Archivos archivos = new Archivos();
    ArrayList<Cuentas> cuentas = new ArrayList<>();

    //login
    @FXML
    TextField usuario;
    @FXML
    PasswordField password;
    @FXML
    Button botonIngresar,botonRegistrarse;

    //Registro
    @FXML
    Button botonVolverRegistro,botonRegistrarseRegistro;
    @FXML
    TextField nuevoUsuario;
    @FXML
    PasswordField nuevoPassword,confirmarNuevoPassword;

    //Registro Correctamente
    @FXML
    AnchorPane anchorPaneRegistroCorrectamente;

    boolean ningunaCoincidencia=false;

    //Extras
    @FXML
    Label mensajeDeErrorLogin,mensajeDeErrorRegistro;


    //************************ login

    public void ingresar() throws IOException {
        cuentas = archivos.cargarCuentas();
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

    public void presionarEnterLogin(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            cuentas = archivos.cargarCuentas();
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

    public void irARegistro(ActionEvent actionEvent) {
        app.registro();
        Stage stage = (Stage)this.botonRegistrarse.getScene().getWindow();
        stage.close();
    }

    //************************ login//

    //************************ registro

    public void registrarse() throws IOException {
        cuentas = archivos.cargarCuentas();

        if(!nuevoUsuario.getText().equals("") && !nuevoPassword.getText().equals("") && !confirmarNuevoPassword.getText().equals("") && nuevoPassword.getText().equals(confirmarNuevoPassword.getText())){
            for(int i = 0; i < cuentas.size(); i++) {
                if(cuentas.get(i).getUsuario().equals(nuevoUsuario.getText())){
                    ningunaCoincidencia=true;
                    mensajeDeErrorRegistro.setText("Usuario ya registrado");
                }
            }
            if(ningunaCoincidencia==false){
                cuentas.add(new Cuentas(nuevoUsuario.getText(),nuevoPassword.getText()));
                archivos.registrarCuenta(cuentas);
                app.registroCorrectamente();
                Stage stage = (Stage)this.botonRegistrarseRegistro.getScene().getWindow();
                stage.close();
            }
            ningunaCoincidencia=false;
        }else{
            mensajeDeErrorRegistro.setText("Revisar datos correctamente");
        }
    }

    public void presionarEnterRegistro(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            cuentas = archivos.cargarCuentas();
            if(!nuevoUsuario.getText().equals("") && !nuevoPassword.getText().equals("") && !confirmarNuevoPassword.getText().equals("") && nuevoPassword.getText().equals(confirmarNuevoPassword.getText())){
                for(int i = 0; i < cuentas.size(); i++) {
                    if(cuentas.get(i).getUsuario().equals(nuevoUsuario.getText())){
                        ningunaCoincidencia=true;
                        mensajeDeErrorRegistro.setText("Usuario ya registrado");
                    }
                }
                if(ningunaCoincidencia==false){
                    cuentas.add(new Cuentas(nuevoUsuario.getText(),nuevoPassword.getText()));
                    archivos.registrarCuenta(cuentas);
                    app.registroCorrectamente();
                    Stage stage = (Stage)this.botonRegistrarseRegistro.getScene().getWindow();
                    stage.close();
                }
                ningunaCoincidencia=false;
            }else{
                mensajeDeErrorRegistro.setText("Revisar datos correctamente");
            }
        }
    }

    public void ventanaRegistroCorrectamente() throws InterruptedException {
        Thread mith = null;
        mith.sleep(1000);
        app.login();
        Stage stage = (Stage)this.anchorPaneRegistroCorrectamente.getScene().getWindow();
        stage.close();
    }

    public void volverRegistro(){
        app.login();
        Stage stage = (Stage)this.botonVolverRegistro.getScene().getWindow();
        stage.close();
    }






    //////////////////Extras
    public void mensajeDeError(){
        mensajeDeErrorLogin.setText("Usuario o contraseña no validos");
    }


    //////////////////


}

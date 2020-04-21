package com.animu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    public static void main( String[] args )
    {
        System.out.println("Hello World!" );
        System.out.println("Nuevo commit");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage =(Stage) FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.show();
    }

    public void login(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el login");
        }
    }

    public void pantallaPrincipal(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/pantallaPrincipal.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en la pantalla principal");
        }
    }

    public void registro(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/registro.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en registro");
        }
    }

    public void registroCorrectamente(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/registroCorrectamente.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en registro Correctamente");
        }
    }


}

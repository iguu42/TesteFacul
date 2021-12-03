package com.projetofinalp3;

import com.projetofinalp3.Entity.ContaCorrente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class Main1 extends Application {

    private static Stage stage;
    private static Scene mainScene;
    private static Scene telaConta;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent fxmlLoader =  FXMLLoader.load(Main1.class.getResource("login.fxml"));
        mainScene = new Scene(fxmlLoader, 520, 400);
        Parent fxmlTelaLogin = FXMLLoader.load(Main1.class.getResource("telaConta.fxml"));
        telaConta = new Scene(fxmlTelaLogin, 520, 400);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
    public static void trocarTela(String scr, String cpf){
        switch (scr){
            case "mainScene":
                stage.setScene(mainScene);
                notifyAllListeners("mainScene",cpf);
                break;
            case "telaConta":
                stage.setScene(telaConta);
                notifyAllListeners("telaConta",cpf);
                break;
        }
    }
    public static void trocarTela(){
        trocarTela();
    }

    public static void main(String[] args) {
        launch();
        ContaCorrente conta = new ContaCorrente();
        System.out.println(Dados.getCPF());
        conta.pegarSaldoCC();
        conta.depositar(500);
        conta.sacar(300);


    }
    private static ArrayList<OnChangeScreen> listener = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, String cpf);
    }

    public static void addOnChangeScreen(OnChangeScreen newListener){
        listener.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, String cpf){
        for(OnChangeScreen l : listener)
            l.onScreenChanged(newScreen, cpf);
    }
}
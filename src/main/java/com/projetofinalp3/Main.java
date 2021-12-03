package com.projetofinalp3;

import com.projetofinalp3.Entity.Conta;
import com.projetofinalp3.Entity.ContaCorrente;
import com.projetofinalp3.infra.ConexaoBDD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class Main extends Application {

    private static Stage primaryStage;
    private static Scene cenaTelaLogin;
    private static Scene cenaTelaPrincipal;
    public static Dados2 dados;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader telaLogin = new FXMLLoader(getClass().getResource("login.fxml"));
        FXMLLoader telaPrincipal = new FXMLLoader(getClass().getResource("telaConta.fxml"));
        //mainScene = new Scene(fxmlLoader, 520, 400);
        primaryStage = stage;
        primaryStage.setTitle("Navegação entre telas");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Parent parentTelaLogin = telaLogin.load();
        Parent parentTelaPrincipal = telaPrincipal.load();

        cenaTelaLogin = new Scene(parentTelaLogin, 520,400);
        cenaTelaPrincipal = new Scene(parentTelaPrincipal, 520,400);
        stage.setScene(cenaTelaLogin);
        stage.show();

    }

    public static void trocarTela(int number){
        switch (number){
            case 1:
                primaryStage.setScene(cenaTelaLogin);
                break;
            case 2:
                primaryStage.setScene(cenaTelaPrincipal);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
//        dados = new Dados2();
//        for(String dados: Main.dados.getCpfs()){
//            System.out.println(dados);
//        }
//        ContaCorrente conta = new ContaCorrente();
        System.out.println(Dados.getCPF());
//        conta.pegarSaldoCC();
//        conta.depositar(500);
//        conta.sacar(300);


    }
    private static ArrayList<OnChangeScreen> listener = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, String cpf);
    }

    public static void addOnChangeScreen(OnChangeScreen newListener){
        listener.add(newListener);
    }

}
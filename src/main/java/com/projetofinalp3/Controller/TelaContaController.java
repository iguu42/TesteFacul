package com.projetofinalp3.Controller;

import com.projetofinalp3.Dados;
import com.projetofinalp3.Entity.ContaCorrente;
import com.projetofinalp3.Main;
import com.projetofinalp3.infra.ConexaoBDD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.w3c.dom.Text;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TelaContaController implements Initializable{

    public String cpf;
    @FXML
    protected Button sairButton1;
    @FXML
    protected Label NameFieldText;
    @FXML
    protected Label SaldoLabelField;

    public void sairButton1OnAction(ActionEvent event){
        Stage stage = (Stage) sairButton1.getScene().getWindow();
        stage.close();
    }
    private String glbIdUsuario;
    private String glbLngIdUsuario;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Dados.getCPF();
//        String nome = ConexaoBDD.resgatarNome(Dados.getCPF());
        NameFieldText.setText("Olá, "+ Dados.getCPF());
        System.out.println(Dados.getCPF());
        SaldoLabelField.setText("Saldo: "+ConexaoBDD.resgatarSaldo(Dados.getCPF()));
    }

//    public double pegarSaldo(){
//        ConexaoBDD connectNow = new ConexaoBDD();
//        Connection connectDB = connectNow.getConnection();
//        ContaCorrente conta = new ContaCorrente();
//
//        String verifyLogin = "select numeroconta from banco where saldo = '"+conta.getCpf() +"'";
//
//        try{
//            Statement statement = connectDB.createStatement();
//            ResultSet queryResult = statement.executeQuery(verifyLogin);
//
//            while(queryResult.next()){
//                if(queryResult.getBoolean(1)) {
//                    loginErroLabel1.setText("Login feito com sucesso!");
//                    Main.trocarTela("telaConta");
//                } else {
//                    loginErroLabel1.setText("Login errado. Tente novamente.");
//                    return false;
//                }
//            }
//
//        }catch(Exception e){
//            e.getCause();
//        }
//        return false;
//    }


}

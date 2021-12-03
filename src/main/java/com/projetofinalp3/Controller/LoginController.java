package com.projetofinalp3.Controller;

import com.projetofinalp3.Dados;
import com.projetofinalp3.Main;
import com.projetofinalp3.infra.ConexaoBDD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button sairButton;
    @FXML
    private Label loginErroLabel;
    @FXML
    private Label loginErroLabel1;
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField senhaTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dados.getInstance(loginTextField.getText());
        File logoFile = new File("Image/verde.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
        File lockFile = new File("Image/2.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
        //Dados.getInstance(loginTextField.getText());
        Main.addOnChangeScreen(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, String cpf) {
                System.out.println("Nova tela: "+newScreen);

            }
        });
        }


    public void loginButtonOnAction(ActionEvent event){
        if(loginTextField.getText().isBlank() == false && senhaTextField.getText().isBlank()==false) {
            if(validateLogin()){
                Main.trocarTela(2);
                //AbreJanela(2);
            }
        }else{
            loginErroLabel.setText("Por favor digite o login e a senha");

        }
    }

    public void sairButtonOnAction(ActionEvent event){
        Stage stage = (Stage) sairButton.getScene().getWindow();
        stage.close();
    }


    public boolean validateLogin(){
        return ConexaoBDD.validateLogin(loginErroLabel1,loginTextField,senhaTextField);
    }

}

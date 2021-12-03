package com.projetofinalp3.infra;
import com.projetofinalp3.Dados;
import com.projetofinalp3.Entity.Cliente;
import com.projetofinalp3.Entity.Conta;
import com.projetofinalp3.Entity.ContaCorrente;
import com.projetofinalp3.Main;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBDD {
    public ConexaoBDD(){

    }
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres","91718377");
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public static boolean validateLogin(Label textoLoginErro, TextField login, TextField senha){
        ConexaoBDD connectNow = new ConexaoBDD();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select numeroconta from banco where cpf = '"+login.getText() +"' and senha = '"+senha.getText()+"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getBoolean(1)) {
                    textoLoginErro.setText("Login feito com sucesso!");
                    //ConexaoBDD.salvarDados(login.getText());
                    //Dados.getInstance(login.getText());
                    return true;
                } else {
                    textoLoginErro.setText("Login errado. Tente novamente.");
                    return false;
                }
            }

        }catch(Exception e){
            e.getCause();
        }
        return false;
    }
    public static String findById(String cpf) {
        String cpfCliente = null;
        String sql = "SELECT cpf FROM banco WHERE cpf = ?";
        try(Connection connection = ConexaoBDD.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cpf);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                do {
                    cpfCliente = rs.getString("cpf");
                    return cpfCliente;
                } while (rs.next());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cpfCliente;
    }
//    public static boolean salvarDados(String cpf){
//        ConexaoBDD connectNow = new ConexaoBDD();
//        Connection connectDB = connectNow.getConnection();
//
//        String verifyLogin = "SELECT * FROM banco WHERE cpf = '"+cpf+"'";
//
//        try{
//            Statement statement = connectDB.createStatement();
//            ResultSet queryResult = statement.executeQuery(verifyLogin);
//
//            while(queryResult.next()){
//                if(queryResult.getBoolean(1)) {
//                    Dados.getInstance(queryResult.getString("cpf"));
//                } else {
//                    return false;
//                }
//            }
//
//        }catch(Exception e){
//            e.getCause();
//        }
//        return false;
//    }

    public static String resgatarNome(String cpf){
        ConexaoBDD connectNow = new ConexaoBDD();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM banco WHERE cpf = '"+cpf+"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getBoolean(1)) {
                    return queryResult.getString("Nome");
                } else {
                    return null;
                }
            }

        }catch(Exception e){
            e.getCause();
        }
        return null;
    }

    public static double resgatarSaldo(String cpf) {
        double saldo = 0;
        String sql = "SELECT * FROM banco WHERE cpf = ?";
        try(Connection connection = ConexaoBDD.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cpf);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                do {
                    saldo = rs.getDouble("saldo");
                    return saldo;
                } while (rs.next());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return saldo;
    }

    public static Conta criarConta(Conta contaCorrente) {
        try(Connection connection = ConexaoBDD.getConnection()) {
            String sql = "INSERT INTO banco (nome,cpf,senha,saldo) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contaCorrente.getNome());
            preparedStatement.setString(2,contaCorrente.getCpf());
            preparedStatement.setString(3, contaCorrente.getSenha());
            preparedStatement.setDouble(4,contaCorrente.getSaldo());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static Conta depositar(String cpf, double valor) {
        try(Connection connection = ConexaoBDD.getConnection()) {
            String sql = "UPDATE banco SET saldo = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, valor);
            preparedStatement.setString(2,findById(cpf));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static Conta sacar(String cpf, double valor) {
        try(Connection connection = ConexaoBDD.getConnection()) {
            String sql = "UPDATE banco SET saldo = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, valor);
            preparedStatement.setString(2,findById(cpf));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
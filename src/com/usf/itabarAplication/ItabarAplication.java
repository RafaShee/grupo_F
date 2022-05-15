package com.usf.itabarAplication;

import com.usf.jdbc.ConnectionFactory;
import com.usf.screen.MainScreen;

import javax.swing.*;
import java.sql.Connection;

public class ItabarAplication {

    public static void main(String[] args) {

//        try{
//            //Testando a conexão com o Banco
//            JOptionPane.showMessageDialog(null, "Testando a conexão");
//            Connection con = new ConnectionFactory().conecta();
//            JOptionPane.showMessageDialog(null, "Está conectado");
//        } catch (Exception e){
//
//            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e);
//        }

        JFrame frame = new MainScreen("Tela inicial");
        frame.setVisible(true);
    }
}

package com.usf.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton botaoListaP;
    private JButton botaoCadastraV;
    private JPanel mainScreen;
    private JButton cadastrarProdutosButton;

    public MainScreen(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainScreen);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        botaoListaP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new TelaProdutos("Lista de produtos");
                frame.setVisible(true);
                dispose();
            }
        });
        botaoCadastraV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new TelaCadastraVenda("Tela de cadastro");
                frame.setVisible(true);
                dispose();
            }
        });
        cadastrarProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new TelaCadastraProduto("Tala cadastro de produtos");
                frame.setVisible(true);
                dispose();
            }
        });
    }
}

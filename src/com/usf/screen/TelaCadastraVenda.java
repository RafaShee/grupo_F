package com.usf.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastraVenda extends JFrame {
    private JButton botaoVoltaTelaInicial;
    private JComboBox produtoComboBox;
    private JSpinner qtdSpinner;
    private JPanel telaCadastro;
    private JTable table1;
    private JButton botaoAddProduto;
    private JButton cadastrarCompraButton;

    public TelaCadastraVenda(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(telaCadastro);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        botaoVoltaTelaInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela Principal");
                frame.setVisible(true);
                dispose();
            }
        });
    }
}

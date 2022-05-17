package com.usf.screen;

import com.usf.DAO.ProdutoDAO;
import com.usf.model.Produto;
import org.postgresql.util.PGmoney;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class TelaCadastraProduto extends JFrame {

    private JPanel telaCadastraProdutos;
    private JTextField nomeProdutoTextField;
    private JTextField valorProdutoTextField;
    private JButton voltarButton;
    private JButton cadastrarButton;

    public TelaCadastraProduto(String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(telaCadastraProdutos);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela inicial");
                frame.setVisible(true);
                dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Produto produto = new Produto();
                    produto.setNome(nomeProdutoTextField.getText());
                    produto.setValor(Double.parseDouble(valorProdutoTextField.getText()));


                    ProdutoDAO dao = new ProdutoDAO();
                    dao.cadastrarProduto(produto);

                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                } catch (Exception ErroSql){
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + ErroSql);
                }

                nomeProdutoTextField.setText("");
                valorProdutoTextField.setText("");
            }
        });
    }
}

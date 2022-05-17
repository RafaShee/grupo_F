package com.usf.screen;

import com.usf.DAO.ProdutoDAO;
import com.usf.model.Produto;
import com.usf.model.Venda;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class TelaCadastraVenda extends JFrame {
    private JButton botaoVoltaTelaInicial;
    private JComboBox produtoComboBox;
    private JSpinner qtdSpinner;
    private JPanel telaCadastro;
    private JTable table1;
    private JButton botaoAddProduto;
    private JButton botaoCadastraVenda;

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
        produtoComboBox.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                ProdutoDAO dao = new ProdutoDAO();
                List<Produto> listaProdutos = dao.listarProdutos();

                produtoComboBox.removeAll();

                for(Produto p : listaProdutos){
                    produtoComboBox.addItem(p);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        botaoCadastraVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Venda venda = new Venda();
            }
        });
    }
}

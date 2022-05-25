package com.usf.screen;

import com.usf.DAO.ProdutoDAO;
import com.usf.DAO.VendaDAO;
import com.usf.model.Produto;
import com.usf.model.ProdutoVenda;
import com.usf.model.Venda;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TelaCadastraVenda extends JFrame {
    private JButton botaoVoltaTelaInicial;
    private JComboBox produtoComboBox;
    private JSpinner qtdSpinner;
    private JPanel telaCadastro;
    private JButton botaoAddProduto;
    private JButton botaoCadastraVenda;

    private int qtdProduto;

    public TelaCadastraVenda(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(telaCadastro);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Venda venda = new Venda();

        List<ProdutoVenda> listaProdutoVenda = new ArrayList<>();

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
        botaoAddProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoVenda produtoVenda = new ProdutoVenda();

                Produto produto = (Produto) produtoComboBox.getSelectedItem();

                venda.getListaProdutos().add(produto);

                venda.setIdProduto(venda.getListaProdutos().get(0).getIdProduto());
                venda.setQtd((Integer) qtdSpinner.getValue());
                venda.setTotal(venda.getListaProdutos().get(0).getValor() * venda.getQtd());

                produtoVenda.setValor(produto.getValor());
                produtoVenda.setNome(produto.getNome());
                produtoVenda.setQtd((Integer) qtdSpinner.getValue());
                produtoVenda.setTotal(produto.getValor() * produtoVenda.getQtd());

                listaProdutoVenda.add(produtoVenda);

//                for(int i = 0; i < listaProdutoVenda.size(); i++){
//
//                    System.out.println(listaProdutoVenda.get(i).getNome());
//                    System.out.println(listaProdutoVenda.get(i).getValor());
//                    System.out.println(listaProdutoVenda.get(i).getQtd());
//                    System.out.println(listaProdutoVenda.get(i).getTotal());
//
//                }

                for (ProdutoVenda produtoVenda1 : listaProdutoVenda) {
                    System.out.println(produtoVenda1.getNome());
                    System.out.println(produtoVenda1.getValor());
                    System.out.println(produtoVenda1.getQtd());
                    System.out.println(produtoVenda1.getTotal());
                }
            }
        });


        botaoCadastraVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    VendaDAO dao = new VendaDAO();
                    dao.cadastrarVenda(venda);

                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                } catch (Exception ErroSql){
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + ErroSql);
                }

            }
        });
    }
}

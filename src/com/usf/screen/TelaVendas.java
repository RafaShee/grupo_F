package com.usf.screen;

import com.usf.jdbc.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaVendas extends JFrame {
    private JPanel telaVendas;
    private JTable tabelaVendas;
    private JButton voltarButton;

    public TelaVendas(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(telaVendas);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        carregaTabela();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela inicial");
                frame.setVisible(true);
                dispose();
            }
        });


    }

    public void carregaTabela(){

        DefaultTableModel modelo = (DefaultTableModel) tabelaVendas.getModel();
        modelo.setNumRows(0);

        modelo.addColumn("idVenda");
        modelo.addColumn("dataVenda");
        modelo.addColumn("idProduto");
        modelo.addColumn("qtd");
        modelo.addColumn("total");


        tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabelaVendas.getColumnModel().getColumn(1).setPreferredWidth(35);
        tabelaVendas.getColumnModel().getColumn(2).setPreferredWidth(35);
        tabelaVendas.getColumnModel().getColumn(3).setPreferredWidth(35);
        tabelaVendas.getColumnModel().getColumn(4).setPreferredWidth(35);
        try{
            Connection con = ConnectionFactory.conecta();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("select * from public.Venda");
            rs = pstm.executeQuery();

            while(rs.next()){
                modelo.addRow(new Object[]{
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),


                });
            }

            ConnectionFactory.closeConnection(con, pstm, rs);
        } catch(Exception ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package com.usf.DAO;

import com.usf.jdbc.ConnectionFactory;
import com.usf.model.Produto;
import com.usf.model.Venda;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection conecta;

    public VendaDAO(){
        this.conecta = ConnectionFactory.conecta();
    }

    public void cadastrarVenda(Venda venda){
        try{
            String cmdsql = "insert into public.Venda(dataVenda, idProduto, qtd, total) values(?, ?, ?, ?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setDate(1, Date.valueOf(String.valueOf(venda.getDataVenda())));
            stmt.setInt(2, venda.getIdProduto());
            stmt.setInt(3, venda.getQtd());
            stmt.setDouble(4, venda.getTotal());

            stmt.execute();

            stmt.close();
        } catch (SQLException ErroSql){
            throw new RuntimeException(ErroSql);
        }
    }

}

package com.usf.DAO;

import com.usf.jdbc.ConnectionFactory;
import com.usf.model.Produto;
import com.usf.model.Venda;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection conecta;

    public VendaDAO(){
        this.conecta = ConnectionFactory.conecta();
    }

    public void cadastrarVenda(Venda venda){
        try{
            String cmdsql = "insert into public.Venda(dataVenda, produtosVenda, total) values(?, ?, ?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, venda.getDataVenda());
            stmt.setArray(2, (Array) venda.getListaProdutos());
            stmt.setBigDecimal(3, venda.getTotal());

            stmt.execute();

            stmt.close();
        } catch (SQLException ErroSql){
            throw new RuntimeException(ErroSql);
        }
    }

}

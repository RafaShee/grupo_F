package com.usf.DAO;

import com.usf.jdbc.ConnectionFactory;
import com.usf.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    private Connection conecta;

    public ProdutoDAO(){
        this.conecta = new ConnectionFactory().conecta();
    }

    public void cadastrarProduto(Produto produto){
        try{
            String cmdsql = "insert into public.Produto(nome, valor) values(?, ?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getValor());

            stmt.execute();

            stmt.close();
        } catch (SQLException ErroSql){
            throw new RuntimeException(ErroSql);
        }
    }
}

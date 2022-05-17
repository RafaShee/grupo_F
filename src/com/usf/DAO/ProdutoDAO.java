package com.usf.DAO;

import com.usf.jdbc.ConnectionFactory;
import com.usf.model.Produto;
import org.postgresql.util.PGmoney;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            stmt.setDouble(2, produto.getValor());

            stmt.execute();

            stmt.close();
        } catch (SQLException ErroSql){
            throw new RuntimeException(ErroSql);
        }
    }

    public List<Produto> listarProdutos(){

        try{
            List<Produto> lista = new ArrayList<Produto>();
            String cmdSql = "select * from public.Produto";
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));


                lista.add(produto);
            }
            return lista;
        } catch (SQLException ErroSql){
            throw new RuntimeException(ErroSql);
        }
    }
}

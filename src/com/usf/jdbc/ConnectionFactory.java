package com.usf.jdbc;

import java.sql.*;

public class ConnectionFactory {

    public static Connection conecta(){

        try {
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bd_Itabar", "postgres", "batata");
        } catch(SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível se conectar: " + ErroSql);
        }

    }

    public static void closeConnection(Connection con) {
        try{
            if(con != null){
                con.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível ffechar a conexão." + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        try{
            if(pstm != null){
                pstm.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível fechar o PreparedStatement." + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
        closeConnection(con, pstm);
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível fechar o PreparedStatement." + ErroSql);
        }
    }
}

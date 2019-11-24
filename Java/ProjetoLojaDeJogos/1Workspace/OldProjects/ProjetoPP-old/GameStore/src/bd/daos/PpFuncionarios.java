package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class PpFuncionarios
{
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar o funcion�rio");
        }

        return retorno;
    }

    public static void incluir (PpFuncionario func) throws Exception
    {
        if (func==null)
            throw new Exception ("Funcion�rio n�o fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO PpFuncionario " +
                  "(CODIGO,NOME,CPF,TELEFONE,ENDERECO,EMAIL,SALARIO) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt     (1, func.getCodigo   ());
            BDSQLServer.COMANDO.setString  (2, func.getNome 	());
            BDSQLServer.COMANDO.setString  (3, func.getCpf 		());
            BDSQLServer.COMANDO.setString  (4, func.getTelefone ());
            BDSQLServer.COMANDO.setString  (5, func.getEndereco ());
            BDSQLServer.COMANDO.setString  (6, func.getEmail 	());
            BDSQLServer.COMANDO.setFloat   (7, func.getSalario  ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();   
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir funcion�rio");
        }
    }

    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("N�o cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM PpFuncionario " +
                  "WHERE CODIGO=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();     // dml
            BDSQLServer.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir funcion�rio");
        }
    }

    public static void alterar (PpFuncionario func) throws Exception
    {
        if (func==null)
            throw new Exception ("Funcion�rio nao fornecido");

        if (!cadastrado (func.getCodigo()))
            throw new Exception ("N�o cadastrado");

        try
        {
            String sql;

            sql = "UPDATE PpFuncionario " +
                  "SET NOME=? " +
                  "SET CPF=? " +
                  "SET TELEFONE=? " +
                  "SET ENDERECO=? " +
                  "SET EMAIL=? " +
                  "SET SALARIO=? " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString  (1, func.getNome 	());
            BDSQLServer.COMANDO.setString  (2, func.getCpf 		());
            BDSQLServer.COMANDO.setString  (3, func.getTelefone ());
            BDSQLServer.COMANDO.setString  (4, func.getEndereco ());
            BDSQLServer.COMANDO.setString  (5, func.getEmail	());
            BDSQLServer.COMANDO.setFloat   (6, func.getSalario  ());
            BDSQLServer.COMANDO.setInt     (7, func.getCodigo 	());

            BDSQLServer.COMANDO.executeUpdate ();     // ddl
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do funcion�rio");
        }
    }

    public static PpFuncionario getFuncionario (int codigo) throws Exception
    {
        PpFuncionario func = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();    // 	sql

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            func = new PpFuncionario (resultado.getInt   ("CODIGO"),
                               		  resultado.getString("NOME"),
                               		  resultado.getString("CPF"),
                               		  resultado.getString("TELEFONE"),
                               		  resultado.getString("ENDERECO"),
                               		  resultado.getString("EMAIL"),
                               		  resultado.getFloat ("SALARIO"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar funcion�rio");
        }

        return func;
    }

    public static MeuResultSet getFuncionario () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar funcion�rio");
        }

        return resultado;
    }
}
package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.ppFuncionario.PpFuncionario;


/**
A classe PpFuncionarios representa uma camada de acesso a dados: DAL.
Essa classe permite o uso do Banco de Dados por meio de m�todos da linguagem Java.
Nela encontramos, por exemplo, m�todos para incluir, excluir, alterar e selecionar funcion�rios.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpFuncionarios
{
	/**
	 * Verifica se um funcion�rio est� cadastrado.
	 * Retorna uma vari�vel que recebe o resultado de um m�todo que verifica se 
	 * o banco de dados encontrou um funcion�rio com o c�digo passado.
	 * @param codigo codigo do funcion�rio a ser procurado.
	 * @throws Exception se houver falha ao procurar o funcion�rio.
	 * @return true, caso haja um funcion�rio cadastrado com o c�digo fornecido, ou false, caso contr�rio.
	*/
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Coloca o resultado em uma vari�vel

            retorno = resultado.first(); //Verifica se h� um item nessa vari�vel
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar o funcion�rio");
        }

        return retorno;
    }
    
    /**
	 * Adiciona um funcion�rio ao banco.
	 * Inclui no banco de dados um funcion�rio por meio de comandos sql.
	 * @param func funcion�rio a ser inclu�do.
	 * @throws Exception se houver falha ao incluir o funcion�rio.
	*/
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

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            //Substitui as interroga��es
            BDSQLServer.COMANDO.setInt     (1, func.getCodigo   ());
            BDSQLServer.COMANDO.setString  (2, func.getNome 	());
            BDSQLServer.COMANDO.setString  (3, func.getCpf 		());
            BDSQLServer.COMANDO.setString  (4, func.getTelefone ());
            BDSQLServer.COMANDO.setString  (5, func.getEndereco ());
            BDSQLServer.COMANDO.setString  (6, func.getEmail 	());
            BDSQLServer.COMANDO.setFloat   (7, func.getSalario  ());

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();   
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir funcion�rio");
        }
    }
    
    /**
	 * Exclui um funcion�rio do banco.
	 * Exclui do banco de dados um funcion�rio por meio de comandos sql que utilizam o seu c�digo.
	 * @param codigo codigo do funcion�rio a ser exclu�do.
	 * @throws Exception se houver falha ao excluir o funcion�rio.
	*/
    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("N�o cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM PpFuncionario " +
                  "WHERE CODIGO=?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir funcion�rio");
        }
    }
    
    /**
	 * Altera um funcion�rio do banco.
	 * Altera no banco de dados um funcion�rio por meio de comandos sql.
	 * @param func funcion�rio a ser alterado.
	 * @throws Exception se houver falha ao alterar o funcion�rio.
	*/
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
                  "SET " +
                  "NOME=? " + "," +
                  "CPF=? " + "," +
                  "TELEFONE=? " + "," +
                  "ENDERECO=? " + "," +
                  "EMAIL=? " + "," +
                  "SALARIO=? " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            //Substitui as interroga��es
            BDSQLServer.COMANDO.setString  (1, func.getNome 	());
            BDSQLServer.COMANDO.setString  (2, func.getCpf 		());
            BDSQLServer.COMANDO.setString  (3, func.getTelefone ());
            BDSQLServer.COMANDO.setString  (4, func.getEndereco ());
            BDSQLServer.COMANDO.setString  (5, func.getEmail	());
            BDSQLServer.COMANDO.setFloat   (6, func.getSalario	());
            BDSQLServer.COMANDO.setInt     (7, func.getCodigo	());

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do funcion�rio");
        }
    }
    
    /**
	 * Coleta um funcion�rio.
	 * Retorna uma vari�vel que recebe o funcion�rio a partir de um MeuResultSet criado a partir de comandos sql.
	 * @param codigo codigo do funcion�rio a ser coletado.
	 * @throws Exception se houver falha ao coletar o funcion�rio.
	 * @return o funcion�rio encontrado.
	*/
    public static PpFuncionario getFuncionario (int codigo) throws Exception
    {
        PpFuncionario func = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Coloca o resultado em uma vari�vel

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            func = new PpFuncionario (resultado.getInt   ("CODIGO"),
                               		  resultado.getString("NOME"),
                               		  resultado.getString("CPF"),
                               		  resultado.getString("TELEFONE"),
                               		  resultado.getString("ENDERECO"),
                               		  resultado.getString("EMAIL"),
                               		  resultado.getFloat ("SALARIO")); //Cria um novo funcion�rio a partir da vari�vel de resultado
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar funcion�rio");
        }

        return func;
    }
    
    /**
	 * Coleta os funcion�rios.
	 * Retorna um MeuResultSet, com todos os funcion�rios do banco, criado a partir de comandos sql.
	 * @throws Exception se houver falha ao coletar os funcion�rios.
	 * @return os funcion�rios encontrados.
	*/
    public static MeuResultSet getFuncionarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpFuncionario";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Coloca o resultado em uma vari�vel
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar funcion�rio");
        }

        return resultado;
    }
}
package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.ppCliente.PpCliente;


/**
A classe PpClientes representa uma camada de acesso a dados: DAL.
Essa classe permite o uso do Banco de Dados por meio de m�todos da linguagem Java.
Nela encontramos, por exemplo, m�todos para incluir, excluir, alterar e selecionar clientes.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpClientes
{
	/**
	 * Verifica se um cliente est� cadastrado.
	 * Retorna uma vari�vel que recebe o resultado de um m�todo que verifica se 
	 * o banco de dados encontrou um cliente com o c�digo passado.
	 * @param codigo codigo do cliente a ser procurado.
	 * @throws Exception se houver falha ao procurar o cliente.
	 * @return true, caso haja um cliente cadastrado com o c�digo fornecido, ou false, caso contr�rio.
	*/
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpCliente " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Coloca o resultado em uma vari�vel

            retorno = resultado.first(); //Verifica se h� um item nessa vari�vel
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar cliente");
        }

        return retorno; //Retorna o boolean
    }
    
    /**
	 * Adiciona um cliente ao banco.
	 * Inclui no banco de dados um cliente por meio de comandos sql.
	 * @param cli cliente a ser inclu�do.
	 * @throws Exception se houver falha ao incluir o cliente.
	*/
    public static void incluir (PpCliente cli) throws Exception
    {
        if (cli==null)
            throw new Exception ("Cliente n�o fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO PpCliente " +
                  "(CODIGO,NOME,CPF,TELEFONE,ENDERECO,EMAIL,SENHA) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            //Substitui as interroga��es
            BDSQLServer.COMANDO.setInt    (1, cli.getCodigo  ());
            BDSQLServer.COMANDO.setString (2, cli.getNome	 ());
            BDSQLServer.COMANDO.setString (3, cli.getCpf	 ());
            BDSQLServer.COMANDO.setString (4, cli.getTelefone());
            BDSQLServer.COMANDO.setString (5, cli.getEndereco());
            BDSQLServer.COMANDO.setString (6, cli.getEmail	 ());
            BDSQLServer.COMANDO.setString (7, cli.getSenha	 ());

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();   
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir cliente");
        }
    }
    
    /**
	 * Exclui um cliente do banco.
	 * Exclui do banco de dados um cliente por meio de comandos sql que utilizam o seu c�digo.
	 * @param codigo codigo do cliente a ser exclu�do.
	 * @throws Exception se houver falha ao excluir o cliente.
	*/
    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("N�o cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM PpCliente " +
                  "WHERE CODIGO=?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir cliente");
        }
    }
    
    /**
	 * Altera um cliente do banco.
	 * Altera no banco de dados um cliente por meio de comandos sql.
	 * @param cli cliente a ser alterado.
	 * @throws Exception se houver falha ao alterar o cliente.
	*/
    public static void alterar (PpCliente cli) throws Exception
    {
        if (cli==null)
            throw new Exception ("Livro nao fornecido");

        if (!cadastrado (cli.getCodigo()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE PPCLIENTE " +
                  "SET NOME=? " + ", " +
                  "CPF=? " + ", " +
                  "TELEFONE=? " + ", " +
                  "ENDERECO=? " + ", " +
                  "EMAIL=?  ,"+ "  SENHA=? "+
                  "WHERE CODIGO=?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            //Substitui as interroga��es
            BDSQLServer.COMANDO.setString (1, cli.getNome 	 ());
            BDSQLServer.COMANDO.setString (2, cli.getCpf	 ());
            BDSQLServer.COMANDO.setString (3, cli.getTelefone());
            BDSQLServer.COMANDO.setString (4, cli.getEndereco());
            BDSQLServer.COMANDO.setString (5, cli.getEmail	 ());
            BDSQLServer.COMANDO.setString (6, cli.getSenha	 ());
            BDSQLServer.COMANDO.setInt    (7, cli.getCodigo  ());

            BDSQLServer.COMANDO.executeUpdate (); //Executa os comandos
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do cliente");
        }
    }
    
    /**
	 * Coleta um cliente.
	 * Retorna uma vari�vel que recebe o cliente a partir de um MeuResultSet criado a partir de comandos sql.
	 * @param codigo codigo do cliente a ser coletado.
	 * @throws Exception se houver falha ao coletar o cliente.
	 * @return o cliente encontrado.
	*/
    public static PpCliente getCliente (int codigo) throws Exception
    {
        PpCliente cli = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpCliente " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Guarda o resultado em uma vari�vel

            if (!resultado.first()) //Se n�o houver um resultado
                throw new Exception ("N�o cadastrado");

            cli = new PpCliente (resultado.getInt   ("CODIGO"),
                               resultado.getString  ("NOME"),
                               resultado.getString  ("CPF"),
                               resultado.getString	("TELEFONE"),
                               resultado.getString	("ENDERECO"),
                               resultado.getString	("EMAIL"),
                               resultado.getString  ("SENHA")); //Cria um novo cliente a partir da vari�vel de resultado
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar cliente");
        }

        return cli;
    }
    
    /**
	 * Coleta os clientes.
	 * Retorna um MeuResultSet, com todos os clientes do banco, criado a partir de comandos sql.
	 * @throws Exception se houver falha ao coletar os clientes.
	 * @return os clientes encontrados.
	*/
    public static MeuResultSet getClientes() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpCliente";

            BDSQLServer.COMANDO.prepareStatement (sql); //Guarda os comandos

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Guarda os resultados em uma vari�vel
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar clientes");
        }

        return resultado;
    }
}
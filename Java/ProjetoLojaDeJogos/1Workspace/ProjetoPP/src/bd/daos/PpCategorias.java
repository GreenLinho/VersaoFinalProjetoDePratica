package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.ppCategoria.PpCategoria;


/**
A classe PpCategorias representa uma camada de acesso a dados: DAL.
Essa classe permite o uso do Banco de Dados por meio de m�todos da linguagem Java.
Nela encontramos, por exemplo, m�todos para incluir, excluir, alterar e selecionar categorias.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpCategorias
{
	/**
	 * Verifica se uma categoria est� cadastrada.
	 * Retorna uma vari�vel que recebe o resultado de um m�todo que verifica se 
	 * o banco de dados encontrou uma categoria com o c�digo passado.
	 * @param codigo codigo da categoria a ser procurada.
	 * @throws Exception se houver falha ao procurar a categoria.
	 * @return true, caso haja uma categoria cadastrada com o c�digo fornecido, ou false, caso contr�rio.
	*/
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false; //Cria uma vari�vel de retorno boolean inicializada em false.

        try
        {
            String sql; //Cria uma String sql.

            sql = "SELECT * " +
                  "FROM PpCategoria " +
                  "WHERE CODIGO = ?"; //Coloca nessa String os comandos a serem executados.

            BDSQLServer.COMANDO.prepareStatement (sql); //Coloca a String no BDSQLServer.

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui os pontos de interroga��o.

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Coloca em um MeuResultSet os valores recebidos do banco.

            retorno = resultado.first(); //Coloca true, se houver uma categoria com esse c�digo, ou false, caso contr�rio.
            
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao procurar categoria!");
        }

        return retorno; //Retorna o boolean.
    }
    
    
    /**
	 * Adiciona uma categoria ao banco.
	 * Inclui no banco de dados uma categoria por meio de comandos sql.
	 * @param categoria categoria a ser inclu�da.
	 * @throws Exception se houver falha ao incluir a categoria.
	*/
    public static void incluir (PpCategoria categoria) throws Exception
    {
        if (categoria==null)
            throw new Exception ("Categoria n�o fornecida"); //Se a categoria passa for null, lan�a exce��o.

        try
        {
            String sql; //Cria uma String sql.

            sql = "INSERT INTO PpCategoria " +
                  "(CODIGO,NOME) " +
                  "VALUES " +
                  "(?,?)"; //Coloca os comandos na vari�vel.

            BDSQLServer.COMANDO.prepareStatement (sql); //Coloca o sql no BDSQLServer.

            //Substitui as interroga��es.
            BDSQLServer.COMANDO.setInt    (1, categoria.getCodigo ());
            BDSQLServer.COMANDO.setString (2, categoria.getNome ());

            BDSQLServer.COMANDO.executeUpdate (); //Realiza os comandos do sql.
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao inserir a categoria"); //Lan�a exce��o.
        }
    }
    
    /**
	 * Exclui uma categoria do banco.
	 * Exclui do banco de dados uma categoria por meio de comandos sql que utilizam o seu c�digo.
	 * @param codigo codigo da categoria a ser exclu�da.
	 * @throws Exception se houver falha ao excluir a categoria.
	*/
    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo)) //Se a categoria n�o estiver cadastrada...
            throw new Exception ("N�o cadastrada"); //Lan�a exce��o

        try
        {
            String sql;

            sql = "DELETE FROM PpCategoria " +
                  "WHERE CODIGO=?"; //Guarda os comandos.

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo); //Substitui as interroga��es.

            BDSQLServer.COMANDO.executeUpdate (); //Realiza os comandos.
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao excluir a categoria"); //Lan�a exce��o
        }
    }
    
    /**
	 * Altera uma categoria do banco.
	 * Altera no banco de dados uma categoria por meio de comandos sql.
	 * @param categ categoria a ser alterada.
	 * @throws Exception se houver falha ao alterar a categoria.
	*/
    public static void alterar (PpCategoria categ) throws Exception
    {
        if (categ==null) //Se o par�metro for nulo
            throw new Exception ("Categoria n�o fornecida!"); //Lan�a exce��o

        if (!cadastrado (categ.getCodigo())) //Se n�o estiver cadastrada
            throw new Exception ("N�o cadastrada"); //Lan�a exce��o

        try
        {
            String sql;

            sql = "UPDATE PpCategoria " +
                  "SET NOME=? " +
                  "WHERE CODIGO = ?"; //Guarda os comandos.

            BDSQLServer.COMANDO.prepareStatement (sql);

            //Substitui as interroga��es.
            BDSQLServer.COMANDO.setString (1, categ.getNome ());
            BDSQLServer.COMANDO.setInt (2, categ.getCodigo ());

            BDSQLServer.COMANDO.executeUpdate (); //Realiza os comandos.
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao atualizar os dados da categoria!");
        }
    }
    
    /**
	 * Coleta uma categoria.
	 * Retorna uma vari�vel que recebe a categoria a partir de um MeuResultSet criado a partir de comandos sql.
	 * @param codigo codigo da categoria a ser coletada.
	 * @throws Exception se houver falha ao coletar a categoria.
	 * @return a categoria encontrada.
	*/
    public static PpCategoria getCategoria (int codigo) throws Exception
    {
        PpCategoria categ = null; //Cria uma vari�vel de categoria.

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpCategoria " +
                  "WHERE CODIGO = ?"; //Guarda os comandos.

            BDSQLServer.COMANDO.prepareStatement (sql);

            //Substitui as interroga��es.
            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Realiza os comandos e guarda em um MeuResultSet

            if (!resultado.first()) //Se n�o houver uma categoria
                throw new Exception ("N�o cadastrada"); //Ela n�o est� cadastrada

            categ = new PpCategoria (resultado.getInt   ("CODIGO"), //Guarda em categ uma categoria. 
                               		 resultado.getString("NOME"));
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao procurar categoria");
        }

        return categ; //Retorna a categoria
    }
    
    /**
	 * Coleta as categorias.
	 * Retorna um MeuResultSet, com todas as categorias do banco, criado a partir de comandos sql.
	 * @throws Exception se houver falha ao coletar as categorias.
	 * @return as categorias encontradas.
	*/
    public static MeuResultSet getCategorias () throws Exception
    {
        MeuResultSet resultado = null; //Cria uma vari�vel de retorno em MeuResultSet.

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PpCategoria"; //Guarda os comandos.

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); //Guarda os resultados no MeuResultSet
        }
        catch (SQLException erro) //Se falhar...
        {
            throw new Exception ("Erro ao recuperar as categorias!");
        }

        return resultado; //Retorna os resultados
    }
}
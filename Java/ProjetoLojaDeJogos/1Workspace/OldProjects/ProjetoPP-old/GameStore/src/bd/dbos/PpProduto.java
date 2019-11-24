package bd.dbos;

public class PpProduto implements Cloneable
{
    private int    codigo;
    private String nome;
    private int    codCategoria;
    private float  preco;
    private int    estoque;
    
    // SETTER's
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("C�digo inv�lido!");

        this.codigo = codigo;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome n�o fornecido!");

        this.nome = nome;
    }
    
    public void setCodCategoria (int codCategoria) throws Exception
    {
        if (codCategoria <= 0)
            throw new Exception ("Categoria inv�lida!");

        this.codCategoria = codCategoria;
    } 
    
    public void setPreco (float preco) throws Exception
    {
        if (preco <= 0)
            throw new Exception ("Pre�o inv�lido!");

        this.preco = preco;
    } 
    
    public void setEstoque (int estoque) throws Exception
    {
        if (estoque <= 0)
            throw new Exception ("N�mero em estoque inv�lido!");

        this.estoque = estoque;
    } 

    // GETTER's
    public int getCodigo()
    {
        return this.codigo;
    }

    public String getNome()
    {
        return this.nome;
    }
    
    public int getCodCategoria()
    {
        return this.codCategoria;
    }
    
    public float getPreco()
    {
        return this.preco;
    }
    
    public int getEstoque()
    {
        return this.estoque;
    }

    // Constructor
    public PpProduto (int codigo, String nome, int codCategoria, float preco, int estoque) throws Exception
    {
        this.setCodigo   	 (codigo);
        this.setNome     	 (nome);
        this.setCodCategoria (codCategoria);
        this.setPreco		 (preco);
        this.setEstoque		 (estoque);
    }

    // Method toString
    public String toString ()
    {
        String ret="";

        ret+="Codigo..: "+this.codigo		+ "\n";
        ret+="Nome....: "+this.nome 		+ "\n";
        ret+="CodCateg: "+this.codCategoria + "\n";
        ret+="Pre�o...: "+this.preco 		+ "\n";
        ret+="Estoque.: "+this.estoque;
        return ret;
    }
//-------------------------------------------------------------------------------------------------//
}
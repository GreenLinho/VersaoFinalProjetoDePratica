package bd.dbos.ppProduto;

/**
A classe PpProduto representa um objeto do banco de dados: DBO.
Essa classe permite a cria��o de um objeto que vir� do banco de dados.
Nela encontramos, por exemplo, equals, toString, setters, getters, construtores, clone e hashCode.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpProduto implements Cloneable
{
	/** Inteiro que define o c�digo do produto. */
	protected int    codigo;
	
	/** Cadeia de caracteres que define o nome do produto. */
	protected String nome;
	
	/** Inteiro que define o c�digo da categoria do produto. */
    protected int    codCategoria;
    
    /** N�mero flutuante que define o pre�o do produto. */
    protected float  preco;
    
    /** Inteiro que define a quantidade em estoque do produto. */
    protected int    estoque;
    
    /** Cadeia de caracteres que define a fonte da imagem do produto */
    protected String imagem;
    
    
    /** 
     * Muda o c�digo do produto.
     * Verifica se o par�metro � v�lido e faz o c�digo da classe receber o passado.
     * @param codigo c�digo novo a ser inclu�do.
     * @throws Exception quando o c�digo � inv�lido.
    */
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("C�digo inv�lido!");

        this.codigo = codigo;
    }   

    /** 
     * Muda o nome do produto.
     * Verifica se o par�metro � v�lido e faz o nome da classe receber o passado.
     * @param nome nome novo a ser inclu�do.
     * @throws Exception quando o nome � inv�lido.
    */
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome n�o fornecido!");

        this.nome = nome;
    }
    
    /** 
     * Muda o c�digo da categoria do produto.
     * Verifica se o par�metro � v�lido e faz o c�digo da categoria da classe receber o passado.
     * @param codCategoria c�digo novo a ser inclu�do.
     * @throws Exception quando o c�digo � inv�lido.
    */
    public void setCodCategoria (int codCategoria) throws Exception
    {
        if (codCategoria <= 0)
            throw new Exception ("Categoria inv�lida!");

        this.codCategoria = codCategoria;
    } 
    
    /** 
     * Muda o pre�o do produto.
     * Verifica se o par�metro � v�lido e faz o pre�o da classe receber o passado.
     * @param preco pre�o novo a ser inclu�do.
     * @throws Exception quando o pre�o � inv�lido.
    */
    public void setPreco (float preco) throws Exception
    {
        if (preco <= 0)
            throw new Exception ("Pre�o inv�lido!");

        this.preco = preco;
    }
    
    /** 
     * Muda o estoque do produto.
     * Verifica se o par�metro � v�lido e faz o estoque da classe receber o passado.
     * @param estoque estoque novo a ser inclu�do.
     * @throws Exception quando o estoque � inv�lido.
    */
    public void setEstoque (int estoque) throws Exception
    {
        if (estoque < 0)
            throw new Exception ("Estoque inv�lido!");

        this.estoque = estoque;
    }
    
    /** 
     * Muda a imagem do produto.
     * Verifica se o par�metro � v�lido e faz a imagem da classe receber a passada.
     * @param imagem imagem nova a ser inclu�da.
     * @throws Exception quando a imagem � inv�lida.
    */
    public void setImagem(String imagem) throws Exception
    {
    	if (imagem == null || imagem.equals(""))
            throw new Exception ("Imagem inv�lida!");

        this.imagem = imagem;
    }

    
    /** 
     * Coleta o c�digo do produto.
     * Retorna um inteiro representando o c�digo do produto.
     * @return o c�digo do produto em int.
    */
    public int getCodigo()
    {
        return this.codigo;
    }

    /** 
     * Coleta o nome do produto.
     * Retorna uma cadeia de caracteres representando o nome do produto.
     * @return o nome do produto em String.
    */
    public String getNome()
    {
        return this.nome;
    }
    
    /** 
     * Coleta o c�digo da categoria do produto.
     * Retorna um inteiro representando o c�digo da categoria do produto.
     * @return o c�digo da categoria do produto em int.
    */
    public int getCodCategoria()
    {
        return this.codCategoria;
    }
    
    /** 
     * Coleta o pre�o do produto.
     * Retorna um n�mero flutuante representando o pre�o do produto.
     * @return o pre�o do produto em float.
    */
    public float getPreco()
    {
        return this.preco;
    }
    
    /** 
     * Coleta a quantidade em estoque do produto.
     * Retorna um inteiro representando o estoque do produto.
     * @return o estoque do produto em int.
    */
    public int getEstoque()
    {
        return this.estoque;
    }
    
    /** 
     * Coleta a imagem do produto.
     * Retorna uma cadeia de caracteres representando a imagem do produto.
     * @return a imagem do produto em String.
    */
    public String getImagem()
    {
        return this.imagem;
    }

    
    /**
    Constroi uma nova inst�ncia da classe PpProduto.
    Para tanto, deve ser fornecido 
    um inteiro, que ser� utilizado como c�digo, 
    uma cadeia de caracteres, que ser� utilizada como nome, 
    um inteiro, que ser� utilizado como c�digo da categoria, 
    um n�mero flutuante, que ser� utilizado como pre�o,
    um inteiro, que ser� utilizado como estoque,
    e uma cadeia de caracteres, que ser� utilizada como fonte da imagem
    da inst�ncia rec�m criada.
    @param codigo o inteiro a ser utilizado como c�digo.
    @param nome a cadeia de caracteres a ser utilizada como nome.
    @param codCategoria o inteiro a ser utilizado como c�digo da categoria.
    @param preco o n�mero flutuante a ser utilizado como pre�o.
    @param estoque o inteiro a ser utilizado como estoque.
    @param imagem a cadeia de caracteres a ser utilizada como fonte da imagem.
    @throws Exception se o codigo, o nome, a categoria, o pre�o ou o estoque forem inv�lidos.
    */
    public PpProduto (int codigo, String nome, int codCategoria, float preco, int estoque, String imagem) throws Exception
    {
        this.setCodigo   	 (codigo);
        this.setNome     	 (nome);
        this.setCodCategoria (codCategoria);
        this.setPreco		 (preco);
        this.setEstoque      (estoque);
        this.setImagem       (imagem);
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpProduto dada.
    Para tanto, deve ser fornecida uma instancia da classe PpProduto para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param prod a inst�ncia da classe PpProduto a ser usada como modelo.
    @throws Exception se prod for null.
    */
    public PpProduto (PpProduto prod) throws Exception
    {
    	if(prod == null)
    		throw new Exception("O produto � null");
    	
        this.setCodigo   	 (prod.codigo);
        this.setNome     	 (prod.nome);
        this.setCodCategoria (prod.codCategoria);
        this.setPreco		 (prod.preco);
        this.setEstoque      (prod.estoque);
        this.setImagem       (prod.imagem);
    }

    
    /**
    Gera uma representa��o textual de todo o conte�do do produto.
    Produz e resulta um String com o c�digo, o nome, a categoria, o pre�o, o estoque e a imagem do produto.
    @return um String contendo todo o conte�do do produto.
    */
    public String toString ()
    {
        String ret="";

        ret+="Codigo....: "+this.codigo		  + "\n";
        ret+="Nome......: "+this.nome 		  + "\n";
        ret+="CodCateg..: "+this.codCategoria + "\n";
        ret+="Pre�o.....: "+this.preco        + "\n";
        ret+="Estoque...: "+this.estoque      + "\n";
        ret+="Imagem....: "+this.imagem;
        return ret;
    }
    
    /**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de um produto.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) do produto representado pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento do produto chamante do m�todo.
    */
    public int hashCode()
    {
    	int ret = 17;
    	
    	ret = ret * 17 + new Integer(this.codigo).hashCode();
    	ret = ret * 17 + this.nome.hashCode();
    	ret = ret * 17 + new Integer(this.codCategoria).hashCode();
    	ret = ret * 17 + new Float(this.preco).hashCode();
    	ret = ret * 17 + new Integer(this.estoque).hashCode();
    	ret = ret * 17 + this.imagem.hashCode();
    	
    	if(ret < 0)
    		ret = -ret;
    	
    	return ret;
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpProduto dada.
    Para tanto, foi utilizado o construtor de c�pia, que gera uma de this.
    @return a c�pia da inst�ncia deste produto.
    */
    public Object clone()
    {
    	PpProduto ret = null;
    	
    	try
    	{
    		ret = new PpProduto(this);
    	}
    	catch(Exception ex)
    	{}
    	
    	return ret;
    }
    
    /**
    Verifica a igualdade entre dois produtos.
    Verifica se o Object fornecido como par�metro representa um
    produto igual �quele representado pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem produtos iguais, ou false, caso contr�rio.
    */
    public boolean equals(Object obj)
    {
    	if(obj == null)
    		return false;
    	
    	if(obj.getClass() != this.getClass())
    		return false;
    	
    	if(obj == this)
    		return true;
    	
    	
    	PpProduto prod = (PpProduto)obj;
    	if(prod.imagem.equals(this.imagem) && prod.codigo == this.codigo && this.nome.equals(prod.nome) && this.codCategoria == prod.codCategoria && this.preco == prod.preco && this.estoque == prod.estoque)
    		return true;
    	
    	return false; //�ltimo caso
    }
}
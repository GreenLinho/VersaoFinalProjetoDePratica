package bd.dbos.ppVenda;

/**
A classe PpVenda representa um objeto do banco de dados: DBO.
Essa classe permite a cria��o de um objeto que vir� do banco de dados.
Nela encontramos, por exemplo, equals, toString, setters, getters, construtores, clone e hashCode.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpVenda implements Cloneable
{
	/** Inteiro que define o c�digo da venda. */
	protected int codigo;
	
	/** Inteiro que define o c�digo do produto da venda. */
	protected int codProd;
	
	/** Inteiro que define o c�digo do cliente da venda. */
	protected int codCli;
	
	/** Inteiro que define a quantidade comprada do produto da venda. */
	protected int quantidade;
	
	
	/** 
     * Muda o c�digo da venda.
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
     * Muda o c�digo do produto da venda.
     * Verifica se o par�metro � v�lido e faz o c�digo do produto da classe receber o passado.
     * @param codProd c�digo novo a ser inclu�do.
     * @throws Exception quando o c�digo � inv�lido.
    */
	public void setCodProd (int codProd) throws Exception
    {
        if (codProd <= 0)
            throw new Exception ("C�digo inv�lido!");

        this.codProd = codProd;
    } 
	
	/** 
     * Muda o c�digo do cliente da venda.
     * Verifica se o par�metro � v�lido e faz o c�digo do cliente da classe receber o passado.
     * @param codCli c�digo novo a ser inclu�do.
     * @throws Exception quando o c�digo � inv�lido.
    */
	public void setCodCli (int codCli) throws Exception
    {
        if (codCli <= 0)
            throw new Exception ("C�digo inv�lido!");

        this.codCli = codCli;
    }
	
	/** 
     * Muda a quantidade do produto na venda.
     * Verifica se o par�metro � v�lido e faz a quantidade da classe receber a passada.
     * @param quantidade quantidade nova a ser inclu�da.
     * @throws Exception quando a quantidade � inv�lida.
    */
	public void setQuantidade(int quantidade) throws Exception
	{
		if(quantidade <= 0)
			throw new Exception("Quantidade inv�lida");
		
		this.quantidade = quantidade;
	}
	
	
	
	/** 
     * Coleta o c�digo da venda.
     * Retorna um inteiro representando o c�digo da venda.
     * @return o c�digo da venda em int.
    */
	public int getCodigo ()
    {
        return this.codigo;
    }
	
	/** 
     * Coleta o c�digo do produto da venda.
     * Retorna um inteiro representando o c�digo do produto da venda.
     * @return o c�digo do produto da venda em int.
    */
	public int getCodProd ()
    {
        return this.codProd;
    }
	
	/** 
     * Coleta o c�digo do cliente da venda.
     * Retorna um inteiro representando o c�digo do cliente da venda.
     * @return o c�digo do cliente da venda em int.
    */
	public int getCodCli ()
    {
        return this.codCli;
    }
	
	/** 
     * Coleta a quantidade da venda.
     * Retorna um inteiro representando a quantidade da venda.
     * @return a quantidade da venda em int.
    */
	public int getQuantidade()
	{
		return this.quantidade;
	}
	
	
	
	/**
    Constroi uma nova inst�ncia da classe PpVenda.
    Para tanto, deve ser fornecido 
    um inteiro, que ser� utilizado como c�digo, 
    um inteiro, que ser� utilizada como c�digo do produto vendido, 
    um inteiro, que ser� utilizado como c�digo do cliente comprador
    e um inteiro, que ser� utilizado como quantidade vendida da inst�ncia rec�m criada.
    @param codigo o inteiro a ser utilizado como c�digo.
    @param codProd o inteiro a ser utilizado como c�digo do produto vendido.
    @param codCli o inteiro a ser utilizado como c�digo do cliente comprador.
    @param quantidade o inteiro a ser utilizado como quantidade vendida.
    @throws Exception se o codigo, o codProd, o codCli ou a quantidade forem inv�lidos.
    */
	public PpVenda(int codigo, int codProd, int codCli, int quantidade) throws Exception
	{
		this.setCodCli(codCli);
		this.setCodigo(codigo);
		this.setCodProd(codProd);
		this.setQuantidade(quantidade);
	}
	
	/**
    Constroi uma c�pia da inst�ncia da classe PpVenda dada.
    Para tanto, deve ser fornecida uma instancia da classe PpVenda para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param vend a inst�ncia da classe PpVenda a ser usada como modelo.
    @throws Exception se vend for null.
    */
	public PpVenda(PpVenda vend) throws Exception
	{
		if(vend == null)
			throw new Exception("Venda � null");
		
		this.setCodigo(vend.codigo);
		this.setCodProd(vend.codProd);
		this.setCodCli(vend.codCli);
		this.setQuantidade(vend.quantidade);
	}
	
	
	/**
    Gera uma representa��o textual de todo o conte�do da venda.
    Produz e resulta um String com o c�digo, o c�digo do produto, o c�digo do cliente e a quantidade da venda.
    @return um String contendo todo o conte�do da venda.
    */
	public String toString()
	{
		String ret = "";
		
		ret += "C�digo.....:" + this.codigo + "\n";
		ret += "CodProd....:"  +this.codigo + "\n";
		ret += "CodCli.....:" + this.codigo + "\n";
		ret += "Quantidade.:" + this.quantidade;
		
		
		return ret;
	}
	
	/**
    Constroi uma c�pia da inst�ncia da classe PpVenda dada.
    Para tanto, foi utilizado o construtor de c�pia, que gera uma de this.
    @return a c�pia da inst�ncia desta venda.
    */
	public Object clone()
	{
		PpVenda ret = null;
		
		try
		{
			ret = new PpVenda(this);
		}
		catch(Exception ex)
		{}
		
		return ret;
	}
	
	/**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de uma venda.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) da venda representado pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento da venda chamante do m�todo.
    */
	public int hashCode()
	{
		int ret = 17;
		
		ret = ret * 17 + new Integer(this.codigo).hashCode();
		ret = ret * 17 + new Integer(this.codProd).hashCode();
		ret = ret * 17 + new Integer(this.codCli).hashCode();
		ret = ret * 17 + new Integer(this.quantidade).hashCode();
		
		if(ret < 0)
			ret = -ret;
		
		return ret;
	}
	
	/**
    Verifica a igualdade entre duas vendas.
    Verifica se o Object fornecido como par�metro representa uma
    venda igual �quela representada pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem vendas iguais, ou false, caso contr�rio.
    */
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		if(obj.getClass() != this.getClass())
			return false;
		
		if(obj == this)
			return true;
		
		
		PpVenda vend = (PpVenda)obj;
		if(this.codigo == vend.codigo && this.codProd == vend.codProd && this.codCli == vend.codCli && this.quantidade == vend.quantidade)
			return true;
		
		return false; //�ltimo caso
	}
}

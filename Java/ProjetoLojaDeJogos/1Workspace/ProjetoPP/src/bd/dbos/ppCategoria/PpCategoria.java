package bd.dbos.ppCategoria;

/**
A classe PpCategoria representa um objeto do banco de dados: DBO.
Essa classe permite a cria��o de um objeto que vir� do banco de dados.
Nela encontramos, por exemplo, equals, toString, setters, getters, construtores, clone e hashCode.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpCategoria implements Cloneable
{
	/** Inteiro que define o c�digo da categoria. */
    protected int    codigo;
    
    /** Cadeia de caracteres que define o nome da categoria. */
    protected String nome;
    
    /** 
     * Muda o c�digo da categoria.
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
     * Muda o nome da categoria.
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
     * Coleta o c�digo da categoria.
     * Retorna um inteiro representando o c�digo da categoria.
     * @return o c�digo da categoria em int.
    */
    public int getCodigo ()
    {
        return this.codigo;
    }
    
    /** 
     * Coleta o nome da categoria.
     * Retorna uma String representando o nome da categoria.
     * @return o nome da categoria em String.
    */
    public String getNome ()
    {
        return this.nome;
    }
    
    /**
    Constroi uma nova inst�ncia da classe PpCategoria.
    Para tanto, deve ser fornecido um inteiro, que ser� utilizado
    como c�digo, e uma cadeia de caracteres, que ser� utilizada como nome da inst�ncia rec�m criada.
    @param codigo o inteiro a ser utilizado como c�digo.
    @param nome a cadeia de caracteres a ser utilizada como nome.
    @throws Exception se o codigo ou o nome forem inv�lidos.
    */
    public PpCategoria (int codigo, String nome) throws Exception
    {
        this.setCodigo   (codigo);
        this.setNome     (nome);
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpCategoria dada.
    Para tanto, deve ser fornecida uma instancia da classe PpCategoria para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param cat a inst�ncia da classe PpCategoria a ser usada como modelo.
    @throws Exception se cat for null.
    */
    public PpCategoria (PpCategoria cat) throws Exception
    {
    	if(cat == null)
    		throw new Exception("Categoria � null");
    	
        this.setCodigo   (cat.codigo);
        this.setNome     (cat.nome);
    }
    
    /**
    Gera uma representa��o textual de todo conte�do da categoria.
    Produz e resulta um String com o c�digo e o nome da categoria.
    @return um String contendo todo o conte�do da categoria.
    */
    public String toString ()
    {
        String ret="";

        ret+="Codigo..: "+this.codigo + "\n";
        ret+="Nome....: "+this.nome;
        return ret;
    }
    
    /**
    Verifica a igualdade entre duas categorias.
    Verifica se o Object fornecido como par�metro representa uma
    categoria igual �quela representada pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem categorias iguais, ou false, caso contr�rio.
    */
    public boolean equals(Object obj)
    {
    	if(obj == null)
    		return false;
    	
    	if(obj.getClass() != this.getClass())
    		return false;
    	
    	if(obj == this)
    		return true;
    	
    	PpCategoria cat = (PpCategoria)obj;
    	if(this.codigo == cat.codigo && this.nome.equals(cat.nome))
    		return true;
    	
    	return false; //�ltimo caso
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpCategoria dada.
    Para tanto, foi utilizado o construtor de c�pia, que gera uma de this.
    @return a c�pia da inst�ncia desta categoria.
    */
    public Object clone()
    {
    	PpCategoria ret = null;
    	
    	try
    	{
    		ret = new PpCategoria(this);
    	}
    	catch(Exception ex)
    	{}
    	
    	return ret;
    }
    
    /**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de uma categoria.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) da categoria representada pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento da categoria chamante do m�todo.
    */
    public int hashCode()
    {
    	int ret = 17;
    	
    	ret = ret * 17 + new Integer(this.codigo).hashCode();
    	ret = ret * 17 + this.nome.hashCode();
    	
    	if(ret < 0)
    		ret = -ret;
    	
    	return ret;
    }
}
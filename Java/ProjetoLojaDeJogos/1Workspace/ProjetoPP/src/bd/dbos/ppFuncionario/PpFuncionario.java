package bd.dbos.ppFuncionario;

/**
A classe PpFuncionario representa um objeto do banco de dados: DBO.
Essa classe permite a cria��o de um objeto que vir� do banco de dados.
Nela encontramos, por exemplo, equals, toString, setters, getters, construtores, clone e hashCode.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpFuncionario implements Cloneable
{
	/** Inteiro que define o c�digo do funcion�rio. */
	protected int    codigo;
	
	/** Cadeia de caracteres que define o nome do funcion�rio. */
	protected String nome;
	
	/** Cadeia de caracteres que define o CPF do funcion�rio. */
	protected String cpf;
	
	/** Cadeia de caracteres que define o telefone do funcion�rio. */
	protected String telefone;
	
	/** Cadeia de caracteres que define o endere�o do funcion�rio. */
	protected String endereco;
	
	/** Cadeia de caracteres que define o email do funcion�rio. */
	protected String email;
	
	/** N�mero flutuante que define o sal�rio do funcion�rio. */
	protected float salario;
    
	
	/** 
     * Muda o c�digo do funcion�rio.
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
     * Muda o nome do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o nome da classe receber o passado.
     * @param nome nome novo a ser inclu�do.
     * @throws Exception quando o nome � inv�lido.
    */
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }
    
    /** 
     * Muda o cpf do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o cpf da classe receber o passado.
     * @param cpf CPF novo a ser inclu�do.
     * @throws Exception quando o cpf � inv�lido.
    */
    public void setCpf(String cpf) throws Exception
    {
    	if(cpf==null || cpf.equals(""))  			// Lembrar de adicionar tamanho do CPF 
    		throw new Exception("CPF n�o fornecido!"); 
    	
    	this.cpf = cpf;
    }
    
    /** 
     * Muda o telefone do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o telefone da classe receber o passado.
     * @param telefone telefone novo a ser inclu�do.
     * @throws Exception quando o telefone � inv�lido.
    */
    public void setTelefone(String telefone) throws Exception
    {
    	if(telefone == null || telefone.equals(""))          // tamanho do telefone
    		throw new Exception("Telefone n�o fornecido!");    
    	
    	this.telefone = telefone;
    }
    
    /** 
     * Muda o endere�o do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o endere�o da classe receber o passado.
     * @param endereco endere�o novo a ser inclu�do.
     * @throws Exception quando o endere�o � inv�lido.
    */
    public void setEndereco(String endereco) throws Exception
    {
    	if(endereco == null || endereco.equals(""))
    		throw new Exception("Endere�o n�o fornecido!");
    	
    	this.endereco = endereco;
    }
    
    /** 
     * Muda o email do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o email da classe receber o passado.
     * @param email email novo a ser inclu�do.
     * @throws Exception quando o email � inv�lido.
    */
    public void setEmail(String email) throws Exception
    {
    	if(email == null || email.equals(""))
    			throw new Exception("Email n�o fornecido!");
    	
    	this.email = email;
    }
    
    /** 
     * Muda o sal�rio do funcion�rio.
     * Verifica se o par�metro � v�lido e faz o sal�rio da classe receber o passado.
     * @param salario sal�rio novo a ser inclu�do.
     * @throws Exception quando o sal�rio � inv�lido.
    */
    public void setSalario(float salario) throws Exception
    {
    	if(salario < 0)
    		throw new Exception("Sal�rio inv�lido!");
    	
    	this.salario = salario;
    }

    
    /** 
     * Coleta o c�digo do funcion�rio.
     * Retorna um inteiro representando o c�digo do funcion�rio.
     * @return o c�digo do funcion�rio em int.
    */
    public int getCodigo ()
    {
        return this.codigo;
    }

    /** 
     * Coleta o nome do funcion�rio.
     * Retorna uma cadeia de caracteres representando o nome do funcion�rio.
     * @return o nome do funcion�rio em String.
    */
    public String getNome ()
    {
        return this.nome;
    }

    /** 
     * Coleta o cpf do funcion�rio.
     * Retorna uma cadeia de caracteres representando o cpf do funcion�rio.
     * @return o cpf do funcion�rio em String.
    */
    public String getCpf  ()
    {
    	return this.cpf;
    }
    
    /** 
     * Coleta o telefone do funcion�rio.
     * Retorna uma cadeia de caracteres representando o telefone do funcion�rio.
     * @return o telefone do funcion�rio em String.
    */
    public String getTelefone()
    {
    	return this.telefone;
    }
    
    /** 
     * Coleta o endere�o do funcion�rio.
     * Retorna uma cadeia de caracteres representando o endere�o do funcion�rio.
     * @return o endere�o do funcion�rio em String.
    */
    public String getEndereco()
    {
    	return this.endereco;
    }
    
    /** 
     * Coleta o email do funcion�rio.
     * Retorna uma cadeia de caracteres representando o email do funcion�rio.
     * @return o email do funcion�rio em String.
    */
    public String getEmail()
    {
    	return this.email;
    }
    
    /** 
     * Coleta o sal�rio do funcion�rio.
     * Retorna um n�mero flutuante representando o sal�rio do funcion�rio.
     * @return o sal�rio do funcion�rio em float.
    */
    public float getSalario()
    {
    	return this.salario;
    }
    
    
    /**
    Constroi uma nova inst�ncia da classe PpFuncionario.
    Para tanto, deve ser fornecido um inteiro, que ser� utilizado
    como c�digo, uma cadeia de caracteres, que ser� utilizada como nome, 
    uma cadeia de caracteres, que ser� utilizada como cpf, 
    uma cadeia de caracteres, que ser� utilizada como telefone,
    uma cadeia de caracteres, que ser� utilizada como endere�o,
    uma cadeia de caracteres, que ser� utilizada como email
    e um n�mero flutuante, que ser� utilizado como sal�rio
    da inst�ncia rec�m criada.
    @param codigo o inteiro a ser utilizado como c�digo.
    @param nome a cadeia de caracteres a ser utilizada como nome.
    @param cpf a cadeia de caracteres a ser utilizada como CPF.
    @param telefone a cadeia de caracteres a ser utilizada como telefone.
    @param endereco a cadeia de caracteres a ser utilizada como endere�o.
    @param email a cadeia de caracteres a ser utilizada como email.
    @param salario o n�mero flutuante a ser utilizado como sal�rio.
    @throws Exception se o codigo, o nome, o cpf, o telefone, o endere�o, o email ou o salario forem inv�lidos.
    */
    public PpFuncionario (int codigo, String nome, String cpf, String telefone, String endereco, String email, float salario) throws Exception
    {
        this.setCodigo   (codigo);
        this.setNome     (nome);
        this.setCpf 	 (cpf);
        this.setTelefone (telefone);
        this.setEndereco (endereco);
        this.setEmail	 (email);
        this.setSalario  (salario);
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpFuncionario dada.
    Para tanto, deve ser fornecida uma instancia da classe PpFuncionario para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param func a inst�ncia da classe PpFuncionario a ser usada como modelo.
    @throws Exception se func for null.
    */
    public PpFuncionario(PpFuncionario func) throws Exception
    {
    	try
    	{
	    	this.setCodigo   (func.getCodigo());
	        this.setNome     (func.getNome());
	        this.setCpf 	 (func.getCpf());
	        this.setTelefone (func.getTelefone());
	        this.setEndereco (func.getEndereco());
	        this.setEmail	 (func.getEmail());
	        this.setSalario  (func.getSalario());
    	}
    	catch(Exception ex)
    	{
    		//Sei que n�o vai dar erro
    	}
    }
    
    /**
    Gera uma representa��o textual de todo conte�do do funcion�rio.
    Produz e resulta um String com o c�digo, o nome, o cpf, o telefone, o endere�o, o email e o sal�rio do funcion�rio.
    @return um String contendo todo o conte�do do funcion�rio.
    */
    public String toString ()
    {
        String ret="";

        ret+="Codigo..: "+this.codigo   + "\n";
        ret+="Nome....: "+this.nome     + "\n";
        ret+="CPF.....: "+this.cpf      + "\n";
        ret+="Telefone: "+this.telefone + "\n";
        ret+="Endere�o: "+this.endereco + "\n";
        ret+="Email...: "+this.email    + "\n";
        ret+="Sal�rio.: "+this.salario;

        return ret;
    }
    
    /**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de um funcion�rio.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) do funcion�rio representado pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento do funcion�rio chamante do m�todo.
    */
    public int hashCode()
    {
    	int ret = 17;
    	
    	ret = ret * 17 + new Integer(this.codigo).hashCode();
    	ret = ret * 17 + this.nome.hashCode();
    	ret = ret * 17 + this.cpf.hashCode();
    	ret = ret * 17 + this.telefone.hashCode();
    	ret = ret * 17 + this.endereco.hashCode();
    	ret = ret * 17 + this.email.hashCode();
    	ret = ret * 17 + new Float(this.salario).hashCode();
    	
    	if(ret < 0)
    		ret = -ret;
    	
    	return ret;
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpFuncionario dada.
    Para tanto, foi utilizado o construtor de c�pia, que gera uma de this.
    @return a c�pia da inst�ncia deste funcion�rio.
    */
    public Object clone()
    {
    	PpFuncionario ret = null;
    	
    	try
    	{
    		ret = new PpFuncionario(this);
    	}
    	catch(Exception ex)
    	{}
    	
    	return ret;
    }
    
    /**
    Verifica a igualdade entre dois funcion�rios.
    Verifica se o Object fornecido como par�metro representa um
    funcion�rio igual �quele representado pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem funcion�rios iguais, ou false, caso contr�rio.
    */
    public boolean equals(Object obj)
    {
    	if(obj == null)
    		return false;
    	
    	if(obj.getClass() != this.getClass())
    		return false;
    	
    	if(obj == this)
    		return true;
    	
    	
    	PpFuncionario func = (PpFuncionario)obj;
    	if(this.codigo == func.codigo && this.nome.equals(func.nome) && this.cpf.equals(func.cpf) && this.telefone.equals(func.telefone) && this.endereco.equals(func.endereco) && this.email.equals(func.email) && this.salario == func.salario)
    		return true;
    	
    	return false; //�ltimo caso
    }
}
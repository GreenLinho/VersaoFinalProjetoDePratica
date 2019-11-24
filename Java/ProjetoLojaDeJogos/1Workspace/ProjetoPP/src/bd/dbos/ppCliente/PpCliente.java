package bd.dbos.ppCliente;

/**
A classe PpCliente representa um objeto do banco de dados: DBO.
Essa classe permite a cria��o de um objeto que vir� do banco de dados.
Nela encontramos, por exemplo, equals, toString, setters, getters, construtores, clone e hashCode.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class PpCliente implements Cloneable
{
	/** Inteiro que define o c�digo do cliente. */
	protected int    codigo;
	
	/** Cadeia de caracteres que define o nome do cliente. */
	protected String nome;
	
	/** Cadeia de caracteres que define o CPF do cliente. */
	protected String cpf;
	
	/** Cadeia de caracteres que define o telefone do cliente. */
	protected String telefone;
	
	/** Cadeia de caracteres que define o endere�o do cliente. */
	protected String endereco;
	
	/** Cadeia de caracteres que define o email do cliente. */
    protected String email;
    
    /** Cadeia de caracteres que define a senha do cliente */
    protected String senha;
 
    
    /** 
     * Muda o c�digo do cliente.
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
     * Muda o nome do cliente.
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
     * Muda o cpf do cliente.
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
     * Muda o telefone do cliente.
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
     * Muda o endere�o do cliente.
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
     * Muda o email do cliente.
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
     * Muda a senha do cliente.
     * Verifica se o par�metro � v�lido e faz a senha da classe receber a passada.
     * @param senha senha nova a ser inclu�da.
     * @throws Exception quando a senha � inv�lida.
    */
    public void setSenha(String senha) throws Exception
    {
    	if(senha == null || senha.equals(""))
			throw new Exception("Senha n�o fornecida!");
	
    	this.senha = senha;
    }

    
    /** 
     * Coleta o c�digo do cliente.
     * Retorna um inteiro representando o c�digo do cliente.
     * @return o c�digo do cliente em int.
    */
    public int getCodigo ()
    {
        return this.codigo;
    }
    
    /** 
     * Coleta o nome do cliente.
     * Retorna uma cadeia de caracteres representando o nome do cliente.
     * @return o nome do cliente em String.
    */
    public String getNome ()
    {
        return this.nome;
    }
    
    /** 
     * Coleta o cpf do cliente.
     * Retorna uma cadeia de caracteres representando o cpf do cliente.
     * @return o cpf do cliente em String.
    */
    public String getCpf  ()
    {
    	return this.cpf;
    }
    
    /** 
     * Coleta o telefone do cliente.
     * Retorna uma cadeia de caracteres representando o telefone do cliente.
     * @return o telefone do cliente em String.
    */
    public String getTelefone()
    {
    	return this.telefone;
    }
    
    /** 
     * Coleta o endere�o do cliente.
     * Retorna uma cadeia de caracteres representando o endere�o do cliente.
     * @return o endere�o do cliente em String.
    */
    public String getEndereco()
    {
    	return this.endereco;
    }
    
    /** 
     * Coleta o email do cliente.
     * Retorna uma cadeia de caracteres representando o email do cliente.
     * @return o email do cliente em String.
    */
    public String getEmail()
    {
    	return this.email;
    }
    
    /** 
     * Coleta a senha do cliente.
     * Retorna uma cadeia de caracteres representando a senha do cliente.
     * @return a senha do cliente em String.
    */
    public String getSenha()
    {
    	return this.senha;
    }

    
    /**
    Constroi uma nova inst�ncia da classe PpCliente.
    Para tanto, deve ser fornecido um inteiro, que ser� utilizado
    como c�digo, uma cadeia de caracteres, que ser� utilizada como nome, uma cadeia de caracteres, que ser� utilizada como cpf, 
    uma cadeia de caracteres, que ser� utilizada como telefone,
    uma cadeia de caracteres, que ser� utilizada como endere�o
    , uma cadeia de caracteres, que ser� utilizada como email
    e uma cadeia de caracteres, que ser� utilizada como senha
    da inst�ncia rec�m criada.
    @param codigo o inteiro a ser utilizado como c�digo.
    @param nome a cadeia de caracteres a ser utilizada como nome.
    @param cpf a cadeia de caracteres a ser utilizada como CPF.
    @param telefone a cadeia de caracteres a ser utilizada como telefone.
    @param endereco a cadeia de caracteres a ser utilizada como endere�o.
    @param email a cadeia de caracteres a ser utilizada como email.
    @param senha a cadeia de caracteres a ser utilizada como senha.
    @throws Exception se o codigo, o nome, o cpf, o telefone, o endere�o, o email ou a senha forem inv�lidos.
    */
    public PpCliente (int codigo, String nome, String cpf, String telefone, String endereco, String email, String senha) throws Exception
    {
        this.setCodigo   (codigo);
        this.setNome     (nome);
        this.setCpf 	 (cpf);
        this.setTelefone (telefone);
        this.setEndereco (endereco);
        this.setEmail	 (email);
        this.setSenha    (senha);
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpCliente dada.
    Para tanto, deve ser fornecida uma instancia da classe PpCliente para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param cli a inst�ncia da classe PpCliente a ser usada como modelo.
    @throws Exception se cli for null.
    */
    public PpCliente(PpCliente cli) throws Exception
    {
    	if(cli == null)
    		throw new Exception("O cliente � null");

    	this.setCodigo   (cli.getCodigo());
        this.setNome     (cli.getNome());
        this.setCpf 	 (cli.getCpf());
        this.setTelefone (cli.getTelefone());
        this.setEndereco (cli.getEndereco());
        this.setEmail	 (cli.getEmail());
        this.setSenha	 (cli.getSenha());
    }

    
    /**
    Gera uma representa��o textual de todo conte�do do cliente.
    Produz e resulta um String com o c�digo, o nome, o cpf, o telefone, o endere�o, o email e a senha do cliente.
    @return um String contendo todo o conte�do do cliente.
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
        ret+="Senha...: "+this.senha;

        return ret;
    }
    
    /**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de um cliente.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) do cliente representado pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento do cliente chamante do m�todo.
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
    	ret = ret * 17 + this.senha.hashCode();
    	
    	if(ret < 0)
    		ret = -ret;
    	
    	return ret;
    }
    
    /**
    Constroi uma c�pia da inst�ncia da classe PpCliente dada.
    Para tanto, foi utilizado o construtor de c�pia, que gera uma de this.
    @return a c�pia da inst�ncia deste cliente.
    */
    public Object clone()
    {
    	PpCliente ret = null;
    	
    	try
    	{
    		ret = new PpCliente(this);
    	}
    	catch(Exception ex)
    	{}
    	
    	return ret;
    }
    
    /**
    Verifica a igualdade entre dois clientes.
    Verifica se o Object fornecido como par�metro representa um
    cliente igual �quele representado pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem clientes iguais, ou false, caso contr�rio.
    */
    public boolean equals(Object obj)
    {
    	if(obj == null)
    		return false;
    	
    	if(obj.getClass() != this.getClass())
    		return false;
    	
    	if(obj == this)
    		return true;
    	
    	
    	PpCliente cli = (PpCliente)obj;
    	if(this.codigo == cli.codigo && this.nome.equals(cli.nome) && this.cpf.equals(cli.cpf) && this.telefone.equals(cli.telefone) && this.endereco.equals(cli.endereco) && this.email.equals(cli.email) && this.senha.equals(cli.senha))
    		return true;
    	
    	return false; //�ltimo caso
    }
}
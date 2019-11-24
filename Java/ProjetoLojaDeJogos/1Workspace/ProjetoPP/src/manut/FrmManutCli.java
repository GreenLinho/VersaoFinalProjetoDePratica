package manut;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.core.MeuResultSet;
import bd.daos.PpClientes;
import bd.daos.PpFuncionarios;
import bd.daos.PpVendas;
import bd.dbos.ppCliente.PpCliente;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
A classe FrmManutCli representa um formul�rio de manuten��o de clientes.
Inst�ncias dessa classe permitem a visualiza��o do formul�rio.
Nela encontramos, por exemplo, uma main e um construtor.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class FrmManutCli extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtSenha;

	/**
	 * Roda a aplica��o.
	 * Cria uma inst�ncia da classe e a coloca como vis�vel.
	 * @param args par�metro adicional passado pelo usu�rio.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManutCli frame = new FrmManutCli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa o formul�rio.
	 * Utiliza vari�veis e m�todos para inicializar o formul�rio.
	 */
	public FrmManutCli() {
		setBackground(new Color(34, 139, 34));
		setTitle("Manuten\u00E7\u00E3o de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha somente este formul�rio
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int codigoCli = Integer.parseInt(txtCodigo.getText());
					
					if(PpClientes.cadastrado(codigoCli))
					{
						PpCliente cli = new PpCliente(PpClientes.getCliente(codigoCli));
						
						txtNome.setText(cli.getNome());
						txtCpf.setText(cli.getCpf());
						txtTelefone.setText(cli.getTelefone());
						txtEndereco.setText(cli.getEndereco());
						txtEmail.setText(cli.getEmail());
						txtSenha.setText(cli.getSenha());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "N�o h� cliente cadastrado com esse c�digo!");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Digite o n�mero corretamente!");
				}
			}
		});
		contentPane.add(btnProcurar, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("Novo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int codigo = Integer.parseInt(txtCodigo.getText());
					String nome = txtNome.getText();
					String cpf = txtCpf.getText();
					String telefone = txtTelefone.getText();
					String endereco = txtEndereco.getText();
					String email = txtEmail.getText();
					String senha = txtSenha.getText();
					
					if(!PpClientes.cadastrado(codigo))
					{
						PpCliente cli = new PpCliente(codigo, nome, cpf, telefone, endereco, email, senha);
						
						try
						{
							PpClientes.incluir(cli);
							JOptionPane.showMessageDialog(null, "Cliente inclu�do com sucesso!");
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "As informa��es digitadas n�o seguem o modelo padr�o");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "J� h� um cliente cadastrado com esse c�digo!");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Digite as informa��es corretamente!");
				}
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("Alterar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int codigo = Integer.parseInt(txtCodigo.getText());
					String nome = txtNome.getText();
					String cpf = txtCpf.getText();
					String telefone = txtTelefone.getText();
					String endereco = txtEndereco.getText();
					String email = txtEmail.getText();
					String senha = txtSenha.getText();
					
					if(PpClientes.cadastrado(codigo))
					{
						PpCliente cli = new PpCliente(codigo, nome, cpf, telefone, endereco, email, senha);
						
						try
						{
							PpClientes.alterar(cli);
							JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "As informa��es digitadas n�o seguem o modelo padr�o");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "N�o h� um cliente cadastrado com esse c�digo!");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Digite as informa��es corretamente!");
				}
			}
		});
		panel.add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int codigo = Integer.parseInt(txtCodigo.getText());
					
					if(PpClientes.cadastrado(codigo))
					{	
						boolean achou = false;
						MeuResultSet result = PpVendas.getVendas();
						while(result.next())
						{
							if(result.getInt(3) == codigo)
							{
								achou = true;
								JOptionPane.showMessageDialog(null, "Este cliente comprou um produto! Ele n�o poder� ser exclu�do at� que a compra seja!");
								break;
							}
						}
						
						if(!achou)
						{
							PpClientes.excluir(codigo);
							JOptionPane.showMessageDialog(null, "Cliente exclu�do com sucesso!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "N�o h� cliente cadastrado com esse c�digo!");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Digite o n�mero corretamente!");
				}
			}
		});
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("  C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBackground(new Color(34, 139, 34));
		panel_1.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigo.setColumns(10);
		panel_1.add(txtCodigo);
		
		JLabel label_1 = new JLabel("  Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBackground(new Color(34, 139, 34));
		panel_1.add(label_1);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNome.setColumns(10);
		panel_1.add(txtNome);
		
		JLabel label_2 = new JLabel("  CPF:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBackground(new Color(34, 139, 34));
		panel_1.add(label_2);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		panel_1.add(txtCpf);
		
		JLabel label_3 = new JLabel("  Telefone:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBackground(new Color(34, 139, 34));
		panel_1.add(label_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefone.setColumns(10);
		panel_1.add(txtTelefone);
		
		JLabel label_4 = new JLabel("  Endere\u00E7o:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBackground(new Color(34, 139, 34));
		panel_1.add(label_4);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		panel_1.add(txtEndereco);
		
		JLabel label_5 = new JLabel("  Email:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBackground(new Color(34, 139, 34));
		panel_1.add(label_5);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		panel_1.add(txtEmail);
		
		JLabel labelSenha = new JLabel("  Senha:");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSenha.setBackground(new Color(34, 139, 34));
		panel_1.add(labelSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSenha.setColumns(10);
		panel_1.add(txtSenha);
	}

}

package relat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.core.MeuResultSet;
import bd.daos.PpProdutos;
import bd.daos.PpVendas;
import bd.dbos.ppProduto.PpProduto;
import bd.dbos.ppVenda.PpVenda;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Font;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
A classe FrmRelatMenos representa um formul�rio de relat�rios dos produtos menos vendidos.
Inst�ncias dessa classe permitem a visualiza��o do formul�rio.
Nela encontramos, por exemplo, uma main e um construtor.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class FrmRelatMenos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblAquiEstoListados;
	private JButton btnAtualizar;

	/**
	 * Roda a aplica��o.
	 * Cria uma inst�ncia da classe e a coloca como vis�vel.
	 * @param args par�metro adicional passado pelo usu�rio.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRelatMenos frame = new FrmRelatMenos();
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
	public FrmRelatMenos() {
		setForeground(new Color(0, 0, 0));
		setTitle("Relat\u00F3rio de Produtos Menos Vendidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha somente este formul�rio
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo do Produto", "Nome do Produto", "Quantidade Vendida"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(101);
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		scrollPane.setViewportView(table);
		
		lblAquiEstoListados = new JLabel("Aqui est\u00E3o listados os produtos cujas vendas s\u00E3o menores ou iguais a um sexto do total");
		lblAquiEstoListados.setForeground(new Color(0, 0, 0));
		lblAquiEstoListados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAquiEstoListados.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAquiEstoListados, BorderLayout.SOUTH);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					MeuResultSet resultProdutos = PpProdutos.getProdutos();
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					
					//Remove as linhas
					int qtasLinhas = modelo.getRowCount();
					for (int i = qtasLinhas - 1; i >= 0; i--) 
					{
					    modelo.removeRow(i);
					}
					
					//Verifica a quantidade de vendas
					MeuResultSet result = PpVendas.getVendas();
					int qtasVendasNoTotal = 0;
					while(result.next())
					{
						qtasVendasNoTotal++;
					}
					int comparador = Math.round(qtasVendasNoTotal / 6.0F);//O comparador � de que os produtos ocupem o equivalente ou menos de um sexto do total de vendas
					
					
					//Verifica quantas vendas h� de cada produto e os coloca ou n�o na tabela com base no comparador
					int i = 1;
					while(resultProdutos.next())
					{		
						result = PpVendas.getVendasDoProduto(i);
						result.absolute(0); //Coloca o "ponteiro" na posi��o 0
						int qtasVendasDoProd = 0;
						while(result.next())
						{
							qtasVendasDoProd++;
						}
						
						if(qtasVendasDoProd <= comparador)
						{
							modelo.addRow(new Object[]{resultProdutos.getInt(1), resultProdutos.getString(2), qtasVendasDoProd});
						}
						
						i++;
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Erro ao gerar o relat�rio!");
				}
			}
		});
		contentPane.add(btnAtualizar, BorderLayout.EAST);
		
		//Faz o mesmo que o bot�o atualizar, mas n�o apaga as linhas j� existentes
		try
		{
			MeuResultSet resultProdutos = PpProdutos.getProdutos();
			modelo = (DefaultTableModel)table.getModel();
			
			MeuResultSet result = PpVendas.getVendas();
			int qtasVendasNoTotal = 0;
			while(result.next())
			{
				qtasVendasNoTotal++;
			}
			int comparador = Math.round(qtasVendasNoTotal / 6.0F);
			
			int i = 1;
			while(resultProdutos.next())
			{		
				result = PpVendas.getVendasDoProduto(i);
				result.absolute(0);
				int qtasVendasDoProd = 0;
				while(result.next())
				{
					qtasVendasDoProd++;
				}
				
				if(qtasVendasDoProd <= comparador)
				{
					modelo.addRow(new Object[]{resultProdutos.getInt(1), resultProdutos.getString(2), qtasVendasDoProd});
				}
				
				i++;
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro ao gerar o relat�rio!");
		}
	}
}

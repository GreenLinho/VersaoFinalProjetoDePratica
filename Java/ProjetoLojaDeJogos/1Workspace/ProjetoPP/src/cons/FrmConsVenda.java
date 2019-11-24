package cons;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.core.MeuResultSet;
import bd.daos.PpVendas;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
A classe FrmConsVenda representa um formul�rio de consulta de vendas.
Inst�ncias dessa classe permitem a visualiza��o do formul�rio.
Nela encontramos, por exemplo, uma main e um construtor.
@author N�colas Maisonnette Duarte.
@since 2019.
*/
public class FrmConsVenda extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Roda a aplica��o.
	 * Cria uma inst�ncia da classe e a coloca como vis�vel.
	 * @param args par�metro adicional passado pelo usu�rio.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsVenda frame = new FrmConsVenda();
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
	public FrmConsVenda() 
	{	
		setTitle("Consulta de Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha somente este formul�rio
		setBounds(100, 100, 850, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					modelo = (DefaultTableModel) table.getModel();
					
					//Remove todas as linhas
					int qtasLinhas = modelo.getRowCount();
					for (int i = qtasLinhas - 1; i >= 0; i--) 
					{
					    modelo.removeRow(i);
					}
					
					//Adiciona todas as linhas dispon�veis
					MeuResultSet result = PpVendas.getVendas();
					while(result.next())
					{
						modelo.addRow(new Object[]{result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)});
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Erro ao coletar as vendas!");
				}
			}
		});
		contentPane.add(btnAtualizar, BorderLayout.SOUTH);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "C\u00F3digo do Produto", "C\u00F3digo do Cliente", "Quantidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		
		try
		{
			//Adiciona todas as linhas dispon�veis
			modelo = (DefaultTableModel) table.getModel();
			MeuResultSet result = PpVendas.getVendas();
			while(result.next())
			{
				modelo.addRow(new Object[]{result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)});
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro ao coletar as vendas!");
		}
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}

package application;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodeSmells extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableLongMethod;
	private  JTable tableGodClass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodeSmells dialog = new CodeSmells();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodeSmells() {
		setTitle("Deteção de Code Smells");
		setBounds(100, 100, 1104, 693);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 39, 526, 565);
		contentPanel.add(scrollPane1);
		
		tableLongMethod = new JTable();
		tableLongMethod.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Method ID", "is Long Method"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane1.setViewportView(tableLongMethod);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(573, 39, 493, 565);
		contentPanel.add(scrollPane2);
		
		tableGodClass = new JTable();
		tableGodClass.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Class", "is God Class"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane2.setViewportView(tableGodClass);
		
		JLabel lblLongMethod = new JLabel("Long Method:");
		lblLongMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLongMethod.setBounds(10, 11, 204, 26);
		contentPanel.add(lblLongMethod);
		
		JLabel lblGodClass = new JLabel("God Class:");
		lblGodClass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGodClass.setBounds(573, 11, 204, 26);
		contentPanel.add(lblGodClass);
		
		JButton btnqualidade = new JButton("Avaliar Qualidade dos Code Smells Detetados");
		btnqualidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnqualidade.setBounds(10, 615, 249, 28);
		contentPanel.add(btnqualidade);
	}
}
package application;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodeSmells extends JDialog {

	private CodeSmellsDetecao codeSmellsDetecao = new CodeSmellsDetecao();
	private CodeSmellsComparar codeSmellsComparar = new CodeSmellsComparar();
	private final JPanel contentPanel = new JPanel();
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
		
		codeSmellsDetecao.setTableLongMethod(new JTable());
		codeSmellsDetecao.getTableLongMethod().setModel(new DefaultTableModel(
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
		scrollPane1.setViewportView(codeSmellsDetecao.getTableLongMethod());
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(573, 39, 493, 565);
		contentPanel.add(scrollPane2);
		
		codeSmellsDetecao.setTableGodClass(new JTable());
		codeSmellsDetecao.getTableGodClass().setModel(new DefaultTableModel(
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
		scrollPane2.setViewportView(codeSmellsDetecao.getTableGodClass());
		
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
				try {
					codeSmellsComparar.compararLongMethod();
					codeSmellsComparar.compararGodClass();
					Chart c = new Chart();
					c.createChart(codeSmellsComparar.getVP1(), codeSmellsComparar.getFP1(), codeSmellsComparar.getVN1(), codeSmellsComparar.getFN1(),"LongMethod");
					c.setVisible(true);
					Chart c1 = new Chart();
					c1.createChart(codeSmellsComparar.getVP2(), codeSmellsComparar.getFP2(), codeSmellsComparar.getVN2(), codeSmellsComparar.getFN2(), "GodClass");
					c1.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnqualidade.setBounds(10, 615, 249, 28);
		contentPanel.add(btnqualidade);
	}
	
	public void detecaoLongMethod (String file, String metrica1 , int valor1,  String andor1, String metrica2, int valor2) throws IOException {
		codeSmellsDetecao.detecaoLongMethod(file, metrica1, valor1, andor1, metrica2, valor2);	
	}
	
	
	public void detecaoGodClass (String file, String metrica3 , int valor3,  String andor2, String metrica4, int valor4) throws IOException {
		codeSmellsDetecao.detecaoGodClass(file, metrica3, valor3, andor2, metrica4, valor4);
	}
	
	public void compararLongMethod() throws IOException {
		codeSmellsComparar.compararLongMethod();
          
	}
	
	public void compararGodClass() throws IOException {
		codeSmellsComparar.compararGodClass();
        
	}
	
	
	
}
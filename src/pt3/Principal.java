package pt3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DatosCiudades datos;
	DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		datos = new DatosCiudades();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setBorder(new CompoundBorder());
		//Para poder seleccionar
        table.setCellSelectionEnabled(true);
        
		String columnas[]= {"Nombre","Comarca","Num. hab","M2"};
		dtm = new DefaultTableModel(columnas,0);
		// Contiene las filas seleccionadas
		ListSelectionModel model=table.getSelectionModel();
		// Define el numero de lineas a seleccionar
		model.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// Listener para cuando sea seleccionado
		model.addListSelectionListener(new ListSelectionListener() {
			
			// Se llama cuando un valor es seleccionado
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String dato = null;
				int[]fila = table.getSelectedRows();
				int[]columna = table.getSelectedColumns();
				for (int i=0;i<fila.length;i++) {
					System.out.println("Fila "+i+" tiene "+columna.length);
					for(int j=0;j<columna.length;j++) {
						dato = (String)table.getValueAt(fila[i], columna[j]);
						System.out.println("Elemento seleccionado "+dato);
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(552, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(263, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

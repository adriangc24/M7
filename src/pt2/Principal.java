package pt2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public int i=0;

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
		ArrayList<String> listaAlumnos = null;
		ArrayList<String> listaMatricula = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaAlumnos = new JLabel("Lista alumnos");
		lblListaAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblAlumnosMatriculados = new JLabel("Alumnos matriculados");
		lblAlumnosMatriculados.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JList listAlumnos = new JList(new DefaultListModel<String>());
		
		JList listMatriculados = new JList(new DefaultListModel<String>());
		
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnQuitar = new JButton("Quitar");
		
		JLabel lblNewLabel = new JLabel("Nuevo alumno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnInscribir = new JButton("Inscribir");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Eliminar alumno seleccionado");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(listAlumnos, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnQuitar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMatricular, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listMatriculados, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(lblListaAlumnos)
							.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
							.addComponent(lblAlumnosMatriculados)))
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInscribir)))
					.addContainerGap(295, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListaAlumnos)
						.addComponent(lblAlumnosMatriculados))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(listAlumnos, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(listMatriculados, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnMatricular)
							.addGap(35)
							.addComponent(btnQuitar)))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnInscribir))
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnNewButton)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		// Añadir elementos a la lista desde codigo
		//((DefaultListModel)(listAlumnos).getModel()).addElement("Jose");
		btnMatricular.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					((DefaultListModel)(listMatriculados).getModel()).addElement(listAlumnos.getSelectedValue());
					((DefaultListModel)(listAlumnos).getModel()).removeElement(listAlumnos.getSelectedValue());

				}
		});
		
		btnQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((DefaultListModel)(listAlumnos).getModel()).addElement(listMatriculados.getSelectedValue());
				((DefaultListModel)(listMatriculados).getModel()).removeElement(listMatriculados.getSelectedValue());

			}
		});
		
		
		
		btnInscribir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				((DefaultListModel)(listAlumnos).getModel()).addElement(textField.getText().toString());
				
				
			}
		});
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				((DefaultListModel)(listMatriculados).getModel()).removeElement(listMatriculados.getSelectedValue());
				((DefaultListModel)(listAlumnos).getModel()).removeElement(listAlumnos.getSelectedValue());

				
			}
		});
		
		

	}
}

package pt1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.lang.UCharacter.JoiningGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	boolean error=false;
	String nombre;
	String ciudad;
	String aficion1, aficion2, aficion3, aficion4;
	String genero;
	public static String aux="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Escoja una opci\u00F3n..", "Barcelona", "Paris", "Bilbao", "Nueva York"}));
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		
		JCheckBox chckbxGolf = new JCheckBox("Golf");
		
		JCheckBox chckbxPadel = new JCheckBox("Padel");
		
		JCheckBox chckbxTenis = new JCheckBox("Tenis");
		
		JCheckBox chckbxPetanca = new JCheckBox("Petanca");
		
		JButton btnNewButton = new JButton("Enviar");
		

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField.getText().isEmpty()||comboBox.getSelectedItem().equals("Escoja una opci\u00F3n..")||(!rdbtnNewRadioButton.isSelected()&&!rdbtnMujer.isSelected())) {
					JOptionPane.showMessageDialog(null,
						    "Uno o mas campos vacíos.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
					error=true;
					
				}
				aux+="Nombre: "+textField.getText();
				aux+="\nCiudad: "+comboBox.getSelectedItem().toString();
				if(chckbxGolf.isSelected()) {
					aux+="\nAfición 1: Golf";
				}
				if(chckbxPadel.isSelected()) {
					aux+="\nAfición 2: Padel";

				}
				if(chckbxTenis.isSelected()) {
					aux+="\nAfición 3: Tenis";

				}
				if(chckbxPetanca.isSelected()) {
					aux+="\nAfición 4: Petanca";

				}
				if(rdbtnMujer.isSelected()) {
					aux+="\nGénero: Mujer";
				}
				if(rdbtnNewRadioButton.isSelected()) {
					aux+="\nGénero: Hombre";

				}
				dispose();
				if(error==false) {
				PrintScreen ps = new PrintScreen();
				ps.setVisible(true);
				}

			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Aficiones");
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9nero:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCiudad)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxGolf)
										.addComponent(chckbxTenis, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addGap(72)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(chckbxPadel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chckbxPetanca, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(61)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNewRadioButton)
										.addComponent(rdbtnMujer)
										.addComponent(lblNewLabel_2)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCiudad))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxGolf)
						.addComponent(chckbxPadel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(chckbxTenis, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxPetanca, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnMujer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

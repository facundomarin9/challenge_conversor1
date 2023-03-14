package proyect;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Conversor Menu v1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxMenu = new JComboBox();
		comboBoxMenu.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		comboBoxMenu.setBounds(40, 117, 284, 47);
		comboBoxMenu.setModel(new DefaultComboBoxModel(new String[] {"Conversor de Unidades","Conversor de Moneda","Conversor de Temperatura"}));
		contentPane.add(comboBoxMenu);
		
		JLabel lblNewLabel = new JLabel("Seleccione una opción");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(104, 51, 171, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(215, 292, 109, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxMenu.getSelectedIndex() == 0) {
					
					ConversorDeUnidades newFrame = null;
					try {
						newFrame = new ConversorDeUnidades();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					newFrame.setVisible(true);
					dispose();
					
				}else if(comboBoxMenu.getSelectedIndex() == 1){
					
					ConversorDeMoneda newFrame = null;
					try {
						newFrame = new ConversorDeMoneda();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					newFrame.setVisible(true);
					dispose();
					
				}else if(comboBoxMenu.getSelectedIndex() == 2) {
					
					ConversorDeTemperatura newFrame = null;
					try {
						newFrame = new ConversorDeTemperatura();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					newFrame.setVisible(true);
					dispose();
					
				}
				
				
			
			}
		});
		btnNewButton_1.setBounds(40, 291, 109, 39);
		contentPane.add(btnNewButton_1);
	}
}

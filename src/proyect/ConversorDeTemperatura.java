package proyect;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import proyect.utilities.Temperaturas;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConversorDeTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeTemperatura frame = new ConversorDeTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ConversorDeTemperatura() throws IOException {
		
		String jsonTemperaturas = "";
		List<Temperaturas> temperaturas = new ArrayList<Temperaturas>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/proyect/utilities/temperaturas.json"));
			String linea;
			while((linea = br.readLine()) != null) {
				jsonTemperaturas += linea;
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Gson gson = new Gson();
		JsonArray array = gson.fromJson(jsonTemperaturas, JsonArray.class);
		for(JsonElement element : array) {
			Temperaturas temp = gson.fromJson(element, Temperaturas.class);
			temperaturas.add(temp);
		}
			
		
		
		
		setTitle("Conversor de Temperaturas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convertir de:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(209, 28, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDe = new JLabel("A:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblDe.setBounds(243, 119, 39, 14);
		contentPane.add(lblDe);
		
	
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kelvin (K)", "Celsius (C)", "Fahrenheit (F)"}));
		comboBox.setBounds(133, 63, 241, 37);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		textField.setBounds(132, 230, 242, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kelvin (K)", "Celsius (C)", "Fahrenheit (F)"}));
		comboBox_1.setBounds(133, 150, 241, 37);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Intercambiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = comboBox.getSelectedIndex();
				comboBox.setSelectedIndex(comboBox_1.getSelectedIndex());
				comboBox_1.setSelectedIndex(temp);
				
				
			}
		});
		btnNewButton_1.setBounds(373, 111, 116, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int comboBox1 = comboBox.getSelectedIndex();
				int comboBox2 = comboBox_1.getSelectedIndex();
				Temperaturas temp = temperaturas.get(comboBox2);
				
				try {
					double textFieldMandar = Double.parseDouble(textField.getText());
					
					if(comboBox1 == comboBox2) {
						JOptionPane.showMessageDialog(btnNewButton, "Son " + textFieldMandar + " " + temperaturas.get(comboBox_1.getSelectedIndex()).getAbrevTemp(), "Conversor de Temperatura", JOptionPane.INFORMATION_MESSAGE );	
					}else {	
						double mostrar = temp.convert(textFieldMandar, comboBox1, comboBox2);
						JOptionPane.showMessageDialog(btnNewButton, "Son " + mostrar + " " + temp.getAbrevTemp(), "Conversor de Temperatura", JOptionPane.INFORMATION_MESSAGE );		
					}	
					int var = JOptionPane.showConfirmDialog(btnNewButton, "Desea Continuar?", "Conversor de Unidades", JOptionPane.YES_NO_CANCEL_OPTION);
					if(var != 0) {
						JOptionPane.showMessageDialog(btnNewButton, "Programa finalizado.", "Conversor de Unidades", JOptionPane.INFORMATION_MESSAGE);
						dispose();	
					}
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(btnNewButton, "No se puede insertar letras ni caracteres especiales. SOLO NÚMEROS.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}		
			}
		});
		
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnNewButton.setBounds(133, 312, 108, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Menu jframe = new Menu();
				jframe.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnNewButton_2.setBounds(266, 312, 108, 30);
		contentPane.add(btnNewButton_2);
		
	}
}

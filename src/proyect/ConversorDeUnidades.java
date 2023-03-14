package proyect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import proyect.utilities.Unidades;
import javax.swing.JTextField;
import java.awt.Color;
public class ConversorDeUnidades extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeUnidades frame = new ConversorDeUnidades();
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
	public ConversorDeUnidades() throws IOException {
		setForeground(Color.DARK_GRAY);
		
		String jsonUnidades = "";
		List<Unidades> unidades = new ArrayList<Unidades>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/proyect/utilities/unidades.json"));
			String linea;
			while((linea = br.readLine()) != null) {
				jsonUnidades += linea;
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Gson gson = new Gson();
		JsonArray array = gson.fromJson(jsonUnidades, JsonArray.class);
		for(JsonElement element : array) {
			Unidades uni = gson.fromJson(element, Unidades.class);
			unidades.add(uni);
		}
		
		setTitle("Conversor de Longitud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kilómetro [km]", "Metro [m]", "Decímetro [dm]", "Centímetro [cm]", "Milímetro [mm]", "Micrómetro [µ]", "Nanómetro [nm]", "Angstrom [Ã]"}));
		comboBox.setBounds(116, 69, 256, 36);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kilómetro [km]", "Metro [m]", "Decímetro [dm]", "Centímetro [cm]", "Milímetro [mm]", "Micrómetro [µ]", "Nanómetro [nm]", "Angstrom [Ã]"}));
		comboBox_1.setBounds(116, 160, 256, 36);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Unidades unidad1 = unidades.get(comboBox.getSelectedIndex());
				Unidades unidad2 = unidades.get(comboBox_1.getSelectedIndex());
				try {
					double numeroInput = Double.parseDouble(textField.getText());
					JOptionPane.showMessageDialog(btnNewButton, "Son " + unidad1.convertir(numeroInput, unidad2) + " " + comboBox_1.getSelectedItem(), "Conversor de Unidades", JOptionPane.INFORMATION_MESSAGE );	
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(btnNewButton, "No se puede insertar letras ni caracteres especiales. SOLO NÚMEROS.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		btnNewButton.setBounds(116, 297, 118, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quiero convertir de:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(167, 27, 180, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(Color.WHITE);
		lblA.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblA.setBounds(234, 127, 20, 14);
		contentPane.add(lblA);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(116, 223, 256, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Intercambiar");
		btnNewButton_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = comboBox.getSelectedIndex();
				comboBox.setSelectedIndex(comboBox_1.getSelectedIndex());
				comboBox_1.setSelectedIndex(temp);
				
			}
		});
		btnNewButton_1.setBounds(370, 122, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu jframe = new Menu();
				jframe.setVisible(true);
				dispose();
				
			}
		});
		btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnSalir.setBounds(254, 297, 118, 36);
		contentPane.add(btnSalir);
	}
}

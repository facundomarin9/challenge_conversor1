package proyect;


import java.awt.EventQueue;   
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import proyect.utilities.Moneda;
import java.awt.Color;

public class ConversorDeMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMonto;
	private JLabel lblSeleccioneLaMoneda;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeMoneda frame = new ConversorDeMoneda();
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
	public ConversorDeMoneda() throws IOException {
		
		String jsonMoneda = "";
		List <Moneda> monedas = new ArrayList<Moneda>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/proyect/utilities/cambio.json"));
			String linea;
			while((linea = br.readLine()) != null) {
				jsonMoneda += linea;	
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Gson gson = new Gson();
		JsonArray array = gson.fromJson(jsonMoneda, JsonArray.class);
		for(JsonElement element : array) {
			
				Moneda mon = gson.fromJson(element, Moneda.class);
				monedas.add(mon);
				
				
			}
			
		
		setTitle("Conversor de Moneda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 290);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese la cantidad de dinero que desee convertir.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(179, 119, 310, 14);
		contentPane.add(lblNewLabel);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		textFieldMonto.setBounds(224, 150, 228, 32);
		contentPane.add(textFieldMonto);
		textFieldMonto.setColumns(10);
		
		lblSeleccioneLaMoneda = new JLabel("Seleccione la moneda a la que deseas convertir tu dinero");
		lblSeleccioneLaMoneda.setForeground(Color.WHITE);
		lblSeleccioneLaMoneda.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblSeleccioneLaMoneda.setBounds(159, 11, 399, 14);
		contentPane.add(lblSeleccioneLaMoneda);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"De ARS a USD ", "De ARS a EUR", "De ARS a GBP", "De ARS a JPY", "De ARS a KRW", "De USD a ARS", "De EUR a ARS", "De GBP a ARS", "De YPY a ARS", "De KRW a ARS"}));
		comboBox.setBounds(225, 46, 228, 32);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Moneda moneda1 = null;
				try {
					Double montoInput = Double.parseDouble(textFieldMonto.getText());
					
					if(comboBox.getSelectedIndex() == 5) {
						Moneda mone = monedas.get(0);
						Double total = mone.convertir(montoInput, mone, true);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + "ARS", "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );
					}else if(comboBox.getSelectedIndex() == 6) {
						Moneda mone = monedas.get(1);
						Double total = mone.convertir(montoInput, mone, true);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + "ARS", "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );	
					}else if(comboBox.getSelectedIndex() == 7) {
						Moneda mone = monedas.get(2);
						Double total = mone.convertir(montoInput, mone, true);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + "ARS", "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );
					}else if(comboBox.getSelectedIndex() == 8) {
						Moneda mone = monedas.get(3);
						Double total = mone.convertir(montoInput, mone, true);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + "ARS", "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );
					}else if(comboBox.getSelectedIndex() == 9) {
						Moneda mone = monedas.get(4);
						Double total = mone.convertir(montoInput, mone, true);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + "ARS", "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );
					}else {	
						moneda1 = monedas.get(comboBox.getSelectedIndex());
						Double total = moneda1.convertir(montoInput, moneda1, false);
						JOptionPane.showMessageDialog(btnNewButton, "Tenés $"+total + " " + moneda1.getNombreMoneda(), "Conversor de Monedas", JOptionPane.INFORMATION_MESSAGE );	
					}	
					int var = JOptionPane.showConfirmDialog(btnNewButton, "Desea Continuar?", "Conversor de Unidades", JOptionPane.YES_NO_CANCEL_OPTION);
					if(var != 0) {
						JOptionPane.showMessageDialog(btnNewButton, "Programa finalizado.", "Conversor de Unidades", JOptionPane.INFORMATION_MESSAGE);
						dispose();	
					}
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(btnNewButton, "No se puede insertar letras ni caracteres especiales. SOLO NÚMEROS.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}	
			

				
				
						
			}});
		btnNewButton.setBounds(224, 208, 106, 32);
		contentPane.add(btnNewButton);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu jframe = new Menu();
				jframe.setVisible(true);
				dispose();
				
			}
		});
		btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnSalir.setBounds(346, 208, 106, 32);
		contentPane.add(btnSalir);
		
		
		
		
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class houses {

	private JFrame frame;
	private JTextField grossinc;
	private JTextField monthlydebt;
	private JTextField rate;
	private JTextField textField_3;
	private JTextField housing1;
	private JTextField housing2;
	private JTextField maxallowed;
	private JTextField financed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					houses window = new houses();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public houses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		grossinc = new JTextField();
		grossinc.setBounds(64, 11, 86, 20);
		panel.add(grossinc);
		grossinc.setColumns(10);
		
		monthlydebt = new JTextField();
		monthlydebt.setBounds(64, 42, 86, 20);
		panel.add(monthlydebt);
		monthlydebt.setColumns(10);
		
		rate = new JTextField();
		rate.setBounds(64, 105, 86, 20);
		panel.add(rate);
		rate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("gross inc");
		lblNewLabel.setBounds(8, 14, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("monthly debt");
		lblNewLabel_1.setBounds(8, 45, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("rate");
		lblNewLabel_2.setBounds(8, 108, 46, 14);
		panel.add(lblNewLabel_2);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "30"}));
		comboBox.setBounds(74, 74, 76, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("term");
		lblNewLabel_3.setBounds(8, 77, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setEnabled(false);
		textField_3.setBounds(64, 136, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDownPayment = new JLabel("down payment");
		lblDownPayment.setBounds(8, 139, 46, 14);
		panel.add(lblDownPayment);
		
		housing1 = new JTextField();
		housing1.setBounds(338, 11, 86, 20);
		panel.add(housing1);
		housing1.setColumns(10);
		
		housing2 = new JTextField();
		housing2.setBounds(338, 42, 86, 20);
		panel.add(housing2);
		housing2.setColumns(10);
		
		maxallowed = new JTextField();
		maxallowed.setBounds(338, 74, 86, 20);
		panel.add(maxallowed);
		maxallowed.setColumns(10);
		
		financed = new JTextField();
		financed.setBounds(338, 105, 86, 20);
		panel.add(financed);
		financed.setColumns(10);
		
		JLabel lblHousingPayment = new JLabel("housing payment");
		lblHousingPayment.setBounds(282, 14, 46, 14);
		panel.add(lblHousingPayment);
		
		JLabel lblHousingOther = new JLabel("housing + other");
		lblHousingOther.setBounds(282, 45, 46, 14);
		panel.add(lblHousingOther);
		
		JLabel lblMaxAllowed = new JLabel("max allowed");
		lblMaxAllowed.setBounds(282, 77, 46, 14);
		panel.add(lblMaxAllowed);
		
		JLabel lblAmountFinanced = new JLabel("amount financed");
		lblAmountFinanced.setBounds(282, 108, 46, 14);
		panel.add(lblAmountFinanced);
		
		JButton btnNewButton = new JButton("calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				final double tgi = Double.parseDouble(grossinc.getText());
				final double tmd = Double.parseDouble(monthlydebt.getText());
				final double intrate = Double.parseDouble(rate.getText());
				final int term = ((Integer)comboBox.getSelectedItem()).intValue();

				double house1 = (tgi/12)*.18;
				double house2 = (tgi/12)*.36 - tmd;
				double monthlyPayment;
				housing1.setText(Double.toString(house1));
				housing2.setText(Double.toString(house2));
				if (house1 < house2){
					
					monthlyPayment = house1;
				}
				else {

					monthlyPayment = house2;
				}
				double numOfPayments = term / 12;
				double monthlyInt = intrate / 12;
				double PV = monthlyPayment / Math.pow(1 + monthlyInt,numOfPayments);
				maxallowed.setText(Double.toString(monthlyPayment));
				financed.setText(Double.toString(PV));

			}
		});
		btnNewButton.setBounds(61, 167, 89, 23);
		panel.add(btnNewButton);
	}

}

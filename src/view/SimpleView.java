package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.CalculationException;
import exceptions.ParserException;
import facade.ApplicationFacade;
import facade.ApplicationFacadeProductive;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
/**
 * Einfache UI-Implementierung generiert von Window Builder
 * Manuelle Anreicherungen sind gekennzeichnet
 *  
 * --> Muss noch erweitert und dekomponiert werden!!!!
 */
public class SimpleView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldInput;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleView frame = new SimpleView();
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
	public SimpleView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldInput = new JTextField();
		textFieldInput.setBounds(141, 10, 197, 26);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);
		
		JLabel lblInput = new JLabel("Eingabe");
		lblInput.setBounds(10, 10, 121, 19);
		contentPane.add(lblInput);
		
		JButton btnEvaluate = new JButton("Auswerten");
// ============== Manuelle Anreicherung Start =======================		
		btnEvaluate.addActionListener((e)->onEvaluateButtonPressed()); 
// ============== Manuelle Anreicherung Ende ========================
		btnEvaluate.setBounds(10, 46, 328, 28);
		contentPane.add(btnEvaluate);
		
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setBounds(10, 90, 469, 26);
		contentPane.add(textFieldResult);
		textFieldResult.setColumns(10);
	}

// =========== Manuelle Anreicherung =============================== 	
	private void onEvaluateButtonPressed() {
		ApplicationFacade facade = new ApplicationFacadeProductive();
		Integer result;
		try {
			result = facade.evaluate(this.textFieldInput.getText());
			this.textFieldResult.setText(result.toString());
		} catch (CalculationException | ParserException e) {
			this.textFieldResult.setText(e.getMessage()); // Fehlermeldung direkt in das Ausgabefeld
			// Alternativ: Separates Ausgabefeld für Fehlertexte anlegen!
		}
	}
}

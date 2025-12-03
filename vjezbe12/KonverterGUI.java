package Vjezbe12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

 public class KonverterGUI {

	  public static void main(String[] args) {

	        final double EUR_USD = 1.10;
	        final double EUR_GBP = 0.85;

	        JFrame prozor = new JFrame("Konverter valuta");
	        prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        prozor.setLayout(new GridLayout(3, 2, 5, 5));

	        JLabel lblEur = new JLabel("EUR");
	        JLabel lblUsd = new JLabel("USD");
	        JLabel lblGbp = new JLabel("GBP");

	        JTextField txtEur = new JTextField();
	        JTextField txtUsd = new JTextField();
	        JTextField txtGbp = new JTextField();

	        prozor.add(lblEur);
	        prozor.add(txtEur);
	        prozor.add(lblUsd);
	        prozor.add(txtUsd);
	        prozor.add(lblGbp);
	        prozor.add(txtGbp);

	        
	        txtEur.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    double eur = Double.parseDouble(txtEur.getText());
	                    double usd = eur * EUR_USD;
	                    double gbp = eur * EUR_GBP;

	                    txtUsd.setText(String.format("%.2f", usd));
	                    txtGbp.setText(String.format("%.2f", gbp));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(
	                            prozor,
	                            "Unesite ispravan broj za EUR.",
	                            "Greška",
	                            JOptionPane.ERROR_MESSAGE
	                    );
	                }
	            }
	        });

	        txtUsd.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    double usd = Double.parseDouble(txtUsd.getText());
	                    double eur = usd / EUR_USD;
	                    double gbp = eur * EUR_GBP;

	                    txtEur.setText(String.format("%.2f", eur));
	                    txtGbp.setText(String.format("%.2f", gbp));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(
	                            prozor,
	                            "Unesite ispravan broj za USD.",
	                            "Greška",
	                            JOptionPane.ERROR_MESSAGE
	                    );
	                }
	            }
	        });

	        txtGbp.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    double gbp = Double.parseDouble(txtGbp.getText());
	                    double eur = gbp / EUR_GBP;
	                    double usd = eur * EUR_USD;

	                    txtEur.setText(String.format("%.2f", eur));
	                    txtUsd.setText(String.format("%.2f", usd));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(
	                            prozor,
	                            "Unesite ispravan broj za GBP.",
	                            "Greška",
	                            JOptionPane.ERROR_MESSAGE
	                    );
	                }
	            }
	        });

	        prozor.setSize(300, 130);
	        prozor.setLocationRelativeTo(null); 
	        prozor.setVisible(true);
	    }
	}
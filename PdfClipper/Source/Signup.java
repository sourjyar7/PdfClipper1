import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private Signup frame;
	private String username="",password_1="",password_2="";
	

	/**
	 * Launch the application.
	 */
/*	public void render() {
		//frame = new Signup();
		//frame.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
	}*/

	/**
	 * Create the frame.
	 */
	public Signup() {
		setTitle("PDF Clipper/Sign Up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				username=textField.getText();
				
	          		
			}
			
			public void keyReleased(KeyEvent e) {
				username=textField.getText();
				
			}
			
			public void keyTyped(KeyEvent arg0) {
				username=textField.getText();
			}
		});
		textField.setBounds(171, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(95, 58, 65, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JPasswordField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				password_1=textField_1.getText();
			}
			
			public void keyReleased(KeyEvent e) {
				password_1=textField_1.getText();
					}
			
			public void keyTyped(KeyEvent arg0) {
				password_1=textField_1.getText();
				
			}
		});
		textField_1.setBounds(171, 126, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(76, 129, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JPasswordField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				password_2=textField_2.getText();
			}
			public void keyReleased(KeyEvent e) {
				password_2=textField_2.getText();
						}
			
			public void keyTyped(KeyEvent arg0) {
				password_2=textField_2.getText();
			
			}
		});
		textField_2.setBounds(171, 157, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setBounds(33, 160, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				 
			    if(password_1.isEmpty() || password_2.isEmpty() || username.isEmpty())
			    {
			    	setVisible(true);
			    	JOptionPane.showMessageDialog(frame, "Blank Fields not allowed");
			    } 
			    else if(password_1.equals(password_2))
					{ try
					 { new User(username,password_1).save();
					   FChooser f=new FChooser();
					 }
					  catch(Exception e1) 
					 {JOptionPane.showMessageDialog(frame, "Oops! Something went wrong.");
					 }
			    	  
			    	}
				else  
				 {  setVisible(true);
					JOptionPane.showMessageDialog(frame, "Passwords Dont Match");}
				
			}
		});
		btnSignUp.setBounds(171, 216, 89, 23);
		contentPane.add(btnSignUp);
		
		setVisible(true);
	}

}

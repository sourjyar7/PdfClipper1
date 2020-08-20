import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	private JFrame frmPdfClipper;
	private JTextField textField;
	private JPasswordField passwordField;
	private String username="",password="";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmPdfClipper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdfClipper = new JFrame();
		
		frmPdfClipper.setBackground(Color.RED);
		frmPdfClipper.setResizable(false);
		frmPdfClipper.setTitle("PDF Clipper");
		frmPdfClipper.setBounds(100, 100, 450, 300);
		frmPdfClipper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdfClipper.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				username=textField.getText();
			}
			
			public void keyReleased(KeyEvent e) {
				username=textField.getText();
				
			}
			
			public void keyTyped(KeyEvent arg0) {
				username=textField.getText();
			}
		});
		textField.setBounds(172, 49, 86, 20);
		frmPdfClipper.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				password=passwordField.getText();
			}
		   
			@SuppressWarnings("deprecation")
			public void keyReleased(KeyEvent e) {
				password=passwordField.getText();
					}
			
			public void keyTyped(KeyEvent arg0) {
				password=passwordField.getText();
				
			}
		});
		passwordField.setBounds(172, 106, 86, 20);
		frmPdfClipper.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(101, 52, 66, 14);
		frmPdfClipper.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(101, 109, 66, 14);
		frmPdfClipper.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPdfClipper.setVisible(false);
				if(password.isEmpty() || username.isEmpty())
			    {
					frmPdfClipper.setVisible(true);
					JOptionPane.showMessageDialog(frmPdfClipper, "Blank Fields not allowed");
			      
			    } 
				else
					{ try {
					  if(new User(username,password).match())
					  {
						  FChooser f=new FChooser();  
					  }
					  else
					  {   frmPdfClipper.setVisible(true);
						  JOptionPane.showMessageDialog(frmPdfClipper, "Access Denied ! Incorrect Username/Password");
					  }
					}
					catch(Exception e1)
					{  frmPdfClipper.setVisible(true); 
						JOptionPane.showMessageDialog(frmPdfClipper, "Please Signup first !");
					  	
					}
				   }	
				
			}
		});
		btnLogin.setBounds(169, 169, 89, 23);
		frmPdfClipper.getContentPane().add(btnLogin);
		
		JLabel lblNewUserSign = new JLabel("New User? Sign Up ");
		lblNewUserSign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmPdfClipper.setVisible(false);
				Signup s=new Signup();
				//s.render();
			}
		});
		lblNewUserSign.setBounds(157, 216, 155, 14);
		frmPdfClipper.getContentPane().add(lblNewUserSign);
		
		
		

		

	
		
		 
		
		
	
	
	
	}
}

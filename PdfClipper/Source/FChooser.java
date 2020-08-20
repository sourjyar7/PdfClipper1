import java.awt.BorderLayout;
import java.io.File;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FChooser extends JFrame {

	private JPanel contentPane;
    private File folder;
    private JSpinner spinner;
    private JTextField textField;
    private String text;
    
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FChooser() {
		setTitle("PDF Clipper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChooseFile = new JButton("Choose Source Folder");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fc.showOpenDialog(btnChooseFile);
				 
				if (returnVal == JFileChooser.APPROVE_OPTION) 
			            {folder = fc.getSelectedFile();
				text=folder.getAbsolutePath();
				text=text.substring(0,text.lastIndexOf('\\')+1);
				text+=folder.getName()+"_clipped";
				textField.setText(text);
			            }
			   
			}
		});
		btnChooseFile.setBounds(133, 52, 170, 23);
		contentPane.add(btnChooseFile);
		
	    spinner = new JSpinner();
		spinner.setBounds(258, 140, 39, 20);
		contentPane.add(spinner);
		
		JLabel lblNoofPages = new JLabel("No.of Pages");
		lblNoofPages.setBounds(159, 143, 75, 14);
		contentPane.add(lblNoofPages);
		
		JButton btnClipPdf = new JButton("Clip Pdf");
		btnClipPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int pages= (int) spinner.getValue();
				 File []files=folder.listFiles();
				 File temp=new File(text);
					temp.mkdir();
					
				    App app=new App(folder,files,pages,text);
				    app.execute();
			}
		});
		btnClipPdf.setBounds(159, 194, 102, 23);
		contentPane.add(btnClipPdf);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.print("hi");
				text=textField.getText();
				}
			public void keyReleased(KeyEvent e) {
				System.out.print("hi");
				text=textField.getText();
			}
			
			public void keyTyped(KeyEvent arg0) {
				System.out.print("hi");
				text=textField.getText();
			}
		});
		
		textField.setBounds(159, 98, 161, 20);
		contentPane.add(textField);
		textField.setColumns(Integer.MAX_VALUE);
		
		JLabel lblNewLabel = new JLabel("Output Folder   :");
		lblNewLabel.setBounds(57, 101, 102, 14);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}
}

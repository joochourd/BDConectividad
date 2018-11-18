package mongoConnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GuiMongo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUsr;
	private JTextField txtContr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMongo frame = new GuiMongo();
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
	public GuiMongo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(187, 27, 82, 24);
		contentPane.add(lblLogIn);
		
		final JLabel lblNombreDe = new JLabel("Nombre Usuario");
		lblNombreDe.setBounds(60, 62, 150, 24);
		contentPane.add(lblNombreDe);
		
		JLabel lblContrasenia = new JLabel("Apellido");
		lblContrasenia.setBounds(60, 97, 150, 24);
		contentPane.add(lblContrasenia);
		
		txtNomUsr = new JTextField();
		txtNomUsr.setBounds(243, 62, 86, 20);
		contentPane.add(txtNomUsr);
		txtNomUsr.setColumns(10);
		
		txtContr = new JTextField();
		txtContr.setBounds(243, 99, 86, 20);
		contentPane.add(txtContr);
		txtContr.setColumns(10);
		
		
		final JLabel lblUsuarioEncontrado= new JLabel("Joaco fue encontrado");
		lblUsuarioEncontrado.setBounds(60, 130, 300, 24);
		contentPane.add(lblUsuarioEncontrado);
		
		
		
		JButton btnIniciarSesion = new JButton("Agregar Usuario");
		btnIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					MongoConnection.setNames(txtContr.getText(), txtNomUsr.getText());
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		btnIniciarSesion.setBounds(60, 200, 150, 31);
		contentPane.add(btnIniciarSesion);
		
		JButton btnCancelar = new JButton("Buscar Usuario");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblUsuarioEncontrado.setText("Mail: "+MongoConnection.getNames(txtNomUsr.getText()));
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancelar.setBounds(253, 200, 150, 33);
		contentPane.add(btnCancelar);
		
	}

}

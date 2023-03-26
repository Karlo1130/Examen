import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame{

	private String anterior = "login";
	private String actual = "login";
	private String usuario;
	public JPanel panel = null;
	
	public Ventana() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setTitle("Hola zumaya :D");
		this.setSize(700, 800);

		panel = editar();
		
		this.add(panel);
		/*repaint();
		revalidate();
		int cont = 5000;
		for (int i=0; i<cont+1;i++) {
			if (i >= cont) {
				actual = "login";
				cont = -1;
			}
		}*/
		
		limpiarVentana();
		/*JScrollPane test = new JScrollPane(new ListaDeUsuarios());
		this.add(test);
		*/
		this.repaint();
		this.revalidate();
	}
	
	public void limpiarVentana() {
		if(panel!= null) {
			this.remove(panel);
		}
		
		if(actual.equals("splash")){
			panel = splash(); 

			this.add(panel);

			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("login")){
			panel = login(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("registro")){
			panel = registro();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("main")){
			panel = menuPrincipal();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("editar")){
			panel = editar();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
	}
	
	///////////////////////////////////////// LOG IN JAJAJA /////////////////////////////////////////////
	
	public JPanel splash() {
		anterior = actual;
		actual = "splash";

		JPanel jp1 = new JPanel();
		jp1.setSize(700, 800);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#5ED6DF"));

		ImageIcon imagen = new ImageIcon("Tortu.png");
		JLabel tortu = new JLabel();
		tortu.setBounds(250, 100, 200, 200);
		tortu.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
		tortu.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortu);

		JProgressBar bar = new JProgressBar(0,100);
		bar.setBounds(150,400,400,80);
		jp1.add(bar);

		try {
			for(int i=0; i<=100;i++) {
				Thread.sleep(10);
				bar.setValue(i);
			}
		}catch(Exception e) {

		}
		if(bar.getValue() == 100) {
			anterior = actual;
			actual = "login";
			limpiarVentana();

			repaint();
			revalidate();
		}

		return jp1;
	}
	
	///////////////////////////////////////// LOG IN JAJAJA /////////////////////////////////////////////
	
	public JPanel login() {

		this.setJMenuBar(null);

		JPanel jp1 = new JPanel();
		jp1.setSize(700,800);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#5ED6DF"));

		//titulo
		JLabel title = new JLabel("Accede a tu cuenta",JLabel.CENTER);
		title.setFont(new Font("Times new roman", Font.BOLD,40));
		title.setSize(400, 40);
		title.setLocation(150, 40);
		title.setOpaque(true);
		title.setBackground(Color.decode("#5ED6DF"));
		jp1.add(title);

		ImageIcon imagen = new ImageIcon("TortuLogin.png");
		JLabel tortuLogin = new JLabel();
		tortuLogin.setBounds(275, 140, 150, 150);
		tortuLogin.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
		tortuLogin.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortuLogin);

		JLabel nombre = new JLabel("Ingrese usuario: ",JLabel.LEFT);
		nombre.setFont(new Font("Open sans", Font.BOLD,20));
		nombre.setSize(300, 20);
		nombre.setLocation(200, 350);
		nombre.setOpaque(true);
		nombre.setBackground(Color.decode("#5ED6DF"));
		nombre.setForeground(Color.white);
		jp1.add(nombre);

		JTextField username = new JTextField();
		username.setSize(300,30);
		username.setLocation(200, 370);
		jp1.add(username);

		JLabel contraseña = new JLabel("Ingrese Contraseña: ",JLabel.LEFT);
		contraseña.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña.setSize(300, 20);
		contraseña.setLocation(200, 440);
		contraseña.setOpaque(true);
		contraseña.setBackground(Color.decode("#5ED6DF"));
		contraseña.setForeground(Color.white);
		jp1.add(contraseña);

		JPasswordField password = new JPasswordField();
		password.setSize(300, 30);
		password.setLocation(200, 460);
		jp1.add(password);


		ImageIcon logImagen = new ImageIcon("LogIn.png");
		JButton btnAccess = new JButton();
		btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnAccess.setSize(60,60);
		btnAccess.setLocation(400,560);
		jp1.add(btnAccess);

		JLabel login = new JLabel("Ingresar");
		login.setFont(new Font("Open sans", Font.BOLD,20));
		login.setBounds(400,500,100,100);
		login.setBackground(Color.decode("#5ED6DF"));
		login.setForeground(Color.white);
		jp1.add(login);

		ImageIcon returnImagen = new ImageIcon("Return.png");
		JButton btnReturn = new JButton();
		btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnReturn.setSize(60,60);
		btnReturn.setLocation(220,560);
		jp1.add(btnReturn);

		JLabel cancelar = new JLabel("Cancelar");
		cancelar.setFont(new Font("Open sans", Font.BOLD,20));
		cancelar.setBounds(200,500,100,100);
		cancelar.setBackground(Color.decode("#5ED6DF"));
		cancelar.setForeground(Color.white);
		jp1.add(cancelar);

		btnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
					String line = reader.readLine();
					
					String[] lineArray = null;
					
					String tempPassword = new String(password.getPassword());
					usuario = username.getText();
					
					boolean match = false;
					
					while (line != null && match == false) {
						lineArray = line.split(", ");

						if(usuario.equals(lineArray[0]) && tempPassword.equals(lineArray[4])) {
							match = true;
							
						}
					
						line = reader.readLine();
					}
					
					reader.close();
					
					if(!match)
						JOptionPane.showMessageDialog(jp1, "Error al iniciar sesion", "ERROR", JOptionPane.ERROR_MESSAGE);
					else
					{
						anterior = actual;
						actual = "main";
						limpiarVentana();
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				

			}

		});
		
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cerrarVentana();
			}
		});

		//this.add(jp1);
		return jp1;
	}
	
	/////////////////////////////////////// MENU PRINCIPAL //////////////////////////////////////////////
	
	public JPanel menuPrincipal() {

		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#C45EDF"));

		JLabel contraseña = new JLabel("BIENVENIDO "+" "+usuario,JLabel.CENTER);
		contraseña.setFont(new Font("Open sans", Font.BOLD,40));
		contraseña.setSize(700, 60);
		contraseña.setLocation(0, 150);
		contraseña.setOpaque(true);
		contraseña.setBackground(Color.decode("#C45EDF"));
		contraseña.setForeground(Color.white);
		jp1.add(contraseña);

		ImageIcon imagen = new ImageIcon("Bienvenido.png");
		JLabel tortuLogin = new JLabel();
		tortuLogin.setBounds(225, 300, 250, 250);
		tortuLogin.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH)));
		tortuLogin.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortuLogin);

		jp1.add(Menu());
		this.setJMenuBar(Menu());

		return jp1;
	}
	
	////////////////////////////////////////MENU ///////////////////////////////////////////////////////
	
	public JMenuBar Menu() {

		JMenuBar jmb1 = new JMenuBar();
		JMenu jm1 = new JMenu("Cuenta");
		JMenu jm2 = new JMenu("Usuarios");
		JMenu jm3 = new JMenu("Ayuda");

		JMenuItem jmi1 = new JMenuItem("Editar mi cuenta");
		JMenuItem jmi2 = new JMenuItem("Cerrar sesión");
		JMenuItem jmi3 = new JMenuItem("Lista de usuarios");
		JMenuItem jmi4 = new JMenuItem("Crear usuario");
		JMenuItem jmi5 = new JMenuItem("¿Cómo crear usuarios?");

		jmb1.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);

		jmb1.add(jm2);
		jm2.add(jmi3);
		jm2.add(jmi4);

		jmb1.add(jm3);
		jm3.add(jmi5);

		//ACTION LISTENERS JAJAJJAA
		ActionListener accion1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "editar";

				limpiarVentana();
			}
		};
				ActionListener accion2 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						anterior = actual;
						actual = "login";
						JOptionPane.showMessageDialog(null,"Sesión cerrada.");

						limpiarVentana();
					}
				};
				jmi1.addActionListener(accion1);
				jmi2.addActionListener(accion2);

		return jmb1;
	}
	
	//////////////////////////////////////////EDITAR //////////////////////////////////////////////////
	
	public JPanel editar() {

		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#7AE9FF"));

		JLabel title = new JLabel("Cuenta personal",JLabel.CENTER);
		title.setBounds(0, 50, 700, 40);
		title.setFont(new Font("Open sans", Font.BOLD,40));
		title.setOpaque(true);
		title.setBackground(Color.decode("#7AE9FF"));
		title.setForeground(Color.white);
		jp1.add(title);

		ImageIcon imagen = new ImageIcon("Cuenta.png");
		JLabel tortu = new JLabel();
		tortu.setBounds(250, 120, 200, 200);
		tortu.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
		tortu.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortu);

		JLabel nombre = new JLabel("Nombre: ",JLabel.LEFT);
		nombre.setFont(new Font("Open sans", Font.BOLD,20));
		nombre.setBounds(80,360,100,20);
		jp1.add(nombre);

		JTextField nombreText = new JTextField("Nombre");
		nombreText.setBounds(80, 380, 520, 30);
		jp1.add(nombreText);

		JLabel apellidos = new JLabel("Apellidos: ",JLabel.LEFT);
		apellidos.setFont(new Font("Open sans", Font.BOLD,20));
		apellidos.setBounds(80,420,100,20);
		jp1.add(apellidos);

		JTextField apellidosText = new JTextField("Apellidos");
		apellidosText.setBounds(80, 440, 520, 30);
		jp1.add(apellidosText);

		JLabel email = new JLabel("Email: ",JLabel.LEFT);
		email.setFont(new Font("Open sans", Font.BOLD,20));
		email.setBounds(80,480,100,20);
		jp1.add(email);

		JTextField emailText = new JTextField("Email");
		emailText.setBounds(80, 500, 520, 30);
		jp1.add(emailText);

		JLabel contraseña = new JLabel("Contraseña: ",JLabel.LEFT);
		contraseña.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña.setBounds(80,540,140,20);
		jp1.add(contraseña);

		JPasswordField contraseñaText = new JPasswordField("Contraseña");
		contraseñaText.setBounds(80, 560, 520, 30);
		jp1.add(contraseñaText);



		ImageIcon logImagen = new ImageIcon("LogIn.png");
		JButton btnAccess = new JButton();
		btnAccess.setBackground(Color.decode("#00D5FF"));
		btnAccess.setBorder(new EmptyBorder(3,3,3,3));
		btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnAccess.setSize(60,60);
		btnAccess.setLocation(540,640);
		jp1.add(btnAccess);

		JLabel login = new JLabel("Adelante");
		login.setFont(new Font("Open sans", Font.BOLD,20));
		login.setBounds(540,580,100,100);
		login.setForeground(Color.white);
		jp1.add(login);

		ImageIcon returnImagen = new ImageIcon("Return.png");
		JButton btnReturn = new JButton();
		btnReturn.setBackground(Color.decode("#00D5FF"));
		btnReturn.setBorder(new EmptyBorder(3,3,3,3));
		btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnReturn.setSize(60,60);
		btnReturn.setLocation(80,640);
		jp1.add(btnReturn);

		btnReturn.addMouseListener(new MouseListener() {

			public void mouseEntered(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#02B6DA"));
			}
			public void mouseExited(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#00D5FF"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnAccess.addMouseListener(new MouseListener() {

			public void mouseEntered(MouseEvent e) {
				btnAccess.setBackground(Color.decode("#02B6DA"));
			}
			public void mouseExited(MouseEvent e) {
				btnAccess.setBackground(Color.decode("#00D5FF"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel returnn = new JLabel("Regresar");
		returnn.setFont(new Font("Open sans", Font.BOLD,20));
		returnn.setBounds(80,580,100,100);
		//returnn.setBackground(Color.decode("#5ED6DF"));
		returnn.setForeground(Color.white);
		jp1.add(returnn);

		JPanel jp2 = new JPanel();
		jp2.setBounds(40, 340, 600, 370);
		jp2.setBackground(Color.decode("#00D5FF"));
		//jp2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Hola",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION));
		jp1.add(jp2);

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = anterior;
				anterior = actual;
				actual = aux;
				limpiarVentana();
			}
		});
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				actualizarUsuario(nombreText, apellidosText, emailText, contraseñaText);
				
				JOptionPane.showMessageDialog(null,"Datos actualizados con exito.");
				String aux = anterior;
				anterior = actual;
				actual = aux;
				
				limpiarVentana();

			}
		});

		return jp1;
	}
	
	
	//REGISTRO
	
	public JPanel registro() {
		
		JPanel jp2 = new JPanel();
		jp2.setSize(500, 700);
		jp2.setLocation(0, 0);
		jp2.setLayout(null);
		jp2.setBackground(Color.decode("#C45EDF"));
		
		//titulo
		JLabel titleR = new JLabel("Registro nuevo usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(true);
		titleR.setBackground(Color.green);
		jp2.add(titleR);
		
		JLabel tag1R = new JLabel("Ingrese el nombre de usuario: ",JLabel.CENTER);
		tag1R.setSize(250, 20);
		tag1R.setLocation(120, 80);
		tag1R.setOpaque(true);
		tag1R.setBackground(Color.black);
		tag1R.setForeground(Color.white);
		jp2.add(tag1R);
		
		JTextField usernameR = new JTextField("");
		usernameR.setSize(250, 40);
		usernameR.setLocation(120, 100);
		jp2.add(usernameR);
		
		JLabel tag2R = new JLabel("Ingrese el correo electrónico: ",JLabel.CENTER);
		tag2R.setSize(250, 20);
		tag2R.setLocation(120, 140);
		tag2R.setOpaque(true);
		tag2R.setBackground(Color.black);
		tag2R.setForeground(Color.white);
		jp2.add(tag2R);
		
		JPasswordField passwordR = new JPasswordField();
		passwordR.setSize(250, 40);
		passwordR.setLocation(120, 160);
		jp2.add(passwordR);
		
		JLabel tag3 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
		tag3.setSize(250, 20);
		tag3.setLocation(120, 210);
		tag3.setOpaque(true);
		tag3.setBackground(Color.black);
		tag3.setForeground(Color.white);
		jp2.add(tag3);
		
		JTextField name = new JTextField("");
		name.setSize(250, 40);
		name.setLocation(120, 250);
		jp2.add(name);
		
		JLabel tag4 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
		tag4.setSize(250, 20);
		tag4.setLocation(120, 300);
		tag4.setOpaque(true);
		tag4.setBackground(Color.black);
		tag4.setForeground(Color.white);
		jp2.add(tag4);
		
		JTextField lastname = new JTextField("");
		lastname.setSize(250, 40);
		lastname.setLocation(120, 340);
		jp2.add(lastname);
		
		JButton btnAdd = new JButton("R E G I S T R O");
		btnAdd.setSize(250,40);
		btnAdd.setLocation(120, 390);
		jp2.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "login";
				
				limpiarVentana();
				
			}
			
		});
		
		return jp2;
	}
	
	public void actualizarUsuario(JTextField nombreText, JTextField apellidosText, 
			JTextField emailText, JPasswordField contraseñaText) {
		String archivo = "users.txt";
		
		try {
			File archivoTemporal = new File("archivoTemporal");
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));
			
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();
			
			String[] lineArray = null;
			
			boolean match = false;

			String contraseña = new String(contraseñaText.getPassword());
			
			String nuevosDatos = usuario+", "+
					nombreText.getText()+", "+
					apellidosText.getText()+", "+
					emailText.getText()+", "+
					contraseña;
			
			while (line != null) {
				lineArray = line.split(", ");

				if(!usuario.equals(lineArray[0])) {
					writer.write(line);
					writer.newLine();
					
				} else {
					writer.write(nuevosDatos);
					writer.newLine();
				}
			
				line = reader.readLine();
			}
			
			reader.close();
			writer.close();
			
			File borrador = new File(archivo);
			borrador.delete();
			
			archivoTemporal.renameTo(borrador);
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void cerrarVentana() {
		this.dispose();
	}
}
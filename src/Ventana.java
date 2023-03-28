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

public class Ventana extends JFrame{

	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	private String usuario;
	private String email;
	private int posicionUsuario;
	public JComboBox seleccionUsuario; 
	public JButton boton;
	
	public Ventana() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setTitle("Hola zumaya :D");
		this.setSize(700, 800);
		
		limpiarVentana();

		this.repaint();
		this.revalidate();
	}
	
	public void limpiarVentana() {
		if(panel!= null) {
			this.remove(panel);
		}
		if(actual.equals("login")){
			panel = login(); 
			
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
		if(actual.equals("tabla")){
			panel = pantallaTabla();
			
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
		if(actual.equals("editarUser")){
			panel = editarUser();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("agregar")){
			panel = agregar();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("info")){
			panel = info();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
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


		//BOTONES
		ImageIcon logImagen = new ImageIcon("LogIn.png");
		JButton btnAccess = new JButton();
		btnAccess.setContentAreaFilled(false);
		btnAccess.setOpaque(true);
		btnAccess.setBackground(Color.decode("#5ED6DF"));
		btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnAccess.setSize(60,60);
		btnAccess.setLocation(440,570);
		jp1.add(btnAccess);

		JLabel login = new JLabel("Adelante",JLabel.RIGHT);
		login.setFont(new Font("Open sans", Font.BOLD,20));
		login.setBounds(400,500,100,100);
		login.setForeground(Color.white);
		jp1.add(login);
		
		ImageIcon returnImagen = new ImageIcon("Return.png");
		JButton btnReturn = new JButton();
		btnReturn.setBackground(Color.decode("#5ED6DF"));
		btnReturn.setBorder(new EmptyBorder(3,3,3,3));
		btnReturn.setContentAreaFilled(false);
		btnReturn.setOpaque(true);
		btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnReturn.setSize(60,60);
		btnReturn.setLocation(200,570);
		jp1.add(btnReturn);
		
		JLabel returnn = new JLabel("Cancelar",JLabel.LEFT);
		returnn.setFont(new Font("Open sans", Font.BOLD,20));
		returnn.setBounds(200,500,100,100);
		returnn.setForeground(Color.white);
		jp1.add(returnn);
		
		btnReturn.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#02B6DA"));
			}
			public void mouseExited(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#5ED6DF"));
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
				btnAccess.setBackground(Color.decode("#5ED6DF"));
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
					int aux = 0;
					
					while (line != null && match == false) {
						lineArray = line.split(", ");

						if(usuario.equals(lineArray[0]) && tempPassword.equals(lineArray[4])) {
							email = lineArray[3];
							posicionUsuario  = aux;
							match = true;
							
						}
						aux++;
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
				ActionListener accion3 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						anterior = actual;
						actual = "tabla";

						limpiarVentana();
					}
				};
				ActionListener accion4 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						anterior = actual;
						actual = "agregar";

						limpiarVentana();
					}
				};
				ActionListener accion5 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						anterior = actual;
						actual = "info";

						limpiarVentana();
					}
				};
				jmi1.addActionListener(accion1);
				jmi2.addActionListener(accion2);
				jmi3.addActionListener(accion3);
				jmi4.addActionListener(accion4);
				jmi5.addActionListener(accion5);

		return jmb1;
	}
	
	/////////////////////////////////// TABLAAAAAAAAAAAAAA /////////////////////////////////////////////
	
	public JPanel pantallaTabla() {
		
		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#7AE9FF"));
		JScrollPane test = new JScrollPane(new ListaDeUsuarios(email));
		test.setVisible(true);
		test.setBounds(50,300,600,400);
		jp1.add(test);
		
		String[] usuarios = new String[getNumeroUsuarios()];

		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();
			
			String[] lineArray = null;
			int aux = 0;
			
			while (line != null) {
				lineArray = line.split(", ");
				
				usuarios[aux]= lineArray[0];

				aux++;
				
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		seleccionUsuario = new JComboBox(usuarios);
		seleccionUsuario.setBounds(75, 200, 550, 40);
		seleccionUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		seleccionUsuario.setMaximumRowCount(6);
		seleccionUsuario.setVisible(true);
		jp1.add(seleccionUsuario);
		
		boton = new JButton();
		boton = new JButton((String)seleccionUsuario.getSelectedItem());
		boton.setBounds(75, 250, 550, 40);
		boton.setVisible(true);
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		jp1.add(boton);

		seleccionUsuario.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionUsuario.repaint();
				seleccionUsuario.revalidate();
				boton.setText((String)seleccionUsuario.getSelectedItem());
				repaint();
				revalidate();
				
			}
		});
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "editarUser";
				
				limpiarVentana();
			}
			
		});
		
		repaint();
		revalidate();
		return jp1;
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

		JTextField nombreText = new JTextField();
		nombreText.setBounds(80, 380, 520, 30);
		jp1.add(nombreText);

		JLabel apellidos = new JLabel("Apellidos: ",JLabel.LEFT);
		apellidos.setFont(new Font("Open sans", Font.BOLD,20));
		apellidos.setBounds(80,420,100,20);
		jp1.add(apellidos);

		JTextField apellidosText = new JTextField();
		apellidosText.setBounds(80, 440, 520, 30);
		jp1.add(apellidosText);

		JLabel email = new JLabel("Email: ",JLabel.LEFT);
		email.setFont(new Font("Open sans", Font.BOLD,20));
		email.setBounds(80,480,100,20);
		jp1.add(email);

		JTextField emailText = new JTextField();
		emailText.setBounds(80, 500, 520, 30);
		jp1.add(emailText);

		JLabel contraseña = new JLabel("Contraseña: ",JLabel.LEFT);
		contraseña.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña.setBounds(80,540,140,20);
		jp1.add(contraseña);

		JPasswordField contraseñaText = new JPasswordField();
		contraseñaText.setBounds(80, 560, 520, 30);
		jp1.add(contraseñaText);



		//BOTONES
				ImageIcon logImagen = new ImageIcon("LogIn.png");
				JButton btnAccess = new JButton();
				btnAccess.setContentAreaFilled(false);
				btnAccess.setOpaque(true);
				btnAccess.setBackground(Color.decode("#00D5FF"));
				btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
				btnAccess.setSize(60,60);
				btnAccess.setLocation(540,640);
				jp1.add(btnAccess);

				JLabel login = new JLabel("Adelante",JLabel.RIGHT);
				login.setFont(new Font("Open sans", Font.BOLD,20));
				login.setBounds(500,570,100,100);
				login.setForeground(Color.white);
				jp1.add(login);
				
				ImageIcon returnImagen = new ImageIcon("Return.png");
				JButton btnReturn = new JButton();
				btnReturn.setBackground(Color.decode("#00D5FF"));
				btnReturn.setBorder(new EmptyBorder(3,3,3,3));
				btnReturn.setContentAreaFilled(false);
				btnReturn.setOpaque(true);
				btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
				btnReturn.setSize(60,60);
				btnReturn.setLocation(80,640);
				jp1.add(btnReturn);
				
				JLabel returnn = new JLabel("Cancelar",JLabel.LEFT);
				returnn.setFont(new Font("Open sans", Font.BOLD,20));
				returnn.setBounds(80,570,100,100);
				returnn.setForeground(Color.white);
				jp1.add(returnn);
				
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

		JPanel jp2 = new JPanel();
		jp2.setBounds(40, 340, 600, 370);
		jp2.setBackground(Color.decode("#00D5FF"));
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
				
				String aux = anterior;
				anterior = actual;
				actual = aux;
				
				limpiarVentana();

			}
		});

		return jp1;
	}
	
	////////////////////////////////////////// EDITAR USUARIO //////////////////////////////////////////////
	
	public JPanel editarUser() {

		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#7AE9FF"));

		JLabel title = new JLabel("Editar usuario",JLabel.CENTER);
		title.setBounds(0, 30, 700, 50);
		title.setFont(new Font("Open sans", Font.BOLD,40));
		title.setOpaque(true);
		title.setBackground(Color.decode("#7AE9FF"));
		title.setForeground(Color.white);
		jp1.add(title);

		ImageIcon imagen = new ImageIcon("Editar.png");
		JLabel tortu = new JLabel();
		tortu.setBounds(250, 80, 150, 150);
		tortu.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
		tortu.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortu);

		JLabel nombre = new JLabel("Nombre: ",JLabel.LEFT);
		nombre.setFont(new Font("Open sans", Font.BOLD,20));
		nombre.setBounds(80,250,100,20);
		jp1.add(nombre);

		JTextField nombreText = new JTextField();
		nombreText.setBounds(80, 270, 520, 30);
		jp1.add(nombreText);

		JLabel apellidos = new JLabel("Apellidos: ",JLabel.LEFT);
		apellidos.setFont(new Font("Open sans", Font.BOLD,20));
		apellidos.setBounds(80,310,100,20);
		jp1.add(apellidos);

		JTextField apellidosText = new JTextField();
		apellidosText.setBounds(80, 330, 520, 30);
		jp1.add(apellidosText);
		
		JLabel usuario = new JLabel("Usuario: ",JLabel.LEFT);
		usuario.setFont(new Font("Open sans", Font.BOLD,20));
		usuario.setBounds(80,370,100,20);
		jp1.add(usuario);

		JTextField usuarioText = new JTextField();
		usuarioText.setBounds(80, 390, 520, 30);
		jp1.add(usuarioText);

		JLabel email = new JLabel("Email: ",JLabel.LEFT);
		email.setFont(new Font("Open sans", Font.BOLD,20));
		email.setBounds(80,430,100,20);
		jp1.add(email);

		JTextField emailText = new JTextField();
		emailText.setBounds(80, 450, 520, 30);
		jp1.add(emailText);

		JLabel contraseña = new JLabel("Contraseña: ",JLabel.LEFT);
		contraseña.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña.setBounds(80,490,140,20);
		jp1.add(contraseña);

		JPasswordField contraseñaText = new JPasswordField();
		contraseñaText.setBounds(80, 510, 520, 30);
		jp1.add(contraseñaText);
		
		JLabel contraseña2 = new JLabel("Confirmar contraseña: ",JLabel.LEFT);
		contraseña2.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña2.setBounds(80,550,220,20);
		jp1.add(contraseña2);

		JPasswordField contraseñaText2 = new JPasswordField();
		contraseñaText2.setBounds(80, 570, 520, 30);
		jp1.add(contraseñaText2);

		//BOTONES
		ImageIcon logImagen = new ImageIcon("LogIn.png");
		JButton btnAccess = new JButton();
		btnAccess.setContentAreaFilled(false);
		btnAccess.setOpaque(true);
		btnAccess.setBackground(Color.decode("#7AE9FF"));
		btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnAccess.setSize(60,60);
		btnAccess.setLocation(540,660);
		jp1.add(btnAccess);

		JLabel login = new JLabel("Adelante",JLabel.RIGHT);
		login.setFont(new Font("Open sans", Font.BOLD,20));
		login.setBounds(500,590,100,100);
		login.setForeground(Color.white);
		jp1.add(login);
		
		ImageIcon returnImagen = new ImageIcon("Return.png");
		JButton btnReturn = new JButton();
		btnReturn.setBackground(Color.decode("#7AE9FF"));
		btnReturn.setBorder(new EmptyBorder(3,3,3,3));
		btnReturn.setContentAreaFilled(false);
		btnReturn.setOpaque(true);
		btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnReturn.setSize(60,60);
		btnReturn.setLocation(80,660);
		jp1.add(btnReturn);
		
		JLabel returnn = new JLabel("Cancelar",JLabel.LEFT);
		returnn.setFont(new Font("Open sans", Font.BOLD,20));
		returnn.setBounds(80,590,100,100);
		returnn.setForeground(Color.white);
		jp1.add(returnn);
		
		btnReturn.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#02B6DA"));
			}
			public void mouseExited(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#7AE9FF"));
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
				btnAccess.setBackground(Color.decode("#7AE9FF"));
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

		JPanel jp2 = new JPanel();
		jp2.setBounds(40, 240, 600, 380);
		jp2.setBackground(Color.decode("#00D5FF"));
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
				String aux = anterior;
				anterior = actual;
				actual = aux;

				JOptionPane.showMessageDialog(null,"Usuario actualizado con exito.");

				limpiarVentana();
			}
		});

		return jp1;
	}
	
	////////////////////////////////////////// AGREGAR USUARIO /////////////////////////////////////////////
	
	public JPanel agregar() {

		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#7AE9FF"));

		JLabel title = new JLabel("Agregar usuario",JLabel.CENTER);
		title.setBounds(0, 30, 700, 50);
		title.setFont(new Font("Open sans", Font.BOLD,40));
		title.setOpaque(true);
		title.setBackground(Color.decode("#7AE9FF"));
		title.setForeground(Color.white);
		jp1.add(title);

		ImageIcon imagen = new ImageIcon("TortuCrea.png");
		JLabel tortu = new JLabel();
		tortu.setBounds(250, 80, 150, 150);
		tortu.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
		tortu.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortu);

		JLabel nombre = new JLabel("Nombre: ",JLabel.LEFT);
		nombre.setFont(new Font("Open sans", Font.BOLD,20));
		nombre.setBounds(80,250,100,20);
		jp1.add(nombre);

		JTextField nombreText = new JTextField();
		nombreText.setBounds(80, 270, 520, 30);
		jp1.add(nombreText);

		JLabel apellidos = new JLabel("Apellidos: ",JLabel.LEFT);
		apellidos.setFont(new Font("Open sans", Font.BOLD,20));
		apellidos.setBounds(80,310,100,20);
		jp1.add(apellidos);

		JTextField apellidosText = new JTextField();
		apellidosText.setBounds(80, 330, 520, 30);
		jp1.add(apellidosText);
		
		JLabel usuario = new JLabel("Usuario: ",JLabel.LEFT);
		usuario.setFont(new Font("Open sans", Font.BOLD,20));
		usuario.setBounds(80,370,100,20);
		jp1.add(usuario);

		JTextField usuarioText = new JTextField();
		usuarioText.setBounds(80, 390, 520, 30);
		jp1.add(usuarioText);

		JLabel email = new JLabel("Email: ",JLabel.LEFT);
		email.setFont(new Font("Open sans", Font.BOLD,20));
		email.setBounds(80,430,100,20);
		jp1.add(email);

		JTextField emailText = new JTextField();
		emailText.setBounds(80, 450, 520, 30);
		jp1.add(emailText);

		JLabel contraseña = new JLabel("Contraseña: ",JLabel.LEFT);
		contraseña.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña.setBounds(80,490,140,20);
		jp1.add(contraseña);

		JPasswordField contraseñaText = new JPasswordField();
		contraseñaText.setBounds(80, 510, 520, 30);
		jp1.add(contraseñaText);
		
		JLabel contraseña2 = new JLabel("Confirmar contraseña: ",JLabel.LEFT);
		contraseña2.setFont(new Font("Open sans", Font.BOLD,20));
		contraseña2.setBounds(80,550,220,20);
		jp1.add(contraseña2);

		JPasswordField contraseñaText2 = new JPasswordField();
		contraseñaText2.setBounds(80, 570, 520, 30);
		jp1.add(contraseñaText2);

		//BOTONES
				ImageIcon logImagen = new ImageIcon("LogIn.png");
				JButton btnAccess = new JButton();
				btnAccess.setContentAreaFilled(false);
				btnAccess.setOpaque(true);
				btnAccess.setBackground(Color.decode("#7AE9FF"));
				btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
				btnAccess.setSize(60,60);
				btnAccess.setLocation(540,660);
				jp1.add(btnAccess);

				JLabel login = new JLabel("Adelante",JLabel.RIGHT);
				login.setFont(new Font("Open sans", Font.BOLD,20));
				login.setBounds(500,590,100,100);
				login.setForeground(Color.white);
				jp1.add(login);
				
				ImageIcon returnImagen = new ImageIcon("Return.png");
				JButton btnReturn = new JButton();
				btnReturn.setBackground(Color.decode("#7AE9FF"));
				btnReturn.setBorder(new EmptyBorder(3,3,3,3));
				btnReturn.setContentAreaFilled(false);
				btnReturn.setOpaque(true);
				btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
				btnReturn.setSize(60,60);
				btnReturn.setLocation(80,660);
				jp1.add(btnReturn);
				
				JLabel returnn = new JLabel("Cancelar",JLabel.LEFT);
				returnn.setFont(new Font("Open sans", Font.BOLD,20));
				returnn.setBounds(80,590,100,100);
				returnn.setForeground(Color.white);
				jp1.add(returnn);
				
				btnReturn.addMouseListener(new MouseListener() {
					public void mouseEntered(MouseEvent e) {
						btnReturn.setBackground(Color.decode("#02B6DA"));
					}
					public void mouseExited(MouseEvent e) {
						btnReturn.setBackground(Color.decode("#7AE9FF"));
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
						btnAccess.setBackground(Color.decode("#7AE9FF"));
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

		JPanel jp2 = new JPanel();
		jp2.setBounds(40, 240, 600, 380);
		jp2.setBackground(Color.decode("#00D5FF"));
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
				CrearUsuario(nombreText, apellidosText, emailText, usuarioText, contraseñaText, contraseñaText2);
				
			}		
		});

		return jp1;
	}
	////////////////////////////////////////////// INFO ///////////////////////////////////////////////////
	public JPanel info() {

		JPanel jp1 = new JPanel();
		jp1.setSize(500, 700);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#7AE9FF"));
		
		ImageIcon imagen = new ImageIcon("Info.png");
		JLabel tortu = new JLabel();
		tortu.setBounds(250, 80, 150, 150);
		tortu.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
		tortu.setBackground(Color.decode("#FFFFFF"));
		jp1.add(tortu);

		JLabel title = new JLabel("¿Cómo crear un usuario?",JLabel.CENTER);
		title.setBounds(0, 30, 700, 50);
		title.setFont(new Font("Open sans", Font.BOLD,40));
		title.setOpaque(true);
		title.setBackground(Color.decode("#7AE9FF"));
		title.setForeground(Color.white);
		jp1.add(title);
		
		JTextArea infoText = new JTextArea("1.- Hacer click en la opción -Usuarios- en"+"\n"
										 + "el menú superior"+"\n"
										 + "2.-Hacer click en la opción -Crear"+"\n"
										 + "Usuario- en el menú desplegado"+"\n"
										 + "3.- Llenar los campos solicitados"+"\n"
										 + "4.- Hacer click en el borón -Crear"+"\n"
										 + "Usuario"+"\n"
										 + "5.- Listo, el usuario se ha creado");
		infoText.setFont(new Font("Open sans", Font.BOLD,22));
		infoText.setForeground(Color.white);
		infoText.setBackground(Color.decode("#00D5FF"));
		infoText.setBounds(140, 260, 460, 260);
		infoText.setBounds(140, 300, 460, 300);
		infoText.setEditable(false);
		infoText.setVisible(true);
		jp1.add(infoText);
		
		//BOTONES
		ImageIcon logImagen = new ImageIcon("LogIn.png");
		JButton btnAccess = new JButton();
		btnAccess.setContentAreaFilled(false);
		btnAccess.setOpaque(true);
		btnAccess.setBackground(Color.decode("#7AE9FF"));
		btnAccess.setIcon(new ImageIcon(logImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnAccess.setSize(400,60);
		btnAccess.setLocation(140,540);
		jp1.add(btnAccess);

		JLabel login = new JLabel("¡Crear usuario ahora!",JLabel.CENTER);
		login.setFont(new Font("Open sans", Font.BOLD,20));
		login.setBounds(140,480,400,100);
		login.setForeground(Color.white);
		jp1.add(login);
		
		ImageIcon returnImagen = new ImageIcon("Return.png");
		JButton btnReturn = new JButton();
		btnReturn.setBackground(Color.decode("#7AE9FF"));
		btnReturn.setBorder(new EmptyBorder(3,3,3,3));
		btnReturn.setContentAreaFilled(false);
		btnReturn.setOpaque(true);
		btnReturn.setIcon(new ImageIcon(returnImagen.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
		btnReturn.setSize(60,60);
		btnReturn.setLocation(80,660);
		jp1.add(btnReturn);
		
		JLabel returnn = new JLabel("Cancelar",JLabel.LEFT);
		returnn.setFont(new Font("Open sans", Font.BOLD,20));
		returnn.setBounds(80,590,100,100);
		returnn.setForeground(Color.white);
		jp1.add(returnn);
		
		btnReturn.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#02B6DA"));
			}
			public void mouseExited(MouseEvent e) {
				btnReturn.setBackground(Color.decode("#7AE9FF"));
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
				btnAccess.setBackground(Color.decode("#7AE9FF"));
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

		JPanel jp2 = new JPanel();
		jp2.setBounds(100, 240, 500, 380);
		jp2.setBackground(Color.decode("#00D5FF"));
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
				anterior = actual;
				actual = "agregar";

				limpiarVentana();
			}
		});
		
		
		return jp1;
	}
	
	public void actualizarUsuario(JTextField nombreText, JTextField apellidosText, 
			JTextField emailText, JPasswordField contraseñaText) {
		String archivo = "users.txt";
		
		String password = new String(contraseñaText.getPassword());
		
		if(password.length() != 0
				&& nombreText.getText().length() != 0
				&& apellidosText.getText().length() != 0
				&& emailText.getText().length() != 0) {

			try {
				File archivoTemporal = new File("archivoTemporal");
				BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));

				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();

				String[] lineArray = null;

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
		else {
			JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void CrearUsuario(JTextField nombreText, JTextField apellidosText, 
			JTextField emailText, JTextField usuarioText, JPasswordField contraseñaText, JPasswordField contraseñaText2) {
		
		String password = new String(contraseñaText.getPassword());
		String password2 = new String(contraseñaText2.getPassword());
		String datosUsuario = "";

		boolean match = false;
		
		if(password.equals(password2) && password.length() != 0
				&& nombreText.getText().length() != 0
				&& apellidosText.getText().length() != 0
				&& emailText.getText().length() != 0
				&& usuarioText.getText().length() != 0) {
			
			try {
				FileWriter writer = new FileWriter("users.txt", true);

				BufferedWriter buffWriter = new BufferedWriter(writer);
				
				datosUsuario = nombreText.getText()+", "
						+apellidosText.getText()+", "
						+usuarioText.getText()+", "
						+emailText.getText()+", "
						+password;
				
				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();
				
				String[] lineArray = null;
				
				while (line != null) {
					lineArray = line.split(", ");

					if(emailText.getText().equals(lineArray[3])) {
						match = true;
					}
				
					line = reader.readLine();
				}
				reader.close();
				
				if(!match) {
					buffWriter.write(datosUsuario);
					buffWriter.newLine();
					buffWriter.close();
					JOptionPane.showMessageDialog(this, "Cuenta creada con exito", "Listo!", JOptionPane.INFORMATION_MESSAGE);
				
					anterior = actual;
					actual = "main";

					limpiarVentana();
				}
				else {
					JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public int getNumeroUsuarios() {

		int numLines = 0;

		try {
			BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
			String lineCounter = readerCounter.readLine();

			while(lineCounter!=null) {
				numLines++;
				lineCounter = readerCounter.readLine();
			}

			readerCounter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		return numLines;

	}
	
	public void cerrarVentana() {
		this.dispose();
	}
	
}
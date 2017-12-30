import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class Main {

	private JFrame frame;
	private JTextField txtGhghghf;
	private JPanel Home;
	private JPanel Login;
	private JPanel registerGuest;
	private JPanel currentGuests;
	private JPanel RegisterHotel;
	private JPanel Welcome;
	private JTextField HotelNameTextB;
	private JTextField FloorsTextB;
	private JTextField RoomsPerFloorTextB;
	private JTextField CostTextB;
	private JTextField textFieldFN;
	private JTextField textFieldLN;
	private JTextField textFieldAD;
	private JTextField textFieldPN;
	private JTextField textFieldNA;
	private JTextField textFieldNC;
	private JTextField textFieldLS;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTable table;
	private JTextField textFieldRN;
	private JTextField textFieldEC;
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		connection=SqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 892, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Home = new JPanel();
		frame.getContentPane().add(Home, "name_698695866720737");
		Home.setLayout(null);
		
		JPanel Login = new JPanel();
		frame.getContentPane().add(Login, "name_698695872684196");
		Login.setLayout(null);
		
		JPanel registerGuest = new JPanel();
		frame.getContentPane().add(registerGuest, "name_698695878777236");
		registerGuest.setLayout(null);
		
		JPanel RegisterHotel = new JPanel();
		frame.getContentPane().add(RegisterHotel, "name_701183341378110");
		RegisterHotel.setLayout(null);
		
		JPanel Welcome = new JPanel();
		frame.getContentPane().add(Welcome, "name_747342890036894");
		Welcome.setLayout(null);
		
		JPanel currentGuests = new JPanel();
		frame.getContentPane().add(currentGuests, "name_698695887455955");
		currentGuests.setLayout(null);
		
		JLabel lblRegisterAGuest = new JLabel("Register a guest");
		lblRegisterAGuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAGuest.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblRegisterAGuest.setForeground(Color.RED);
		lblRegisterAGuest.setBounds(0, 16, 886, 63);
		registerGuest.add(lblRegisterAGuest);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(15, 148, 103, 37);
		registerGuest.add(lblFirstName);
		
		textFieldFN = new JTextField();
		textFieldFN.setBounds(278, 153, 174, 26);
		registerGuest.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(15, 193, 99, 26);
		registerGuest.add(lblLastName);
		
		textFieldLN = new JTextField();
		textFieldLN.setBounds(278, 193, 174, 26);
		registerGuest.add(textFieldLN);
		textFieldLN.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(15, 235, 77, 26);
		registerGuest.add(lblAddress);
		
		textFieldAD = new JTextField();
		textFieldAD.setBounds(132, 233, 320, 31);
		registerGuest.add(textFieldAD);
		textFieldAD.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(15, 280, 77, 26);
		registerGuest.add(lblPhone);
		
		textFieldPN = new JTextField();
		textFieldPN.setBounds(132, 280, 320, 26);
		registerGuest.add(textFieldPN);
		textFieldPN.setColumns(10);
		
		JLabel lblNumberOfAdults = new JLabel("Number of Adults");
		lblNumberOfAdults.setBounds(15, 322, 137, 37);
		registerGuest.add(lblNumberOfAdults);
		
		textFieldNA = new JTextField();
		textFieldNA.setBounds(375, 327, 77, 26);
		registerGuest.add(textFieldNA);
		textFieldNA.setColumns(10);
		
		JLabel lblNumberOfChildren = new JLabel("Number of children");
		lblNumberOfChildren.setBounds(15, 369, 159, 26);
		registerGuest.add(lblNumberOfChildren);
		
		textFieldNC = new JTextField();
		textFieldNC.setBounds(375, 369, 77, 26);
		registerGuest.add(textFieldNC);
		textFieldNC.setColumns(10);
		
		JLabel lblLengthOfStay = new JLabel("Length of stay");
		lblLengthOfStay.setBounds(15, 411, 137, 26);
		registerGuest.add(lblLengthOfStay);
		
		textFieldLS = new JTextField();
		textFieldLS.setBounds(375, 411, 77, 26);
		registerGuest.add(textFieldLS);
		textFieldLS.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int total = Integer.parseInt(textFieldEC.getText())+ (Hotel.costPerDay);
					String query = "insert into Guest_info (First name,Last name,Room number,# of adults,# of children,Length of stay,Address,Extra charges,Total price,Phone_number) values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					
					pst.setString(1, textFieldFN.getText());
					pst.setString(2, textFieldLN.getText());
					pst.setString(3, textFieldRN.getText());
					pst.setString(4, textFieldNA.getText());
					pst.setString(5, textFieldNC.getText());
					pst.setString(6, textFieldLS.getText());
					pst.setString(7, textFieldAD.getText());
					pst.setString(8, textFieldEC.getText());
					pst.setString(9, Integer.toString(total));
					pst.setString(10, textFieldPN.getText());
					
					
				    pst.execute();
					JOptionPane.showMessageDialog(null, "Guest information saved.");
					
					pst.close();
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEnter.setBounds(552, 314, 137, 78);
		registerGuest.add(btnEnter);
		
		textFieldRN = new JTextField();
		textFieldRN.setBounds(664, 151, 77, 26);
		registerGuest.add(textFieldRN);
		textFieldRN.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(493, 148, 137, 37);
		registerGuest.add(lblRoomNumber);
		
		JLabel lblExtraCharges = new JLabel("Extra charges");
		lblExtraCharges.setBounds(492, 184, 109, 44);
		registerGuest.add(lblExtraCharges);
		
		textFieldEC = new JTextField();
		textFieldEC.setBounds(664, 193, 77, 26);
		registerGuest.add(textFieldEC);
		textFieldEC.setColumns(10);
		
		JButton btnBack_2 = new JButton("back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.setVisible(false);
				RegisterHotel.setVisible(false);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				Welcome.setVisible(true);
			}
		});
		btnBack_2.setBounds(46, 20, 115, 29);
		registerGuest.add(btnBack_2);
		
		JButton btnLoadInfo = new JButton("Load info");
		btnLoadInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from Guest_info";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadInfo.setBounds(369, 26, 115, 29);
		currentGuests.add(btnLoadInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 66, 886, 486);
		currentGuests.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack_3 = new JButton("back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				RegisterHotel.setVisible(false);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				Welcome.setVisible(true);
			}
		});
		btnBack_3.setBounds(33, 26, 115, 29);
		currentGuests.add(btnBack_3);
		
		JLabel lblHotelRegisterationSystem = new JLabel("Hotel Registeration System");
		lblHotelRegisterationSystem.setForeground(Color.RED);
		lblHotelRegisterationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelRegisterationSystem.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblHotelRegisterationSystem.setBounds(15, 26, 856, 55);
		Home.add(lblHotelRegisterationSystem);
		
		JButton btnRegisterHotel = new JButton("Register Hotel");
		btnRegisterHotel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRegisterHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				RegisterHotel.setVisible(true);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				Welcome.setVisible(false);
			}
		});
		btnRegisterHotel.setBounds(323, 164, 216, 72);
		Home.add(btnRegisterHotel);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				Login.setVisible(true);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				RegisterHotel.setVisible(false); 
				Welcome.setVisible(false);
			}
		});
		btnLogIn.setBounds(323, 323, 216, 72);
		Home.add(btnLogIn);
		
		JLabel lblYouMustRegister = new JLabel("You must register the hotel on the system before using it");
		lblYouMustRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouMustRegister.setBounds(15, 516, 856, 20);
		Home.add(lblYouMustRegister);
		
		
		JLabel lblLogIn = new JLabel("Log in ");
		lblLogIn.setForeground(Color.RED);
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(360, 16, 183, 61);
		Login.add(lblLogIn);
		
		JLabel lblGoBackAnd = new JLabel("Go back and register your hotel if you havent already");
		lblGoBackAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoBackAnd.setBounds(233, 80, 431, 50);
		Login.add(lblGoBackAnd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(true);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				RegisterHotel.setVisible(false); 
				Welcome.setVisible(false);
			}
		});
		btnBack.setBounds(61, 32, 115, 29);
		Login.add(btnBack);
		
		JLabel lblHotelName = new JLabel("Hotel name");
		lblHotelName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHotelName.setBounds(61, 206, 172, 61);
		Login.add(lblHotelName);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(61, 324, 152, 69);
		Login.add(lblPassword);
		
		JButton btnLogIn_1 = new JButton("Log in");
		btnLogIn_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLogIn_1.setBounds(336, 471, 219, 44);
		Login.add(btnLogIn_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordField.setBounds(323, 337, 220, 44);
		Login.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(654, 0, 232, 552);
		Login.add(panel);
		
		
		JLabel lblRegisterHotel = new JLabel("Register Hotel");
		lblRegisterHotel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblRegisterHotel.setForeground(Color.RED);
		lblRegisterHotel.setBounds(290, 23, 327, 65);
		RegisterHotel.add(lblRegisterHotel);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(true);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(false);
				RegisterHotel.setVisible(false); 
				Welcome.setVisible(false);
			}
		});
		btnBack_1.setBounds(44, 53, 115, 29);
		RegisterHotel.add(btnBack_1);
		
		JLabel lblHotelName_1 = new JLabel("Hotel Name");
		lblHotelName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHotelName_1.setBounds(74, 157, 168, 41);
		RegisterHotel.add(lblHotelName_1);
		
		JLabel lblNumberOfFloors = new JLabel("Number of floors");
		lblNumberOfFloors.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNumberOfFloors.setBounds(74, 214, 235, 41);
		RegisterHotel.add(lblNumberOfFloors);
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms/floor");
		lblNumberOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNumberOfRooms.setBounds(74, 274, 310, 47);
		RegisterHotel.add(lblNumberOfRooms);
		
		JLabel lblNewLabel = new JLabel("Cost per night");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(74, 330, 232, 41);
		RegisterHotel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(74, 382, 182, 41);
		RegisterHotel.add(lblNewLabel_1);
		
		HotelNameTextB = new JTextField();
		HotelNameTextB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		HotelNameTextB.setBounds(350, 157, 295, 41);
		RegisterHotel.add(HotelNameTextB);
		HotelNameTextB.setColumns(10);
		
		FloorsTextB = new JTextField();
		FloorsTextB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		FloorsTextB.setBounds(570, 220, 75, 41);
		RegisterHotel.add(FloorsTextB);
		FloorsTextB.setColumns(10);
		
		RoomsPerFloorTextB = new JTextField();
		RoomsPerFloorTextB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		RoomsPerFloorTextB.setBounds(570, 279, 75, 41);
		RegisterHotel.add(RoomsPerFloorTextB);
		RoomsPerFloorTextB.setColumns(10);
		
		CostTextB = new JTextField();
		CostTextB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		CostTextB.setBounds(570, 336, 75, 41);
		RegisterHotel.add(CostTextB);
		CostTextB.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Hotel.hotelName = null;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel newHotel = new Hotel();
				try {
					Hotel.hotelName = HotelNameTextB.getText();
					newHotel.numberOfFloors = Integer.parseInt(FloorsTextB.getText());
					newHotel.roomsPerFloor = Integer.parseInt(RoomsPerFloorTextB.getText());
					newHotel.costPerDay = Integer.parseInt(CostTextB.getText());
					newHotel.password = passwordField_1.getText();
					Home.setVisible(true);
					Login.setVisible(false);
					registerGuest.setVisible(false);
					currentGuests.setVisible(false);
					RegisterHotel.setVisible(false); 
					Welcome.setVisible(false);
					JOptionPane.showMessageDialog(null, "Successful, sign in to manage your hotel's reservations.");
					
					JLabel lblNewLabel_2 = new JLabel(String.valueOf(Hotel.hotelName));
					lblNewLabel_2.setBounds(348, 468, 69, 20);
					Login.add(lblNewLabel_2);
					txtGhghghf = new JTextField();
					txtGhghghf.setBounds(250, 213, 295, 45);
					Login.add(txtGhghghf);
					txtGhghghf.setColumns(10);
					txtGhghghf.setFont(new Font("Tahoma", Font.PLAIN, 30));
					
					if (Hotel.hotelName==null) {
						txtGhghghf.setText("Please register hotel first!");
					} else {
					    txtGhghghf.setText(String.valueOf(Hotel.hotelName));
					}
					btnLogIn_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						if(passwordField.getText().equals(newHotel.password)) {
							JOptionPane.showMessageDialog(null, "Successful!");
							Home.setVisible(false);
							Login.setVisible(false);
							registerGuest.setVisible(false);
							currentGuests.setVisible(false);
							RegisterHotel.setVisible(false); 
							Welcome.setVisible(true);
							
						} else {
							JOptionPane.showMessageDialog(null, "Wrong password!");
						}
						}
					});
					
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please input valid values!");
				}
			}
		});
		btnNewButton.setBounds(351, 495, 136, 41);
		RegisterHotel.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_1.setBounds(401, 393, 244, 41);
		RegisterHotel.add(passwordField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(654, 0, 232, 552);
		RegisterHotel.add(panel_1);
		
	
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblWelcome.setBounds(0, 16, 886, 69);
		Welcome.add(lblWelcome);
		
		JButton btnRegisterAGuest = new JButton("Register a guest");
		btnRegisterAGuest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRegisterAGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				Login.setVisible(false);
				registerGuest.setVisible(true);
				currentGuests.setVisible(false);
				RegisterHotel.setVisible(false); 
				Welcome.setVisible(false);
			}
		});
		btnRegisterAGuest.setBounds(325, 166, 238, 51);
		Welcome.add(btnRegisterAGuest);
		
		JButton btnCurrentGuests = new JButton("Current guests");
		btnCurrentGuests.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCurrentGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				Login.setVisible(false);
				registerGuest.setVisible(false);
				currentGuests.setVisible(true);
				RegisterHotel.setVisible(false); 
				Welcome.setVisible(false);
			}
		});
		btnCurrentGuests.setBounds(325, 329, 238, 51);
		Welcome.add(btnCurrentGuests);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(654, 0, 232, 552);
		Welcome.add(panel_2);
		
	}
}

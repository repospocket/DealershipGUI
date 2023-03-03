import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;


public class dealershipUI {

	private JFrame frame;
	private static CarDealership dealer;
	private static ArrayList<Car> kar;
	static AccountingSystem sys;
	private JButton btnList;
	 private JScrollPane scrollPane;
	 private JTextPane heloos;
	 private JButton btnExist;
	 private JPanel panel_2;
	 private JTextField textprice1;
	 private JTextField textprice2;
	 private JLabel lblWelcomeDealership;
	 private JPanel panel_5;
	 private JPanel panel_3;
	 private JLabel label;
	 private JTextField txtVin;
	 private JButton button;
	 private JPanel panel_6;
	 private JPanel panel_4;
	 private JButton button_1;
	 private JButton button_2;
	 private JButton button_3;
	 private JButton button_4;
	 private JSeparator separator;
	 private JSeparator separator_2;
	 private JSeparator separator_1;
	 private JSeparator separator_3;
	 private JPanel panel_7;
	 private JCheckBox checkBox;
	 private JCheckBox checkBox_1;
	 private JSeparator separator_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 dealer = new CarDealership();

		    sys = dealer.sys;
	          
		  // Then create an (initially empty) array list of type Car
	      // Then create some new car objects of different types
		  // See the cars file for car object details
		  // Add the car objects to the array list
	      // The ADD command should hand this array list to CarDealership object via the addCars() method	
		  /**
		   * Create an array list of car type and add car objects to it.
		   */
		   kar = new ArrayList<Car>();
		    
	  
	  		kar  =  CarDealershipSimulator.readCSV("cars.csv");
		  
		  //I/O reader that reads from cars.txt file and adds cars automatically to the inventory arraylist.
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dealershipUI window = new dealershipUI();
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
	public dealershipUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.setBounds(100, 100, 565, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		 
		 JPanel panel_1 = new JPanel();
		 
		 lblWelcomeDealership = new JLabel("Welcome to the Dealership!",JTextField.CENTER);
		 lblWelcomeDealership.setFont(new Font("Sitka Text", Font.BOLD, 16));
		  
		  scrollPane = new JScrollPane();
		  SpringLayout sl_panel_1 = new SpringLayout();
		  panel_1.setLayout(sl_panel_1);
		  
		  panel_5 = new JPanel();
		  sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -164, SpringLayout.SOUTH, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel_1);
		  panel_1.add(panel_5);
		  
		  JComboBox<String> comboBox = new JComboBox<String>(){
			    @Override public void setBorder(Border border) {
			        // No!
			    }
			};
		  comboBox.setBackground(Color.LIGHT_GRAY);
		  
		   comboBox.addItem("Sort By..");
		   comboBox.addItem("By Price");
		   comboBox.addItem("By Safety Rating");
		   comboBox.addItem("By MaxRange");

		   comboBox.addActionListener (new ActionListener () {
			    public void actionPerformed(ActionEvent e) {
			    	String selection = (String) comboBox.getSelectedItem();
		             switch(selection) {
		             case "By Price":
		             	dealer.sortByPrice();
			  			heloos.setText( "\n"+ dealer.displayInventory());
		               break;
		             case "By Safety Rating":
		     			dealer.sortBySafetyRating();
			  			heloos.setText( "\n"+ dealer.displayInventory());
		               break;
		             case "By MaxRange":
		             	dealer.sortByMaxRange();
			  			heloos.setText( "\n"+ dealer.displayInventory());
		               break;
		             default:
		               // code block
		           }}
			});
		   
		   ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		   
		   panel_2 = new JPanel();
		   
		   textprice1 = new JTextField("Min") {
			    @Override public void setBorder(Border border) {
			        // No!
			    }
			};
		   textprice1.setHorizontalAlignment(JTextField.CENTER);
		   textprice1.setColumns(10);
		   
		   JButton btnNewButton = new JButton("< Filter Price <");
		   btnNewButton.setBackground(Color.LIGHT_GRAY);
		   btnNewButton.setBorderPainted(false);

		   btnNewButton.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		int num1, num2;
		   		
		   		try {
		   			num1 =  Integer.parseInt(textprice1.getText());
		   			num2 =  Integer.parseInt(textprice2.getText());
				    dealer.filterByPrice(num1, num2);
		   			heloos.setText( "\n"+ dealer.displayInventory());

		   		}catch(Exception e) {
		   			JOptionPane.showMessageDialog(null, "please inter valid number");
		   		}
		   	}
		   });
		   
		   textprice2 = new JTextField(){
			    @Override public void setBorder(Border border) {
			        // No!
			    }
			};
		   textprice2.setText("Max");
		   textprice2.setHorizontalAlignment(JTextField.CENTER);
		   textprice2.setColumns(10);
		  
		  panel_3 = new JPanel();
		  sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		  panel_1.add(panel_3);
		  
		  label = new JLabel("Enter VIN:", SwingConstants.CENTER);
		  label.setForeground(SystemColor.desktop);
		  label.setBackground(SystemColor.textHighlight);
		  
		  txtVin = new JTextField(){
			    @Override public void setBorder(Border border) {
			        // No!
			    }
			};
		  txtVin.setText("vin");
		  txtVin.setColumns(10);
		  
		  button = new JButton("SELL");
		  button.setBackground(SystemColor.activeCaption);
		  button.setBorderPainted(false);

		  button.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try {
		  			JOptionPane.showMessageDialog(null, "SOLD! \n" + dealer.buyCar(Integer.parseInt(txtVin.getText()) ) );
		  			heloos.setText( "\n"+ dealer.displayInventory());
		  		}catch(Exception f) {
		  			JOptionPane.showMessageDialog(null, "invalid entry");
		  		}
			  			
		  	}
		  });
		  
		  panel_6 = new JPanel();
		  sl_panel_1.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_6, 42, SpringLayout.NORTH, panel_1);
		  sl_panel_1.putConstraint(SpringLayout.EAST, panel_6, 0, SpringLayout.EAST, panel_1);
		  panel_1.add(panel_6);
		  
		  btnList = new JButton("List");
		  btnList.setBackground(Color.LIGHT_GRAY);
		  btnList.setBorderPainted(false);


		  btnList.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
				    String header = ("# VIN MFR COLOR MODEL POWER SAFTYRATING PRICE RECHARGETIME");
		  			heloos.setText( header + "\n"+ dealer.displayInventory());
		  			
		  	}
		  });
		  
		  JButton btnPopulate = new JButton("Add cars.csv");
		  btnPopulate.setBackground(new Color(60, 179, 113));
		  btnPopulate.setForeground(Color.BLACK);
		  btnPopulate.setBorderPainted(false);

		  		  btnPopulate.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent arg0) {
		  		  		
		  		  		dealer.addCars(kar);
						JOptionPane.showMessageDialog(null, "ADDED", "Warning", JOptionPane.WARNING_MESSAGE);

		  		  		
		  		  	}
		  		  });
		  		  
		  		  btnExist = new JButton("Save");
		  		btnExist.setBorderPainted(false);

		  		  btnExist.setBackground(Color.LIGHT_GRAY);
		  		  GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		  		  gl_panel_6.setHorizontalGroup(
		  		  	gl_panel_6.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_6.createSequentialGroup()
		  		  			.addGap(1)
		  		  			.addComponent(btnList, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		  		  			.addComponent(btnPopulate, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		  		  			.addComponent(btnExist, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		  		  			.addGap(1))
		  		  );
		  		  gl_panel_6.setVerticalGroup(
		  		  	gl_panel_6.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(btnList, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(btnPopulate, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(btnExist, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  );
		  		  panel_6.setLayout(gl_panel_6);
		  		  
		  		  panel_4 = new JPanel();
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -10, SpringLayout.SOUTH, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_1);
		  		  panel_1.add(panel_4);
		  		  
		  		  button_1 = new JButton("Sales Team");
		  		button_1.setBorderPainted(false);

		  		
		  		  button_1.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent arg0) {
		  		  	SalesTeam team = new SalesTeam();
		  		  	String tm = "TEAM \n";
		  		  	
					for (String x : team.listt)
						tm += x + " : ";
					
		  		  		JOptionPane.showMessageDialog(null, tm);
		  		  	}
		  		  });
		  		  button_1.setBackground(Color.LIGHT_GRAY);
		  		  
		  		  button_2 = new JButton("Sales Leaderboard");
		  		button_2.setBorderPainted(false);

		  		  button_2.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent e) {
		  		  	 Map<String, Integer> map = new HashMap<String, Integer>();
					   for (Transaction x : sys.history) {
						   if (x.sellType.equals("BUY")) {
						   map.put(x.seller, map.get(x.seller) == null ? 1 : map.get(x.seller) + 1 );
						   } }
			  		  	String tm = "LEADERBOARD \n";

					   for (Entry<String, Integer> entry : map.entrySet()) {
						    tm += entry.getKey() + ":" + entry.getValue().toString() + "\n";
						}
		  		  		JOptionPane.showMessageDialog(null, tm);
		  		  	}
		  		  });
		  		  
		  		  
		  		  button_2.setBackground(Color.LIGHT_GRAY);
		  		  
		  		  button_3 = new JButton("Sales Stats");
		  		button_3.setBorderPainted(false);

		  		  button_3.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent e) {
		  		  		

					 	 double total = 0;     
					 	 int totalsold = 0;
					 	 int totalreturn = 0 ;
			             for (Transaction x : sys.history) {
			            	 if (x.sellType.equals("BUY"))
			            		 total += x.price;
			            	 else  {total -= x.price;}
			            	 if(x.sellType.equals("BUY")) {
			            		 totalsold++;
			            	 }
			            	 if(x.sellType.equals("RET")) {
			            		 totalreturn++;
			            	 }
			             }
			               
							Map<Integer, Integer> map = new HashMap<Integer, Integer>();
							   for (Transaction x : sys.history) {
								   if (x.sellType.equals("BUY")) {
								   map.put(x.date.get(2), map.get(x.date.get(2)) == null ? 1 : map.get(x.date.get(2)) + 1 );
								   }
							   }
					
			  		  		JOptionPane.showMessageDialog(null, "Totalvalue: " + total + " Averagevalue: " + String.format("%.2f", total/12) + " Totalsold:"  + totalsold + " Returned: " + totalreturn
				            		 );

			            
		  		  	}
		  		  });
		  		  button_3.setBackground(Color.LIGHT_GRAY);

		  		  button_4 = new JButton("Sales History");
		  		button_4.setBorderPainted(false);

		  		  button_4.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent e) {
		  		  		String tm = "HISTORY \n";
		  		  	for (Transaction x : sys.history) 
						tm += x.display() + ""
								+ "\n";
		  		  JOptionPane.showMessageDialog(null,tm);}
		  		  });
		  		  button_4.setBackground(Color.LIGHT_GRAY);
		  		  
		  		  separator = new JSeparator();
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.SOUTH, separator);
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, separator, -212, SpringLayout.SOUTH, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, separator, 50, SpringLayout.NORTH, panel_1);
		  		  panel_1.add(separator);
		  		  
		  		  separator_2 = new JSeparator();
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, separator_2, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, separator_2, 0, SpringLayout.EAST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, separator_2);
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, separator_2, 191, SpringLayout.NORTH, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_2, -71, SpringLayout.SOUTH, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, separator_2);
		  		  panel_1.add(separator_2);
		  		  
		  		  separator_1 = new JSeparator();
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1, -108, SpringLayout.SOUTH, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, panel_1);
		  		  panel_1.add(separator_1);
		  		  
		  		  separator_3 = new JSeparator();
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, separator_3, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, separator_3, 0, SpringLayout.EAST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 4, SpringLayout.SOUTH, separator_3);
		  		  GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		  		  gl_panel_3.setHorizontalGroup(
		  		  	gl_panel_3.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_3.createSequentialGroup()
		  		  			.addGap(1)
		  		  			.addComponent(label, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		  		  			.addComponent(txtVin, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
		  		  			.addGap(18)
		  		  			.addComponent(button, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
		  		  			.addGap(56))
		  		  );
		  		  gl_panel_3.setVerticalGroup(
		  		  	gl_panel_3.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addGroup(gl_panel_3.createSequentialGroup()
		  		  			.addGap(10)
		  		  			.addComponent(txtVin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  		  		.addComponent(button, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  );
		  		  panel_3.setLayout(gl_panel_3);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_3, -125, SpringLayout.SOUTH, panel_1);
		  		  panel_1.add(separator_3);
		  		  
		  		  panel_7 = new JPanel();
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, 6, SpringLayout.SOUTH, panel_5);
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, separator_3, 6, SpringLayout.SOUTH, panel_7);
		  		  panel_1.add(panel_7);
		  		  
		  		  checkBox = new JCheckBox("electric cars");
		  		  
		  		  checkBox_1 = new JCheckBox("Fourwheels");
		  		  checkBox_1.addActionListener(new ActionListener() {
		  			  
		  		  	public void actionPerformed(ActionEvent e) {
		  		  	if(checkBox_1.isSelected()) {
		  		  		dealer.filterByAWD();
			  			heloos.setText( "\n"+ dealer.displayInventory());}
		  		  		else {
		  		  		dealer.awdClear();
			  			heloos.setText( "\n"+ dealer.displayInventory());
		  		  		}
		  		  		
		  		  	}
		  		  });

		  		checkBox.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent e) {
		  		  		if(checkBox.isSelected()) {
		  		  		dealer.filterByElectric();
			  			heloos.setText( "\n"+ dealer.displayInventory());}
		  		  		else {
		  		  		dealer.eleclear();
			  			heloos.setText( "\n"+ dealer.displayInventory());
		  		  		}
		  		  	}
		  		  });
		  		  GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		  		  gl_panel_7.setHorizontalGroup(
		  		  	gl_panel_7.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_7.createSequentialGroup()
		  		  			.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		  		  			.addComponent(checkBox_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
		  		  );
		  		  gl_panel_7.setVerticalGroup(
		  		  	gl_panel_7.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(checkBox)
		  		  		.addComponent(checkBox_1)
		  		  );
		  		  panel_7.setLayout(gl_panel_7);
		  		  
		  		  separator_4 = new JSeparator();
		  		  sl_panel_1.putConstraint(SpringLayout.NORTH, separator_4, 17, SpringLayout.SOUTH, separator_2);
		  		  sl_panel_1.putConstraint(SpringLayout.WEST, separator_4, 0, SpringLayout.WEST, panel_1);
		  		  sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_4, -11, SpringLayout.NORTH, panel_4);
		  		  GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		  		  gl_panel_4.setHorizontalGroup(
		  		  	gl_panel_4.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_4.createSequentialGroup()
		  		  			.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
		  		  			.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 133, Short.MAX_VALUE)
		  		  			.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
		  		  			.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
		  		  			.addGap(1))
		  		  );
		  		  gl_panel_4.setVerticalGroup(
		  		  	gl_panel_4.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		  		  );
		  		  panel_4.setLayout(gl_panel_4);
		  		  sl_panel_1.putConstraint(SpringLayout.EAST, separator_4, 0, SpringLayout.EAST, panel_1);
		  		  GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		  		  gl_panel_2.setHorizontalGroup(
		  		  	gl_panel_2.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_2.createSequentialGroup()
		  		  			.addGap(79)
		  		  			.addComponent(textprice1, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
		  		  			.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
		  		  			.addComponent(textprice2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		  		  );
		  		  gl_panel_2.setVerticalGroup(
		  		  	gl_panel_2.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(textprice1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(textprice2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  );
		  		  panel_2.setLayout(gl_panel_2);
		  		  GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		  		  gl_panel_5.setHorizontalGroup(
		  		  	gl_panel_5.createParallelGroup(Alignment.LEADING)
		  		  		.addGroup(gl_panel_5.createSequentialGroup()
		  		  			.addComponent(comboBox, 0, 121, Short.MAX_VALUE)
		  		  			.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  		  );
		  		  gl_panel_5.setVerticalGroup(
		  		  	gl_panel_5.createParallelGroup(Alignment.LEADING)
		  		  		.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
		  		  		.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		  		  );
		  		  panel_5.setLayout(gl_panel_5);
		  		  panel_1.add(separator_4);
		  		btnExist.setBorderPainted(false);

		  		  btnExist.addActionListener(new ActionListener() {
		  		  	public void actionPerformed(ActionEvent arg0) {
						//JOptionPane.showMessageDialog(null, "Warning: This action cannot be undone!", "Warning", JOptionPane.WARNING_MESSAGE);
						//JOptionPane.showConfirmDialog(null, "ADDED");
						 // Display a confirmation dialog box with options "Yes", "No", and "Cancel"
						 int result = JOptionPane.showConfirmDialog(null, "Do you want to save changes?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

						 // Handle the user's response
						 if (result == JOptionPane.YES_OPTION) {
							CarDealershipSimulator.writeCSV("cars.csv", dealer.carz);
							JOptionPane.showMessageDialog(null, "Saved!", null, JOptionPane.WARNING_MESSAGE);

							 System.out.println("User clicked 'Yes'");
						 } else if (result == JOptionPane.NO_OPTION) {
							 System.out.println("User clicked 'No'");
						 } else if (result == JOptionPane.CANCEL_OPTION) {
							 System.out.println("User clicked 'Cancel'");
						 }

                        //frame.dispose();
		  		  	}
		  		  });
		  
		  heloos = new JTextPane();
		  scrollPane.setViewportView(heloos);
		  GroupLayout gl_panel = new GroupLayout(panel);
		  gl_panel.setHorizontalGroup(
		  	gl_panel.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel.createSequentialGroup()
		  			.addGap(162)
		  			.addComponent(lblWelcomeDealership, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
		  			.addGap(168))
		  );
		  gl_panel.setVerticalGroup(
		  	gl_panel.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel.createSequentialGroup()
		  			.addGap(5)
		  			.addComponent(lblWelcomeDealership, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		  );
		  panel.setLayout(gl_panel);
		  GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		  groupLayout.setHorizontalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGap(7)
		  			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		  				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
		  				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
		  				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
		  			.addGap(7))
		  );
		  groupLayout.setVerticalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGap(7)
		  			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		  			.addGap(4)
		  			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
		  			.addGap(4)
		  			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
		  			.addGap(12))
		  );
		  frame.getContentPane().setLayout(groupLayout);
		  
	
	}
}

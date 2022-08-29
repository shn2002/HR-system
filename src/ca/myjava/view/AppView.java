package ca.myjava.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import ca.myjava.model.CountryExpectancy;
import ca.myjava.query.CountryExpectancyDao1;
import ca.myjava.update.CountryExpectancyDao2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JComboBox<String> comboBox ;
	private JLabel label;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView window = new AppView();
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
	public AppView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 936, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblFrom = new JLabel("From:");
		panel.add(lblFrom);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);
		
		JLabel lblTo = new JLabel("To:");
		panel.add(lblTo);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(5);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("both_sexes");
		comboBox.addItem("Male");
		comboBox.addItem("Female");
		panel.add(comboBox);
		
		JButton btnQueryUsingPrestmt = new JButton("Query using PreStmt");
		btnQueryUsingPrestmt.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				ReadAction(1);
			}	
		});
		panel.add(btnQueryUsingPrestmt);
		
		JButton btnQueryUsingStmt = new JButton("Query using stmt");
		btnQueryUsingStmt.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				ReadAction(0);
			}	
		});
		panel.add(btnQueryUsingStmt);
		
		JButton btnDelUsingPrestmt = new JButton("Del using PreStmt");
		btnDelUsingPrestmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				DeleteAction(1);
			}
	
		});
		
		panel.add(btnDelUsingPrestmt);
		
		JButton btnDelUsingStmt = new JButton("Del using Stmt");
		btnDelUsingStmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				DeleteAction(0);
			}
	
		});
		panel.add(btnDelUsingStmt);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		table=new JTable();
		List<CountryExpectancy> data= new CountryExpectancyDao1().findAll();
		ReLoadData(data);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 500, 431);
		panel_1.add(scrollPane);	
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(524, 5, 382, 431);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(22, 13, 22, 16);
		panel_2.add(lblId);
		
		label = new JLabel("");
		label.setBounds(111, 13, 56, 16);
		panel_2.add(label);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(23, 59, 56, 16);
		panel_2.add(lblName);
		
		JLabel lblBothSexes = new JLabel("Both Sexes:");
		lblBothSexes.setBounds(22, 117, 88, 16);
		panel_2.add(lblBothSexes);
		
		JLabel lblFemale = new JLabel("female:");
		lblFemale.setBounds(22, 179, 56, 16);
		panel_2.add(lblFemale);
		
		JLabel lblMale = new JLabel("male:");
		lblMale.setBounds(23, 236, 56, 16);
		panel_2.add(lblMale);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 56, 116, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 114, 116, 22);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 176, 116, 22);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(111, 233, 116, 22);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnUpdateUsingPrestmt = new JButton("Update using PreStmt");
		btnUpdateUsingPrestmt.setBounds(22, 311, 170, 25);
		btnUpdateUsingPrestmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				CreateOrUpdateAction(1,"Update");
			}
	
		});

		panel_2.add(btnUpdateUsingPrestmt);
		
		JButton btnUpdateUsingStmt = new JButton("Update using Stmt");
		btnUpdateUsingStmt.setBounds(22, 363, 170, 25);
		btnUpdateUsingStmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				CreateOrUpdateAction(0,"Update");
			}
	
		});
		panel_2.add(btnUpdateUsingStmt);
		
		JButton btnAddUsingPrestmt = new JButton("Add using PreStmt");
		btnAddUsingPrestmt.setBounds(204, 311, 154, 25);
		btnAddUsingPrestmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				CreateOrUpdateAction(1,"Create");
			}
	
		});
		panel_2.add(btnAddUsingPrestmt);
		
		JButton btnAddUsingStmt = new JButton("Add using stmt");
		btnAddUsingStmt.setBounds(204, 363, 154, 25);
		btnAddUsingStmt.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				CreateOrUpdateAction(0,"Create");
			}
	
		});
		panel_2.add(btnAddUsingStmt);
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!selectionModel.isSelectionEmpty()) {
					int index =selectionModel.getMinSelectionIndex();
					String id = table.getModel().getValueAt(index, 0).toString();
					String name = table.getModel().getValueAt(index, 1).toString();
					String bothsexes = table.getModel().getValueAt(index, 2).toString();
					String female = table.getModel().getValueAt(index, 3).toString();
					String male = table.getModel().getValueAt(index, 4).toString();
					label.setText(id);
					textField_2.setText(name);
					textField_3.setText(bothsexes);
					textField_4.setText(female);
					textField_5.setText(male);					
				}
				
			}
		});
	}
	public static Vector<String> getHeader(){
		Vector<String> vh = new Vector<String>();
		vh.add("id");
		vh.add("name");
		vh.add("bothsexes");
		vh.add("female");
		vh.add("male");
		return vh;
	}
	public Vector< Vector<Object> >getData(List<CountryExpectancy> countryExpectancies){
		Vector< Vector<Object> > vd = new Vector<Vector<Object>>();
		for(CountryExpectancy obj:countryExpectancies) {
			Vector<Object> v = new Vector<Object>();
			v.add(obj.getId());
			v.add(obj.getName());
			v.add(obj.getBothSex());
			v.add(obj.getFemale());
			v.add(obj.getMale());
			vd.add(v);
		}
		return vd;
	}
	
	public void ReLoadData(List<CountryExpectancy> countryExpectancies) {
		Vector< Vector<Object> > vd =getData(countryExpectancies);
		DefaultTableModel tabModel = new DefaultTableModel(vd,getHeader());
		table.setModel(tabModel);	
	}
	
	//this is read action, params 1=preStmt 0=Stmt
	public void ReadAction(int method) {
		double from = 0;
		double to = 0;
		try {
			from = Double.parseDouble(textField.getText()); 
			to = Double.parseDouble(textField_1.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null,"Please input valid number");  
			e1.printStackTrace();
		} 
		List<Object> params = new ArrayList<Object>();
		String columnName =String.valueOf(comboBox.getSelectedItem());
		params.add(from);
		params.add(to);
		List<CountryExpectancy> newData= method==1?new CountryExpectancyDao1().findByRangeUsingPreStmt(columnName,params):new CountryExpectancyDao1().findByRangeUsingStmt(columnName,params);
		ReLoadData(newData);
		
	}
	//this is read action, params 1=preStmt 0=Stmt
	public void DeleteAction(int method) {
		int result =JOptionPane.showConfirmDialog(null,"Are you sure to delete this record ?","Delete Action",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(label.getText());
			int affactedRow=method==1? new CountryExpectancyDao2().deleteCountryExpectancyUsingPreStmt(id):new CountryExpectancyDao2().deleteCountryExpectancyUsingStmt(id);
			List<CountryExpectancy> data= new CountryExpectancyDao1().findAll();
			ReLoadData(data);
			JOptionPane.showMessageDialog(null,"Affected Row("+affactedRow+")");
		}
		
	}
	//this is update or create action, params 1=preStmt 0=Stmt
	public void CreateOrUpdateAction(int method,String actionType) {
		CountryExpectancy bean=BeanValidation();
		int affactedRow=-1;
		if (bean!=null) {
			if (actionType=="Create") {
				affactedRow=method==1? new CountryExpectancyDao2().addCountryExpectancyUsingPreStmt(bean):new CountryExpectancyDao2().addCountryExpectancyUsingStmt(bean);	
			}else {
				affactedRow=method==1? new CountryExpectancyDao2().updateCountryExpectancyUsingPreStmt(bean):new CountryExpectancyDao2().updateCountryExpectancyUsingStmt(bean);	
			}
			List<CountryExpectancy> data= new CountryExpectancyDao1().findAll();
			ReLoadData(data);
			JOptionPane.showMessageDialog(null,"Affected Row("+affactedRow+")");
		}
	}
	//bean validation
	public CountryExpectancy BeanValidation() {
		int id = Integer.parseInt(label.getText());
		String name = textField_2.getText();
		if(name == null || name.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Name shoud not be blank"); 
			return null;
		}
		double bothsex=0;
		double female=0;
		double male=0;
		try {
			bothsex =Double.parseDouble(textField_3.getText());  
			female =Double.parseDouble(textField_4.getText());
			male =Double.parseDouble(textField_5.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Please input valid number"); 
			return null;
		}
		CountryExpectancy bean = new CountryExpectancy(id,name,bothsex,female,male);
		
		return bean;
	}
}

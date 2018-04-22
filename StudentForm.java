package com.swingdemo.client;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.org.apache.xerces.internal.impl.XMLScanner.NameType;


import com.swingdemo.models.Student;
import com.swingdemo.serviceimpl.StudentServiceImpl;
import com.swingdemo.services.StudentService;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import java.awt.Color;

import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.util.List;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblStudentForm;
	private JLabel lblName;
	private JTextField nameField;
	private JLabel lblBirthdate;
	private JLabel lblFaculty;
	private JTextField facultyField;
	private JLabel lblSemester;
	private JLabel lblCollegeName;
	private JTextField collegeField;
	private JTextField semesterField;
	private JPanel genderField;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblAddress;
	private JTextField addressField;
	private JLabel lblPhoneNo;
	private JTextField phoneField;
	private JButton btnSave;
	private JLabel lblRollNo;
	private JTextField rollField;
	private JDateChooser dateField;
	private JButton btnBack;
	private JButton btnViewDetails;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnExit;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnPrint;
	private JButton btnGoogle;
	private JLabel imgBox;
	
	private String imgPath = "D:/eclipse/filesEclipse/swingdemo/images/";
	private String picName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setTitle("Student Management Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getBtnBack());
		contentPane.add(getBtnViewDetails());
		contentPane.add(getBtnEdit());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnExit());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnPrint());
		populateData();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(12, 13, 997, 213);
			panel.setLayout(null);
			panel.add(getLblStudentForm());
			panel.add(getLblName());
			panel.add(getNameField());
			panel.add(getLblBirthdate());
			panel.add(getLblFaculty());
			panel.add(getFacultyField());
			panel.add(getLblSemester());
			panel.add(getLblCollegeName());
			panel.add(getCollegeField());
			panel.add(getSemesterField());
			panel.add(getGenderField());
			panel.add(getLblAddress());
			panel.add(getAddressField());
			panel.add(getLblPhoneNo());
			panel.add(getPhoneField());
			panel.add(getBtnSave());
			panel.add(getLblRollNo());
			panel.add(getRollField());
			panel.add(getDateField());
			panel.add(getBtnGoogle());
			panel.add(getImgBox());
		}
		return panel;
	}
	private JLabel getLblStudentForm() {
		if (lblStudentForm == null) {
			lblStudentForm = new JLabel("Student Form");
			lblStudentForm.setBounds(0, 0, 84, 16);
		}
		return lblStudentForm;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setBounds(0, 32, 56, 16);
		}
		return lblName;
	}
	private JTextField getNameField() {
		if (nameField == null) {
			nameField = new JTextField();
			nameField.setBounds(49, 29, 116, 22);
			nameField.setColumns(10);
		}
		return nameField;
	}
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("BirthDate");
			lblBirthdate.setBounds(196, 32, 56, 16);
		}
		return lblBirthdate;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setBounds(0, 85, 56, 16);
		}
		return lblFaculty;
	}
	private JTextField getFacultyField() {
		if (facultyField == null) {
			facultyField = new JTextField();
			facultyField.setBounds(49, 82, 116, 22);
			facultyField.setColumns(10);
		}
		return facultyField;
	}
	private JLabel getLblSemester() {
		if (lblSemester == null) {
			lblSemester = new JLabel("Semester");
			lblSemester.setBounds(196, 85, 56, 16);
		}
		return lblSemester;
	}
	private JLabel getLblCollegeName() {
		if (lblCollegeName == null) {
			lblCollegeName = new JLabel("College Name");
			lblCollegeName.setBounds(501, 85, 89, 16);
		}
		return lblCollegeName;
	}
	private JTextField getCollegeField() {
		if (collegeField == null) {
			collegeField = new JTextField();
			collegeField.setBounds(629, 82, 116, 22);
			collegeField.setColumns(10);
		}
		return collegeField;
	}
	private JTextField getSemesterField() {
		if (semesterField == null) {
			semesterField = new JTextField();
			semesterField.setBounds(287, 82, 116, 22);
			semesterField.setColumns(10);
		}
		return semesterField;
	}
	private JPanel getGenderField() {
		if (genderField == null) {
			genderField = new JPanel();
			genderField.setBounds(12, 125, 153, 62);
			genderField.setLayout(null);
			genderField.add(getLblGender());
			genderField.add(getRdbtnMale());
			genderField.add(getRdbtnFemale());
		}
		return genderField;
	}
	private JLabel getLblGender() {
		if (lblGender == null) {
			lblGender = new JLabel("Gender");
			lblGender.setBounds(0, 0, 56, 16);
		}
		return lblGender;
	}
	private JRadioButton getRdbtnMale() {
		if (rdbtnMale == null) {
			rdbtnMale = new JRadioButton("Male");
			buttonGroup.add(rdbtnMale);
			rdbtnMale.setBounds(0, 28, 56, 25);
		}
		return rdbtnMale;
	}
	private JRadioButton getRdbtnFemale() {
		if (rdbtnFemale == null) {
			rdbtnFemale = new JRadioButton("Female");
			buttonGroup.add(rdbtnFemale);
			rdbtnFemale.setBounds(60, 28, 85, 25);
		}
		return rdbtnFemale;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(196, 154, 56, 16);
		}
		return lblAddress;
	}
	private JTextField getAddressField() {
		if (addressField == null) {
			addressField = new JTextField();
			addressField.setBounds(287, 151, 116, 22);
			addressField.setColumns(10);
		}
		return addressField;
	}
	private JLabel getLblPhoneNo() {
		if (lblPhoneNo == null) {
			lblPhoneNo = new JLabel("Phone No.");
			lblPhoneNo.setBounds(415, 154, 81, 16);
		}
		return lblPhoneNo;
	}
	private JTextField getPhoneField() {
		if (phoneField == null) {
			phoneField = new JTextField();
			phoneField.setBounds(489, 151, 116, 22);
			phoneField.setColumns(10);
		}
		return phoneField;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Student s = new Student();
					s.setName(nameField.getText());
					s.setAddress(addressField.getText());
					s.setCollege(collegeField.getText());
					s.setFaculty(facultyField.getText());
					s.setPhone(phoneField.getText());
					s.setSemester(semesterField.getText());
					
					if(rdbtnMale.isSelected()){
						s.setGender("Male");
					}else{
						s.setGender("Female");
					}
					
					s.setRollno(Integer.parseInt(rollField.getText()));
					s.setDob(new Date(dateField.getDate().getTime()));
					
					s.setImageName(picName);
					uploadImage();
					
					StudentService ss = new StudentServiceImpl();
					if(ss.addStudent(s)){
						JOptionPane.showMessageDialog(null, "Added");
						populateData();
					}else{
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			});
			btnSave.setBounds(629, 150, 97, 25);
		}
		return btnSave;
	}
	private JLabel getLblRollNo() {
		if (lblRollNo == null) {
			lblRollNo = new JLabel("Roll No.");
			lblRollNo.setBounds(549, 32, 56, 16);
		}
		return lblRollNo;
	}
	private JTextField getRollField() {
		if (rollField == null) {
			rollField = new JTextField();
			rollField.setBounds(629, 29, 116, 22);
			rollField.setColumns(10);
		}
		return rollField;
	}
	private JDateChooser getDateField() {
		if (dateField == null) {
			dateField = new JDateChooser();
			dateField.setBounds(290, 26, 100, 22);
		}
		return dateField;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.setBounds(58, 512, 97, 25);
		}
		return btnBack;
	}
	private JButton getBtnViewDetails() {
		if (btnViewDetails == null) {
			btnViewDetails = new JButton("View details");
			btnViewDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(table.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Select any row!");
						return;
					}
					
					int row = table.getSelectedRow();
					int sid = (int)table.getModel().getValueAt(row, 0);	//returns as obj so casting is reqd;

					ViewForm vf = new ViewForm();
					vf.displayAllData(sid);
					vf.setVisible(true);
					
					dispose(); // closes current form

					
				}
			});
			btnViewDetails.setBounds(201, 512, 116, 25);
		}
		return btnViewDetails;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Edit");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(table.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Select any row!");
						return;
					}
					
					int row = table.getSelectedRow();
					int sid = (int)table.getModel().getValueAt(row, 0);	//returns as obj so casting is reqd;

					EditForm ef = new EditForm();
					ef.displayAllData(sid);
					ef.setVisible(true);
					
					dispose(); // closes current form
					
				}
			});
			btnEdit.setBounds(353, 512, 97, 25);
		}
		return btnEdit;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(table.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Select any row!");
						return;
					}
					
					int row = table.getSelectedRow();
					int sid = (int)table.getModel().getValueAt(row, 0);	//returns as obj so casting is reqd;
					
					StudentService ss = new StudentServiceImpl();
					if(ss.deleteStudent(sid)){
						JOptionPane.showMessageDialog(null, "Delete Success");
						populateData();
					}
					
				}
			});
			btnDelete.setBounds(494, 512, 97, 25);
		}
		return btnDelete;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					System.exit(0);
					
				}
			});
			btnExit.setBounds(718, 512, 97, 25);
		}
		return btnExit;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 253, 997, 213);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Faculty", "College"
				}
			));
		}
		return table;
	}
	
	private void populateData(){
		
		StudentService ss = new StudentServiceImpl();
		List<Student> slist = ss.getAllStudent();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for(Student s : slist){
			model.addRow(new Object[]{s.getId(),s.getName(),s.getFaculty(),s.getCollege()});
		}
		
	}
	
	
	
	
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						table.print();
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			btnPrint.setBounds(609, 512, 97, 25);
		}
		return btnPrint;
	}
	private JButton getBtnGoogle() {
		if (btnGoogle == null) {
			btnGoogle = new JButton("Google");
			btnGoogle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						URI uri = new URI("http://www.google.com");
						Desktop.getDesktop().browse(uri);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
						e.printStackTrace();
					}
					
				}
			});
			btnGoogle.setBounds(629, 117, 97, 25);
		}
		return btnGoogle;
	}
	private JLabel getImgBox() {
		if (imgBox == null) {
			imgBox = new JLabel("");
			imgBox.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(null);
					
					File img = jf.getSelectedFile();
					picName = img.getName();
					
					imgBox.setIcon(new ImageIcon(new ImageIcon(img.getAbsolutePath()).getImage().getScaledInstance(imgBox.getWidth(), imgBox.getHeight(), Image.SCALE_DEFAULT)));
					
					
				}
			});
			imgBox.setBorder(new LineBorder(Color.GREEN, 1, true));
			imgBox.setBounds(786, 32, 185, 138);
		}
		return imgBox;
	}
	
	private void uploadImage(){
		
		ImageIcon ic = (ImageIcon) imgBox.getIcon();
		BufferedImage img = new BufferedImage(ic.getIconWidth(), ic.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.createGraphics();
		ic.paintIcon(null, g, 0, 0);
		
		File out = new File(imgPath + picName);
		try {
			ImageIO.write(img, "jpg", out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBox.setIcon(null);
		
		
	}
	
}

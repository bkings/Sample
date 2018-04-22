package com.swingdemo.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.swingdemo.models.Student;
import com.swingdemo.serviceimpl.StudentServiceImpl;
import com.swingdemo.services.StudentService;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField nameField;
	private JLabel lblAddress;
	private JTextField addressField;
	private JLabel lblGender;
	private JTextField genderField;
	private JLabel lblDob;
	private JDateChooser dateChooser;
	private JLabel lblCollege;
	private JTextField collegeField;
	private JLabel lblSemester;
	private JTextField semesterField;
	private JLabel lblFaculty;
	private JTextField facultyField;
	private JLabel lblPhone;
	private JTextField phoneField;
	private JLabel lblRollNo;
	private JTextField rollField;
	
	private int uid = 0;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private String imgPath = "D:/eclipse/filesEclipse/swingdemo/images/";
	private JLabel imgBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewForm frame = new ViewForm();
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
	public ViewForm() {
		setTitle("Edit Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getNameField());
		contentPane.add(getLblAddress());
		contentPane.add(getAddressField());
		contentPane.add(getLblGender());
		contentPane.add(getGenderField());
		contentPane.add(getLblDob());
		contentPane.add(getDateChooser());
		contentPane.add(getLblCollege());
		contentPane.add(getCollegeField());
		contentPane.add(getLblSemester());
		contentPane.add(getSemesterField());
		contentPane.add(getLblFaculty());
		contentPane.add(getFacultyField());
		contentPane.add(getLblPhone());
		contentPane.add(getPhoneField());
		contentPane.add(getLblRollNo());
		contentPane.add(getRollField());
		contentPane.add(getBtnBack());
		contentPane.add(getImgBox());
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setBounds(107, 63, 56, 16);
		}
		return lblName;
	}
	private JTextField getNameField() {
		if (nameField == null) {
			nameField = new JTextField();
			nameField.setEnabled(false);
			nameField.setBounds(222, 60, 207, 22);
			nameField.setColumns(10);
		}
		return nameField;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(107, 115, 56, 16);
		}
		return lblAddress;
	}
	private JTextField getAddressField() {
		if (addressField == null) {
			addressField = new JTextField();
			addressField.setEnabled(false);
			addressField.setBounds(222, 112, 207, 22);
			addressField.setColumns(10);
		}
		return addressField;
	}
	private JLabel getLblGender() {
		if (lblGender == null) {
			lblGender = new JLabel("Gender");
			lblGender.setBounds(107, 172, 56, 16);
		}
		return lblGender;
	}
	private JTextField getGenderField() {
		if (genderField == null) {
			genderField = new JTextField();
			genderField.setEnabled(false);
			genderField.setBounds(222, 169, 207, 22);
			genderField.setColumns(10);
		}
		return genderField;
	}
	private JLabel getLblDob() {
		if (lblDob == null) {
			lblDob = new JLabel("DOB");
			lblDob.setBounds(107, 227, 56, 16);
		}
		return lblDob;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setEnabled(false);
			dateChooser.setBounds(223, 221, 206, 22);
		}
		return dateChooser;
	}
	private JLabel getLblCollege() {
		if (lblCollege == null) {
			lblCollege = new JLabel("College");
			lblCollege.setBounds(107, 278, 56, 16);
		}
		return lblCollege;
	}
	private JTextField getCollegeField() {
		if (collegeField == null) {
			collegeField = new JTextField();
			collegeField.setEnabled(false);
			collegeField.setBounds(222, 275, 207, 22);
			collegeField.setColumns(10);
		}
		return collegeField;
	}
	private JLabel getLblSemester() {
		if (lblSemester == null) {
			lblSemester = new JLabel("Semester");
			lblSemester.setBounds(107, 331, 56, 16);
		}
		return lblSemester;
	}
	private JTextField getSemesterField() {
		if (semesterField == null) {
			semesterField = new JTextField();
			semesterField.setEnabled(false);
			semesterField.setBounds(222, 328, 207, 22);
			semesterField.setColumns(10);
		}
		return semesterField;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setBounds(107, 379, 56, 16);
		}
		return lblFaculty;
	}
	private JTextField getFacultyField() {
		if (facultyField == null) {
			facultyField = new JTextField();
			facultyField.setEnabled(false);
			facultyField.setBounds(222, 376, 207, 22);
			facultyField.setColumns(10);
		}
		return facultyField;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setBounds(107, 427, 56, 16);
		}
		return lblPhone;
	}
	private JTextField getPhoneField() {
		if (phoneField == null) {
			phoneField = new JTextField();
			phoneField.setEnabled(false);
			phoneField.setBounds(222, 424, 207, 22);
			phoneField.setColumns(10);
		}
		return phoneField;
	}
	private JLabel getLblRollNo() {
		if (lblRollNo == null) {
			lblRollNo = new JLabel("Roll No.");
			lblRollNo.setBounds(107, 472, 56, 16);
		}
		return lblRollNo;
	}
	private JTextField getRollField() {
		if (rollField == null) {
			rollField = new JTextField();
			rollField.setEnabled(false);
			rollField.setBounds(222, 469, 207, 22);
			rollField.setColumns(10);
		}
		return rollField;
	}
	
	public void displayAllData(int id){
		uid = id;
		
		StudentService ss = new StudentServiceImpl();
		Student s = ss.getById(id);
		
		nameField.setText(s.getName());
		addressField.setText(s.getAddress());
		genderField.setText(s.getGender());
		dateChooser.setDate(s.getDob());
		collegeField.setText(s.getCollege());
		semesterField.setText(s.getSemester());
		facultyField.setText(s.getFaculty());
		phoneField.setText(s.getPhone());
		rollField.setText(new Integer(s.getRollno()).toString());
		imgBox.setIcon(new ImageIcon(new ImageIcon(imgPath + s.getImageName()).getImage().getScaledInstance(imgBox.getWidth(), imgBox.getHeight(), Image.SCALE_DEFAULT)));
		
	}
	
	
	
	
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new StudentForm().setVisible(true);
					dispose();
				}
			});
			btnBack.setBounds(233, 523, 97, 25);
		}
		return btnBack;
	}
	private JLabel getImgSet() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			lblNewLabel.setBounds(506, 65, 169, 158);
		}
		return lblNewLabel;
	}
	private JLabel getImgBox() {
		if (imgBox == null) {
			imgBox = new JLabel("");
			imgBox.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			imgBox.setBounds(464, 63, 300, 231);
		}
		return imgBox;
	}
}

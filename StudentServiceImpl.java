package com.swingdemo.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.swingdemo.db.DB;
import com.swingdemo.models.Student;
import com.swingdemo.services.StudentService;

public class StudentServiceImpl implements StudentService{
	
	Connection con = null;
	
	public StudentServiceImpl(){ // constructor-every time object is created constructor is called resulting code redundancy;
		
		con = DB.getDbCon();
	}

	@Override
	public boolean addStudent(Student s) {
		
		String sql = "insert into student(name,address,gender,dob,college,semester,faculty,phone,rollno,imageName)values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getName());		// 1 specifies the first parameter in the query
			pstm.setString(2, s.getAddress());
			pstm.setString(3, s.getGender());
			pstm.setDate(4, s.getDob());
			pstm.setString(5, s.getCollege());
			pstm.setString(6, s.getSemester());
			pstm.setString(7, s.getFaculty());
			pstm.setString(8, s.getPhone());
			pstm.setInt(9, s.getRollno());
			pstm.setString(10, s.getImageName());
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> slist = new ArrayList<Student>();
		String sql = "select * from student";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setFaculty(rs.getString("faculty"));
			s.setCollege(rs.getString("college"));
			slist.add(s);
		}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return slist;
	}

	@Override
	public boolean deleteStudent(int id) {
		
			String sql = "delete from student where id = ' "+id+" ' ";
			
			try {
				Statement stm = con.createStatement();
				stm.execute(sql);
				return true;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		
String sql = "update  student set name=?,address=?,gender=?,dob=?,college=?,semester=?,faculty=?,phone=?,rollno=? where id = ?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getAddress());
			pstm.setString(3, s.getGender());
			pstm.setDate(4, s.getDob());
			pstm.setString(5, s.getCollege());
			pstm.setString(6, s.getSemester());
			pstm.setString(7, s.getFaculty());
			pstm.setString(8, s.getPhone());
			pstm.setInt(9, s.getRollno());
			pstm.setInt(10, s.getId());
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return false;

		
	}

	@Override
	public Student getById(int id) {
		
		Student s = new Student();
		String sql = "select * from student where Id = ' " +id+ "  ' ";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
			
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setFaculty(rs.getString("faculty"));
			s.setCollege(rs.getString("college"));
			s.setAddress(rs.getString("address"));
			s.setDob(rs.getDate("dob"));
			s.setSemester(rs.getString("semester"));
			s.setPhone(rs.getString("phone"));
			s.setGender(rs.getString("gender"));
			s.setRollno(rs.getInt("rollno"));
			s.setImageName(rs.getString("imageName"));
			
		}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		return s;
	}
	

}

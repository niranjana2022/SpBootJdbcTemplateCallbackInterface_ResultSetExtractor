//package com.eidiko.niranjana.dao;
//
//import java.sql.ResultSet;         //Approach 1: Create our own Extractor class which is implements ResultSetExtractor<T>(I) using query method
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.stereotype.Repository;
//
//import com.eidiko.niranjana.entity.StudentsBO;
//@Repository
//public class StudentsDAOImpl implements StudentsDAO {
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public List<StudentsBO> getStudentsDetailsByName(String name) {
//		System.out.println("getStudentsDetailsByName method in DAO impl class");
//		String retrieveMultipleData = "select sno,sname,saddrs,ssal from Students where sname=?";
//		List<StudentsBO> listBO=null;
//		listBO=jdbcTemplate.query(retrieveMultipleData,  //arg1
//				                     new StudentExtractor(), //arg2
//				                     name  //args3  (var args)
//				                     );
//		return listBO;
//	}
//	
//	//nested inner class /static inner class
//	private  static class    StudentExtractor implements ResultSetExtractor<List<StudentsBO>>{
//
//		@Override
//		public List<StudentsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//			System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//			List<StudentsBO>  listBO=null;
//			StudentsBO bo=null;
//			//copy  RS object records to  List of StudentsBO collection
//			listBO=new ArrayList();
//			while(rs.next()) {
//				//get each record into StudentsBO class object
//				bo=new StudentsBO();
//				bo.setSno(rs.getInt(1));
//				bo.setSname(rs.getString(2));
//				bo.setSaddrs(rs.getString(3));
//				bo.setSsal(rs.getFloat(4));
//				//add each BO class obj to List colleciton
//				listBO.add(bo);
//			}//while
//			return listBO;
//		}//extractData(-)
//		
//	}//inner class
//	
////===============================================================================================================
//	
//	@Override
//	public List<StudentsBO> getStudentsDetailsByMultipleName(String name1, String name2, String name3) {
//		Object[] args= {name1,name2,name3};
//		String retrieveStudentsData = "select sno, sname, saddrs, ssal from students where sname IN(?,?,?)";
//		System.out.println("getStudentsDetailsByName method of StudentsDAOImpl class");
//		List<StudentsBO> listBO=null;
//		listBO=jdbcTemplate.query(retrieveStudentsData,  //arg1
//				                     new StudentsExtractor(), //arg2
//				                     name1,name2,name3  //args3  (var args)
//				                     );
//		return listBO;
//	}
//	private  static class    StudentsExtractor implements ResultSetExtractor<List<StudentsBO>>{
//
//		@Override
//		public List<StudentsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//			System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//			List<StudentsBO>  listBO=null;
//			StudentsBO bo=null;
//			//copy  RS object records to  List of StudentsBO collection
//			listBO=new ArrayList();
//			while(rs.next()) {
//				//get each record into StudentsBO class object
//				bo=new StudentsBO();
//				bo.setSno(rs.getInt(1));
//				bo.setSname(rs.getString(2));
//				bo.setSaddrs(rs.getString(3));
//				bo.setSsal(rs.getFloat(4));
//				//add each BO class obj to List colleciton
//				listBO.add(bo);
//			}//while
//			return listBO;
//		}//extractData(-)
//		
//	}//inner class
//	
//	
//}

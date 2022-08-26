//package com.eidiko.niranjana.dao;
//
//import java.sql.ResultSet;         //Approach 2: Create Annonymous Inner class which is implements ResultSetExtractor<T>(I) using query method
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
//public class StudentsDAOImpl2 implements StudentsDAO {
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
//				                     new ResultSetExtractor<List<StudentsBO>>() {
//			@Override
//			public List<StudentsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//				List<StudentsBO>  listBO=null;
//				StudentsBO bo=null;
//				//copy  RS object records to  List of StudentsBO collection
//				listBO=new ArrayList();
//				while(rs.next()) {
//					//get each record into StudentsBO class object
//					bo=new StudentsBO();
//					bo.setSno(rs.getInt(1));
//					bo.setSname(rs.getString(2));
//					bo.setSaddrs(rs.getString(3));
//					bo.setSsal(rs.getFloat(4));
//					//add each BO class obj to List colleciton
//					listBO.add(bo);
//				}//while
//				return listBO;
//			}//extractData(-)
//		}, name  //args3  (var args)
//				                     );
//		return listBO;
//	}
////===================================================================================================================================
//
//	@Override
//	public List<StudentsBO> getStudentsDetailsByMultipleName(String name1, String name2, String name3) {
//		System.out.println("getStudentsDetailsByMultipleName method in DAO impl class");
//		String retrieveMultipleData = "select sno,sname,saddrs,ssal from Students where sname IN(?,?,?)";
//		List<StudentsBO> listBO=null;
//		listBO=jdbcTemplate.query(retrieveMultipleData,  //arg1
//				                     new ResultSetExtractor<List<StudentsBO>>() {
//			@Override
//			public List<StudentsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//				List<StudentsBO>  listBO=null;
//				StudentsBO bo=null;
//				//copy  RS object records to  List of StudentsBO collection
//				listBO=new ArrayList();
//				while(rs.next()) {
//					//get each record into StudentsBO class object
//					bo=new StudentsBO();
//					bo.setSno(rs.getInt(1));
//					bo.setSname(rs.getString(2));
//					bo.setSaddrs(rs.getString(3));
//					bo.setSsal(rs.getFloat(4));
//					//add each BO class obj to List colleciton
//					listBO.add(bo);
//				}//while
//				return listBO;
//			}//extractData(-)
//		}, name1,name2,name3);
//		return listBO;
//	}
//	
//}

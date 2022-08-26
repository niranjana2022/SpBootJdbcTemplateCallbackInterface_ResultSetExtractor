//package com.eidiko.niranjana.dao;
//
//import java.util.ArrayList;    //APPROACH3: Here we use Lambda Expression created and implementes RowMapper<I> and copy RS record to StudentsBO class object
//import java.util.List;		//Lambda exp based annonymous inner class implements ResultSetExtractor<T>(I)
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.eidiko.niranjana.entity.StudentsBO;
//@Repository
//public class StudentsDAOImpl3 implements StudentsDAO {
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
//				 rs->{
//				System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//				List<StudentsBO>  listBOO=null;
//				StudentsBO bo=null;
//				//copy  RS object records to  List of StudentsBO collection
//				listBOO=new ArrayList();
//				while(rs.next()) {
//					//get each record into StudentsBO class object
//					bo=new StudentsBO();
//					bo.setSno(rs.getInt(1));
//					bo.setSname(rs.getString(2));
//					bo.setSaddrs(rs.getString(3));
//					bo.setSsal(rs.getFloat(4));
//					//add each BO class obj to List colleciton
//					listBOO.add(bo);
//				}//while
//				return listBOO;
//			}, name );
//		return listBO;
//	}
////=========================================================================================================
//	@Override
//	public List<StudentsBO> getStudentsDetailsByMultipleName(String name1, String name2, String name3) {
//		System.out.println("getStudentsDetailsByMultipleName method in DAO impl class");
//		String retrieveMultipleData = "select sno,sname,saddrs,ssal from Students where sname IN(?,?,?)";
//		List<StudentsBO> listBO=null;
//		listBO=jdbcTemplate.query(retrieveMultipleData,  //arg1
//				 rs->{
//				System.out.println("StudentDAOImpl.StudentExtractor.extractData(-)");
//				List<StudentsBO>  listBOO=null;
//				StudentsBO bo=null;
//				//copy  RS object records to  List of StudentsBO collection
//				listBOO=new ArrayList();
//				while(rs.next()) {
//					//get each record into StudentsBO class object
//					bo=new StudentsBO();
//					bo.setSno(rs.getInt(1));
//					bo.setSname(rs.getString(2));
//					bo.setSaddrs(rs.getString(3));
//					bo.setSsal(rs.getFloat(4));
//					//add each BO class obj to List colleciton
//					listBOO.add(bo);
//				}//while
//				return listBOO;
//			}, name1,name2,name3 );
//		return listBO;
//	}
//	
//}

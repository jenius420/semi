package common.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.dao.CommonDao;
import common.model.vo.District;
import common.model.vo.JobType;
import empService.model.dao.EmpServiceDao;
import ownerService.model.vo.Appliant;

public class CommonService {
	
	public District selectDistrict(int dongNum, int roadNum) {
		
		Connection conn = getConnection();
		
		District district = null;
		
		if(dongNum == 0) {
			district = new CommonDao().selectDistrict1(conn, roadNum);
		}else {
			district = new CommonDao().selectDistrict2(conn, dongNum);
		}
		
		close(conn);

		return district;
	}
	
	public ArrayList<District> selectDistrictList() {

		Connection conn = getConnection();

		ArrayList<District> list = new CommonDao().selectDistrictList(conn);

		close(conn);

		return list;
	}
	
	public ArrayList<JobType> selectTypeList() {

		Connection conn = getConnection();

		ArrayList<JobType> list = new CommonDao().selectTypeList(conn);

		close(conn);

		return list;
	}
	
	

}

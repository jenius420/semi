package ownerService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.service.CommonService;
import common.model.vo.District;
import empService.model.dao.ResumeDao;
import empService.model.vo.Resume;
import ownerService.model.dao.OwnerServiceDao;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Owner;

public class OwnerServiceService {
	
	public Owner selectOwner(int oNum){
		
		Connection conn = getConnection();

		Owner owner = new OwnerServiceDao().selectOwner(conn, oNum);
		District district = new CommonService().selectDistrict(owner.getDongNum(), owner.getRoadNum());
		
		owner.setDistrictNum(district.getDistrictNum());
		owner.setDistrict(district.getDistrictName());

		close(conn);

		return owner;
		
	}
	
	public ArrayList<Resume> selectResumeList(ArrayList<Appliant> alist) {
		
		Connection conn = getConnection();
		
		ArrayList<Resume> list = new ArrayList<>();
		Resume r = null;
		
		for(Appliant a : alist) {
			r = new ResumeDao().selectResume(conn, a.getrNum());
			list.add(r);
		}
		
		close(conn);
		
		return list;
	}

}

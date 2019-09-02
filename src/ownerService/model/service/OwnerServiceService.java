package ownerService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import common.model.service.CommonService;
import common.model.vo.District;
import ownerService.model.dao.OwnerServiceDao;
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

}

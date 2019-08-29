package ownerService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import ownerService.model.dao.OwnerServiceDao;
import ownerService.model.vo.Owner;

public class OwnerServiceService {
	
public Owner selectOwner(int oNum){
		
		Connection conn = getConnection();

		Owner owner = new OwnerServiceDao().selectOwner(conn, oNum);

		close(conn);

		return owner;
		
	}

}

package ownerService.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import ownerService.model.dao.IncruitDao;
import ownerService.model.dao.IncruitProductDao;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.IncruitProduct;

public class IncruitProductService {
	
	public ArrayList<IncruitProduct> selectIncruitProduct(){
		
		Connection conn = getConnection();

		ArrayList<IncruitProduct> list = new IncruitProductDao().selectIncruitProduct(conn);

		close(conn);

		return list;
		
	}

}

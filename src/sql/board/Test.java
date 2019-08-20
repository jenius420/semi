package sql.board;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int currentPage =10;
		int pageLimit=10;
		int startPage =((currentPage-1)/pageLimit)*10+1;
		System.out.println(startPage);
	}

}

package board.model.vo;

public class PageInfo {

	private int currentPage; 		// 현재 페이지 번호를 표시할 변수
	private int listCount;			// 총 게시글 수
	private int pageLimit;			// 한 페이지에 보여질 페이징바의 총 수
	private int maxPage;			// 전체 페이지에서 가장 마지막 페이지
	private int startPage;			// 한 페이지 하단에 보여질 페이징바의 첫 페이지수
	private int endPage;			// 한 페이지 하단에 보여질 페이징바의 마지막 페이지수
	private int boardLimit;			// 한 페이지에 보여질 게시글 수

	public PageInfo() {
		
	}

	public PageInfo(int currentPage, int listCount, int pageLimit, int maxPage, int startPage, int endPage,
			int boardLimit) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.pageLimit = pageLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.boardLimit = boardLimit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", pageLimit=" + pageLimit
				+ ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage + ", boardLimit="
				+ boardLimit + "]";
	}
	
	
}

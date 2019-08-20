<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 상품 등록</title>
</head>
<body>

	<div class="outer">
	
		<h2>광고 상품 등록</h2>
		
		<div class="tableArea">
			<form action="<%= request.getContextPath()%>/insertProduct.as" get="POST">
			
				<table>
					<tr>
						<td>상품 이름</td>
						<td><input type="text" name="pTitle"></td>	
					</tr>
					<tr>
						<td>요금(단위:일)</td>
						<td><input type="text" name="pPay"></td>	
					</tr>
					<tr>
						<td>상품 설명</td>
						<td colspan="3"><textArea rows="15" cols="60" name="pExplain" style="resize:none;"></textArea></td>	
					</tr>
				</table><br>
				
				<div align="center">
					<button type="submit">등록</button>
					<button onclick="history.back();">취소</button>
				</div>
				
			</form>
		</div>
	
	</div>


</body>
</html>
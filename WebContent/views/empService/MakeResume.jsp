<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ include file="../empService/EmpServiceMenubar.jsp"%>
<%	
	String eName = emp.geteName();
	int phone = emp.getPhone();
	String address = emp.getAddress();
	String email = emp.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�̷¼� ���</title>
</head>
<body>

	<form id="resumeForm" action="<%=request.getContextPath()%>/submitResume.es" method="POST">
		
		���� <input type="text" name="resumeTitle" id="resumeTitle"
			placeholder="�̷¼� ����">
			
		�̸� <%= eName %>
		��ȭ��ȣ<%= phone %>
		�̸���<%= email %>
		
		����ٹ���(��) 
		<select name="district" id="district">
			<option value="������">������</option>
		</select> 
		
		��������� 
		<select name="type" id="type">
			<option value="IT">IT</option>
		</select> 
		
		�����з� 
		<select name="edu" id="edu">
			<option value="��������">��������</option>
		</select> 
		
		����޿����� 
		<select name="desireForm" id="desireForm">
			<option value="�ñ�">�ñ�</option>
		</select> 
		
		����޿� 
		<input type="text" name="desireIncome" id="desireIncome">��
		
		����
		
		�ϰ������
		<textarea name="comment" id="comment" cols="30" rows="10" style="resize:none;"></textarea>
		
		�̷¼��������� 	
		<input type="checkbox" name="openSet" id="openSet"  value="Y" checked>
		
		<input type="hidden" value="�����ָ� �� �Ǵµ� ���� �Ѱܾ� �ϴ� ���">
		
		<input type="submit" value="����Ϸ�" validation �ۼ��ؾ���>
		<input type="reset" value="�ʱ�ȭ">
		<button type="button" onclick="javascript:history.back();">���� ȭ������</button>

	</form>

</body>
</html>
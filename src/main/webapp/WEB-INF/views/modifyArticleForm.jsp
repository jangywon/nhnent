<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>NHN ENTERTAINMENT ASSIGNMENT</title>
</head>
<body>
<body bgcolor="#222222" text="#ffffff">
	<!--
 ��й�ȣ�� �Է� �޾� ���� �� ���� 
 ���� �� ���� ���̺� �÷��� ���� �ð� ���
-->
	<script>
	var checkPassword = function(str) {
		var password= '<c:out value="${article.password}"/>';
		if(str.trim() == password.trim()){
			
			alert("���� �Ϸ�");
			return true;
		}else{
			alert("��й�ȣ�� Ȯ�����ּ���")
			return false;
		}
	}
	</script>


	<table width="640" border="2" cellpadding="0" cellspacing="0"
		bordercolor="#D6D4D6" align="center">
		<tr height="40">
			<td style="padding-left: 20px;" align="center" text="#222222"><b>����
					�����ϱ�</b></td>
		</tr>
		<br>
	</table>
		
		
	<form method="post"
		action="http://localhost:8080/web/newArticle/modify"
		onsubmit="return checkPassword(this.password.value)">
		<table width="600" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td width="600" colspan="4" height="4" bgcolor="#D6D4D6"></td>
			</tr>
			<tr>
				<td>
				<td width="100" height="30" align="left">�۹�ȣ</td>
				</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"
					colspan="3"><input type="text" size="35" name="num"
					value="${article.num}" maxlength="20" READONLY /></td>

			</tr>
			<tr>
				<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
			</tr>
			<tr>
				<td>
				<td width="100" height="30" align="left">�̸���</td>
				</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"
					colspan="3"><input type="text" name="email" size="35"
					maxlength="20" value=${article.email} /></td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
			</tr>
			<tr>
				<td>
				<td width="100" height="30" align="left" name="password">��й�ȣ</td>
				</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"
					colspan="3"><input type="password" name="password" size="35"
					maxlength="20" /></td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
			</tr>

			<tr>
				<td width="500" colspan="3" style="padding-left: 10px;" align="left">

					<textarea TextMode="MultiLine" wrap="true" name="contents" rows="3"
						cols="84" style="height: 200px;">${article.contents}</textarea>
				</td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#D6D4D6"></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="35" align="right"
					style="padding-right: 15px;"><input type="submit" value="�����ϱ�" />
			</tr>
		</table>
	</form>
</html>


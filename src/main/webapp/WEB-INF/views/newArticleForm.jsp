<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>NHNjj</title>
</head>
<script>

// 정규표현식을 이용한 E-mail Check

	var checkEmail = function(str) {
		alert(str);
		if (/^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/
				.test(str) == false) {
			alert("E-mail 형식을 체크해주세요");
			return false;
		} else {
			alert("글이 정상적으로 등록되었습니다.");
			return true;
		}
	}

	var modifyData = function(id) {
		var input = id;
		var id = input.getAttribute('value');
		document.location.href = "http://localhost:8080/web/modifyArticle?num="
				+ id;
	};
</script>
<body bgcolor="#222222" text="#ffffff">

	<center>
		<br />&nbsp;<br />
		<table width="640" border="2" cellpadding="0" cellspacing="0"
			bordercolor="#D6D4D6" align="center">
			<tr height="40">
				<td style="padding-left: 20px;" align="center" text="#222222">
				<b>NHN ENTERTAINMENT 방 명 록</b></td>
			</tr>
		</table>

		<br />&nbsp;<br />
		<form method="post"
			action="http://localhost:8080/web/newArticle/submit" onsubmit = "return checkEmail(this.email.value)">
			<table width="600" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<td width="600" colspan="4" height="4" bgcolor="#D6D4D6"></td>
				</tr>
				<tr>
					<td>
					<td width="100" height="30" align="left">이메일</td>
					</td>
					<td width="240" height="30" style="padding-left: 10px;"
						align="left" colspan="3"><input type="text" name="email"
						size="35" maxlength="20"/></td>
				</tr>

				<tr>
					<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
				</tr>
				<tr>
					<td>
					<td width="100" height="30" align="left">비밀번호</td>
					</td>
					<td width="240" height="30" style="padding-left: 10px;"
						align="left" colspan="3"><input type="password"
						name="password" size="35" maxlength="20" class="boxTF" /></td>
				</tr>

				<tr>
					<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
				</tr>

				<tr>
					<td width="500" colspan="3" style="padding-left: 10px;"
						align="left"><textarea name="contents" rows="3" cols="84"
							style="height: 200px;"></textarea></td>
				</tr>

				<tr>
					<td width="600" colspan="4" height="3" bgcolor="#D6D4D6"></td>
				</tr>
				<tr>
					<td width="600" colspan="4" height="35" align="right"
						style="padding-right: 15px;"><input type="submit"
						value="등록하기" />
				</tr>
			</table>
		</form>


		<table width="600" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<c:forEach var="listv" items="${list}">
				<tr>
					<td width="600" colspan="10" height="5" bgcolor="#D6D4D6"></td>
				</tr>
				<tr>
				<tr>
				<tr>
					<td width="50%" align="left">No. ${listv.num}</td>
					<td width="50%" align="right">Email : ${listv.email}
						<p>Date : ${listv.writedate}
					</td>
					<td><div id="${listv.num}" value="${listv.num}"
							onclick="modifyData(this)">modify</div></td>
				</tr>
				<tr>
					<td width="600" colspan="4" height="1" bgcolor="#D6D4D6"></td>
				</tr>

				<td height="150">
					<p>${listv.contents}</p>  
				</td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
		</form>
</html>


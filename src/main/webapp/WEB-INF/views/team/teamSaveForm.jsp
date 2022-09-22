<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br />
<h2 style="text-align: center">팀 등록</h2>
<br />
<div class="container">
	<form>
		<div class="d-flex justify-content-center">
			<select id="stadium">
				<option value="none">== 팀 선택 ==</option>
				<c:forEach var="teamList" items="${teamList}">
					<option value="${teamList.stadiumId}">${teamList.stadiumName}</option>
				</c:forEach>
			</select>
			<div style="width: 500px">
				<input id="teamName" class="form-control" placeholder="구단 이름 작성" />
			</div>
			<button id="btnSave" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script>
	$("#btnSave").click(()=>{
		teamSave();
	});
	

	function teamSave(){

		let data = {
				stadiumId : $("#stadium option:selected").val(),
				name : $("#teamName").val()
		};
		
		$.ajax("/team/teamSave",{
			type : "POST",
			dataType :"json",
			data: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("팀 등록 성공");
				location.href = "/team/teamList";
			}
		});
	}
		
		

  </script>

<%@ include file="../layout/footer.jsp"%>

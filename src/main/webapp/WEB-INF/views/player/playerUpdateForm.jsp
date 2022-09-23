<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br />
<h2 style="text-align: center">선수 수정</h2>
<br />
<div class="container">
	<form>
		<div class="d-flex justify-content-center">
		<input id="playerId" type="hidden" value="${player.id }">
			<select id="team">
				<option value="none">== 팀 선택 ==</option>
				<c:forEach var="playerList" items="${playerList}">
					<option value="${playerList.teamId}">${playerList.teamname}</option>
				</c:forEach>
			</select>
			<select id="position">
				<option value="none">== 포지션 선택 ==</option>
				<c:forEach var="playerList" items="${playerList}">
					<option value="${playerList.position}">${playerList.position}</option>
				</c:forEach>
			</select>
			<div style="width: 300px">
				<input id="playerName" class="form-control" placeholder="선수이름 작성" value="${player.name}"/>
			</div>
			<button id="btnUpdate" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>

<script >


	$("#btnUpdate").click(()=>{
		playerUpdate();
	});
	

	function playerUpdate(){

		let data = {
				name : $("#playerName").val(),
				teamId : $("#team option:selected").val(),
				position : $("#position option:selected").val()
		};
		console.log(data);
		let id = $("#playerId").val();
		$.ajax("/player/update/"+id,{
			type : "PUT",
			dataType :"json",
			data: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("선수 수정 성공");
				location.href = "/player/playerList";
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>

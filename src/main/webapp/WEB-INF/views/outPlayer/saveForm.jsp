<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br />
<h2 style="text-align: center">선수 퇴출</h2>
<br />
<div class="container">
	<form>
		<div class="d-flex justify-content-center">
			<select id="player">
				<option value="none">= 선수 선택 =</option>
				<c:forEach var="outPlayer" items="${outPlayerList}">
					<option value="${outPlayer.id}">${outPlayer.name}</option>
				</c:forEach>
			</select>
			<div style="width: 500px">
				<input id="reason" class="form-control" placeholder="퇴출 사유" />
			</div>
			<button id="btnSave" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script>
	$("#btnSave").click(()=>{
		playerOutReasonSave();
	});
	

	function playerOutReasonSave(){

		let data = {
				playerId : $("#player option:selected").val(),
				reason : $("#reason").val()
		};
		let id = $("#player option:selected").val();
		$.ajax("/outPlayer/out/"+id,{
			type : "POST",
			dataType :"json",
			data: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("퇴출 사유 입력 성공");
				location.href = "/outPlayer/list/1";
			}
		});
	}
		
		

  </script>

<%@ include file="../layout/footer.jsp"%>

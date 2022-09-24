<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br />
<h2 style="text-align: center">팀 수정</h2>
<br />
<div class="container">
	<form>
		<div class="d-flex justify-content-center">
			<input id="teamId" type="hidden" value="${team.id}">

			<select id="stadium">
				<option value="none">경기장 선택</option>
				<c:forEach var="teamList" items="${teamList}">
					<option value="${teamList.stadiumId}" >${teamList.stadiumName}</option>
				</c:forEach>
			</select>
			<div style="width: 500px">
				<input id="teamName" class="form-control" placeholder="구단 이름 작성" value="${team.name}" />
			</div>
			<button id="btnUpdate" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script>

let foundedinputsStadium = [];
$("select[id=stadium] option").each(function() {
  if($.inArray(this.value, foundedinputsStadium) != -1) $(this).remove();
  foundedinputsStadium.push(this.value);
});

	$("#btnUpdate").click(()=>{
		teamUpdate();
	});
	

	function teamUpdate(){

		let data = {
				stadiumId : $("#stadium option:selected").val(),
				name : $("#teamName").val()
		};
		let id = $("#teamId").val();
		$.ajax("/team/update/"+id,{
			type : "PUT",
			dataType :"json",
			data: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("팀 수정 성공");
				location.href = "/team/list";
			}
		});
	}
		
		

  </script>

<%@ include file="../layout/footer.jsp"%>

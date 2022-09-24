<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br/>
<h2 style="text-align: center">경기장 수정</h2>
<br/>
<div class="container">
	<form>
			<div class="d-flex justify-content-center">
				<div style="width: 500px">
				<input id="stadiumId" type="hidden" value="${stadium.id }">
			<input id="stadiumName" class="form-control" placeholder="경기장 이름 입력" value="${stadium.name}"/>
				</div>
			<button id="btnUpdate" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script>

	$("#btnUpdate").click(()=>{
		stardiumUpdate();
	});
	
	function stardiumUpdate(){
		let data = {
				id : $("#stadiumId").val(),
				name : $("#stadiumName").val()
		};
		
		let id = $("#stadiumId").val();
		$.ajax("/stadium/update/"+id,{
			type : "PUT",
			dataType :"json",
			data: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				alert("경기장 수정 성공");
				location.href = "/stardium/list";
			}
		});
	}
		
		

  </script>

<%@ include file="../layout/footer.jsp"%>

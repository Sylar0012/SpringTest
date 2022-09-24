<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3" style="text-align: center;">
	<h2 style="text-align: center">경기장 목록</h2>
	<table class="table table-bordered">
		<thead>
			<tr style="text-align: center;">
				<th>번호</th>
				<th>이름</th>
				<th>개장일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<form>
				<c:forEach var="stadium" items="${stadiumList}">
					<tr>
						<c:set var="count" value="${count+1}" />
						<td>${count }</td>
						<td>${stadium.name }</td>
						<td>${stadium.createdAt }</td>
						<td><a href="/stadium/updateForm/${stadium.id}"><i
								class="fa-solid fa-gears"></i></a></td>
						<td><label> <input id="stadiumId" type="checkbox"
								value="${stadium.id}">
						</label></td>
					</tr>
				</c:forEach>
				<button style="float: right; margin-right: 40px;" id="btnDelete"
					type="button" class="btn btn-primary">삭제</button>
				<br />
			</form>
		</tbody>
	</table>
</div>

<script type="text/javascript">
$("#btnDelete").click(()=>{
	stadiumDelete();	
})

function stadiumDelete(){
	let stadiumIdArr = [];
	$("input:checkbox[id='stadiumId']:checked").each(function() {
		stadiumIdArr.push($(this).val()); 
	})
	
	for(let i =0; i<stadiumIdArr.length; i++){
		let id = stadiumIdArr[i];
		console.log(id);
		
	$.ajax("/stadium/delete/"+id, {
		type : "DELETE",
		dataType : "json"
	}).done((res) =>{
		if(res.code == 1){
			alert("스타티움 삭제 성공");
			location.href = "/";
		}
	});
	}
}
</script>

<%@ include file="../layout/footer.jsp"%>

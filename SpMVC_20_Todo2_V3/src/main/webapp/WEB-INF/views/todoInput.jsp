<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form class="form" id="todoInput" method="post"
	enctype="multipart/form-data">
	<div class="image_wrapper">
		<img id="to_image_thumnail"
			src="${rootPath}/static/images/noImage.png" width="30px">
	</div>
	<input name="to_text" placeholder="TODO">
	<div class="insert-button">추가</div>
	<input accept="image/*" id="imgTag" name="to_image" type="file" />
</form>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		// noImage 부분 클릭 시 사진 파일 선택 popup이 나온다.
		document.querySelector("div.image_wrapper").addEventListener("click",
				function() {
					document.querySelector("input#imgTag").click()
				})
				
		document.querySelector("div.insert-button").addEventListener("click", function() {
			const main_form = document.querySelector("form#todoInput")
			// input에 담긴 데이터를 form 데이터로 변경하기 위한 코드...?
			// form에 담긴 데이터를 취급하기 위한 클래스
			const upData = new FormData(main_form)
			
			const todoText = document.querySelector("input[name='to_text']").value
			const todoImage = document.querySelector("input[name='to_image']")
			
			// upData.append("to_image", todoImage.files[0])
			// upData.append("to_text", todoText)
			
			fetch("${rootPath}/upload", {
					method: 'POST',
					body: upData
			})
			.then(result=>result.json())
			.then(json=>{
				alert(JSON.stringify(json))
				document.querySelector("img#imgView").src="${rootPath}/files/" + json.SAVENAME
			})
		})

		// input type=file tag를 클릭하고 fileOpenDialog가 뜨고 파일 선택 후 Open을 누른 후의 Event 
		const imgTag = document.querySelector("input#imgTag")
		if(imgTag) {
			imgTag.addEventListener("change", function() {
				// fileOpen Dialog에서 선택한 파일들 getter
				const fileList = imgTag.files
				
				// 선택한 파일 중 첫 번째 파일만 또 getter
				const file0 = fileList[0]
				
				// 파일 열기(읽기) 클래스
				const fileReader = new FileReader()
				fileReader.readAsDataURL(file0)
				
				// 파일을 열고 모두 읽어 들였으면
				fileReader.onload = function() {
					document.querySelector("img#to_image_thumnail").src = fileReader.result
				}
				
				// 첫 번째 파일 이름 alert()
				// alert(file0.name)
			})
		}
	})
</script>
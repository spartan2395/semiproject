<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="https://apis.google.com/js/platform.js" async defer></script>
<meta name = "google-signin-client_id" content="261347811871-g4ri915lfl53tn24smcrch9r9fcr7dtm.apps.googleusercontent.com">
<script type="text/javascript">
	function onSignIn(googleUser){
		var profile = googleUser.getBasicProfile();
		console.log("ID : "+profile.getID());
		console.log("Name : "+profile.getName());
		console.log("Image URL : "+profile.getImageUrl());
		console.log("Email")
	}
	
</script>
</head>
<body>
	<div class="g-signin2" data-onsuccess="onSignIn">로그인</div>
</body>
</html>
window.onload = function() {
// 개인 & 병원 구분 
	var eventlist = document.getElementsByClassName("select");

	for (var i = 0; i < eventlist.length; i++) {
		eventlist[i].addEventListener("click",
				function(event) {
					event.preventDefault();
					if (this.getAttribute("id") == "indiv") {
						document.getElementById("login_member_bg")
								.setAttribute('src',
										'resources/imgs/login_member.svg');
						document.getElementById("register").setAttribute(
								'href', 'newMember.html');
						document.getElementById("id").setAttribute('name',
								'member_id');
						document.getElementById("pw").setAttribute('name',
								'member_pw');
						document.getElementById("formtag").setAttribute(
								'action', 'MemberServlet');

					} else if (this.getAttribute("id") == "doc") {
						document.getElementById("login_member_bg")
								.setAttribute('src',
										'resources/imgs/login_doctor.svg');
						document.getElementById("register").setAttribute(
								'href', 'newDoctor.html');
						document.getElementById("id").setAttribute('name',
								'doc_id');
						document.getElementById("pw").setAttribute('name',
								'doc_pw');
						document.getElementById("formtag").setAttribute(
								'action', 'DoctorServlet');
					}
				})
	}

// 로그인 버튼 색 변환 활성화
	var idpwchk = document.getElementsByClassName("idpw");

	for (var i = 0; i < idpwchk.length; i++) {
		idpwchk[i].addEventListener("keypress", function() {
			var id = document.getElementById("id").value;
			var pw = document.getElementById("pw").value;

			var cell = document.getElementsByClassName("logincell")[0];

			if (id != "" && pw != "") {
				cell.style.backgroundColor = '#f14a3b';
				cell.style.cursor="pointer";
				cell.addEventListener("click", function() {
					// 로그인 비동기 통신 
					var grade = document.getElementById("formtag").getAttribute("action");
					$.ajax({
						url : grade,
						data : {
							"command" : "login",
							"id" : $("#id").val(),
							"pw" : $("#pw").val()
						},
						dataType : "text",
						type : "post",
			
						success : function(data) {
							$("#error").html(data);
						},
						error : function() {
							alert("fail");
						}
					})
				})
			} else {
				cell.style.backgroundColor = 'gray';
			}
		});
	}

}
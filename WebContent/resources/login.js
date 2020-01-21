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
	idpwchk[0].addEventListener("input", login);
	idpwchk[1].addEventListener("input", login);


// 로그인 비동기 통신
	var cell = document.getElementsByClassName("logincell")[0];
	cell.addEventListener("click", function() {
		var grade = document.getElementById("formtag").getAttribute("action");
		$.ajax({
			url : grade,
			data : {
				"command" : "login",
				"id" : $("#id").val(),
				"pw" : $("#pw").val()
			},
			dataType : "json",
			type : "post",
			async : true,

			success : function(data) {
				$("#error").html(data.result);
				if(data.id==undefined){

				} else {
					alert(data.id);
					var info = JSON.stringify(data);
					alert("info :" + info);
					sessionStorage.setItem("data",info);
					if(grade=="DoctorServlet"){
						window.location.href="doctormain.jsp";
					} else {
						window.location.href="patientmain.jsp";
					}
					
				}
			},
			error : function() {
				alert("fail");
			}
		})
	})
}

// 로그인 버튼 색 변환 활성화(함수)
function login() {
	var cell = document.getElementsByClassName("logincell")[0];
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;

	if (id != "" && pw != "") {
		cell.style.backgroundColor = '#f14a3b';
		cell.style.cursor = "pointer";
		cell.setAttribute("title", "ready");

	} else if (id == "" || pw == "") {
		cell.style.backgroundColor = 'gray';
		cell.style.cursor = "plain";
		cell.setAttribute("title", "notready");
	}
}
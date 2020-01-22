window.onload = function () {
    
var grade = document.getElementsByTagName("form")[0].getAttribute("action");

// 유효성 검사---------------------------------------------------------------------------------

// submit 
document.getElementById("form")[0].addEventListener("submit",function (event) {
	alert("submit");
    var chkfinal = document.getElementsByClassName("chk");
    for(var i = 0 ; i<chkfinal.length; i++){
        var status = this.getAttribute("title");
        alert(this.getAttribute("name"));
        if (status!="ready"){
            this.focus();
            event.preventDefault();
        }
    }
})


// 수정시 바로 상태 ==> notready 
var chk = document.getElementsByClassName("chk");
for (var i = 0 ; i < chk.length; i++){
    chk[i].addEventListener("input", function () {
        this.setAttribute("title","notready");
    })
}

// 비밀번호 유효성 검사
document.getElementById("pw").addEventListener("focusout", function () {
	var pw = document.getElementById("pw").value;
	var pwchk = document.getElementById("pwchk").value;
	var pattern = /^[a-zA-Z0-9]{8,16}/;
	var chk = pattern.test(pw);
	console.log(chk);
    if(chk == false && pw!=""){
        this.parentElement.parentElement.lastElementChild.innerHTML="비밀번호는 8자리에서 16자리의 숫자, 알파벳만 가능합니다."
    } else if (this.value==""){
    	this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
    } else {
    	this.parentElement.parentElement.lastElementChild.innerHTML=""
        this.setAttribute("title","ready");
    }
})

// 비밀번호 일치 확인
document.getElementById("pwchk").addEventListener("focusout", function () {
	var pw = document.getElementById("pw").value;
	var pwchk = document.getElementById("pwchk").value;
	
    if(pw!=pwchk){
        this.parentElement.parentElement.lastElementChild.innerHTML="비밀번호가 일치하지 않습니다."
    } else if (this.value==""){
    	this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
    } else {
        this.setAttribute("title","ready");
    }
})

// 아이디 유효성 검사
document.getElementsByName("id")[0].addEventListener("focusout", function () {
    var pattern = /^[a-zA-Z0-9]{4,}/;
    var val = this.value;
    var chk = pattern.test(this.value);

    if(chk==false && val!=""){
        this.parentElement.parentElement.lastElementChild.innerHTML="아이디는 4자리 이상 숫자, 알파벳만 가능합니다."
    } else if (val==""){
    	this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
    } else {
        this.setAttribute("title","ready");
        this.parentElement.parentElement.lastElementChild.innerHTML=""
    }
})

// 이름 유효성 검사
document.getElementsByName("name")[0].addEventListener("focusout", function () {
    var pattern = /^[가-힣]{2,}/;
    var val = this.value;
    
    var chk = pattern.test(val);
    if(chk==false && val!=""){
        this.parentElement.parentElement.lastElementChild.innerHTML="유효하지 않은 이름입니다. "
    } else if (val==""){
    	this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
    } else {
        this.setAttribute("title","ready");
        this.parentElement.parentElement.lastElementChild.innerHTML=""
    }
})

// 생일 유효성 검사
var select = document.getElementsByClassName("bd");
var a = document.getElementById("bderror");
var pattern = /^[0-9]*$/ ;

for (var i =0 ; i<select.length;i++){
	 select[i].addEventListener("focusout", function () {
		 var chk = pattern.test(this.value);
		for(i of select){
			 if(i.value==""){
		            a.innerHTML="필수 요소입니다. "
		        } else if (i.value!="" && chk==false){
		        	a.innerHTML="생년월일을 정확히 입력해 주세요 "
		        } else {
		        	this.setAttribute("title","ready");
		            a.innerHTML=""
		        }		 
		}
	})
}

// 이메일 중복 검사
document.getElementsByName("email")[0].addEventListener("focusout", function () {
    var pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    var val = this.value;
    
    var chk = pattern.test(val);
    if(chk==false && val!=""){
        this.parentElement.parentElement.lastElementChild.innerHTML="유효하지 않은 이메일 형식 입니다. "
    } else if (val==""){
    	this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
    } else {
    	
        var ptag =  this.parentElement.parentElement.lastElementChild;
        ptag.innerHTML ="";
        	
        $.ajax({
        	url: grade,
        	data :{"command":"emailchk","email":$("input[name=email]").val()},
        	dataType:"text",
        	type:"post",
        	success:function(data){
        		if(data>0){
        			ptag.innerHTML="이미 사용 중인 이메일 입니다.";
        			$("input[name=email]").attr("title","notready");
        		} else {
        			ptag.innerHTML="인증하기를 눌러주세요";
        			$("input[name=email]").attr("title","ready");
        		}
        	},
        	error: function(data){
        		alert("이메일 통신 오류");
        	}
        })
    }
})

// 이메일 확인 코드보내기
document.getElementsByClassName("btna")[1].addEventListener("click", function(){
var emailp = document.getElementById("emailerror");
   var ready = document.getElementsByName("email")[0].getAttribute("title");
   emailp.innerHTML="";
   if(ready =="ready"){
	   $.ajax({
		   url:grade,
		   data :{"command":"emailcodesend","email":$("input[name=email]").val()},
		   dataType:"text",
		   type:"post",
		   success:function(data){
			   emailp.innerHTML=data;
		   }
	   })
   } else {
	   emailp.innerHTML="이메일을 확인해 주세요";
   }
   
})

// 코드 확인 
var code = document.getElementById("code");
code.addEventListener("focusout",function () {
	if(code.value!=""){
    $.ajax({
        url:grade,
        data:{"command":"code","inputcode":$("#code").val()},
        dataType:"text",
        type:"post",
        success: function (data) {
            if (data==0){   // 코드 일치
            code.parentElement.parentElement.lastElementChild.innerHTML="확인 되었습니다!";
            code.getAttribute("title","ready");
        } else {
            code.parentElement.parentElement.lastElementChild.innerHTML="코드가 일치하지 않습니다.";
            code.getAttribute("title","notready");
        }
        },
        error: function(){
        	alert("코드확인 통신 오류")
        	}
    })	
	} else {
		  this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
	}
})

// ----------------------------------------------------------------------------------------------------------
}

// 아이디 중복 체크
function idchk(){

    console.log(grade);

	$.ajax({
		url:grade,
		data:{"command":"idchk","id":$("input[name=id]").val()},
		dataType:"text",
		type:"post",
		
		success:function(data){
			if(data > 0){
				$("#iderror").text("이미 사용중인 아이디 입니다.");
				$("input[name=id]").attr("title","notready");
			}else{
				alert("사용 가능한 아이디 입니다.");
				$("input[name=id]").attr("title","ready");
			}
		},
		error:function(data){
			console.log(data);
		}
	});
}

// 주소 api

function goPopup(){
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	document.getElementById("juso").value=roadFullAddr;
}


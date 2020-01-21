window.onload = function () {
    var arraylist = document.getElementsByTagName("input");

    for (var i = 0; i < arraylist.length; i++) {
        arraylist[i].addEventListener("focusin", function () {
            // this.parentElement.style.border = "1px inset #daeff7";
            // if(this.value==""){
            //     this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            // } else {
            //     this.parentElement.parentElement.lastElementChild.innerHTML=""
            // }
        })
        
        arraylist[i].addEventListener("focusout", function () {
            this.parentElement.style.border = "solid 1px #75adc7";
            var except = this.getAttribute("class");
            var a = document.getElementById("bderror");
            
            if(this.value=="" && except!="bd"){
                this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            } else if (this.value=="" && except=="bd"){
            	a.innerHTML="필수 요소 입니다. "
            } else if(this.value!="" && except=="bd"){
            	a.innerHTML="";
            } else if (this.value!="" && except!="bd"){
            	 this.parentElement.parentElement.lastElementChild.innerHTML=""
            }
        })
    }
    
// 유효성 검사 notready(전체)////////---------------------------------------------------------------------------------
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
    if(chk == false){
        this.parentElement.parentElement.lastElementChild.innerHTML="비밀번호는 8자리에서 16자리의 숫자, 알파벳만 가능합니다."
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
    } else {
        this.setAttribute("title","ready");
    }
})

// 아이디 유효성 검사 
document.getElementsByName("id")[0].addEventListener("focusout", function () {
    var pattern = /^[a-zA-Z0-9]{4,}/;
    var chk = pattern.test(this.value);
    if(chk==false){
        this.parentElement.parentElement.lastElementChild.innerHTML="아이디는 4자리 이상 숫자, 알파벳만 가능합니다."
    } else {
        this.setAttribute("title","ready");
        this.parentElement.parentElement.lastElementChild.innerHTML=""
    }
})

// 이름 유효성 검사 
document.getElementsByName("name")[0].addEventListener("focusout", function () {
    var pattern = /^[가-힣]{2,}/;
    var chk = pattern.test(this.value);
    if(chk==false){
        this.parentElement.parentElement.lastElementChild.innerHTML="유효하지 않은 이름입니다. "
    } else {
        this.setAttribute("title","ready");
        this.parentElement.parentElement.lastElementChild.innerHTML=""
    }
})

//생일 유효성 검사 
var select = document.getElementsByClassName("bd");
var a = document.getElementById("bderror");

for (var i = 0 ; i<select.length;i++){
	 select[i].addEventListener("focusout", function () {
	        if(this.value==""){
	            a.innerHTML="생년월일을 정확히 입력해 주세요"
	        }else {
	        	this.setAttribute("title","ready");
	            this.parentElement.parentElement.lastElementChild.innerHTML=""
	        }
	})
}

//----------------------------------------------------------------------------------------------------------
}

// 아이디 중복 체크 
function idchk(){
    var grade = document.getElementsByTagName("form")[0].getAttribute("action");
    console.log(grade);

	$.ajax({
		url:grade,
		data:{"command":"idchk","id":$("input[name=id]").val()},
		dataType:"text",
		type:"post",
		
		success:function(data){
			if(data > 0){
				alert("이미 사용중인 아이디 입니다.");
				$("input[name=id]").val("");
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



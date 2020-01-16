window.onload = function () {
    var arraylist = document.getElementsByTagName("input");

    for (var i = 0; i < arraylist.length; i++) {
        arraylist[i].addEventListener("focusin", function () {
            this.parentElement.style.border = "1px inset #daeff7";
            if(this.value==""){
                this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            } else {
                this.parentElement.parentElement.lastElementChild.innerHTML=""
            }
        })
        arraylist[i].addEventListener("focusout", function () {
            this.parentElement.style.border = "solid 1px #75adc7";
            if(this.value==""){
                this.parentElement.parentElement.lastElementChild.innerHTML="필수 요소입니다."
            } else {
                this.parentElement.parentElement.lastElementChild.innerHTML=""
            }
        })
    }

    for (var i = 0; i < arraylist.length; i++) {
        if (arraylist[i].value !=null){
            
        }
    }
};
function idchk(){
	$.ajax({
		url:"DoctorServlet",
		data:{"command":"idchk","id":$("input[name=id]").val()},
		dataType:"text",
		type:"post",
		
		success:function(data){
			if(data > 0){
				alert("이미 사용중인 아이디 입니다.");
				$("input[name=id]").val("");
			}else{
				alert("사용 가능한 아이디 입니다.");
			}
		},
		error:function(data){
			console.log(data);
		}
	});
}


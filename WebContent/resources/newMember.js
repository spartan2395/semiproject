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

    $('#pw_u_chk').blur(function(){
 	   if($('#pw').val() != $('#pw_u_chk').val()){
 	    	if($('#pw_u_chk').val()!=''){
 		    alert("비밀번호가 일치하지 않습니다.");
 	    	    $('#pw_u_chk').val('');
 	          $('#pw_u_chk').focus();
 	       }
 	    }
 	});

    $("#idchk").click(function() {
    	var id_u = $("#id_u").val();
    	alert(id_u);
    	$.ajax({
    		type: "POST",
    		data: {"command":"MemberChk","id":id_u},
    		url: "MemberServlet",
    		dataType: "text",
    		
    		success : function(data) {
    			if(data > 0) {
    				alert("중복")
    				$("input[name=id]".val)
    			}
    			else {
    				alert("사용 가능")
    			}
    		}
    		
    	})
    });
    

};

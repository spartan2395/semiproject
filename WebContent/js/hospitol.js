var x;
var y;
var location;
var hos_x;
var hos_y;

function thispos(){
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition);
	} else {
	  console.log("Geolocation is not supported by this browser.");
	}
}
function showPosition(position) {
	y = position.coords.latitude; 
	x = position.coords.longitude; 
	searchNear(x,y);
}

function searchNear(x,y){
	$.ajax({
		url:"HosSelected",
		data:{command:"nearHos",x:x,y:y},
		dataType:"text",
		method:"post",
		success:function(data){
			var obj = JSON.parse(data);
			$.each(obj,function(key,val){
				var list = val;
				for(var i = 0;i<list.length;i++){
					var str = list[i];
					if(i != 0 && i%3-1 == 0){
						$(".appointmentWrap").append(
								"<article class='medicalinfo'>" +
									"<a class='medical_link' onclick='send(\""+i+"\")'>" +
										"<div class = 'medical_photo'>" +
											"<img alt ='병원사진' src ='./image/hello.jpg'/>" +
											"<input type = 'hidden' id = 'addr' name = 'addr'/>"+
										"</div>" +
										"<div class = 'medical_info'>" +
											"<p class = 'medical_name'></p></div>"+
									"</a>" +
								"</article>"		
								);
					}else{
						$(".appointmentWrap").append(
						"<article class='medicalinfo'>" +
						"<a class = 'medical_link' onclick = 'send(\""+i+"\")'>" +
								"<div class = 'medical_photo'>" +
								"<img alt ='병원사진' src ='./image/hello.jpg'/>"+
								"<input type = 'hidden' id = 'addr' name = 'addr'/>"+
								"</div>" +
								"<div class = 'medical_info'>" +
								"<p class = 'medical_name'></p></div></a>" +
								"</article>"		
						);
					}
					$(".medical_name").eq(i).text(list[i].yadmNm);
					$(".medical_name").eq(i).val(list[i].ykiho);
					$("#addr").eq(i).val(list[i].addr);
				}
			});
		},
		error:function(){
			alert("실패!");
		}
	})
}
function hospitolinfo(ykiho){
	$.ajax({
		url:"HosSelected",
		data:{command:"hosinfo",ykiho:ykiho},
		dataType:"text",
		method:"post",
		success:function(infodata){
			if(infodata.indexOf("u") < -1){
					alert(infodata);
					obj = JSON.parse(infodata);
					console.log(obj);
					
			}else{
				$("#time").text("평일 : 09:00 ~ 18:00");
				$("#info").text("토요일 : 09:00 ~ 14:00");
			}
		},
		error:function(){
			alert("info 실패!");
		}
	});
	$.ajax({
		url:"HosSelected",
		data:{command:"searchcode",ykiho:ykiho},
		dataType:"text",
		method:"post",
		success:function(codeinfo){
			var infobj = JSON.parse(codeinfo);
			$.each(infobj,function(key,val){
				if(key == "item"){
					var listinfo = val;
					$("#info").append("<br>---진료 과목 ---<br> ");
					for(var i = 0 ; i < listinfo.length; i++){
							$("#info").append(listinfo[i].dgsbjtCdNm+"<br>");
					}
				}
			})
		}
	});
}

function send(i){
	var ykiho = $(".medical_name").eq(i).val();
	var hosname = $(".medical_name").eq(i).text();
	var addrss = $("input[name=addr]").eq(i).val();
	var add = $("#addr").eq(i).val();
	location.href = "HosSelected?command=medical_clinic&ykiho="+ykiho+"&hosName="+hosname+"&addr="+add;
}
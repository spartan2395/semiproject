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
					if(i != 0 && i%3 == 0){
						$(".appointmentWrap").append(
								"<article class='medicalinfo'>" +
									"<a class='medical_link' onclick='send(\""+i+"\")'>" +
										"<div class = 'medical_photo'>" +
											"<img alt ='병원사진' src ='./image/hello.jpg'/>" +
											"<input type = 'hidden' class = 'addr' name = 'addr'/>"+
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
								"<input type = 'hidden' class = 'addr' name = 'addr'/>"+
								"</div>" +
								"<div class = 'medical_info'>" +
								"<p class = 'medical_name'></p></div></a>" +
								"</article>"		
						);
					}
					console.log(str.XPos + ", " + str.YPos);
					$(".medical_name").eq(i).text(list[i].yadmNm);
					$(".medical_name").eq(i).val(list[i].ykiho);
					$(".addr").eq(i).val(list[i].addr+"&x="+list[i].XPos+"&y="+list[i].YPos);
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

function searchHos(){
	var name = $("input[name=search_input]").val();
	var enm = encodeURIComponent(name);
	$(".appointmentWrap").empty();
	$.ajax({
		url:"HosSelected",
		data:{command:"searchHos",name:enm},
		method:"post",
		success:function(data){
			var pasdata = JSON.parse(data);
			$.each(pasdata,function(key,val){
				if(key == "item"){
					var listdata = val;
					for(var i=0;i<listdata.length;i++){
						var str = listdata[i];
						$(".appointmentWrap").append(
								"<article class='medicalinfo'>" +
									"<a class='medical_link' onclick='send(\""+i+"\")'>" +
										"<div class = 'medical_photo'>" +
											"<img alt ='병원사진' src ='./image/hello.jpg'/>" +
											"<input type = 'hidden' class = 'addr' name = 'addr'/>"+
										"</div>" +
										"<div class = 'medical_info'>" +
											"<p class = 'medical_name'></p></div>"+
									"</a>" +
								"</article>"		
						);
						$(".medical_name").eq(i).text(str.yadmNm);
						$(".medical_name").eq(i).val(str.ykiho);
						$(".addr").eq(i).val(str.addr+"&x="+str.XPos+"&y="+str.YPos);
					}
				}
			})
		},error:function(data){
			var err = data;
			console.log("error : "+err);
		}
	})
}

function send(i){
	var ykiho = $(".medical_name").eq(i).val();
	var hosname = $(".medical_name").eq(i).text();
	var add = $(".addr").eq(i).val();
	location.href = "HosSelected?command=medical_clinic&ykiho="+ykiho+"&hosName="+hosname+"&addr="+add;
}
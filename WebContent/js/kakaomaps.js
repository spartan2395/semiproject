function map(x,y){
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(y,x), // 지도의 중심좌표
	        level: 2 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	var markerPosition = new kakao.maps.LatLng(y,x);
	
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});
	
	marker.setMap(map);
}
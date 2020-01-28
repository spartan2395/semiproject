<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="resources/newDoctor.css" type="text/css">
<link rel="icon" href="resources/imgs/carrot.png" type="image/x-icon">

<title>당근 병원 - 당신 근처의 병원</title>
</head>
<script type='text/javascript' src="resources/newMember.js"></script>
<script type='text/javascript' src="js/jquery-3.4.1.min.js"></script>
<body>
	<div id="content">
		<a href=""><img src="resources/imgs/carrotlogopractice.png"
			alt="logo" style="width: 250px; margin-top: 20px;"></a>
		<p
			style="font-weight: 900; font-size: larger; color: #263e63; margin: 20px 0 20px 0;">회원가입(의사)</p>
	</div>

	<div class="container">
		<form action="DoctorServlet" method="post" id="form">
			<input type="hidden" name="command" value="update">
			<div id="idpw">
				<div id="id">
					<h4>아이디</h4>
					<div class="wbtn">
						<span><input type="text" required name="id"
							class="chk" readonly value=${dto.id_d }></span> 
							<a onclick="idchk()" class="btna" style="display:none"><span class="btn">아이디 확인</span></a>
						<p class="required" id="iderror" hidden="hidden"></p>
					</div>
				</div>

				<div>
					<h4>비밀번호</h4>
					<span><input type="text"
						placeholder="8자리 이상 16자리 이하 숫자와 알파벳" class="chk" id="pw"
						title="notready" required></span>
					<p class="required" ></p>
				</div>
				<div>
					<h4>비밀번호 확인</h4>
					<span><input type="text" class="chk" id="pwchk"
						title="notready" name="pw" required></span>
					<p class="required"></p>
				</div>
			</div>

			<div id="who">
				<div>
					<h4>이름</h4>
					<span><input type="text" required name="name"
						title="ready" value=${dto.name_d } ></span>
					<p class="required " hidden="hidden"></p>
				</div>

				<div>
					<h4>성별</h4>
					<span> <select required name="gender">
							<option value="F">여</option>
							<option value="M">남</option>
					</select>
					</span>
					<p class="required" hidden="hidden"></p>
				</div>

				<div id="bd">
					<h4>생년월일</h4>

					<div id="bd_yy">
						<span> <input type="text" class="bd" name="bd_yy" readonly value=${bd_yy }>
						</span>
					</div>

					<div id="bd_mm">
                        <span>
                            <input type="text"class="bd" readonly name="bd_mm" value=${bd_mm} >
                              
                        </span>
                        <!-- <p class="required"></p> -->
                    </div>

					 <div id="bd_d">
                        <span><input type="text" class="bd" name="bd_d" readonly value=${bd_d}></span>
                        <!-- <p class="required"></p> -->
                    </div>
                     <p class="required" id="bderror" hidden="hidden"></p>
				</div>
				
				<div>
					<h4>전화번호</h4>
					<span><input type="tel" name="tel" id="tel" required title="ready" value=${dto.number_d}></span>
					<p class="required"></p>
				</div>

				<div>
					<h4>주소</h4>
					<span><input type="text" readonly onclick="goPopup()"
						id="juso" name="addr" title="ready" value=${dto.addr_d }></span>
					<p class="required" style="display:none;"></p>
				</div>

			</div>

			<div id="verification">
				 <div>
                    <h4>이메일</h4>
                    <div class="wbtn">
                          <span ><input type="email" name = "email" class ="chk" readonly value=${dto.email_d}></span>
                        <a class="btna" style="display:none" ><span class="btn">인증하기</span></a>
                        <p class="required" id="emailerror" hidden="hidden"></p>
                    </div>
                </div>
                <div style="display:none">
                    <h4>인증코드</h4>
                    <span><input type="text" maxlength="10" title="ready" id="code" required readonly></span>
                    <p class="required"></p>
                </div>
            </div>

			<div id="hospital">
			<div>
				<h4>소속 병원</h4>
				<span><input type="text" required class="doc" name="medical" title="ready" value=${dto.medical_d }></span>
				<p class="required"></p>
			</div>
			<div>
				<h4>직책</h4>
				<span><input type="text" name="grade" class="doc" title="ready"
					required value=${dto.grade_d }></span>
				<p class="required"></p>
			</div>
			<div>
				<h4>부서</h4>
				<span><input type="text" name="department" class="doc" title="ready"
					required value=${dto.department }></span>
				<p class="required"></p>
			</div>
		</div>

	<div id="confirm">
		<button style="submit" class="confirmbtn">
			<span id="confirmspan">정보 수정</span>
		</button>
	</div>
	 <div id="delete">
            	<p style="font-style: italic; color: gray;">회원 탈퇴는 <a style="color:red;" href="" id="delete">여기</a>를 클릭 해주세요</p>
            </div>
	</form>
	</div>
	
	<div id="footer">
		<p>
			@Carrot Doctor Team <br> jfekjfkejkfjekfk|fefefeeffef |
			fwfwefefefefe | fefegegegege | fewgaegegege<br>
			<br>
			<br>
		</p>
	</div>

</body>


</html>
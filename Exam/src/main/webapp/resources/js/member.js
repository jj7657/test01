var idcheck = false;
var pwcheck = false;
var idregcheck=false;
var pwregcheck=false;


$(document).ready(function(){

	$("#userid").on("keyup",function(){
		
		let str = $("#userid").val();
		
		$("#idmsg").html("<p style='color: red;'>"+str+"</p>")
		
	})
		$("#userid").on("blur",function(){
	
			let idreg=/^[a-zA-Z0-9]{4,12}$/;

			let idval = $("#userid").val();
			if(idreg.test(idval)){
				$("#idmsg").html("<p style='color: green;'>제대로 입력했네!</p>");
				idregcheck=true;
			}else{
				$("#idmsg").html("<p style='color: red;'>영어랑 숫자로 4~12글자까지 쓰세요! </p>")
				idregcheck=false;
			}
	
		})
	
		$("#userpw").on("keyup",function(){
		
		let str = $("#userpw").val();
		
		$("#pwmsg").html("<p style='color: red;'>"+str+"</p>")
		
	})/* 아이디 이벤트 */
	
	
		$("#userpw").on("blur",function(){
	
			/* let pwreg=/^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/; */
			/*
			 * let
			 * pwreg=/^.*(?=^.{8,24}$)
			 * 				(?=.*\d)   숫자
			 * 				(?=.*[a-zA-Z])
			 * 				(?=.*[!@#$%^&+=]).*$/;
			 */
			let pwreg=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$/;
			

			let pwval = $("#userpw").val();
			if(pwreg.test(pwval)){
				$("#pwmsg").html("<p style='color: green;'>제대로 입력했네!</p>");
				pwregcheck=true;
			}else{
				$("#pwmsg").html("<p style='color: red;'>대문자,소문자,숫자,특수문자 혼합으로 8자 이상 쓰세요! </p>")
				pwregcheck=false;
			}
	
		}) /* 비밀번호 이벤트 */
		
		
		$("#re_userpw").on("keyup",function(){
		let str = $("#re_userpw").val();
		
		$("#re_pwmsg").html("<p style='color: red;'>"+str+"</p>")
		})
		
		
		$("#re_userpw").on("blur",function(){
	
		let pwval = $("#userpw").val();
		let re_pwval = $("#re_userpw").val();
	
		if(pwval==re_pwval){
			$("#re_pwmsg").html("<p style='color: green;'>제대로 입력했네!</p>");
			pwcheck=true;
		}else{
			$("#re_pwmsg").html("<p style='color: red;'>비밀번호가 달라요!</p>");
			pwcheck=false;
		}
	}) /*비밀번호 재확인*/
	
	
	$("#idbtn").click(function(e){
		
		let userid = $("#userid").val();
		let str = encodeURIComponent(userid);
		console.log(userid);
		$.getJSON("/Exam/member/checkId/"+userid,function(data){
			console.log("====");
			console.log(data);	
//			if(data==0){
//				$("#idcheck").html("<p style='color: green;'>사용하셔도 좋습니다</p>");
//				idcheck=true;
//			}else{
//				$("#idcheck").html("<p style='color: red;'>중복된 아이디가 있습니다</p>");
//				idcheck=false;		
//			}
		})

//		$.ajax({
//			url:"/Exam/member/checkId/"+str,
//			type:'GET',
//			success:function(data){
//				console.log("====");
//				console.log(data);	
//				if(userid==data){
//					$("#idcheck").html("<p style='color: red;'>중복된 아이디가 있습니다</p>");
//				}else{
//					$("#idcheck").html("<p style='color: green;'>사용하셔도 좋습니다</p>");
//				}
//			}
//			
//		})		
	})
	

});

function checkmem() {
	
	if(idcheck && pwcheck && idregcheck && pwregcheck){
		console.log("true");
		return true;
	}
	console.log("false");
	return false;
}

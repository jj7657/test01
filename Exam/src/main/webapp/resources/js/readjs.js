/**
 * 
 */
$(document).ready(function() {
	var formObj = $("form[role='form']");

	console.log(formObj);

	$(".mod").on("click", function() {
		formObj.attr("action", "/Exam/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});
	$(".remove").on("click", function() {
		formObj.attr("action", "/Exam/board/remove");
		formObj.submit();
	});
	$(".list").on("click", function() {
		formObj.attr("action", "/Exam/board/list");
		formObj.attr("method", "get");
		formObj.submit();
//		self.location = "/Exam/board/list?pageNum=${cri.pageNum}";
	});
	
	 var bno = $("#bno").val();
//	 console.log(bno);
	 alert(bno);
	$.getJSON("/Exam/board/getAttachList",{bno:bno},function(arr){
		console.log(arr);
		var str="";
		$(arr).each(function(i,attach) {
			console.log(attach.fileType)
			var file = encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_"+attach.fileName);
			if(attach.fileType){   //image == true
				var s_file = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
				str+= "<li><img src='/Exam/display?fileName="+s_file+"'> " +
				" <input type='button'" +
				"data-file='"+s_file+"'"+
				"data-type='image'" +
				" value='X'></li>";		
			}else{
				str+= "<li>" +
				"<a  href='/Exam/download?fileName="+file+"'>" +
				"<img id='att' src='/Exam/resources/img/att.png'>"
				+attach.fileName + "</a> <input type='button' value='X'></li>";
			}
		});
		$(".uploadResult ul").append(str);
	})
	
	
	
	
	
	
});
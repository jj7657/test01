$(document).ready(function() {
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$") // 정규식(해당 종류의 파일 업로드 안되게)
	var maxSize=5242880;
	
	function checkExtension(fileName,fileSize) {
		if(fileSize>=maxSize){
			alert("파일사이즈 초과.")			
			return false;
		}
		if(regex.test(fileName)){
			alert("해당종류의 파일은 업로드 할수 없습니다.")
			return false; 
		}
		
		return true;
	}
	
	$(".fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
	})
	$(".fileDrop").on("drop",function(e) {
		e.preventDefault();
		var files=e.originalEvent.dataTransfer.files;
		var formData = new FormData(); // uploadAjax.jsp 에 form태그가 없어 대체 하는것이, FormData이다
		for(var i = 0; i<files.length;i++){
		var file=files[i];
		console.log(file);
		console.log(file.name);
		console.log(file.size);
		if(!checkExtension(file.name,file.size)){
			return false;
		}
		formData.append("file",file);		
		}
		$.ajax({
			url:"/Exam/uploadAjax",
			data:formData,
			dataType:'JSON',
			//processData와 contentType은 파일전송시 false가되어야 함
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				console.log("====");
				console.log(data);
				list(data);
				
			}
			
		})
		
	})

	
	function list(data) {	
		var str ="";
		$(data).each(function(i,obj) {
			console.log(obj.fileName);
			var file = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
			if(obj.image){
				console.log(file);
				
//				"<img src='"+ file   +"'>"
				
				var s_file = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				str+= "<li><img src='/Exam/display?fileName="+s_file+"'> " +
						" <input type='button'" +
						"data-file='"+s_file+"'"+
						"data-type='image'" +
						" value='X'></li>";				
			}else{
				str+= "<li>" +
						"<a  href='/Exam/download?fileName="+file+"'>" +
						"<img id='att' src='resources/img/att.png'>"
				+obj.fileName + "</a> <input type='button' value='X'></li>";
			}
		})
		$(".uploadResult ul").append(str);
	}
	$(".uploadedList").on("click","input",function(e){
		e.preventDefault();
		var fileName = $(this).data("file");
		var s_fileName = $(this).data("s_file");
		var type = $(this).data("type");
//		console.log(fileName+" "+type)
		
		
		
		
		$.ajax({
			url:"/Exam/deleteFile",
			data:{fileName:fileName,type:type},
			dataType:"text",
			type:"POST",
			success:function(data){
				console.log("삭제 메세지"+data);
//				alert(data);
			}
		});
	})
	
	
})
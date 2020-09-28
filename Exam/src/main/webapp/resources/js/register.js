/**
 * 
 */
$(document).ready(function() {
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$") // 정규식(해당 종류의 파일 업로드
														// 안되게)
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
		var formData = new FormData(); // uploadAjax.jsp 에 form태그가 없어 대체 하는것이,
										// FormData이다
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
			// processData와 contentType은 파일전송시 false가되어야 함
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
	
	
var formobj= $("form[role='form']");	

 $("input[type='submit']").on("click",function(e){
 e.preventDefault();
 console.log("인풋태그");
var str="";
	$(".uploadedList ul li").each(function(i,obj) {
		var jobj=$(obj);
		console.log(jobj);
		
		str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
		str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
		str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("uploadpath")+"'>";
		str+="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("filetype")+"'>";
	})
	
	formobj.append(str).submit();
 });
		
	function list(data) {	
			var str ="";
			$(data).each(function(i,obj) {
				console.log(obj.fileName);
				var file = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				console.log(file);
				
// "<img src='"+ file +"'>"
				if(obj.image){
				var s_file = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				str+= "<li " +
						"data-filename='" +obj.fileName+"'"+
						"data-uuid='" +obj.uuid+"'"+
						"data-uploadpath='" +obj.uploadPath+"'"+
						"data-filetype='" +obj.image+"'"+
						"><img src='/Exam/display?fileName="+s_file+"'> " +
						" <input type='button'" +
						"data-file='"+s_file+"'"+
						"data-type='image'" +
						" value='X'></li>";				
				}else{
				str+= "<li " +
						"data-filename='" +obj.fileName+"'"+
						"data-uuid='" +obj.uuid+"'"+
						"data-uploadpath='" +obj.uploadPath+"'"+
						"data-filetype='" +obj.image+"'"+
						">" +
						"<a  href='/Exam/download?fileName="+file+"'>" +
						"<img id='att' src='resources/img/att.png'>"
				+obj.fileName + "</a> <input type='button' value='X'></li>";
				}
			})
			$(".uploadedList ul").append(str);
		}
		
		

	
})
/**
 * 
 */
$(document)
		.ready(
				function() {

					var bno = $("#bno").val();
					var page = 1;
					// method 방식이 get인 경우 getJSON
					// $.getJSON(서버url,데이터(생략가능),성공(생략가능))
//					getPageList(page);
					getAllList(page);
					function getAllList(page) {

						$("#modDiv").hide("slow");
						var str = "";
						$.getJSON("/Exam/replies/all/" + bno + "/" + page,
										function(data) {
											console.log(data);
											$(data.list).each(function() {
																str += "<li data-rno='"
																		+ this.rno
																		+ "'class='replyLi'>"
																		+ this.rno
																		+ ":<span>"
																		+ this.replytext
																		+ "</span><input type='button' value='수정'></li>";

																// <input
																// type="button"
																// value="수정">
															});
										var endNum=Math.ceil(page/10.0)*10;
										var startNum= endNum-9;
										var prev= startNum>1;
										var next=false;
										if(endNum*10>= data.replyCnt){
											endNum=Math.ceil(data.replyCnt/10.0);
										}
										if (endNum*10<data.replyCnt) {
											next=true;
										}
										var pstr="";
										if(prev){
											pstr+="<li><a href='"+(startNum-1)+"'>이전</a></li> ";
										}
										for (var i = startNum; i <= endNum; i++) {
											var active= page==i ? "active" : "" ;
											
											pstr+="<li class='page-item "+active+"'><a href='"+i+"'>"+i+"</a></li> ";
										}
										if(next){
											pstr+="<li><a href='"+(endNum+1)+"'>다음</a></li> ";
										}	
											$("#replyPage").html(pstr);
											$("#replies").html(str);
										});
					}
					$("#replyPage").on("click","li a",function(e){
						e.preventDefault();
//						console.log("page click");
						var targetPageNum=$(this).attr("href");

						page=targetPageNum;
						
						getAllList(page);
					})
					
					
					

					$("#replyAddBtn").on("click", function() {
						var replyer = $("#newReplyWriter").val();
						var replytext = $("#newReplyText").val();

						$.ajax({
							type : "post",
							url : "/Exam/replies/",
							headers : {
								"Content-Type" : "application/json",
								"X-HTTP-Method-Overried" : "POST"
							},
							dataType : "text",
							data : JSON.stringify({
								bno : bno,
								replytext : replytext,
								replyer : replyer
							}),
							success : function(result) {
								if (result == "success") {
									alert("등록성공.");
									getAllList();
								}
							},
							error : function(err) {
								console.log(err)
							}
						})
					})// 댓글등록

					$("#replies").on("click", ".replyLi input", function() {

						var reply = $(this).parent();

						var rno = reply.attr("data-rno");
						// var replytext = reply.text();
						var replytext = reply.children("span").text();

						// alert(rno+" : " + replytext);

						$(".modal-title").html(rno);
						$("#replytext").val(replytext);
						$("#modDiv").show("slow");

					})// 수정창 불러오기

					$("#replyModBtn").on("click", function() {

						var rno = $(".modal-title").html();
						var replytext = $("#replytext").val();
						alert(rno + "번 : 댓글" + replytext);
						$.ajax({
							type : 'put',
							url : "/Exam/replies/" + rno,
							headers : {
								"Content-Type" : "application/json",
								"X-HTTP-Method-Overried" : "PUT"
							},
							dataType : "text",
							data : JSON.stringify({
								replytext : replytext
							}),
							success : function(result) {
								console.log("result:" + result);
								if (result == 'success') {
									alert("수정완료");
									$("#modDiv").hide("slow");
									getAllList(page);
								}
							}
						})
					})// 수정

					$("#replyDelBtn").on("click", function() {

						var rno = $(".modal-title").html();
						// var replytext = $("#replytext").val();

						$.ajax({
							type : 'delete',
							url : "/Exam/replies/" + rno,
							headers : {
								"Content-Type" : "application/json",
								"X-HTTP-Method-Overried" : "DELETE"
							},
							dataType : "text",
							success : function(result) {
								console.log("result:" + result);
								if (result == 'success') {
									alert("삭제완료");
									$("#modDiv").hide("slow");
									getAllList(page);
								}
							}

						})

					})// 삭제

//					function getPageList(page) {
//
//
//						$.getJSON("/Exam/replies/all/" + bno + "/" + page,
//										function(data) {
//
//											console.log(data.length);
//
//											var str = "";
//											$(data.list).each(function() {
//																str += "<li data-rno='"
//																		+ this.rno
//																		+ "'class='replyLi'>"
//																		+ this.rno
//																		+ ":<span>"
//																		+ this.replytext
//																		+ "</span><input type='button' value='수정'></li>";
//															});
//
//											$("#replies").html(str);
//											console.log(data);
////											printPaging(pageMaker);
//										});
//					}// function getPageList
//
//					function printPaging(pageMaker) {
//
//						var str = "";
//
//						if (pageMaker.prev) {
//							str += "<li><a href='" + (pageMaker.startpage - 1)
//									+ "'><< </a></li>";
//						}
//						for (var i = pageMaker.startPage, len = pageMaker.endPage; i < len; i++) {
//							var strClass = pageMaker.cri.page == i ? 'class=active'
//									: '';
//							str += "<li " + strClass + "><a href='" + i + "'>"
//									+ i + "</a></li>";
//						}
//
//						if (pageMaker.next) {
//							str += "<li><a href='" + (pageMaker.endPage + 1)
//									+ "'> >> </a></li>";
//						}
//						$('.pagination').html(str);
//
//					}

				})
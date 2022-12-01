	const url = "http://openapi.seoul.go.kr:8088/6a5572664f746f6439357579556c44/json/culturalSpaceInfo";
	
	let culturePlaceInfomation = [];
	const gu = document.querySelector(".gu");
	let tbody = document.querySelector('tbody');
	let reviewMore = document.querySelector('.review-more');
	let culNo = [];
	let guName = "";
	let reviewList = document.querySelector(".review-list");
	// let gulist = document.querySelectorAll("li");
	
	const culturePlaceList = (area) => {
	
	  culNo = [];
      guName = "";
      
      guName = area;
	
	  axios.all([axios.get(`${url}/1/100`),
	            axios.get(`${url}/101/200`),
	            axios.get(`${url}/201/300`),
	            axios.get(`${url}/301/400`),
	            axios.get(`${url}/401/500`),
	            axios.get(`${url}/501/600`),
	            axios.get(`${url}/601/700`),
	            axios.get(`${url}/701/800`),
	            axios.get(`${url}/801/900`)
	          ]).then(
	            axios.spread((res1, ...rest) => {
	                [res1, ...rest].forEach(response  => {
	                  response.data.culturalSpaceInfo.row.forEach(obj => {
	                    if(!(/(서울)/).test(obj.ADDR) || !(obj.ADDR.match(/[ㄱ-ㅎ가-힣]+구/))) return;
	                        if (obj.ADDR.match(/[ㄱ-ㅎ가-힣]+구/)[0] === area) {
	                          culturePlaceInfomation.push(obj);                   
	                        }
	                  })  
	                })
	                
	                culturePlaceInfomation.forEach( culturePlace => {
	                  let facName = document.createElement('td');
	                  facName.innerHTML = culturePlace.FAC_NAME;
	
	                  let addr = document.createElement('td');
	                  addr.append(culturePlace.ADDR);
	
	                  let subjcode = document.createElement('td');
	                  subjcode.append(culturePlace.SUBJCODE);
	
	                  let enterFree = document.createElement('td');
	                  enterFree.append(culturePlace.ENTRFREE);
	
	                  let closeDay = document.createElement('td');
	                  closeDay.append(culturePlace.CLOSEDAY);
	
	                  let phine = document.createElement('td');
	                  phine.append(culturePlace.PHNE);
	
	                  let tr = document.createElement('tr');
	                  tr.append(facName, addr, subjcode, enterFree, closeDay, phine);
	                  
	                  culNo.push(+culturePlace.NUM);
	                  tbody.append(tr);
	                })
	                culturePlaceInfomation = [];
	                reviewPostApi(culNo, guName);
	            })
	          )
	     
	}
	
	let districts = new Set();
	
	const guList = () => {
	  axios.all([axios.get(`${url}/1/100`),
	            axios.get(`${url}/101/200`),
	            axios.get(`${url}/201/300`),
	            axios.get(`${url}/301/400`),
	            axios.get(`${url}/401/500`),
	            axios.get(`${url}/501/600`),
	            axios.get(`${url}/601/700`),
	            axios.get(`${url}/701/800`),
	            axios.get(`${url}/801/900`)
	          ]).then(
	            axios.spread((res1, ...rest) => {		            
	                [res1, ...rest].forEach(response  => {
	                  response.data.culturalSpaceInfo.row.forEach(obj => {
	                    if(!(/(서울)/).test(obj.ADDR) || !(obj.ADDR.match(/[ㄱ-ㅎ가-힣]+구/))) return;
	                      districts.add(obj.ADDR.match(/[ㄱ-ㅎ가-힣]+구/)[0]);
	                  })  
	                })
	
	                const cultureSubHeading = document.querySelector(".culture-sub-heading");
	
	                for(let district of [...districts].sort()) {
	                  let li = document.createElement('li');
	                  li.innerHTML = district;
	                  gu.appendChild(li);
	                }
	                 cultureSubHeading.after(gu);
	            })
	          )        
	}
	
	guList();
	
	gu.addEventListener("click", (e) => {
	
	   let list = document.querySelectorAll("li");
	   list.forEach( element => element.classList.remove("gu-selected") );
	   e.target.classList.add("gu-selected");
	
	   tbody.innerText = "";
	   culturePlaceList(e.target.innerText);   
	   localStorage.setItem("gu", e.target.innerText);
	});
	
	const reviewPostApi = (num, guName) => {
		fetch("culture-place-search.culture", {
		  method: "POST",
		  headers: {
		    "Content-Type": "application/json",
		  },
         body: JSON.stringify({
		    culturePlaceNum: num,
		    gu: guName
		  }),
		})
		.then( response => response.json())
		.then( data => {
			data.forEach( no => {
			//	console.log(no); 
				placeInfo(no.CUL_NO);
			})
		})
		.catch( error => console.error('실패:', error));
	};
	
	/*const reviewCommentPostApi = (num) => {
		fetch("culture-review-comment.culture", {
		  method: "POST",
		  headers: {
		    "Content-Type": "application/json",
		  },
         body: JSON.stringify({
		    culNo: num,
		  }),
		})
		.then( response => response.json())
		.then( data => {
			data.forEach( comment => {
				console.log(comment);
				
				// cmNum placeNum cm time nickName profile
			    let reviewBody = document.createElement("p");
			    reviewBody.classList = "review-body";
			    reviewBody.innerText = comment.cm;
			    console.log(comment.cm);
			    
			    let listSummaryTop = document.createElement("div");
			    listSummaryTop.classList = "list-summary-top";
			    
			    let personInformation = document.createElement("div");
			    personInformation.classList = "person-information";
			    
			    let userProfile = document.createElement("img");
			    userProfile.classList = "profile";
			    userProfile.src = comment.profile;
			    userProfile.setAttribute("onerror", "this.src='images/man4.svg'");
			    // onerror=this.src='images/man4.svg'
			    
			    let nickNameDate = document.createElement("div");
			    nickNameDate.classList = "nickname-date";
			    
			    let nickName = document.createElement("span");
			    nickName.classList = "nickname";
			    nickName.innerText =  comment.nickName;
			    
			    let date = document.createElement("span");
			    date.classList = "date";
			    date.innerText = comment.time;
			    
			    let listSummary = document.querySelector(".list-summary" + comment.placeNum);
			   
			   nickNameDate.append(nickName, date);
			   personInformation.append(userProfile, nickNameDate);
			   listSummaryTop.append(personInformation);
			   listSummary.append(reviewBody, listSummaryTop);		    
			})
		})
		.catch( error => console.error('실패:', error));
	}; */
	const reviewCommentPostApi = (num) => {
		fetch("culture-review-comment.culture", {
		  method: "POST",
		  headers: {
		    "Content-Type": "application/json",
		  },
         body: JSON.stringify({
		    culNo: num,
		  }),
		})
		.then( response => response.json())
		.then( data => {
			data.forEach( comment => {
				console.log(comment);
				
				// cmNum placeNum cm time nickName profile
			    let reviewBody = document.createElement("p");
			    reviewBody.classList = "review-body";
			    reviewBody.innerText = comment.cm;
			    console.log(comment.cm);
			    
			    let listSummaryTop = document.createElement("div");
			    listSummaryTop.classList = "list-summary-top";
			    
			    let personInformation = document.createElement("div");
			    personInformation.classList = "person-information";
			    
			    let userProfile = document.createElement("img");
			    userProfile.classList = "profile";
			    userProfile.src = comment.profile;
			    userProfile.setAttribute("onerror", "this.src='images/man4.svg'");
			    // onerror=this.src='images/man4.svg'
			    
			    let nickNameDate = document.createElement("div");
			    nickNameDate.classList = "nickname-date";
			    
			    let nickName = document.createElement("span");
			    nickName.classList = "nickname";
			    nickName.innerText =  comment.nickName;
			    
			    let date = document.createElement("span");
			    date.classList = "date";
			    date.innerText = comment.time;
			    
			    let reviewComment = document.createElement("div");
			    reviewComment.classList = "review-comment";
			    
			    
			    let listSummary = document.querySelector(".list-summary" + comment.placeNum);
			   
			   nickNameDate.append(nickName, date);
			   personInformation.append(userProfile, nickNameDate);
			   listSummaryTop.append(personInformation);
			   reviewComment.append(reviewBody, listSummaryTop);
			   listSummary.append(reviewComment);		   
			   
			    
			})
		})
		.catch( error => console.error('실패:', error));
	};
	
	const placeInfo = (num)  => {
		    reviewList.innerText = "";
            axios.all([axios.get(`${url}/1/100/${num}`),
                      axios.get(`${url}/101/200/${num}`),
                      axios.get(`${url}/201/300/${num}`),
                      axios.get(`${url}/301/400/${num}`),
                      axios.get(`${url}/401/500/${num}`),
                      axios.get(`${url}/501/600/${num}`),
                      axios.get(`${url}/601/700/${num}`),
                      axios.get(`${url}/701/800/${num}`),
                      axios.get(`${url}/801/900/${num}`)
                      ]).then(   axios.spread((res1, ...res) => {
                             [res1, ...res].forEach(response => {
                                 if(response.data?.culturalSpaceInfo?.row){
	                              // console.log(response.data.culturalSpaceInfo.row[0]);
	                              
	                              // culture-review-detail.culture
	                              
	                              let anchor = document.createElement('a');
	                              anchor.href = "culture-review-detail.culture?culNo=" + response.data.culturalSpaceInfo.row[0].NUM;
                                  
                                  let listSummaryReview = document.createElement('div');
                                  listSummaryReview.className = "list-summary-review";
                                  listSummaryReview.className += (" list-summary" + response.data.culturalSpaceInfo.row[0].NUM)
                                  
                                  let reviewCultureInfo = document.createElement('div');
                                  reviewCultureInfo.className = "review-culture-info";
                                  
                                  let reviewCulturePlaceName = document.createElement('div');
                                  reviewCulturePlaceName.className = "review-culture-place-name";
                                  reviewCulturePlaceName.innerText = response.data.culturalSpaceInfo.row[0].FAC_NAME
                                        
                                  let reviewAddress = document.createElement('p');
                                  reviewAddress.className = "review-address";
                                  reviewAddress.innerText = response.data.culturalSpaceInfo.row[0].ADDR;
                                  
                                  reviewCultureInfo.append(reviewCulturePlaceName, reviewAddress);
                                  listSummaryReview.append(reviewCultureInfo);
                                  
                                  
                                  anchor.append(listSummaryReview);
                                  reviewList.append(anchor);
                                  
                                  //reviewCommentPostApi(num);
                                 }  
                               //  console.log(reviewList);
                             })
                            // reviewCommentPostApi(num);
                         })

                      )           
                      reviewCommentPostApi(num);  
                    };

    reviewMore.addEventListener('click', () => {
	   let guName = document.querySelector(".gu-selected");
	   reviewMore.href = "culture-Review-list.culture?gu=" + guName.innerText;
	   console.log(reviewMore.href);
	   reviewMore.click();
    })
    
    window.addEventListener('DOMContentLoaded', () => {
	    console.log("window.onload test");
	    console.log(localStorage.getItem("gu"));
	    let list = document.querySelectorAll("li");
	    console.log("list : " + list.length);
	    list.forEach( element => {
		   console.log("element : " + element );
		   element.className = (element.innerText === localStorage.getItem("gu")) ? ".gu-selected" : "";
     })
    }); 
	
    /*    const CheckedGu = () => {
	    console.log("window.onload test");
	    console.log(localStorage.getItem("gu"));
	    let list = document.querySelectorAll("li");
	    console.log("list : " + list.length);
	    list.forEach( element => {
		   console.log("element : " + element );
		   element.className = (element.innerText === localStorage.getItem("gu")) ? ".gu-selected" : "";
	    });
    } */
    /*
    

    /* let list = document.querySelectorAll("li");
	   list.forEach( element => element.classList.remove("gu-selected") );
	   e.target.classList.add("gu-selected"); */
	
	/* 
	    window.onload = reviewMore.addEventListener("click", () => {
	    
			    let guName = document?.querySelector(".gu-selected")?.innerText;
			    console.log(guName);
			    
			    if(document?.querySelector(".gu-selected")?.innerText) {
				    let inputGu = document.createElement('input');
				    let reviewoForm = document.querySelector('.review-form');
				    
				    inputGu.setAttribute('type' , 'hidden');
				    inputGu.setAttribute('name' , 'gu');
				    inputGu.setAttribute('vlaue' , guName);
				    
				    reviewoForm.appendChild(inputGu);
				    
				    console.log("inputGu.type : " + inputGu.type);
				    console.log("inputGu.name : " + inputGu.name);
				    console.log("inputGu.vlaue : " + inputGu.vlaue);
				    
				    reviewoForm.submit();
			    }
			});
	*/

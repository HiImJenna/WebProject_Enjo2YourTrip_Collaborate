	const url = "http://openapi.seoul.go.kr:8088/6a5572664f746f6439357579556c44/json/culturalSpaceInfo";
	
	let culturePlaceInfomation = [];
	let culNo = [];
	let guName = "";
	let reviewList = document.querySelector(".review-list");
	let districts = new Set();
    let gu = document.querySelector(".gu");  
	
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
	                  culNo.push(+culturePlace.NUM);
	                })
	                culturePlaceInfomation = [];
	                reviewPostApi(culNo, guName);
	            })
	          )
	     
	}

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
			    reviewBody.classList = "comment-body";
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
			    
			    /*
			    let reviewComment = document.createElement("div");
			    reviewComment.classList = "review-comment"; */
			    
			    let commentList = document.createElement("div");
			    commentList.classList = "review-comment";
			    
			    let listSummary = document.querySelector(".list-summary" + comment.placeNum);
			   
			   nickNameDate.append(nickName, date);
			   personInformation.append(userProfile, nickNameDate);
			   
			   listSummaryTop.append(personInformation);
			   commentList.append(reviewBody, listSummaryTop);
			  
			   listSummary.append(commentList);		   
			   
			    
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
                                  listSummaryReview.className = "review-list-part";
                                  listSummaryReview.className += (" list-summary" + response.data.culturalSpaceInfo.row[0].NUM)
                                  
                                  let reviewCultureInfo = document.createElement('div');
                                  reviewCultureInfo.className = "list-context";
                                  
                                  let hr = document.createElement('hr');
                                  
                                  let reviewCulturePlaceName = document.createElement('div');
                                  reviewCulturePlaceName.className = "review-title";
                                  reviewCulturePlaceName.innerText = response.data.culturalSpaceInfo.row[0].FAC_NAME
                                        
                                  let reviewAddress = document.createElement('p');
                                  reviewAddress.className = "review-body";
                                  reviewAddress.innerText = response.data.culturalSpaceInfo.row[0].ADDR;
                                  
                                  reviewCultureInfo.append(reviewCulturePlaceName, reviewAddress);
                                  listSummaryReview.append(reviewCultureInfo, hr);
                                  
                                  
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
  /* const placeInfo = (num)  => {
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
                    }; */
	culturePlaceList(gu.innerText);
	
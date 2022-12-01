
/* 
const url = "http://openapi.seoul.go.kr:8088/6a5572664f746f6439357579556c44/json/culturalSpaceInfo";
const placeNum = document.querySelector(".placeNum");

const reviewTitle = document.querySelector(".review-title");
const reviewBody = document.querySelector(".review-body");

let reviewList = document.querySelector(".review-list");
    const placeInfo = (num)  => {
	console.log(num);
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
                           console.log(response.data.culturalSpaceInfo.row[0]);
                             let listSummaryReview = document.createElement("div");
                             listSummaryReview.className = "list-summary-review";
                             
                             let reviewCultureInfo = document.createElement("div");
                             reviewCultureInfo.className = "review-culture-info";
                             
                             let reviewCulturePlaceName = document.createElement("div");
                             reviewCulturePlaceName.className = "review-culture-place-name";
                             
                             let reviewAddress = document.createElement("p");
                             reviewAddress.className = "review-address";
                             
                             reviewCultureInfo.append(reviewCulturePlaceName, reviewAddress);
                             
                             let reviewComment = document.createElement("div");
                             reviewComment.className = "review-comment";
                             
                             let reviewBody = document.createElement("p");
                             reviewBody.className = "review-body";
                             
                             let listSummaryTop = document.createElement("div");
                             listSummaryTop.className = "list-summary-top";
                             
                             let listSummaryTop = document.createElement("div");
                             listSummaryTop.className = "list-summary-top";
                             
                             
                             
                             
                             
                             
                             
                             
                             reviewTitle.innerText = response.data.culturalSpaceInfo.row[0].FAC_NAME;
                             reviewBody.innerText = response.data.culturalSpaceInfo.row[0].ADDR;
                          
                         }  
                       //  console.log(reviewList);
                     })
                    // reviewCommentPostApi(num);
                 })

              )           
             // reviewCommentPostApi(num);  
            };
            
 console.log(placeNum.innerText);           
window.onload = placeInfo(placeNum.innerText); 
*/
const url = "http://openapi.seoul.go.kr:8088/6a5572664f746f6439357579556c44/json/culturalSpaceInfo";
const placeNum = document.querySelector(".placeNum");

const reviewTitle = document.querySelector(".review-title");
const reviewBody = document.querySelector(".review-body");
let listContext = document.querySelector(".list-context2");

const placeInfo = (num)  => {
	console.log(num);
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
                           console.log(response.data.culturalSpaceInfo.row[0]);
                             reviewTitle.innerText = response.data.culturalSpaceInfo.row[0].FAC_NAME;
                             reviewBody.innerText = "주소 : ";
                             reviewBody.innerText += response.data.culturalSpaceInfo.row[0].ADDR;
                             
                             let p1 = document.createElement("p");
                             p1.classList = "review-body";
                             p1.innerText = "주제분류 : "
                             p1.innerText += response.data.culturalSpaceInfo.row[0].SUBJCODE
                             
                             let p2 = document.createElement("p");
                             p2.classList = "review-body";
                             p2.innerText = "홈페이지 : "
                             p2.innerText += response.data.culturalSpaceInfo.row[0].HOMEPAGE
                             
                             let p3 = document.createElement("p");
                             p3.classList = "review-body";
                             p3.innerText = "관람시간 : "
                             p3.innerText += response.data.culturalSpaceInfo.row[0].OPENHOUR
                             
                             let p4 = document.createElement("p");
                             p4.classList = "review-body";
                             p4.innerText = "휴관일 : "
                             p4.innerText += response.data.culturalSpaceInfo.row[0].CLOSEDAY
                             
                             let p5 = document.createElement("p");
                             p5.classList = "review-body";
                             p5.innerText = "무료구분 : "
                             p5.innerText += response.data.culturalSpaceInfo.row[0].ENTRFREE
                             
                             let p6 = document.createElement("p");
                             p6.classList = "review-body";
                             p6.innerText = "관람료 : "
                             p6.innerText += response.data.culturalSpaceInfo.row[0].ENTR_FEE
                             
                             
                             
                             
                             listContext.append(p1, p2, p3, p4, p5, p6);
                             
                             // SUBJCODE 주제 분류
                             // HOMEPAGE 홈페이지 
                             // OPENHOUR 관람시간
                             // CLOSEDAY 휴관일
                             // ENTRFREE 무료구분
                             // ENTR_FEE 관람료
                            
                             
                          
                         }  
                       //  console.log(reviewList);
                     })
                    // reviewCommentPostApi(num);
                 })

              )           
             // reviewCommentPostApi(num);  
            };
            
 console.log(placeNum.innerText);           
window.onload = placeInfo(placeNum.innerText); 

/* const url = "http://openapi.seoul.go.kr:8088/6a5572664f746f6439357579556c44/json/culturalSpaceInfo";
const placeNum = document.querySelector(".placeNum");

const reviewTitle = document.querySelector(".review-title");
const reviewBody = document.querySelector(".review-body");

const placeInfo = (num)  => {
	console.log(num);
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
                           console.log(response.data.culturalSpaceInfo.row[0]);
                             reviewTitle.innerText = response.data.culturalSpaceInfo.row[0].FAC_NAME;
                             reviewBody.innerText = response.data.culturalSpaceInfo.row[0].ADDR;
                          
                         }  
                       //  console.log(reviewList);
                     })
                    // reviewCommentPostApi(num);
                 })

              )           
             // reviewCommentPostApi(num);  
            };
            
 console.log(placeNum.innerText);           
window.onload = placeInfo(placeNum.innerText); */

let infowindow;
let map;
let latitude;
let longitude;
let keyword = "";

$(function(){
	$('#keyword').onclick=function(){
		searchByKeyword();
	}
	keyword=$('#keyword').val();
	initMap();
});

/**
 * Geolocation API는 사용자의 현재 위치를 가져오는 API 이며
 * 지도에 사용자 위치를 표시하는 등 다양한 용도로 사용할 수 있음
 */

/////////////////////////////Map 초기화///////////////////////////////////

// 최초 실행 시 1, 맵을 초기화하는 함수
function initMap() {

  // HTML5에서 제공하는 navigator.geolocation 객체의 존재를 확인 후
  // 존재한다면 'getCurrentPosition' 메서드를 호출하여 기기의 위도 경도 위치를 알아냄
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
    $('#resultTable').empty();
  } else {
    alert('위치 정보를 가져올 수 없습니다.');
    return;
  }
}



// 최초 실행 시 2, getCurrentPosition의 콜백 메서드...
function showPosition2(position) {
  // 기기의 위도 경도를 얻음
  latitude = position.coords.latitude;
  longitude = position.coords.longitude;

  // kakao Map API 를 활용한 지도 렌더링 로직

  // html의 map 요소를 가져옴
  var container = document.getElementById('map');

  // 지도 생성 전에 지도를 어떻게 표시할지 옵션을 매김
  // 특징은 Geolocation을 통해 얻은 좌표를 옵션으로 줌으로써 지도의 중심 좌표를 설정함
  var options = {
    // 사용자의 위도 경도 정보
    center: new kakao.maps.LatLng(latitude, longitude),
    draggable: false,
    level: 3
  };

  // 지도 생성
  var map = new kakao.maps.Map(container, options);

  // 마커 이미지 생성
  var icon = new kakao.maps.MarkerImage(
    'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png',
    new kakao.maps.Size(31, 35)
  );

  // 마커를 생성하고 지도에 표시
  var marker = new kakao.maps.Marker({
    // 사용자의 위도 경도 정보
    position: new kakao.maps.LatLng(latitude, longitude),
    image: icon
  });

  // 아래는 중요한 정보가 아님
  marker.setMap(map);
  document.getElementById("result").style.visibility = "hidden";

/*  renderFavorite();*/
}

/////////////////////////////Map 초기화 끝///////////////////////////////////

/////////////////////////////Map 검색///////////////////////////////////

// 사용자가 검색 버튼을 눌렀을 경우 실행되는 함수 1 
function searchByKeyword() {
	//initMap();
  // 키워드 input text의 value를 가져옴

  keyword = document.getElementBy("keyword").value;

  // 검색어가 입력되지 않은 경우 예외 처리
  if (keyword == "") {
    alert('검색어를 입력해주세요^^');
    return;
  }

  // navigator.geolocation 객체 존재 확인
  // 존재 시 'getCurrentPosition' 메서드를 호출하여 기기의 위도 경도 위치를 알아냄
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else {
    alert('위치 정보를 가져올 수 없습니다.');
    return;
  }
}

// 사용자가 검색 버튼을 눌렀을 경우 실행되는 함수 2
function showPosition(position) {

  // 사용자 기기의 좌표를 얻음
  latitude = position.coords.latitude;
  longitude = position.coords.longitude;

  // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다 ()
  infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
      center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
      level: 3 // 지도의 확대 레벨
    };

  // 지도를 생성합니다    
  map = new kakao.maps.Map(mapContainer, mapOption);

  // 마커 이미지 생성
  var icon = new kakao.maps.MarkerImage(
    'https://w7.pngwing.com/pngs/814/371/png-transparent-red-map-logo-computer-icons-symbol-location-location-miscellaneous-text-logo-thumbnail.png',
    new kakao.maps.Size(31, 35)
  );

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    position: new kakao.maps.LatLng(latitude, longitude),
    image: icon
  });

  // 마커가 지도 위에 표시되도록 설정합니다
  marker.setMap(map);

  map.setCenter(new kakao.maps.LatLng(latitude, longitude));

  // 장소 검색 객체를 생성합니다
  var ps = new kakao.maps.services.Places();

  var searchOption = {
    location: new kakao.maps.LatLng(latitude, longitude),
    radius: 20000,
    sort: kakao.maps.services.SortBy.DISTANCE,
    size: 5
  }

  // 키워드로 장소를 검색합니다 (카카오 서버에 요청, 
  // 결과는 콜백 메서드인 'placesSearchCB'를 통해 결정됨)
  ps.keywordSearch(keyword, placesSearchCB, searchOption);
}

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
  // 검색이 성공인 경우
  if (status === kakao.maps.services.Status.OK) {
	

    // 검색 결과 존재시 데이터를 보일 Div 영역을 보이게 설정함
    document.getElementById("result").style.visibility = "visible";

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    // LatLngBounds 객체에 좌표를 추가함
    var bounds = new kakao.maps.LatLngBounds();
    for (var i = 0; i < data.length; i++) {
      displayMarker(data[i]);
      console.log("===================");
      console.log(data[i]);
      bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
    }

    // // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);

    // 검색 데이터 local storage에 저장
    localStorage.setItem("searchData", JSON.stringify(data));

    // 검색 결과를 화면에 그림
    // 상호명, 주소, 거리 등의 정보를 그림
    // <input type="checkbox" ..... onclick="checkFavorite() ==> 즐겨찾기 등록 함수
    $('#resultTable').empty();
    let number = 1;
    for (const item of data) {
      console.log("item : " + item);
      let html = `<tr >
                    <th scope="row">${number++}</th>
                    <td align:center><a href="detail.restaurant?addr=${item.address_name}&phone=${item.phone}&name=${item.place_name}&category=${item.category_name}">${item.place_name}</a></td>
                    <td>${item.road_address_name}</td>
                    <td>${item.distance}m</td>
                  </tr>`;
      $('#resultTable').append(html);
    }
  } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    // 검색의 결과가 없는 경우 검색 결과 영역을 보이지 않게 함
    $('#keyword').val('');
    alert("검색 결과가 없습니다.");
    document.getElementById("result").style.visibility = "hidden";
  }
}

// 지도에 마커를 표시하는 함수
// 검색한 지도의 결과들의 마커를 표시하는 함수(중요X)
function displayMarker(place) {
  // 마커를 생성하고 지도에 표시합니다
  var marker = new kakao.maps.Marker({
    map: map,
    position: new kakao.maps.LatLng(place.y, place.x)
  });

  // 마커에 클릭이벤트를 등록합니다
  kakao.maps.event.addListener(marker, 'click', function () {
    // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
    infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
    infowindow.open(map, marker);
  });
}


///////////////////////////**/////////////////////////////////
// 즐겨찾기 등록 및 제거 함수
/*function checkFavorite(obj, x, y) {
  // 로컬스토리지의 데이터를 가져옴 ************************************
  const searchData = JSON.parse(localStorage.getItem("searchData"));
  let favoriteData = JSON.parse(localStorage.getItem("favoriteData"));

  // 즐겨찾기 추가
  // 체크 박스가 checked == true 이면 (눌렀을 경우) 아래 if 블록에 진입
  if (obj.checked) {
    // 로컬스토리지에 저장한 검색 데이터 반복문 순회
    for (const item of searchData) {
      // 현재 저장할 곳의 위도 경도와 검색 데이터 중 위도 경도가 같은 것을 확인
      if (item.x == x && item.y == y) {

        // 최초 데이터 예외 처리
        if (favoriteData == null) {
          // 로컬 스토리지에 즐겨찾기 데이터가 없을 경우 Array를 만듦
          favoriteData = [];
        }

        // 이미 즐겨찾기 등록되어 있는지 체크
        for (const store of favoriteData) {
          if (store.x == x && store.y == y) {
            alert("이미 즐겨찾기에 등록되어 있습니다.");
            obj.checked = false;
            return;
          }
        }

        // 즐겨찾기 Array 추가
        favoriteData.push(item);

        // 해당 Array 로컬 스토리지에 저장 ************************************
        localStorage.setItem("favoriteData", JSON.stringify(favoriteData));
        alert("즐겨 찾기에 추가했습니다");
        obj.checked = false;
      }
    }
  } else { //즐겨찾기 삭제
    renewFavoriteData = favoriteData.filter(function (element) {
      return element.x != x && element.y != y;
    });
    localStorage.setItem("favoriteData", JSON.stringify(renewFavoriteData));
  }

  // 즐겨찾기 화면에 그리는 함수 호출
  renderFavorite();
}
///////////////////////////**/////////////////////////////////

function renderFavorite() {
  // 로컬 스토리지에 저장된 즐겨찾기 데이터를 가져옴
  const favoriteData = JSON.parse(localStorage.getItem("favoriteData"));

  // 화면에 즐겨찾기를 그리는 요소를 가져옴 
  const favoriteDiv = document.getElementById("favorite");

  // 로컬 스토리지에 저장된 데이터가 없는 경우
  if (favoriteData == null || favoriteData.length == 0) {
    // 즐겨찾기를 그리는 부분을 보이지 않게 설정함
    favoriteDiv.style.visibility = "hidden";
    // 함수 종료
    return;
  }

  // 로컬 스토리지에 즐겨찾기 데이터가 1개 이상 존재할 경우

  // 즐겨찾기 그리는 부분을 보이게 함
  favoriteDiv.style.visibility = "visible";

  // 로컬 스토리지에서 가져온 데이터를 화면에 그림
  $('#favoriteTable').empty();
  let number = 1;
  for (const item of favoriteData) {
    let html = `<tr>
                  <th scope="row">${number++}</th>
                  <td><a href="${item.place_url}">${item.place_name}</a></td>
                  <td>${item.road_address_name}</td>
                  <td>${item.x}</td>
                  <td>${item.y}</td>
                </tr>`;
    $('#favoriteTable').append(html);
  }
}
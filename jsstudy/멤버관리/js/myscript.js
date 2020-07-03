
// name 값을 매개변수로 넘겨주면 value를 찾아서 리턴해주는 함수 
// 주소줄의 특징name의 value값을 찾는 기능을 범용화
// 값이 안 넘어왔거나, 찾을수 없을 때는 null값을 리턴하는 걸로
// 범용화 자바의 패키지처럼 함수의 소속을 줌!

var request = {};

request.getParameter = function (p_name) {
    var v_jusoVal = location.href;
    if(v_jusoVal.indexOf("?") == -1){
        return null;
    }
    // ? 오른쪽 문자열만 빼기
    v_jusoVal = decodeURIComponent(v_jusoVal.split("?")[1]).split("&") ;
    for(var i=0; i<v_jusoVal.length; i++){
        if(v_jusoVal[i].split("=")[0] == p_name ){
              return v_jusoVal[i].split("=")[1];
        }
     }

}
// 과제 같은이름 여러개 넘어올때
request.getParameterValues = function(p_name) {
    var v_jusoVal = location.href;
    var v_vals = [];
    if(v_jusoVal.indexOf("?") == -1){
        return null;
    }
    // ? 오른쪽 문자열만 빼기
    v_jusoVal = decodeURIComponent(v_jusoVal.split("?")[1]).split("&") ;
    for(var i=0; i<v_jusoVal.length; i++){
        if(v_jusoVal[i].split("=")[0] == p_name ){
            v_vals.push(v_jusoVal[i].split("=")[1]);
        }
     }
     return v_vals;

}

/* function f_init() {
     alert("전 초기화 루틴이에요")
}
 window.onload = f_init; */

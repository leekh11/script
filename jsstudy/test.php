<?php
    //echo phpinfo(); // php 잘 설치 되었는지 확인하는 함수 
    //php 에서 변수 선언은 $로 십작 문자열, 더하기는 .
    //여기는 서버쪽에서 실행된다는 것이 중요
    //넘어가는 것이 아니고 실행결과값(단지 문자열 )이 넘어간다는 것이 중요 
    $s_name=$_GET["nm_id"]; // get방식으로 값 받기
    // echo는 out.print에 해당 
    // echo "<h1>Hello Greatest Programmer " .$s_name." 님</h1>"
    // echo "<script>";
    // echo "alert('안녕하세요'"  .$s_name. ");";
    // echo "</script>";
    /* 쉽지만 꼭 기억
        페이지내에 서버에서 실행되는 부분이 먼저 실행되고 그결과 같이 넣어진
        문자열 전체가 클라이언트로 넘어가서 전체 문자열이 브라우저에서
        위에서 아래로 다시 해석된다는 사실 
        곧 페이지내에 서버에서 실행되는 곳과 클라이언트에서 실행되는 것이 짬뽕    
    */
?>

<script>
    alert("안녕하세요" + '<?=$s_name?>');
</script>
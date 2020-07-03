<?php
    // 아작스 크로스 오리진 회피, 서버경유
    // 모든 서버는 서버면서 클라이언트. 내 서버에서 다른서버에 요청
    // 일반적인 크로스오리진 해결책은 JSONP와 서버경유방법
    //Header set Access-Control-Allow-Origin "*"
    $schWord = $_GET["imgsch"];

    $flikrURL = "https://www.flickr.com/services/feeds/photos_public.gne?tags=".$schWord."&format=json";
    $cont=file_get_contents($flikrURL);
    echo $cont
    // $cont = file_get_contents("http://192.168.10.6/jsstudy/AJAX/data.xml");
    // echo $cont;
?>
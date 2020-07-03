<?php
    $schWord = $_GET["yuyu"];
    $cont =file_get_contents("https://news.google.com/rss/search?q=".urlencode($schWord)."&hl=ko&gl=KR&ceid=KR:ko");
    $simpleXml = simplexml_load_string($cont);
    $json = json_encode($simpleXml);
    echo $json;
?>

<?php
function cont($array, $ele){
    $contains = "false";
    foreach($array as $value){
      if($value == $ele){
      $contains = "true";
      }
    }
    return $contains;
  }
$arr = array(1,2,3,4,5);
$ele = 6;
echo cont($arr, $ele);
?>

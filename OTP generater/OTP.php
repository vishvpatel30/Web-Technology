
<?php 

function generateNumericOTP($n) { 
    $generator = "1357902468"; 
    $result = ""; 
    
    
    back:
    for ($i = 1; $i <= $n; $i++) { 
        $result .= substr($generator, (rand()%(strlen($generator))), 1); 
    }
    
    if ($result!='234567'){
        return $result;
    }
    else{
        goto back;
    }
    
} 

$n = 6; 
print_r(generateNumericOTP($n)); 
  
?>
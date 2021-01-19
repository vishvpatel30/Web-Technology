
<?php

function year($num){
    
    $months = array(
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July ',
        'August',
        'September',
        'October',
        'November',
        'December',
    );

    for($i=0; $i< 12; $i++){
        $mon=cal_days_in_month(CAL_GREGORIAN, $i+1, $num);
        $toshow[$months[$i]]=$mon;
    }

    return $toshow;
}

$x=year(2020);
print_r($x);

?>
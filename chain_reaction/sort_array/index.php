<?php 
function sortArray(&$arr, $l, $h) {
    
    if ($l < $h) {
        $p = partition($arr, $l, $h);
        sortArray($arr, $l, $p - 1);
        sortArray($arr, $p + 1, $h);
    }
}

function partition(&$arr, $l, $h) {
    $p = $arr[$h];
    $i = $l - 1;
    for ($j = $l; $j < $h; $j++) {
        if ($arr[$j] <= $p) {
            $i++;
            swap($arr, $i, $j);
        }
    }
    
    swap($arr, $i + 1, $h);
    return $i + 1;
}

function swap(&$arr, $i, $j) {
    $temp = $arr[$i];
    $arr[$i] = $arr[$j];
    $arr[$j] = $temp;
}

$array = [3, 6, 8, 7, 0, 1, 4, 2, 9, 5 ];
sortArray($array, 0, count($array) - 1);
print_r($array);

?>

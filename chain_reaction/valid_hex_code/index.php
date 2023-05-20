<?php 
$strings = array('#CD5C5C', '#EAECEE', '#eaecee', '#CD5C58C', '#CD5C5Z', '#CD5C&C', 'CD5C5C');
foreach ($strings as $string) {
    validateHexCode($string);
}

function validateHexCode($string) {
        if($string[0] != "#"){
            echo "$string => false <br>";
        }else if (ctype_xdigit(ltrim($string, '#')) && (strlen($string) == 7)) {
            echo "$string => true <br>";
        } else {
            echo "$string => false <br>";
        }
  }

?>
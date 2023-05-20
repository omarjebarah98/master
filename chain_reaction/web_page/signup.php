<?php 
include "db_connection.php";
if(isset($_POST['fname']) && isset($_POST['lname']) && isset($_POST['phone'])){
    
    function validate($data){
        echo "$data";
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }

    $fname = validate($_POST['fname']);
    $lname = validate($_POST['lname']);
    $phone = validate($_POST['phone']);

    if(empty($fname)) {
        header("Location: index.php?error=First Name is required");
        exit();
    }else if(empty($lname)){
        header("Location: index.php?error=Last Name is required");
        exit();
    }else if(empty($phone)){
        header("Location: index.php?error=Phone number is required");
        exit();
    }else {
        $getUser = "SELECT * FROM users WHERE first_name = '$fname' AND last_name = '$lname'";
        $result = mysqli_query($conn, $getUser);
        if(mysqli_num_rows($result)){
            header("Location: index.php?error= This User exist!");
        }else{
            $query = "INSERT INTO users(first_name,last_name,phone) VALUES('$fname', '$lname', '$phone')";
            if(mysqli_query($conn, $query)){
                header("Location: index.php?success=User added successfully");
            }else {
                header("Location: index.php?error=Please try again!");
            }
        }
        
    }
}else{
    header("Location: index.htm");
}

?>
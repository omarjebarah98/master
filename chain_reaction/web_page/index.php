<!DOCTYPE html>
<html>
<head>
	<title>SIGNUP</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
     <form action="signup.php" method="post">
     	<h2>Hello, who's this ?</h2>
     	<?php if (isset($_GET['error'])) { ?>
     		<p class="error"><?php echo $_GET['error']; ?></p>
     	<?php } ?>
		 <?php if (isset($_GET['success'])) { ?>
     		<p class="success"><?php echo $_GET['success']; ?></p>
     	<?php } ?>
     	<label>First Name</label>
     	<input type="text" name="fname" placeholder="First Name"><br>

        <label>Last Name</label>
     	<input type="text" name="lname" placeholder="Last Name"><br>

     	<label>Phone number</label>
     	<input type="text" name="phone" placeholder="Phone number"><br>

     	<button type="submit">Submit</button>
     </form>
</body>
</html>
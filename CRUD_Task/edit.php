<?php
$database=mysqli_connect("localhost","root","","Task");

if(isset($_GET['edit'])){
	$id=$_GET['edit'];
	$update=true;
	$store=mysqli_query($database,"SELECT * FROM student WHERE id=$id");
	
	$num=mysqli_fetch_array($store);
	$stud_name=$num['studname'];
	$subject=$num['subject'];
	
	echo $id;
}
?>
<form method="post" action="first.php">>
<input type="hidden" name="id" value="<?php echo $id; ?>">
<label>Student name :</label>
<input type="text" name="name">
<label>Subject :</label>
<input type="text" name="sub">
<button type="submit" name="update">Update</button>
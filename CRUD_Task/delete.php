<?php
$database=mysqli_connect("localhost","root","","Task");

if(isset($_GET['delete'])){
	$id=$_GET['delete'];
	$update=true;
	mysqli_query($database,"DELETE FROM student WHERE id=$id");
	
	header('location: second.php');
	
}
?>
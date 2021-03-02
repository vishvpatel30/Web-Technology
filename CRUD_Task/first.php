<?php
session_start();
$database=mysqli_connect("localhost","root","","Task");

$stud_name=$_POST["name"];
$subject=$_POST["sub"];


if($id==NULL && $stud_name!=NULL && $subject!=NULL)
{
	mysqli_query($database,"INSERT INTO student(studname,subject) VALUES ('$stud_name','$subject')");
	$_SESSION["message"]="subject of student saved";
	
	header('location: second.php');
}

if(isset($_POST['update'])){
	$id=$_POST["id"];
	$stud_name=$_POST["name"];
	$subject=$_POST["sub"];
	
	mysqli_query($database,"UPDATE student SET studname='$stud_name', subject='$subject' WHERE id=$id");
	header('location: second.php');
}

?>
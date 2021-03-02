<?php
$database=mysqli_connect("localhost","root","","Task");

$result= mysqli_query($database,"SELECT * FROM student");
?>


<table>
	<thead>
		<tr>
			<th>Student Name</th>
			<th>Subject</th>
			<th colspan="2">Action</th>
		</tr>
	</thead>
	<?php while($row=mysqli_fetch_array($result)){?>
	
		<tr>
			<td><?php echo $row['studname']; ?></td>
			<td><?php echo $row['subject']; ?></td>
			<td><a href="edit.php?edit=<?php echo $row['id']; ?>" class=edit_btn>Edit</a>
			<td><a href="delete.php?delete=<?php echo $row['id']; ?>" class=delete_btn>Delete</a>
		</tr>
	<?php }?>
</table>
			
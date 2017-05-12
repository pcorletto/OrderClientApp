<?php  
 require "init.php";  
 $username = $_POST["username"];  
 $password =  $_POST["password"]; 

// Validate the username
$sql_query = "select * from clientTable where username = '$username';";
 $result = mysqli_query($con,$sql_query);
// If no such user name exists...  
 if(mysqli_num_rows($result) == 0 )  
 {  
 echo "Incorrect username";
 } 

else
{
// Validate the password
$sql_query = "select * from clientTable where username = '$username' and password = '$password';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) == 0 )  
 {  
 echo "Incorrect password";
 }  
}
 
 $sql_query = "select * from clientTable where username = '$username' and password = '$password';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 //$firstname = var_export($row["firstname"]);  
 /*$lastname = var_export($row["lastname"]);*/
 echo var_dump($row);
 /*echo $firstname;*/
 /*echo $lastname;*/
 /*echo var_export($row["firstname"]);*/
 /*echo var_dump($row['lastname']);*/
 }  
  
 ?>
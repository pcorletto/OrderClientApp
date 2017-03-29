<?php  
 require "init.php";  
 $username = $_POST["username"];  
 $password =  $_POST["password"];  
 $sql_query = "select * from clientTable where username like '$username' and password like '$password';";
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
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>
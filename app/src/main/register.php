<?php
require "init.php";

$username=$_POST["username"];
$password=$_POST["password"];
$firstname=$_POST["firstname"];
$lastname=$_POST["lastname"];
$email=$_POST["email"];
$address=$_POST["address"];
$city=$_POST["city"];
$state=$_POST["state"];
$zipcode=$_POST["zipcode"];
$telephone=$_POST["telephone"];
$mobile=$_POST["mobile"];

$sql_query = "select username from clientTable where username = '$username';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
//$row = mysqli_fetch_assoc($result); 
//echo var_dump($row);
echo "That username already exists";
}

else{
$clientid=$_POST["clientid"];
$sql_query="insert into clientTable values('$clientid','$username','$password','$firstname','$lastname','$email','$address','$city','$state','$zipcode','$telephone','$mobile');";
if(mysqli_query($con,$sql_query))
{
//echo "<h3>Data insertion success...</h3>";
}
else
{
//echo "Data insertion error...".mysqli_error($con);
}
}
?>
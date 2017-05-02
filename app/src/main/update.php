<?php
require "init.php";
$clientid=$_POST["clientid"];
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

$sql_query="update clientTable set firstname = '$firstname', lastname = '$lastname', email = '$email', address = '$address', city = '$city', state = '$state', zipcode = '$zipcode', telephone = '$telephone', mobile = '$mobile' where username = '$username'";

if(mysqli_query($con,$sql_query))
{
//echo "<h3>Data insertion success...</h3>";
}

else
{
//echo "Data insertion error...".mysqli_error($con);
}


?>
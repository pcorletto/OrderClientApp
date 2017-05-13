<?php  
 require "init.php";  

$sql_query = "select * from productTable;";
 $result = mysqli_query($con,$sql_query);
 
 if(mysqli_num_rows($result) > 0 )  
 {  
 //$row = mysqli_fetch_assoc($result);

foreach($result as $line)
{
  echo(var_dump($line));
}  
 //$firstname = var_export($row["firstname"]);  
 /*$lastname = var_export($row["lastname"]);*/
 //echo var_dump($row); 
 /*echo $firstname;*/
 /*echo $lastname;*/
 /*echo var_export($row["firstname"]);*/
 /*echo var_dump($row['lastname']);*/
 }  
 ?>
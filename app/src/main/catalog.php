<?php  
 require "init.php";  

$sql_query = "select * from productTable where productid = 2";

$result = mysqli_query($con, $sql_query);  

    while ($row = mysqli_fetch_array($result)) {
        $image = base64_encode($row['image']);


    }
echo $image;


    //echo $finallyWeAreThere;



    //mysqli_close($sql_query);



//$sth = $db->query($sql_query);
//$result=mysqli_fetch_array($sth);
//$image = $result['image'];
//echo '<img src="data:image/jpeg;base64,'.base64_encode($image->load()) .'" />';

 //$result = mysqli_query($con,$sql_query);
 
 //if(mysqli_num_rows($result) > 0 )  
 //{  
 //$row = mysqli_fetch_assoc($result);
 
// Echo out the title "catalog" so that I know from where the array result is coming from
//$title = "catalog";
//echo(var_dump($title));
//foreach($result as $line)
//{
  //echo(var_dump($line));
//}  
 //$firstname = var_export($row["firstname"]);  
 /*$lastname = var_export($row["lastname"]);*/
 //echo var_dump($row); 
 /*echo $firstname;*/
 /*echo $lastname;*/
 /*echo var_export($row["firstname"]);*/
 /*echo var_dump($row['lastname']);*/
 //}  
 ?>
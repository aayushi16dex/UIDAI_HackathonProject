<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
  overflow-x: hidden;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

img{
   float: left;
   margin-right: 300px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
h1{
font-size: 50px;
font-family: Georgia;

}
/* Set a style for the submit button */
.submitbtn {
  background-color: #04AA6D;
  color: white;
  font-size: 30px;
  padding: 12px 16px;
  margin: 2px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.submitbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

</style>
<title>UIDAI</title>
</head>
<body style="background-color:  #008080;">

<form action = "UserResult" method = "post">
  <div class="container">

<table>
            <tr>
                <td>
                    <img src="https://spiderimg.amarujala.com/assets/images/2017/12/02/750x506/demo-pic_1512220322.jpeg?format=webp&w=400&dpr=2.6" alt = "Cannot embed image" style="float: left; width:350px;height:160px;margin-right: 150px">
                    
       </td> 
    <td> <h1>UIDAI </h1></td>
                 <td>
                     <img src="https://i.pinimg.com/originals/aa/34/53/aa34538b884a1103e9cf82bbd52cfad7.jpg" alt = "Cannot embed image" style="float: right; width:350px;height:200px; margin-left: 170px;">
                </td> 
            </tr>
        </table>
  
<p style= "color: white; text-align: center; font-size: 200%; background-color:#04AA6D; padding: 10px 14px;"><b>Address Formatter</b></p>
 
<p style = "color: red; background-color:#F0FFF0; font-size: 100%; padding: 8px 12px;"><marquee> <b>Note: All * are mandatory fields</b></marquee></p>
    <label for="aadhar number"><b>Aadhar number <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Digits only" name = "aadharNo" minlength = "12" maxlength = "12" required>

    <label for="hNo"><b>House No</b></label>
    <input type="text" placeholder="Enter House no" name = "hNo">

    <label for="street"><b>Street/Road/Lane</b></label>
    <input type="text" placeholder="Enter Street/Road/Lane no" name = "street">

    <label for="area"><b>Area/Locality/Sector</b></label>
    <input type="text" placeholder="Enter Area/Locality/Sector" name = "area">

    <label for="lmark"><b>Landmark</b></label>
    <input type="text" placeholder="Enter Landmark" name = "landmark">

    <label for="vill"><b>Village/Town/City <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Village/Town/City" name = "town" required>

    <label for="sd"><b>Sub-District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Sub-District" name = "subDistrict" required>

    <label for="dist"><b>District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter District" name = "district" required>

    <label for="state"><b>State <span style="color: #ff0000">*</span></b></label><br>
    <select style="min-height:40px;min-width:100px;" id="state" name="state" required>
      <option>State/ Union Territory</option>
      <option>Andaman and Nicobar Islands</option>
      <option>Andhra Pradesh</option>
      <option>Arunachal Pradesh</option>
      <option>Assam</option>
      <option>Bihar</option>
      <option>Chandigarh</option>
      <option>Chhattisgarh</option>
      <option>Dadra & Nagar Haveli and Daman & Diu</option>
      <option>Delhi</option>
      <option>Goa</option>
      <option>Gujarat</option>
      <option>Haryana</option>
      <option>Himachal Pradesh</option>
      <option>Jammu and Kashmir</option>
      <option>Jharkhand</option>
      <option>Karnataka</option>
      <option>Kerala</option>
      <option>Ladakh</option>
      <option>Lakshadweep</option>
      <option>Madhya Pradesh</option>
      <option>Maharashtra</option>
      <option>Manipur</option>
      <option>Meghalaya</option>
      <option>Mizoram</option>
      <option>Nagaland</option>
      <option>Odisha</option>
      <option>Puducherry</option>
      <option>Punjab</option>
      <option>Rajasthan</option>
      <option>Sikkim</option>
      <option>Tamil Nadu</option>
      <option>Telangana</option>
      <option>Tripura</option>
      <option>Uttar Pradesh</option>
      <option>Uttarakhand</option>
      <option>West Bengal</option>
    </select>
    <br><br>

    <label for="pin"><b>Pincode <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter pincode" name = "pincode" minlength = "6" maxlength = "6" required>
    <hr>
     
    <button type="submit" class="submitbtn">Submit</button>
  </div>
  
</form>
</body>
</html>
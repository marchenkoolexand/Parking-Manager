<%@ page session="false" %>
<html>
<head>
	<title>Parking Manager App MVC</title>
</head>
<h1 style="color: #5e9ca0; text-align: left;">Parking Manager App</h1>
<h3 style="text-align: left;"><strong>Web App</strong></h3>
<ul style="list-style-type: square; text-align: left;">
<li><strong>Just execute request&nbsp;in browser URL line. Examples of request in table below or launch Desktop App.</strong></li>
</ul>
<h2 style="color: #2e6c80; text-align: left;">Request types example:</h2>
<table style="height: 314px; border-color: #000000; float: left; background-color: #fdda9d;" border="1" width="495">
<thead>
<tr>
<td><strong>Name of the function</strong></td>
<td><strong>Example how to use</strong></td>
</tr>
</thead>
<tbody>
<tr>
<td>Add new Car to garage</td>
<td>http://localhost:8080/ParkingManagerApp/addNewCar?garageId=1&amp;brand=BMW&amp;model=535&amp;year=2013&amp;color=Blue&amp;plateNumber=TY678HJ&amp;ownerId=3</td>
</tr>
<tr>
<td>Add new Garage&nbsp;</td>
<td>http://localhost:8080/ParkingManagerApp/addNewGarage?city=Ternopil&amp;street=Naukova&amp;buildingNumber=34</td>
</tr>
<tr>
<td>Add new Owner</td>
<td>http://localhost:8080/ParkingManagerApp/addNewOwner?name=Leonid&amp;surname=Koverovuch</td>
</tr>
<tr>
<td>Update Garage</td>
<td>
<p>http://localhost:8080/ParkingManagerApp/updateGarage?field=city&amp;newData=New York&amp;garageID=3</p>
<p><em>(field types = street,building,city)</em></p>
</td>
</tr>
<tr>
<td>Update Owner</td>
<td>
<p>http://localhost:8080/ParkingManagerApp/updateOwner?field=name&amp;newData=Oleh</p>
<p><em>(field types = name,surname)</em></p>
</td>
</tr>
<tr>
<td>Update Car</td>
<td>http://localhost:8080/ParkingManagerApp/updateCar?field=brand&amp;newData=FORD&amp;carID=3
<p><em>(field types = color,model,owner,year,plateNumber,year)</em></p>
</td>
</tr>
<tr>
<td>Fetch Car</td>
<td>http://localhost:8080/ParkingManagerApp/loadCar?carID=5</td>
</tr>
<tr>
<td>Fetch Owner</td>
<td>http://localhost:8080/ParkingManagerApp/loadOwner?ownerID=name2</td>
</tr>
<tr>
<td>Fetch Garage</td>
<td>http://localhost:8080/ParkingManagerApp/loadGarage?garageId=name4</td>
</tr>
<tr>
<td>Load All Data</td>
<td>http://localhost:8080/ParkingManagerApp/loadAllData</td>
</tr>
<tr>
<td>Delete Car&nbsp;</td>
<td>http://localhost:8080/ParkingManagerApp/deleteCar?carID=5</td>
</tr>
<tr>
<td>Delete Garage</td>
<td>http://localhost:8080/ParkingManagerApp/deleteGarage?garageId=name4</td>
</tr>
<tr>
<td>Delete Owner</td>
<td>http://localhost:8080/ParkingManagerApp/deleteOwner?ownerID=name2</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<body>
	<form action="transact" method="get">
		<h3><center><p style='color:purple'>Successfully Logged in...</p></center>
	
	<label for="transaction" >Select your transaction type</label>
	<select	name=trans_type>
	<option value="withdraw">Withdraw</option>
	<option value="view">View Account Details</option>
	<option value="deposit">Deposit</option>
	<option value ="transfer">Transfer</option>
	<option value="bal_status">Check Balance status</option>
	<option value="prin_trans">Print transactions</option>
	<option value="logout">Logout</option></select>
		<br>
			<center>
				<input type="submit" value="SUBMIT" name="transact">
			</center>
			<br>
		
		 
		<img		src="D:\Eclipse-Workspace\starter\parallel_project_serv_jsp\WebContent\images\images.jpg">

</body>
</html>
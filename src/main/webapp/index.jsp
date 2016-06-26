<html>
<body>

	<h2>Welcome to the Java Authentication and Authorization Service</h2>
	<form action="/jaaspractice/auth/basic" method="post">
		<table>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="uname" id="user_name_text" />
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="upassword"
					id="user_password_text" />
			</tr>

			<tr>
				<td><input type="submit" value="authenticate" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

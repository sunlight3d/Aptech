<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>    
    <form method="POST" action="{{ route('login') }}"> 
        @csrf
    <!--Gọi đến hàm calculate trong controller hiện tại(CalculationController) -->
        <input type="text" name="username" placeholder="Enter username" required>
            <input type="password" name="password" placeholder="Enter password" required>
            <button type="submit">Login</button>    
    </form>        
</body>
</html>

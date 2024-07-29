<!-- resources/views/users/register.blade.php -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Register</h2>
        <form action="{{ route('users.store') }}" method="POST">
            @csrf
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" 
                id="email" name="email">
            </div>
            <div class="form-group">
                <label for="fullname">Full Name:</label>
                <input type="text" class="form-control" 
                    id="fullname" name="fullname">
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <input type="text" class="form-control" id="role" name="role" >
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" >
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        @if ($errors->any())
            <div class="alert alert-danger">
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </div>
        @endif
    </div>
</body>
</html>

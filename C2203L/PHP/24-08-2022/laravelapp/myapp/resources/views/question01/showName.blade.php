<html>
    <body>
        <h1>Kakaaaaa1111</h1>
        <form action="{{url('question01/showName')}}">
            <input
            type="text" name="username"
            placeholder="Enter your name">
            <button type="submit">Submit name</button>
        </form>
        <h1>Your name: {{$username}}</h1>
    </body>
</html>

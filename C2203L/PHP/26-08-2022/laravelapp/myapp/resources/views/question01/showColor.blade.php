<html>
    <body>
        <h1>Show color</h1>
        <form action="{{url('question01/showColor')}}">
            <input
            type="text" name="message"
            placeholder="Enter message">
            <button type="submit">Input</button>
        </form>
        {{-- <h1>Your name: {{$messages}}</h1> --}}
        @foreach ($messages as $message)
        <span style="color:red;">{{$message[0]}}</span>{{substr($message, 1)}}
        @endforeach
    </body>
</html>

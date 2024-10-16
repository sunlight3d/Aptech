@include('header')

<h1>Post List</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>URL</th>
            <th>User</th>            
        </tr>
    </thead>
    <tbody>
        @foreach($posts as $post)
            <tr>
                <td>{{ $post->id }}</td>
                <td>{{ $post->title }}</td>
                <td>{{ $post->content }}</td>
                <td>{{ $post->url }}</td>
                <td>{{ $post->user_id }}</td>
            </tr>
        @endforeach
    </tbody>
</table>

@include('footer')

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách bài viết</title>
</head>
<body>
    <h1>Danh sách bài viết</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tiêu đề</th>
                <th>Nội dung</th>
                <th>URL</th>
                <th>Người dùng</th>
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
</body>
</html>

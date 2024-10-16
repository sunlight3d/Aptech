<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Do you really want to delete this book?</h2>
    <form method="post" action="/book/deleteBook">
        <input type="hidden" value="${bookid}" name="bookId">
        <input type="submit" value="submit">
    </form>
    <a href="/book/booklist">Return to Book list</a></td>
</body>
</html>
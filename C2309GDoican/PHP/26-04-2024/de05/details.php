<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Cookie name</th>
                <th>Cookie value</th>
            </tr>
        </thead>
        <?php foreach ($_COOKIE as $key => $value): ?>
            <?php if($key == "username" || $key == "password") { ?>
                <tr>
                    <td><?php echo $key; ?></td>                
                    <td><?php echo $value; ?></td>                
                </tr>
            <?php }?>            
        <?php endforeach; ?>
        <tr>
            <td>

            </td>
        </tr>
    </table>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Hello, World!</h1>
<form method="post" action="/myApp/greeting">
    <input name="name"/>
    <button type="submit">Sendd</button>
</form>
<br/>
<form method="post" action="/myApp/send" enctype="multipart/form-data">
    <input type="text" name="author" />
    <input type="file" name="file"/>
    <button type="submit">Send</button>
</form>
</body>
</html>

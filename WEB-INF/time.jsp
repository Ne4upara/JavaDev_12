<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Current Time (GMT ${param.timezone})</title>
</head>
<body>
<h1>Ваше время (GMT ${param.timezone > 0 ? '+' : ''}${param.timezone})</h1>
<p>${formattedTime}</p>
</body>
</html>
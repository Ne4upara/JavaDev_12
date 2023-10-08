<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <div class="container">
        <h1>Время.</h1>
        <form action="<%= request.getContextPath() %>/time" method="GET">
            <label for=>Введите часовой пояс <input type="text" name="timezone"></label>
            <button type="submit">Далее</button>
        </form>

    </div>
</body>
</html>
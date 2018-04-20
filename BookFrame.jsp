<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Список книг:</title>
    </head>

    <body>
        <form action="<c:url value="/edit"/>" method="POST">
            <input type="hidden" name="BookId" value="${Book.BookId}"/>
            <table>
                <tr>
                    <td>Автор: </td><td><input type="text" name="Author" value="${Book.Author}"/></td>
                </tr>
                <tr>
                    <td>Назва книжки: </td><td><input type="text" name="Name_b" value="${Book.Name_b}"/></td>
                </tr>
             
                <tr>
                    <td><input type="submit" value="OK" name="OK"/></td>
                    <td><input type="submit" value="Cancel" name="Cancel"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
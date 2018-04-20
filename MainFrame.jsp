<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
    <head>
        <title>Список книг</title>
    </head>
 
    <body>
        <form action="<c:url value="/main"/>" method="POST">
            <table>
                <tr>
                    //<td>Год:<input type="text" name="year" value="${form.year}"/><br/></td>
                  //  <td>Список групп:
                        <select name="BookId">
                            <c:forEach var="Book" items="${form.Books}">
                                <c:choose>
                                    <c:when test="${Book.BookId==form.BookId}">
                                        <option value="${Book.BookId}" selected><c:out value="${Book.name_b}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${Book.BookId}"><c:out value="${Book.name_b}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                      
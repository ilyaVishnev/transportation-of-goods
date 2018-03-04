<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.03.2018
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trucks</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>Driver List</h1>
<table class="tg">
    <tr>
        <th>drivername</th>
        <th>surname</th>
        <th>id_driver</th>
        <th>countofhoursatmonth</th>
        <th>driver_status</th>
        <th>city</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listDrivers}" var="driver">
        <tr>
            <td>${driver.drivername}</td>
            <td>${driver.surname}</td>
            <td>${driver.idDriver}</td>
            <td>${driver.countofhoursatmonth}</td>
            <td>${driver.driverStatus}</td>
            <td>${driver.city}</td>
            <td><a href="<c:url value='/edit/${driver.idDriver}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${driver.idDriver}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<h1>Add a Truck</h1>

<c:url var="addAction" value="/truckers/add"/>

<form:form action="${addAction}" commandName="driver">
    <table>
        <tr>
            <td>
                <form:label path="idDriver">
                    <spring:message text="idDriver"/>
                </form:label>
            </td>
            <td>
                <form:input path="idDriver"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="drivername">
                    <spring:message text="drivername"/>
                </form:label>
            </td>
            <td>
                <form:input path="drivername"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surname">
                    <spring:message text="surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countofhoursatmonth">
                    <spring:message text="countofhoursatmonth"/>
                </form:label>
            </td>
            <td>
                <form:input path="countofhoursatmonth"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="driverStatus">
                    <spring:message text="driverStatus"/>
                </form:label>
            </td>
            <td>
                <form:input path="driverStatus"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="city">
                    <spring:message text="city"/>
                </form:label>
            </td>
            <td>
                <form:input path="city"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty driver.surname}">
                    <input type="submit"
                           value="<spring:message text="Edit Driver"/>"/>
                </c:if>
                <c:if test="${empty driver.surname}">
                    <input type="submit"
                           value="<spring:message text="Add Driver"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

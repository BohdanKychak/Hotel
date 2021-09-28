<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>

<form name="room">

    <jsp:include page="menu1.jsp"></jsp:include>

     <TABLE BORDER="1">
        <TR>
            <TH>id</TH>
            <TH>roomClass</TH>
            <TH>capacity</TH>
            <TH>price</TH>
            <TH>status</TH>
        </TR>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty list}">
    <Е>
        <c:forEach items="${list}" var="record">
            <tr>
                <td>${record.id}</td>
                <td>${record.roomClass}</td>
                <td>${record.capacity}</td>
                <td>${record.price}</td>
                <td>${record.status}</td>
            </tr>
        </c:forEach>
     </TABLE>
</c:if>

 </form>
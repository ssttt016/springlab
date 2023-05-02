<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>Cust All Page</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>PWD</th>
                        <th>NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="c" items="${clist}">
                        <tr>
                            <td><a href="/cust/get?id=${c.id}">${c.id}</a></td>
                            <td>${c.pwd}</td>
                            <td>${c.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>  <%--        row content end--%>
    </div>
</div>
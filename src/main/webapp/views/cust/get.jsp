<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
    <h1>Detail Page</h1>
    <form id="update_form" class="form-horizontal well">
        <div class="form-group">
            <label for="user">ID:</label>
            <input type="text" class="form-control" id="user" name="id" value="${gcust.id}" readonly>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" name="pwd" value="${gcust.pwd}">
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${gcust.name}">
        </div>
        <div class="form-group">
            <button id="update_btn" type="button" class="btn btn-warning">UPDATE</button>
        </div>
        <div class="form-group">
            <button id="remove_btn" type="button" class="btn btn-warning">REMOVE</button>
        </div>
    </form>
</div>

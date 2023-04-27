<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">
    <h1>Register Page</h1>
    <form id="register_form" class="form-horizontal well">
        <div class="form-group">
            <label for="user">ID:</label>
            <input type="text" class="form-control" id="user" placeholder="Enter ID" name="id">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
        </div>
        <div class="form-group">
            <button id="register_btn" type="button" class="btn btn-warning">Submit</button>
        </div>
    </form>
</div>

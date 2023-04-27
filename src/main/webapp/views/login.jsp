<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">
    <h1>Login Page</h1><br/>
    <form id="login_form" class="form-horizontal well">
        <div class="form-group">
            <label for="id">ID</label><br/>
            <input type="text" name="id" id="id" placeholder="ID를 입력하세요" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="pwd">PASSWORD</label><br/>
            <input type="password" name="pwd" id="pwd" placeholder="PWD를 입력하세요" class="form-control"/>
        </div>
        <div class="form-group">
            <button id="login_btn" class="btn btn-danger">로그인</button>
        </div>
    </form>
</div>

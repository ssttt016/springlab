<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="col-sm-6 text-left">
            <h1>CFR1</h1><br/>
            <h2>${result}</h2>
            <form action="/cfr1impl" method="post" enctype="multipart/form-data" id="cfr1_form" class="form-horizontal well">
                <div class="form-group">
                    <label for="img">IMG</label><br/>
                    <div class="col-sm-10">
                        <input type="file" name="img" id="img" placeholder="Input Image" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <button id="cfr1_btn" type="submit" class="btn btn-danger">Send</button>
                </div>
            </form>
        </div>
    </div>
</div>

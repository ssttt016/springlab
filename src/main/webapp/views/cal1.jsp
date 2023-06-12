<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .fc-day-sun a {
        color: red;
    }

    .fc-day-sat a {
        color: blue;
    }
</style>

<script>

    $(function(){

        var calendar = new FullCalendar.Calendar($('#calendar')[0], {
            height: '600px', // calendar 높이 설정
            headerToolbar: {
                start: 'dayGridMonth,timeGridWeek,timeGridDay today',
                center: 'title',
                end: 'prev,next'
            },
            footerToolbar: {
                start: 'prevYear',
                center: '',
                end: 'nextYear'
            }

        });

        calendar.render();

    });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-8  text-left ">
                    <div id='calendar-container' style="margin-top:20px">
                        <div id='calendar'></div>
                    </div>
            </div>
        </div>
    </div>
</div>
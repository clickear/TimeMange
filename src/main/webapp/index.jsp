<%@ page import="java.util.Date" %>
<%@page contentType="text/html; utf-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href='./scripts/libs/calendra/fullcalendar.css' rel='stylesheet' />
    <link href='./scripts/libs/calendra/fullcalendar.print.css' rel='stylesheet' media='print' />
    <script src='./scripts/libs/moment.min.js'></script>
    <script src='./scripts/libs/jquery.min.js'></script>
    <script src='./scripts/libs/calendra/fullcalendar.js'></script>
    <script>
        $(document).ready(function() {
            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: ''
                },
                contentHeight:'auto',
                aspectRatio:4,
                editable: true,
                monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
                dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
                today: ["今天"],
                firstDay: 0,
                buttonText: {
                    today: '本月',
                    month: '月',
                    week: '周',
                    day: '日',
                    prev: '上一月',
                    next: '下一月'
                },
                businessHours: true, // display business hours
                editable: true,
                selectable: true,
                selectHelper: true,
                select: function(start, end) {
                    var title = prompt('Event Title:');
                    var eventData;
                    if (title) {
                        eventData = {
                            title: title,
                            start: start,
                            end: end
                        };
                        $.post("/events",{eventData:JSON.stringify(eventData)},function(result){
                            debugger;
                            eventData.id = result;
                            $('#calendar').fullCalendar('renderEvent', eventData); // stick? = true
                            $('#calendar').fullCalendar( 'rerenderEvents');
                        });

                    }
                    $('#calendar').fullCalendar('unselect');
                },
                eventClick: function(event, element) {

                    event.title = "CLICKED!";

                    $('#calendar').fullCalendar('updateEvent', event);

                //    $('#calendar').fullCalendar( 'removeEvents',event.id);

                },
                eventDataTransform:function (event) {
                    if((event && event.eventsid)){
                        event.id = event.eventsid;
                    }

                    return event;
                },
                dayRender:function(eventData, cell){

                },
                viewRender:function(view, element){

                },
                events: {
                    url: '/events',
                    cache: true
                },
                eventDrop: function(event, delta, revertFunc) {
                    //post 数据
                    debugger;
                    $.post("/events",{eventData:JSON.stringify(event)},function(result){
                        alert('成功');
                    });

                }
            });
        });
    </script>
    <style>
        body {
            margin: 40px 10px;
            padding: 0;
            font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
            font-size: 14px;
        }
        #calendar {
            max-width: 900px;
            margin: 0 auto;
            width: 400px;
        }
        .fc-day.fc-widget-content.sign{
            background:#fff url(http://i2.piimg.com/508767/a9576b09fc014d6e.png) no-repeat center;
            background-position-y: 2px;
        }

    </style>
</head>
<body>
<div id='calendar'></div>
</body>
</html>

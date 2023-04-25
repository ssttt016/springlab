<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    let chart03 = {
        init:function(){
            this.getdata1();
            this.getdata2();
            this.getdata3();
        },
        getdata1:function(){
            $.ajax({
                url:'/chart0301',
                success:function(result){
                    chart03.display1(result);
                }
            });
        },
        getdata2:function(){
            $.ajax({
                url:'/chart0302',
                success:function(result){
                    chart03.display2(result);
                }
            });
        },
        getdata3:function(){
            $.ajax({
                url:'/chart0303',
                success:function(result){
                    chart03.display3(result);
                }
            });
        },
        display1:function(result){
            Highcharts.chart('c1', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45
                    }
                },
                title: {
                    text: 'Beijing 2022 gold medals by country',
                    align: 'left'
                },
                subtitle: {
                    text: '3D donut in Highcharts',
                    align: 'left'
                },
                plotOptions: {
                    pie: {
                        innerSize: 100,
                        depth: 45
                    }
                },
                series: [{
                    name: 'Medals',
                    data: result
                }]
            });

        },
        display2:function(result){
            Highcharts.chart('c2', {
                title: {
                    text: 'Scatter plot with regression line'
                },
                xAxis: {
                    min: -0.5,
                    max: 5.5
                },
                yAxis: {
                    min: 0
                },
                series: [{
                    type: 'line',
                    name: 'Regression Line',
                    data: result.line,
                    marker: {
                        enabled: false
                    },
                    states: {
                        hover: {
                            lineWidth: 0
                        }
                    },
                    enableMouseTracking: false
                }, {
                    type: 'scatter',
                    name: 'Observations',
                    data: result.dot,
                    marker: {
                        radius: 4
                    }
                }]
            });
        },
        display3:function(result){
            var colors = Highcharts.getOptions().colors;

            Highcharts.chart('c3', {
                chart: {
                    type: 'spline'
                },

                legend: {
                    symbolWidth: 40
                },

                title: {
                    text: 'Most common desktop screen readers',
                    align: 'left'
                },

                subtitle: {
                    text: 'Source: WebAIM. Click on points to visit official screen reader website',
                    align: 'left'
                },

                yAxis: {
                    title: {
                        text: 'Percentage usage'
                    },
                    accessibility: {
                        description: 'Percentage usage'
                    }
                },

                xAxis: {
                    title: {
                        text: 'Time'
                    },
                    accessibility: {
                        description: 'Time from December 2010 to September 2019'
                    },
                    categories: ['December 2010', 'May 2012', 'January 2014', 'July 2015', 'October 2017', 'September 2019']
                },

                tooltip: {
                    valueSuffix: '%',
                    stickOnContact: true
                },

                plotOptions: {
                    series: {
                        point: {
                            events: {
                                click: function () {
                                    window.location.href = this.series.options.website;
                                }
                            }
                        },
                        cursor: 'pointer'
                    }
                },

                series: [
                    {
                        name: 'NVDA',
                        data: result.data1,
                        website: 'https://www.nvaccess.org',
                        color: colors[2],
                        accessibility: {
                            description: 'This is the most used screen reader in 2019.'
                        }
                    }, {
                        name: 'JAWS',
                        data: result.data2,
                        website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
                        dashStyle: 'ShortDashDot',
                        color: colors[0]
                    }, {
                        name: 'VoiceOver',
                        data: result.data3,
                        website: 'http://www.apple.com/accessibility/osx/voiceover',
                        dashStyle: 'ShortDot',
                        color: colors[1]
                    }, {
                        name: 'Narrator',
                        data: result.data4,
                        website: 'https://support.microsoft.com/en-us/help/22798/windows-10-complete-guide-to-narrator',
                        dashStyle: 'Dash',
                        color: colors[9]
                    }, {
                        name: 'ZoomText/Fusion',
                        data: result.data5,
                        website: 'http://www.zoomtext.com/products/zoomtext-magnifierreader',
                        dashStyle: 'ShortDot',
                        color: colors[5]
                    }, {
                        name: 'Other',
                        data: result.data6,
                        website: 'http://www.disabled-world.com/assistivedevices/computer/screen-readers.php',
                        dashStyle: 'ShortDash',
                        color: colors[3]
                    }
                ],

                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 550
                        },
                        chartOptions: {
                            chart: {
                                spacingLeft: 3,
                                spacingRight: 3
                            },
                            legend: {
                                itemWidth: 150
                            },
                            xAxis: {
                                categories: ['Dec. 2010', 'May 2012', 'Jan. 2014', 'July 2015', 'Oct. 2017', 'Sep. 2019'],
                                title: ''
                            },
                            yAxis: {
                                visible: false
                            }
                        }
                    }]
                }
            });  // display3 end
        }
    };

    $(function(){
        chart03.init();
    })
</script>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>CHART03</h3>
        <div class="row">
            <div class="col-sm-4" id="c1"></div>
            <div class="col-sm-4" id="c2"></div>
            <div class="col-sm-4" id="c3"></div>
        </div>
    </div>
</div>
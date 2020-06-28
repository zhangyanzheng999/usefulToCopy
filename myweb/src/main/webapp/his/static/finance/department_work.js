$(function(){
    showBar();
    showPie();
    showLine();
});

var department = ['耳鼻喉科', '内科', '全科门诊', '妇产科', '心血管内科']
var work_name = ['诊疗','检验','超声','放射','MRI','CT','西药','麻醉']
var date = ['2019/10', '2019/11', '2019/12', '2020/1', '2020/2', '2020/3', '2020/4']
function showBar(){
    // click trend 条形图
    var myChart_bar = echarts.init(document.getElementById('Bar'));

    var option_bar = {
        title:{
            text:'科室工作量Top5',
            textStyle:{
                fontSize:16
            },
            y:6
        },
        tooltip: {},
        toolbox: {
            itemSize:16,
            show: true,
            itemSize:13,
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true},
            }
        },
        xAxis: {
            name:'科室',
            type: 'category',
            data: department,
            axisLabel: {
                interval:0,
                rotate:20
            }
        },
        yAxis: {
            name:'工作量',
            type: 'value'
        },
        series: [{
            data: [42, 32, 24, 3, 2],
            type: 'bar'
        }]
    };
    myChart_bar.setOption(option_bar);
}

function showPie(){
    var myChart_Pie = echarts.init(document.getElementById('Pie'));

    var option_Pie = {
        title:{
            text:'工作量占比',
            textStyle:{
                fontSize:16
            },
            x:'center',
            y:'top'
        },
        tooltip: {},
        toolbox: {
            itemSize:16,
            show: true,
            itemSize:13,
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true},
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: work_name
        },
        series: [
            {
                name: '各项工作占比',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 30, name: '诊疗'},
                    {value: 36, name: '检验'},
                    {value: 24, name: '超声'},
                    {value: 42, name: '放射'},
                    {value: 12, name: 'MRI'},
                    {value: 18, name: 'CT'},
                    {value: 6, name: '西药'},
                    {value: 12, name: '麻醉'}
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart_Pie.setOption(option_Pie);
}

function showLine() {
    var myChart_Line = echarts.init(document.getElementById('Line'));
    var option_Line = {
        title:{
            text:'工作量变化趋势',
            textStyle:{
                fontSize:16
            },
            y:6
        },
        tooltip: {},
        toolbox: {
            itemSize:16,
            show: true,
            itemSize:13,
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true},
            }
        },
        xAxis: {
            name:'时间',
            type: 'category',
            data: date,
            axisLabel: {
                interval:1,
            }
        },
        yAxis: {
            name:'工作量',
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        }]
    };
    myChart_Line.setOption(option_Line);
}

function searchByTime() {
    var x = document.getElementById('department-table').insertRow(5, 6);
    var y1 = x.insertCell(0);
    var y2 = x.insertCell(1);
    var y3 = x.insertCell(2);
    var y4 = x.insertCell(3);
    var y5 = x.insertCell(4);
    var y6 = x.insertCell(5);
    var y7 = x.insertCell(6);
    var y8 = x.insertCell(7);
    var y9 = x.insertCell(8);
    var y10 = x.insertCell(9);
    var y11 = x.insertCell(10);
    var y12 = x.insertCell(11);
    y1.innerHTML = "K05"
    y2.innerHTML = "耳鼻喉科"
    y3.innerHTML = "42"
    y4.innerHTML = "5"
    y5.innerHTML = "6"
    y6.innerHTML = "4"
    y7.innerHTML = "7"
    y8.innerHTML = "2"
    y9.innerHTML = "3"
    y10.innerHTML = "1"
    y11.innerHTML = "0"
    y12.innerHTML = "2"
}










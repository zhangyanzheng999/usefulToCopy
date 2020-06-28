$(function(){
    showLine2()
});

var date = ['2019/10', '2019/11', '2019/12', '2020/1', '2020/2', '2020/3', '2020/4']
function showLine2() {
    var myChart_Line2 = echarts.init(document.getElementById('Line2'));
    var option_Line2 = {
        title:{
            text:'本科室工作量变化趋势',
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
            boundaryGap: false,
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
            areaStyle: {}
        }]
    };
    myChart_Line2.setOption(option_Line2);
}

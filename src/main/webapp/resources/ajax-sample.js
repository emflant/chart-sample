// Load the Visualization API and the piechart package.
google.load('visualization', '1', {'packages':['corechart', 'gauge']});
 
// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart);

function drawChart() {
	var jsonData = $.ajax({
		url: "sampleData.json",	//"sampleData.json",
		dataType:"json",
		//contentType: "application/x-www-form-urlencoded; charset=MS949",
		async: false
	}).responseText;
	
	
	
	// Create our data table out of JSON data loaded from server.
	var data = new google.visualization.DataTable(jsonData);

	// Instantiate and draw our chart, passing in some options.
	var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
	pieChart.draw(data, {width: 500, height: 400});
	
	var areaChart = new google.visualization.AreaChart(document.getElementById('area_chart_div'));
	areaChart.draw(data, {width: 600, height: 300});
	
	var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
	barChart.draw(data, {width: 600, height: 240});
	
	
	var gaugeChart = new google.visualization.Gauge(document.getElementById('gauge_chart_div'));
    var options = {
		width: 800, height: 120,
		redFrom: 90, redTo: 100,
		yellowFrom:75, yellowTo: 90,
		minorTicks: 5
    };
    
    //gaugeChart.draw(data, options);
    //console.log(jsonData);
    //document.getElementById("chart_div").innerHTML = jsonData;
	
}


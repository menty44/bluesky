<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<style type="text/css" title="currentStyle">
@import "../resources/css/demo_table.css";
</style>

<table cellpadding="0" cellspacing="0" border="0"
id="tableId">
<thead>
<tr>
<th width="10%">First Name</th>
<th width="10%">Last Name</th>
<th width="10%">Address 1</th>
<th width="10%">Address 2</th>
</tr>
</thead>
</table>

<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
var oTable = $('#tableId').dataTable( {
"processing": true,
"ajax": {
"url": "/FeedSummaryUpdate/FeedServlet",
"dataSrc": "demo",
"type": "GET"
}
} );
} );
</script>



<script type="text/javascript"
charset="utf-8" src="/DataTables/js/jquery.js"></script>
<script type="text/javascript"
charset="utf-8" src="/DataTables/js/jquery.dataTables.js"></script>
</body>
</html>
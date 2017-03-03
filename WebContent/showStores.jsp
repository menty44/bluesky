<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#deleteEmployee").hide();
     $("#updateEmployee").hide();
    
    $("#update").click(function(){
        $("#updateEmployee").show();
        $("#deleteEmployee").hide();
    });
    $("#delete").click(function(){
        $("#deleteEmployee").show();
         $("#updateEmployee").hide();
    });
});
</script>
    </head>
    <body>
All Employees: <br> 
        <c:forEach var="emp" items="${storeList}">
            Employee ID: ${emp.id} <br>
            Employee Name: ${emp.ename} <br>
            Employee Number: ${emp.enumber}<br>
            -------------------------------------<br>
        </c:forEach>
        <form action="EmployeeController" method="POST">
            Update: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('ename').disabled=this.checked;document.getElementById('enumberupdate').disabled=this.checked;"><br><br>
            <select name="id">
                <c:forEach items="${employeeList}" var="employee">
                <option value="${employee.id}">${employee.id}</option>
                 </c:forEach>
            </select>
            
            <br>
            Update Name: <input id="ename" type="text" name="ename"><br>
            Update Number: <input id="enumberupdate" type="text" name="enumberupdate"> <br><br>
            <button type="submit" id="updateEmployee" name="updateEmployee"> Update</button> <br> <br>
            <button type="submit" id="deleteEmployee" name="deleteEmployee"> Delete </button>
            
            
               
       
        </form>
    </body>
</html>

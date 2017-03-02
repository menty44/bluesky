<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.LoginService"%>
<%@page import="com.javawebtutor.service.SearchService"%>
<%@page import="java.util.Date"%>
<%@page import="com.javawebtutor.model.User"%>


<!DOCTYPE html PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN” “http://www.w3.org/TR/html4/loose.dtd”&gt;
<html>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″>
<title>view/search</title>
</head>
<body>
<SCRIPT>
function addpage(){
document.frm.action=”adduser.jsp”;
document.frm.submit();
}
function Editpage(){
document.frm.action=”edituser.jsp”;
document.frm.submit();
}
function search(){
document.frm.action=”search.jsp”;
document.frm.submit();
}
</SCRIPT>
<form name=frm method=”post” >
<table border=”1″>
<tr><td>Type name</td>
<td><INPUT type=”text” name=search_username value=”” size=”24″></td>
<td> <BUTTON type=”submit” value=search name=cmdsearch onclick=”search()”>Search</BUTTON></td>
</tr>
</table>
<table border=”1″>
<TBODY>
<TR align=”left”>
<TD nowrap><FONT size=3 ><B>User-Name</B></FONT></TD>
<TD nowrap><FONT size=3 ><B>Age</B></FONT></TD>
<TD nowrap><FONT size=3 ><B>CellNO</B></FONT></TD>
<TD nowrap><FONT size=3 ><B>Address</B></FONT></TD>
</tr>
<%!
private String checkNull(String value) {
if(value=="null" || value==null)
{return "";}
return value;
}
%>
<%
String search_name=checkNull(request.getParameter("search_username"));
System.out.println("search_name length@@"+search_name.length());
if(search_name.length()==0)
{
SearchService ss = new SearchService();
List<User> list = ss.getListOfUsers();
for (User u : list) {
%>
<TR bgcolor=”#d6d6d6”>
<TD nowrap><%=u.getName()%></TD>
<TD nowrap><%=u.getEmail()%></TD>

</TR>

<%}}else{
SearchService udet1 = new SearchService();
System.out.println("search_name**:"+search_name);
List<User> list1 = udet1.getListOfUsers(search_name);
for (User u1 : list1) {
%>
<TR bgcolor=”#d6d6d6″>
<TD nowrap><%=u1.getName()%></TD>
<TD nowrap><%=u1.getEmail()%></TD>

</TR>
<%}}%>
<TR><td><BUTTON type=”submit” value=save name=cmdadd onclick=”addpage()”>Add Page</BUTTON></td>
<td><BUTTON type=”submit” value=edit name=cmdedit onclick=”Editpage()”>Edit Page</BUTTON></td></TR>
</TBODY>
</table>
</form>
</body>
</html>


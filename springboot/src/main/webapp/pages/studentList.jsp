<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!--避免中文乱码 -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->

<%  if ((String)request.getAttribute("rs") == "Success") { %>
<script>
    alert("新增成功！");
</script>
<%}%>

<html>
<head>
    <title>学生列表</title>
</head>

<body>
    <h2>学生列表</h2>

    <table>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td><label>学生ID：${student.id}</label></td>
                <td><label>学生姓名：${student.name}</label></td>
                <td><label>学生年龄：${student.age}</label></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
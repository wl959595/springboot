<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!--避免中文乱码 -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->
<jsp:useBean id="command" class="com.caesar.entity.Student" scope="request" ></jsp:useBean>
<html>
<head>
    <title>添加学生</title>
</head>

<body>
  <form:form method="post" action="add">
      <table>
          <tr>
              <td><form:label path="name">姓名：</form:label></td>
              <td><form:input path="name"/></td>
          </tr>
          <tr>
              <td><form:label path="age">年龄：</form:label></td>
              <td><form:input path="age"/></td>
          </tr>
          <tr>
              <td colspan="2"><input value="提交" type="submit" /></td>
          </tr>
      </table>
  </form:form>
</body>

</html>
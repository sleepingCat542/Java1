<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 5/3/19
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="my" uri="//WEB-INF/pdaLabeledTextField.tld" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <c:set var="name" value="world"/>
    <h1>Hello, <c:out value="${name}"/>!</h1>
    <c:if test="${1 < 2}">
        <c:out value="1 < 2"/>
    </c:if>
    <c:if test="${1 > 2}">
        <c:out value="1 > 2"/>
    </c:if>
    <c:set var="value" value="5"/>
    <c:choose>
        <c:when test="${value == 1}">
            <p>value = 1</p>
        </c:when>
        <c:when test="${value == 2}">
            <p>value = 2</p>
        </c:when>
        <c:when test="${value == 3}">
            <p>value = 3</p>
        </c:when>
        <c:otherwise>
            <p>Value is undefined</p>
        </c:otherwise>
    </c:choose>
    <p>Url test</p>
    <c:url value="/url"/>

    <my:pdaLabeledTextField value="10" label="Custom label" name="name"/>
    <my:pdasubmit/>
    <c:set var="str" value="<%=new java.util.Date()%>" />
    <table border="2" width="100%">
        <tr>
            <td width="100%" colspan="2" bgcolor="#FF7F50">
                <p align="center">
                    <b>
                        <font color="#000000" size="6">Formatting:
                            <fmt:formatDate value="${str}" type="both"
                                            timeStyle="long" dateStyle="long" />
                        </font>
                    </b>
                </p>
            </td>
        </tr>

        <c:forEach var="zone"
                   items="<%=java.util.TimeZone.getAvailableIDs()%>">
            <tr>
                <td width="50%"  bgcolor="#C0C0C0">
                    <c:out value="${zone}" />
                </td>
                <td width="50%" bgcolor="#FFEBCD">
                    <fmt:timeZone value="${zone}">
                        <fmt:formatDate value="${str}" timeZone="${zn}"
                                        type="both"/>
                    </fmt:timeZone>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

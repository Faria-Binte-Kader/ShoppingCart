<%--
  Created by IntelliJ IDEA.
  User: Nisa
  Date: 1/13/2022
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.shoppingcart.ItemBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:useBean id="Chair" class="com.example.shoppingcart.ItemBean"
             scope="application" type="com.example.shoppingcart.ItemBean"/>
<jsp:setProperty name="Chair" property="quantity" value="15"/>
<jsp:setProperty name="Chair" property="price" value="1500"/>
<jsp:setProperty name="Chair" property="name" value="Chair"/>

<jsp:useBean id="Table" class="com.example.shoppingcart.ItemBean"
             scope="application" type="com.example.shoppingcart.ItemBean"/>
<jsp:setProperty name="Table" property="quantity" value="10"/>
<jsp:setProperty name="Table" property="price" value="15000"/>
<jsp:setProperty name="Table" property="name" value="Table"/>

<jsp:useBean id="Bed" class="com.example.shoppingcart.ItemBean"
             scope="application" type="com.example.shoppingcart.ItemBean"/>
<jsp:setProperty name="Bed" property="quantity" value="20"/>
<jsp:setProperty name="Bed" property="price" value="5500"/>
<jsp:setProperty name="Bed" property="name" value="Bed"/>

<jsp:useBean id="Mattress" class="com.example.shoppingcart.ItemBean"
             scope="application" type="com.example.shoppingcart.ItemBean"/>
<jsp:setProperty name="Mattress" property="quantity" value="22"/>
<jsp:setProperty name="Mattress" property="price" value="1800"/>
<jsp:setProperty name="Mattress" property="name" value="Mattress"/>

<h1>Home</h1>
<br/>
<%
  int chairq=0, tableq=0, bedq=0, matq=0;
    List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("ShopItems");
    for( ItemBean items : myItems) {
        if(items.getName().equals("Chair"))
        {chairq = items.getQuantity();}
        if(items.getName().equals("Table"))
        {tableq = items.getQuantity();}
        if(items.getName().equals("Bed"))
        {bedq = items.getQuantity();}
        if(items.getName().equals("Mattress"))
        {matq = items.getQuantity();}

    }

%>
<h3>Available Items:</h3>
<form method="post" action="gotocart">
    <input type="checkbox" name="item" value="Chair"/>Chair
    <br>
    Available item:<%=chairq%> , Price: <jsp:getProperty name="Chair" property="price"/>
    <br>
    <input type="checkbox" name="item" value="Table"/>Table
    <br>
    Available item: <%=tableq%> , Price: <jsp:getProperty name="Table" property="price"/>
    <br>
    <input type="checkbox" name="item" value="Bed"/>Bed
    <br>
    Available item: <%=bedq%> , Price: <jsp:getProperty name="Bed" property="price"/>
    <br>
    <input type="checkbox" name="item" value="Mattress"/>Mattress
    <br>
    Available item: <%=matq%> , Price: <jsp:getProperty name="Mattress" property="price"/>
    <br>
    <input type="submit" value="Add to Cart">
</form>
<form method="post" action="mycart"><input type="submit" value="My Cart"></form>
<br/>
<a href="logout.html">Log Out</a>
</body>
</html>

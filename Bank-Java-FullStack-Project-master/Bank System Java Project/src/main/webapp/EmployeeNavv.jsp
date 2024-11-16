<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ASBank.Customer.Home" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.navlinks{
  color: black;
  padding: 10px;
  font-weight: 500;
  font-family: "poppins",sans-serif;
}
.navButtons{
  margin-left: 10px;
  margin-right: 30px;
}
.navMain{
  display: flex;
  margin-right: 40px;
}
.navMain li{
  list-style: none;
  font-size: 18px;
  margin-top: 15px;
}
.navMain li a{
  text-decoration: none;
}
.Subheader{
  padding-left: 694px;
  background-color: darkblue;
}
.nav-pills{
margin-left:-90px;
}
.nav-pills .nav-item a{
  color: white;
} 

.home:hover,.transfer:hover,.deposite:hover,
.balanceChek:hover,.passbook:hover,.settings:hover{
background-color:blue;
border:none;
outline:none;
border-radius:5px;
}

</style>
</head>
<body>
	<div class="containerr">
      <nav class="Subheader">
        <ul class="nav nav-pills">
          <li class="nav-item"><a href="EmployeeHome.jsp" class="nav-link home" aria-current="page">Home</a></li>
          <li class="nav-item"><a href="EmployeeHome.jsp?option=ETransactions" class="nav-link passbook">Transactions</a></li>
          <li class="nav-item"><a href="EmployeeHome.jsp?option=EChangeData" class="nav-link passbook">UpdateData</a></li>
        </ul>
      </nav>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Acceuil</title>
</head>
<body style="diplay : flex;justify-content: center;align-content: center;">
<div class="container m-2">

  <div class="container" >
  <div class="row">
    <div class="col-11">
      <h1 class="text-success">Liste des Départements</h1>
   </div>
   <div class="col-1 mt-2">
 <sec:authorize access="isAuthenticated()">
<a class="btn btn-danger" href="<c:url value="/logout" />">Logout</a> 
</sec:authorize>
 </div>
  </div>
 </div>
   <br/>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Titre</th>
      <th scope="col">allez vers</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach var="d" items="${listdep}">
          <tr>
      <th scope="row">1</th>
      <td>${d.titre}</td>
      <td><a href="listMat?iddep=${d.id }">liste des materiels</a></td>
    </tr>
     </c:forEach>
  
  </tbody>
  </table>
  </div>
  <a href="/tpSpring/register">rr</a>
</body>
</html>
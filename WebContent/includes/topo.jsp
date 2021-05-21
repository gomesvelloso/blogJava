<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
    
 
<% 
List<String> menu;

if(request.getAttribute("menu") != null){
	menu = (List<String>)request.getAttribute("menu"); 	
}else{
	menu = new ArrayList<String>();
	for(int i = 0; i<3; i++){
		String m = "";
		if(i == 0){
			m = "active";
		}
		menu.add(i,m);
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Blogo Java JSP</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<header>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="./">BLOG JAVA JSP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="<%=menu.get(0) %>" style="display:none"><a href="./">HOME</a></li>
        
        <li class="dropdown <%=menu.get(1)%>">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
          role="button" aria-haspopup="true" aria-expanded="false">POSTAGENS <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Control?cmd=posts">Postagens</a></li>
            <li><a href="Control?cmd=listPosts">Listar</a></li>
            <li><a href="Control?cmd=newPost">Novo Postagem</a></li>
            
          </ul>
        </li>
        <li class="dropdown <%=menu.get(2)%>">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
          role="button" aria-haspopup="true" aria-expanded="false">CATEGORIAS <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Control?cmd=categorias">Categorias</a></li>
          </ul>
        </li>
      </ul>
      <!--
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>-->
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</header>
<body>
<div class="container" id="container">

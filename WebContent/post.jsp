<%@page import="java.time.Instant"%>
<%@page import="utilities.FormataData"%>
<%@page import="entities.Post"%>
<%@page import="entities.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@include file="includes/topo.jsp" %>

<div class="row" id="descricaoPagina">
	<div class="col-md-12">
		<h3>POSTAGEM #<%=request.getAttribute("id") %></h3>
		<hr/>	
	</div>
</div>


<%
if(request.getAttribute("post") != null){
	
	Post p = (Post)request.getAttribute("post");

	if(p.getPostId() > 0){
		
			FormataData fd = new FormataData();
			String data = fd.dataTela(p.getPostData());			
%>
			<div class="row" id="divPostagem">
				<div class="col-md-12" id="tituloPostagem">
					<h4><%=p.getPostTitulo() %> </h4>
				</div>
				<div class="col-md-12" id="conteudoPostagem">
					<%=p.getPostTexto() %>
				</div>
				<div class="col-md-12" id="dataPostagem">
					Publicado em <%=data %> | Categoria: <%=p.getCategoria().getCategoriaNome() %>
				</div>
				
			</div>

<% 		
	}else{
%>
		Postagem não encontrada!
<% }
}
%>
<%@include file="includes/rodape.jsp" %>
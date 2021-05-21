<%@page import="java.time.Instant"%>
<%@page import="utilities.FormataData"%>
<%@page import="entities.Post"%>
<%@page import="entities.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@include file="includes/topo.jsp" %>

<div class="row" id="descricaoPagina">
	<div class="col-md-12">
		<h3>POSTAGENS</h3>
		<hr/>	
	</div>
</div>

<%
if(request.getAttribute("lista") != null){
	
	List<Post> lista = (List<Post>)request.getAttribute("lista");
	
	if(lista.size() > 0){
		for(Post s : lista){
			FormataData fd = new FormataData();
			String data = fd.dataTela(s.getPostData());			
%>
			<div class="row" id="divPostagem">
				<div class="col-md-12" id="tituloPostagem">
					<h4><%=s.getPostTitulo() %> </h4>
				</div>
				<div class="col-md-12" id="conteudoPostagem">
					<%=s.getPostTexto() %>
				</div>
				<div class="col-md-7" id="dataPostagem">
					Publicado em: <%=data %> | Categoria: <%=s.getCategoria().getCategoriaNome() %>
				</div>
			</div>

<% 		
		}
	}else{%>
		Nenhuma postagem criada até o momento.
<% }
}
%>
<%@include file="includes/rodape.jsp" %>
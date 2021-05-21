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

<table class="table table striped table-bordered">
	<thead>
		<th></th>
		<th>Título</th>
		<th>Categoria</th>
		<th>Data</th>
	</thead>
	<tbody id="tabela">
<%
if(request.getAttribute("lista") != null){
	
	List<Post> lista = (List<Post>)request.getAttribute("lista");
	
	if(lista.size() > 0){
		for(Post s : lista){
			FormataData fd = new FormataData();
			String data = fd.dataTela(s.getPostData());			
%>
			<tr id="tr_<%=s.getPostId()%>">
				<td class="tdButtons" style="width: 15%">
					<a href="Control?cmd=editarPost&postId=<%=s.getPostId()%>">
					<button class="btn btn-primary btn-sm">Editar</button>
					</a>
					<button 
						class="btn btn-danger btn-sm" 
						style="margin-left:5px;" 
						onclick="confirmExclusao(<%=s.getPostId()%>)">Excluir</button>
				</td>
				<td>
					<a class="link" href="Control?cmd=post&post=<%=s.getPostId()%>"><%=s.getPostTitulo() %></a>
				</td>
				<td class="tdData" style="width: 15%"><%=s.getCategoria().getCategoriaNome() %></td>
				<td class="tdData" style="width: 8%"><%=data %></td>
			</tr>

<% 		
		}
	}else{%>
		<tr><td colspan="4">Nenhuma postagem criada até o momento.</td></tr>
<% }
}
%>
</tbody>
</table>
<script src="js/posts.js"></script>
<%@include file="includes/rodape.jsp" %>
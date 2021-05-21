<%@page import="java.time.Instant"%>
<%@page import="utilities.FormataData"%>
<%@page import="entities.Post"%>
<%@page import="entities.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@include file="includes/topo.jsp" %>

<div class="row" id="descricaoPagina">
	<div class="col-md-12">
		<h3>Categorias </h3>
		<hr/>	
	</div>
</div>

<table class="table table striped table-bordered">
	<thead>
		<th></th>
		<th>Categoria</th>
		
	</thead>
	<tbody id="tabela">
<%
if(request.getAttribute("categorias") != null){
	
	List<Categoria> lista = (List<Categoria>)request.getAttribute("categorias");
	
	if(lista.size() > 0){
		for(Categoria s : lista){
%>
			<tr id="tr_<%=s.getCategoriaId() %>">
				<td class="tdButtons" style="width: 20%">
					<a title="Listar Postagens" style="margin-left:5px;" target="_blank"  href="Control?cmd=listarPorCategoria&categoria=<%=s.getCategoriaNome()%>&t=<%=s.getCategoriaId()%>">
						<buttton class="btn btn-primary">Ver Postagens</buttton>
					</a>
				</td>
				<td><%=s.getCategoriaNome() %></td>
			</tr>
<% 		
		}
	}else{%>
		<tr><td colspan="2">Nenhuma postagem criada até o momento.</td></tr>
<% }
}
%>
</tbody>
</table>
<script src="js/posts.js"></script>
<%@include file="includes/rodape.jsp" %>
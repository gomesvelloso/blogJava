<%@page import="java.time.Instant"%>
<%@page import="utilities.FormataData"%>
<%@page import="entities.Post"%>
<%@page import="entities.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@include file="includes/topo.jsp" %>

<div class="row" id="descricaoPagina">
	<div class="col-md-12">
		<h3>EDITAR POSTAGEM</h3>
		<hr/>	
	</div>
</div>

<%
	
Post p = (Post) request.getAttribute("postagem");

Integer categoriaBd = p.getCategoria().getCategoriaId();
String postTitulo = p.getPostTitulo();
String postTexto = p.getPostTexto();
%>

<div class="row">
	<form action="Control" method="post">
		<div class="col-md-12">
			<label>Título</label>
			<input type="text" class="form-control" name="postTitulo" value="<%=postTitulo%>" required placeholder="Digite o título do seu post"/>
			<input type="hidden" name="cmd"    value="update_post" />
			<input type="hidden" name="postId" value="<%=request.getAttribute("postId")%>" />
			
		</div>
		<div class="col-md-12" style="margin-top: 5px">
			<label>Conteúdo</label>
			<textarea rows="10"  class="form-control" name="postTexto" 
			placeholder="Digite o conteúdo do seu post" required><%=postTexto%></textarea>
		</div>
		<div class="col-md-6" style="margin-top: 5px">
			<label>Categoria</label>
			<select class="form-control" name="categoriaId"  required>
				<option value="">Selecione a categoria</option>
				<%
						if(request.getAttribute("categorias") != null){
							
							List<Categoria> lista = (List<Categoria>)request.getAttribute("categorias");
							
							if(lista.size() > 0){
								for(Categoria s : lista){
									String selected = "";
									
									if(s.getCategoriaId() == categoriaBd){
										selected = "SELECTED";
									}
											
						%>
									<option value="<%=s.getCategoriaId()%>" <%=selected%> ><%=s.getCategoriaNome()%></option> 
						<% 		
								}
							}else{%>
								<option value="">Nenhuma categoria encontrada</option>
						<% }
						}
						%>
			</select>
		</div>
		<div class="col-md-6" style="margin-top: 5px">
			<button class="btn btn-primary btn-block" type="submit"  style="margin-top: 25px">Editar</button>
		</div>
	</form>
</div>
<%@include file="includes/rodape.jsp" %>
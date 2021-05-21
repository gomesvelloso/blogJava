<% if(request.getAttribute("msg") != null){ %>
	<div class="row" style="margin-top:20px">
		<div class="col-md-12">
		<p><%=request.getAttribute("msg") %></p>
		</div>
	</div>
	
<% } %>

</div>
<div class="row" id="rodape">
		<div class="col-md-12">
			<p>Criando Blog com JSP</p>
		</div>
	</div>
</body>
</html>
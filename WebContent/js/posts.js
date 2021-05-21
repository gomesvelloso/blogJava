function confirmExclusao(v){
	if(v > 0){
		let confirma = confirm("Deseja realmente excluir esta postagem?");
		
		if(confirma == true){
			
			let ajax = new XMLHttpRequest();
			ajax.onreadystatechange = function() {
				console.log(this);
		    if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("tr_"+v).remove();
		    	let r = document.getElementsByClassName("tdButtons");
		        
		        if(r.length == 0){
		        	document.getElementById("tabela").innerHTML ='<tr><td colspan="4">Nenhuma postagem criada até o momento.</td></tr>';
		        }
		      }
		    };
			ajax.open("GET","Control?cmd=deleletePost&post="+v, true);
			ajax.send();			
		}
	}
}
package entities;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer categoriaId;
	private String categoriaNome;
	
	private List<Post> posts = new ArrayList<Post>();
	
	public Categoria() {
		super();
	}
	
	
	
	public Categoria(Integer categoriaId, String categoriaNome) {
		super();
		this.categoriaId = categoriaId;
		this.categoriaNome = categoriaNome;
	}



	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoriaNome() {
		return categoriaNome;
	}
	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}



	@Override
	public String toString() {
		return "Categoria [categoriaId=" + categoriaId + ", categoriaNome=" + categoriaNome + ", posts=" + posts + "]";
	}
}

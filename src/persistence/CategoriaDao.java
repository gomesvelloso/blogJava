package persistence;

import java.util.ArrayList;
import java.util.List;

import entities.Categoria;

public class CategoriaDao extends Dao {

	//Lista todas as categorias
	public List<Categoria> findAll() throws Exception {
		
		open();
		List<Categoria> lista = new ArrayList<Categoria>();
		
		stmt = conn.prepareStatement("SELECT * FROM categoria ORDER BY categoriaNome");
		rs = stmt.executeQuery();
		while(rs.next()) {
			Categoria c = new Categoria();
			c.setCategoriaId(rs.getInt("categoriaId"));
			c.setCategoriaNome(rs.getString("categoriaNome"));
			lista.add(c);
		}
		close();
		return lista;
	}
}
package persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.Categoria;
import entities.Post;
import utilities.FormataData;

public class PostDao extends Dao{
	
	//Lista todas as postagens
	public List<Post> findAll() throws Exception{
		
		open();
		List<Post> lista = new ArrayList<Post>();
		
		stmt = conn.prepareStatement("SELECT post.*, categoria.categoriaNome FROM post, categoria WHERE post.categoriaId = categoria.categoriaId ORDER BY post.postData DESC, postId DESC");
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			Categoria c = new Categoria();
			c.setCategoriaId(rs.getInt("categoriaId"));
			c.setCategoriaNome(rs.getString("categoriaNome"));
			
			Post p = new Post();
			p.setPostId(rs.getInt("postId"));
			p.setPostTitulo(rs.getString("postTitulo"));
			p.setPostTexto(rs.getString("postTexto"));
			p.setPostData(rs.getDate("postData"));
			p.setCategoria(c);
			
			lista.add(p);
		}
		close();
		return lista;
		
	}
	
	//Lista todas as postagens por categoria
	public List<Post> findByCategoria(int categoria) throws Exception{
		
		open();
		List<Post> lista = new ArrayList<Post>();
		
		stmt = conn.prepareStatement("SELECT post.*, categoria.categoriaNome FROM post, categoria WHERE post.categoriaId = ? AND post.categoriaId = categoria.categoriaId ORDER BY post.postData DESC, poistId DESC");
		stmt.setInt(1, categoria);
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			Categoria c = new Categoria();
			c.setCategoriaId(rs.getInt("categoriaId"));
			c.setCategoriaNome(rs.getString("categoriaNome"));
			
			Post p = new Post();
			p.setPostId(rs.getInt("postId"));
			p.setPostTitulo(rs.getString("postTitulo"));
			p.setPostTexto(rs.getString("postTexto"));
			p.setPostData(rs.getDate("postData"));
			p.setCategoria(c);
			
			lista.add(p);
		}
		close();
		return lista;
		
	}
	
	//Atualiza uma postagem
	public void update(Post p) throws Exception {
		
		open();
		stmt = conn.prepareStatement("UPDATE post SET postTitulo = ?, postTexto = ?, categoriaId = ? WHERE postId = ?");
		System.out.println(p);
		stmt.setString(1, p.getPostTitulo());
		stmt.setString(2, p.getPostTexto());
		stmt.setInt(3, p.getCategoria().getCategoriaId());
		stmt.setInt(4, p.getPostId());
		stmt.execute();
		close();
	}

	//Busca uma postagem pelo id
	public Post findById(int id) throws Exception {
		open();
		Post p = new Post();
		Categoria c = new Categoria();
		
		stmt = conn.prepareStatement("SELECT post.*, categoria.categoriaNome FROM post, categoria WHERE post.categoriaId = categoria.categoriaId AND post.postId = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		while(rs.next()) {
			c.setCategoriaId(rs.getInt("categoriaId"));
			c.setCategoriaNome(rs.getString("categoriaNome"));
			
			p.setPostId(rs.getInt("postId"));
			p.setPostTitulo(rs.getString("postTitulo"));
			p.setPostTexto(rs.getString("postTexto"));
			p.setPostData(rs.getDate("postData"));
			p.setCategoria(c);
		}
		
		close();
		return p;
	}
	

	//Deleta uma postagem
	public void delete(int id) throws Exception {
		open();
		stmt = conn.prepareStatement("DELETE FROM post WHERE postId = ?");
		stmt.setInt(1, id);
		stmt.execute();
		close();
	}

	//Cria uma postagem
	public int save(Post p) throws Exception {
		
		open();
		stmt = conn.prepareStatement("INSERT INTO post (postTitulo, postTexto, postData, categoriaId) VALUES (?, ?, ?, ? )");
		stmt.setString(1, p.getPostTitulo());
		stmt.setString(2, p.getPostTexto());
		stmt.setString(3, new FormataData().dataBanco(p.getPostData()));
		stmt.setInt(4, p.getCategoria().getCategoriaId());
		
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		Integer id = 0;
		while(rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
}

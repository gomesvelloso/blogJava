package entities;

import java.util.Date;

public class Post {
	
	private Integer postId;
	private String postTitulo;
	private String postTexto;
	private Date postData;
	private Categoria categoria;
	
	public Post() {
		super();
	}
	
	

	public Post(Integer postId, String postTitulo, String postTexto, Date postData, Categoria categoria) {
		super();
		this.postId = postId;
		this.postTitulo = postTitulo;
		this.postTexto = postTexto;
		this.postData = postData;
		this.categoria = categoria;
	}



	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTexto() {
		return postTexto;
	}

	public void setPostTexto(String postTexto) {
		this.postTexto = postTexto;
	}

	public Date getPostData() {
		return postData;
	}

	public void setPostData(Date postData) {
		this.postData = postData;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPostTitulo() {
		return postTitulo;
	}



	public void setPostTitulo(String postTitulo) {
		this.postTitulo = postTitulo;
	}



	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTexto=" + postTexto + ", postData=" + postData + ", categoria="
				+ categoria + "]";
	}
}

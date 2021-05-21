package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Post;
import persistence.CategoriaDao;
import persistence.PostDao;
import utilities.FormataData;

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("posts")) {
			postagens(request, response);
		}else if(cmd.equalsIgnoreCase("listPosts")) {
			listarPostagens(request, response);
		}else if(cmd.equalsIgnoreCase("post")) {
			buscarPostagem(request, response);
		}else if(cmd.equalsIgnoreCase("deleletePost")) {
			deletarPostagem(request,response);
		}else if(cmd.equalsIgnoreCase("newPost")) {
			novoPost(request,response);
		}else if(cmd.equalsIgnoreCase("save_post")) {
			salvarPostagem(request, response);
		}else if(cmd.equalsIgnoreCase("update_post")){
			updatePost(request, response);
		}else if(cmd.equalsIgnoreCase("editarPost")) {
			editarPost(request,response);
		}else if(cmd.equalsIgnoreCase("categorias")) {
			categorias(request,response);
		}else if(cmd.equalsIgnoreCase("listarPorCategoria")) {
			listarPorCategoria(request,response);
		}
	}
	
	protected void listarPorCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "");
		menu.add(2, "active");
		
		PostDao pd = new PostDao();
		List<Post> lista = new ArrayList<Post>();
		
		int categoria = Integer.parseInt(request.getParameter("t"));
		
		try {
			lista = pd.findByCategoria(categoria);
			
		}catch (Exception e) {
			request.setAttribute("msg", "Erro ao listar as categorias. Erro: "+e.getMessage());
		}
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("posts.jsp").forward(request, response);
	}
	
	protected void categorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "");
		menu.add(2, "active");
		
		CategoriaDao cd = new CategoriaDao();
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			categorias = cd.findAll();
		}catch (Exception e) {
			request.setAttribute("msg", "Erro ao listar as categorias. Erro: "+e.getMessage());
		}
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("categorias.jsp").forward(request, response);
	}
	
	protected void updatePost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		PostDao pd = new PostDao();
		Post p = new Post();
		Categoria c = new Categoria();
		c.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));
		
		p.setPostId(Integer.parseInt(request.getParameter("postId")));
		p.setPostData(new Date());
		p.setPostTitulo(request.getParameter("postTitulo"));
		p.setPostTexto(request.getParameter("postTexto"));
		p.setCategoria(c);
		
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			pd.update(p);
			response.sendRedirect("Control?cmd=posts");
		}catch(Exception e) {
			request.setAttribute("msg", "Erro atualizar postagem! ERRO: "+e.getMessage());
			listarPostagens(request, response);
		}
		
	}
	
	protected void salvarPostagem(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		PostDao pd = new PostDao();
		Post p = new Post();
		Categoria c = new Categoria();
		c.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));
		
		p.setPostData(new Date());
		p.setPostTitulo(request.getParameter("postTitulo"));
		p.setPostTexto(request.getParameter("postTexto"));
		p.setCategoria(c);
		
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			
			int postId = pd.save(p);
			if(postId > 0) {
				response.sendRedirect("Control?cmd=posts");
				
			}else {
				request.setAttribute("msg", "Erro ao salvar a postagem.");
				request.getRequestDispatcher("new_post.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			request.setAttribute("msg", "Erro listar as categorias.");
			request.getRequestDispatcher("new_post.jsp").forward(request, response);
		}
	}
	
	
	protected void editarPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		CategoriaDao cd = new CategoriaDao();
		
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			categorias = cd.findAll();
		}catch(Exception e) {
			request.setAttribute("msg", "Erro listar as categorias.");
		}
		
		
		Post p = new Post();
		int post = Integer.parseInt(request.getParameter("postId"));
		
		PostDao pd = new PostDao();
		try {
			p = pd.findById(post);
		}catch(Exception e) {
			request.setAttribute("Erro", "Erro buscar postagem.");
		}
		
		
		request.setAttribute("categorias", categorias);
		request.setAttribute("postId", post);
		request.setAttribute("postagem", p);
		request.getRequestDispatcher("editar_post.jsp").forward(request, response);
		
	}
	protected void novoPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		CategoriaDao cd = new CategoriaDao();
		
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			categorias = cd.findAll();
		}catch(Exception e) {
			request.setAttribute("msg", "Erro listar as categorias.");
		}
		
		
		Post p = new Post();
		
		request.setAttribute("categorias", categorias);
		request.setAttribute("postId", 0);
		request.setAttribute("postagem", p);
		request.getRequestDispatcher("new_post.jsp").forward(request, response);
		
	}
	
	protected void deletarPostagem(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer post = Integer.parseInt(request.getParameter("post"));
		
		PostDao pd = new PostDao();
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			pd.delete(post);
		}catch(Exception e) {
			request.setAttribute("msg", "Erro ao excluir a postagem "+post+".");
		}
	}
	
	protected void buscarPostagem(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer post = Integer.parseInt(request.getParameter("post"));
		PostDao pd = new PostDao();
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			Post p = pd.findById(post);
			request.setAttribute("post", p);
			request.setAttribute("id", post);
			
			request.setAttribute("menu", menu);
			request.getRequestDispatcher("post.jsp").forward(request, response);
			
		}catch(Exception e) {
			request.setAttribute("menu", menu);
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("post.jsp").forward(request, response);
		}
		
	}
	
	protected void postagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDao pd = new PostDao();
		
		List<Post> lista = new ArrayList<Post>();
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			lista = pd.findAll();
			System.out.println(lista);
			request.setAttribute("teste", "teste123");
			request.setAttribute("menu", menu);
			
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("posts.jsp").forward(request, response);
		} catch (Exception e) {
			String msg = "Erro ao listar as postagens.";
			request.setAttribute("menu", menu);
			request.setAttribute("erro", msg);
			request.getRequestDispatcher("posts.jsp").forward(request, response);
		}
	}	
	
	protected void listarPostagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDao pd = new PostDao();
		
		List<Post> lista = new ArrayList<Post>();
		List<String> menu = new ArrayList<String>();
		menu.add(0, "");
		menu.add(1, "active");
		menu.add(2, "");
		
		try {
			lista = pd.findAll();
			System.out.println(lista);
			
			request.setAttribute("menu", menu);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("lista_posts.jsp").forward(request, response);
		} catch (Exception e) {
			String msg = "Erro ao listar as postagens.";
			request.setAttribute("menu", menu);
			
			request.setAttribute("erro", msg);
			request.getRequestDispatcher("lista_posts.jsp").forward(request, response);
		}
	}

}

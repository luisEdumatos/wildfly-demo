package proj;

import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource
	private UserTransaction ut; 
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto p = new Produto(); 
		p.setDescricao("caneta"); 
		p.setPreco(9.6); 
		
		try {
			ut.begin();
			em.persist(p); 
			ut.commit(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e); 
		} 
		
		
		response.getWriter().append("Produto criado com ID " + p.getId()).close();
	}

}

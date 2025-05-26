package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet({
"/RelatorioController",
"/relatorio"
})
public class RelatorioController extends controller {
	private static final long serialVersionUID = 1L;

    public RelatorioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
	    System.out.println("POST action: " + action);
	    if (action.equals("/relatorio")) {
	    	retornaRelatorio(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	
	protected void retornaRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("relatorio.jsp");
	}

}

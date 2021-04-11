package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeEmpresa = req.getParameter("nome");
		String paramDataEmpresa = req.getParameter("data");	
	    
		Date dataAbertura = null;
	    try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	   	
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		req.setAttribute("empresa", empresa.getNome());
		resp.sendRedirect("listaEmpresas");
		
//		//Chamando o JSP
//		//Redirecionamentos ao lado do servidor(uma servlet chamando a outra).
//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		req.setAttribute("empresa", empresa.getNome());
//		rd.forward(req, resp);
	}
}
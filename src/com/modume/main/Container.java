package com.modume.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Container extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapper mapper;

	public Container() {
		super();
		mapper = new HandlerMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proc(request, response);
	}

	private void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] uriArr = request.getRequestURI().split("/");
		String temp = mapper.nav(request,uriArr);

		if (temp.indexOf(":") >= 0) {
			String prefix = temp.substring(0, temp.indexOf(":"));
			String value = temp.substring(temp.indexOf(":") + 1);

			switch (prefix) {
			case "redirect":
				response.sendRedirect(value);
				return;
			case "ajax":
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print(value);
				return;
			}
		}
		request.getRequestDispatcher(temp).forward(request, response);
	}
}

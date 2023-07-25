package org.study.web;
import org.study.storage.DatabaseInitService;
import org.study.web.command.CommandService;
import org.thymeleaf.TemplateEngine;


import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/*")
public class FrontController extends HttpServlet {
	private TemplateEngine engine;
	private CommandService commandService;
	@Override
	public void init() throws ServletException {

		new DatabaseInitService().initDB();

		engine = new TemplateEngine();

			ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
			secondaryTemplateResolver.setPrefix("templates/");
			secondaryTemplateResolver.setSuffix(".html");
			secondaryTemplateResolver.setTemplateMode("HTML5");
			secondaryTemplateResolver.setCharacterEncoding("UTF-8");
			secondaryTemplateResolver.setCheckExistence(false);

		engine.addTemplateResolver(secondaryTemplateResolver);

		commandService = new CommandService();
		}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commandService.process(req,resp,engine);
	}
}

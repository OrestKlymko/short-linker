package org.study.web.command;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class IndexCommand implements Command{
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException {
		res.setContentType("text/html; charset=utf-8");

		Context simpleContext = new Context(req.getLocale(), Collections.emptyMap());


		engine.process("index", simpleContext, res.getWriter());

		res.getWriter().close();
	}
}

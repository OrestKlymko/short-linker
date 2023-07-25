package org.study.web.command;

import org.study.link.LinkService;
import org.study.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ListCommand implements Command {
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException {
		res.setContentType("text/html; charset=utf-8");

		LinkService linkService = ServiceProvider.get(LinkService.class);


		Context simpleContext = new Context(req.getLocale(), Collections.singletonMap("links",linkService.listAllLink()));


		engine.process("list", simpleContext, res.getWriter());

		res.getWriter().close();
	}
}

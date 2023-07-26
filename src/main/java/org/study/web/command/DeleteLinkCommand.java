package org.study.web.command;

import org.study.link.LinkService;
import org.study.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteLinkCommand implements Command{
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException {
		String shortLink = req.getParameter("shortLink");
		LinkService linkService = ServiceProvider.get(LinkService.class);
		linkService.deleteByShortLink(shortLink);
		res.sendRedirect("/list");
	}
}

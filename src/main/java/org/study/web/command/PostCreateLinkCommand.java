package org.study.web.command;

import org.study.link.Link;
import org.study.link.LinkService;
import org.study.link.ShortLinkGenerator;
import org.study.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class PostCreateLinkCommand implements Command {
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException {
		LinkService linkService = ServiceProvider.get(LinkService.class);
		String fullUrl = req.getParameter("fullUrl");
		String shortUrl;

		do {
			shortUrl = new ShortLinkGenerator().generate();
		} while (linkService.getByShortLink(shortUrl) != null);

		Link link = new Link();
		link.setShortLink(shortUrl);
		link.setLink(fullUrl);
		linkService.save(link);
		res.sendRedirect("/list");
	}
}

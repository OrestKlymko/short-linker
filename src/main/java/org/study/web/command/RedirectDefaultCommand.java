package org.study.web.command;

import org.study.link.Link;
import org.study.link.LinkService;
import org.study.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectDefaultCommand implements Command{
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException {
		String shortLink = req.getRequestURI().replace("/", "");
		LinkService linkService = ServiceProvider.get(LinkService.class);
		Link byShortLink = linkService.getByShortLink(shortLink);

		byShortLink.setOpenCount(byShortLink.getOpenCount()+1);
		linkService.save(byShortLink);

		String fullLink = byShortLink.getLink();
		res.sendRedirect(fullLink);
	}
}

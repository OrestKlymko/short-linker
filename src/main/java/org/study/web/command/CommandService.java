package org.study.web.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService {
	private Map<String,Command> commands;

	public CommandService(){
		commands = new HashMap<>();
		commands.put("GET /",new IndexCommand() );
		commands.put("GET /list",new ListCommand() );
	}

	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException{
		String requestURI = req.getRequestURI();
		String commandKey = req.getMethod() + " "+requestURI;
		commands.get(commandKey).process(req,res,engine);
	}
}

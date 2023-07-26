package org.study.web.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService {
	private Map<String,Command> commands;
	private Command defaultCommand;

	public CommandService(){
		commands = new HashMap<>();
		commands.put("GET /",new IndexCommand() );
		commands.put("GET /list",new ListCommand() );
		commands.put("GET /link/create", new GetCreateLinkCommand());
		commands.put("POST /link/create", new PostCreateLinkCommand());
		commands.put("GET /link/delete",new DeleteLinkCommand());
		defaultCommand = new RedirectDefaultCommand();
	}

	public void process(HttpServletRequest req, HttpServletResponse res, TemplateEngine engine) throws IOException{
		String requestURI = req.getRequestURI();
		String commandKey = req.getMethod() + " "+requestURI;
		Command command = commands.get(commandKey);
		if(command!=null) {
			command.process(req, res, engine);
		}else {
			defaultCommand.process(req,res,engine);
		}
	}
}

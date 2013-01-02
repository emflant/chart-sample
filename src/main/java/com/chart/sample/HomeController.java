package com.chart.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chart.common.GoogleChartDTO;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws IOException {
		
		
		logger.info(req.getCharacterEncoding());
		logger.info(resp.getCharacterEncoding());
		
		
		logger.info(req.getParameter("a"));
		//resp.setContentType("text/plain");//charset=utf-8
		resp.setCharacterEncoding("utf-8");
		
		GoogleChartDTO go = new GoogleChartDTO();
		go.addColumn("month", "string");
		go.addColumn("A product", "number");
		go.addColumn("B product", "number");
		
		go.createRows(5);
		
		go.addCell(0, "201204", "2012년4월");
		go.addCell(0, 70);
		go.addCell(0, 400);
		
		go.addCell(1, "201205", "5월");
		go.addCell(1, 556);
		go.addCell(1, 200);
		
		go.addCell(2, "201206", "6월");
		go.addCell(2, 798);
		go.addCell(2, 665);
		
		go.addCell(3, "201207", "7월");
		go.addCell(3, 312);
		go.addCell(3, 800);
		
		go.addCell(4, "201208", "8월");
		go.addCell(4, 780);
		go.addCell(4, 150);
		
		Gson gson = new Gson();
		String json = gson.toJson(go.getResult());
		
		logger.info(json);
		
		//PrintWriter out = resp.getWriter();
		out.write(json);
		out.close();
		//model.addAttribute("aa", "��");
		
		
		return null;
	}
	
	
	
}

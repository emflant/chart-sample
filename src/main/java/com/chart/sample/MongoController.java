package com.chart.sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chart.domain.Person;
import com.chart.repository.PersonRepository;

@Controller
public class MongoController {

	private static final Logger logger = LoggerFactory.getLogger(MongoController.class);
	
	@Autowired private PersonRepository repository;
	
	@RequestMapping(value = "/mongo/insert", method=RequestMethod.GET)
	public String insert(Locale locale, Model model){
		
		Person p = new Person("Joe", 34);
		Person p1 = this.repository.save(p);	
		
		ObjectId id = new ObjectId(p.getId());
		
		Date date = new Date(id.getTime());
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		
		logger.info("["+formattedDate+"] " + p1.toString());
		
		return null;
	}
	
	
	@RequestMapping(value = "/mongo/select", method=RequestMethod.GET)
	public String select(Locale locale, Model model){
		
		
		Page<Person> page = repository.findAll(new PageRequest(1, 3));
		List<Person> people = page.getContent();
		
		for(Person person : people){
			logger.info(person.toString());
		}
		
		//Person person = repository.findOne("506290099ff6009e77f89fc8");
		//logger.info(person.toString());
				
		return null;
	}
	
	@RequestMapping(value = "/mongo/deletAll", method=RequestMethod.GET)
	public String deleteAll(Locale locale, Model model){
		
		
		repository.deleteAll();
		
		//Person person = repository.findOne("506290099ff6009e77f89fc8");
		//logger.info(person.toString());
				
		return null;
	}
}

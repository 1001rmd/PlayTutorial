package controllers;

import models.Person;
import java.util.List;
import play.libs.Json;

import play.mvc.*;
import play.mvc.Http.Request;
import play.*;
import play.data.Form;
import play.data.FormFactory;
import io.ebean.Finder;

import javax.inject.Inject;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * pertaining to the Person class.
 */
public class PersonController extends Controller {

	private Form<Person> form;
	private Finder<Long, Person> finder = new Finder<>(Person.class);

    //Creates the controller and the Person form
	@Inject
	public PersonController(FormFactory formFactory){
		
		this.form = formFactory.form(Person.class);
		
	}
	
	//Adds a person to the database
    public Result addPerson(String name) {
       
		
		/*if(form.hasErrors){
			return redirect(routes.HomeController.test(form.getGlobalError.message()));
		}
		//person.save();
		*/return redirect(routes.HomeController.test(name));
    }
	
	//Displays people
	public Result getPerson(){
		
		List<Person> people = finder.all();
		
		return ok(Json.toJson(people));
		
	}

}
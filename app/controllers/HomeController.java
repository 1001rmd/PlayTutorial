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
public class HomeController extends Controller {

	private Form<Person> form;
	private Finder<Long, Person> finder = new Finder<>(Person.class);

    //Creates the controller and the Person form
	@Inject
	public HomeController(FormFactory formFactory){
		
		this.form = formFactory.form(Person.class);
		
	}
	
	public Result index() {
		
		return ok(index.render(form));
    }
	
	public Result test(String debug){
		return ok(test.render(debug));
	}
	
	//Adds a person to the database
    public Result addPerson() {
       
		Person person = form.bindFromRequest().get();
		person.save();
		return redirect(routes.HomeController.index());
    }
	
	//Displays people
	public Result getPerson(){
		
		List<Person> persons = finder.all();
		return ok(Json.toJson(persons));
		
	}

}

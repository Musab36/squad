import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("heros", request.session().attribute("heros")); //We are retrieving the squad from the session
    	model.put("template", "templates/index.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heros", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();

    	ArrayList<Squad> heros = request.session().attribute("heros");
    	if (heros == null) { // We are retrieving an ArrayList from the session saved under the key "heros"
    		heros = new ArrayList<Squad>(); // If that ArrayList does not exist yet, we create a new one 
    		request.session().attribute("heros", heros); // And add it to the session
    	}

    	String name = request.queryParams("name"); // Saving user inputted hero name into a String
    	Squad newSquad = new Squad(name); // Squad constructorcreating new squad with the user's provided name
    	request.session().attribute("hero", "newSquad"); // We then save the squad object into the user's session
    	heros.add(newSquad); // we create our Squad object and add it into the heros ArrayList

    	model.put("template", "templates/success.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Project{
	String name;
	String deadline;
	Status status;



	public static ArrayList<Project> projects = new ArrayList<>();
	
	Project(String name, String deadline, Status status){
		this.name = name;
		this.deadline = deadline;
		this.status = status;


	}
	public String getInfo(){
		return "project " + this.name + " (" + this.status + ")" + " with deadline of " + this.deadline;
	}

	public String getName(){
		return this.name;
	}

	
}
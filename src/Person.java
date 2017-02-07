import java.util.ArrayList;
import java.util.Comparator;

public class Person{
	
	private Integer id;
	private String name;
	private String email;
	protected String type;
	protected ArrayList<ResearchProject> projects = new ArrayList<ResearchProject>();
	private Comparator<ResearchProject> byEndDate = (project1, project2) -> project2.getEndDateCode().compareTo(project1.getEndDateCode());
	
	private ArrayList<Production> productions = new ArrayList<Production>();	
	private Comparator<Production> byPublishmentDate = (production1, production2) -> production2.getDate().compareTo(production1.getDate());
	
	public void setId(Integer id){
		
		this.id = id;
		
	}
	
	public Integer getId(){
		
		return this.id;
		
	}
	
	public void setName(String name){
		
		this.name = name;
		
	}
	
	public String getName(){
		
		return this.name;
		
	}
	
	public void setEmail(String email){
		
		this.email = email;
		
	}
	
	public String getEmail(){
		
		return this.email;
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean addProject(ResearchProject project){
		if(!this.projects.contains(project)){
			this.projects.add(project);
			return true;
		}
		else{
			System.out.println("This collaborator is already in the selected project!");
			return false;
		}
		
	}
	
	public boolean addProduction(Production newProduction){
		
		if(!this.productions.contains(newProduction)){
			this.productions.add(newProduction);
			return true;
		}
		else{
			System.out.println("This collaborator is already in the selected production!");
			return false;
		}
		
	}
	
	public void printCollaborator(){
		System.out.println("Name: "+this.name+" | Email: "+this.email);
		System.out.println("Projects: ");
		this.printProjects();
		System.out.println("\nAcademic Productions: ");
		this.printProductions();
		return;
	}
	
	public void printProjects(){
		projects.stream().sorted(byEndDate).forEach(i -> System.out.println(i));
	}
	
	public void printProductions(){
		productions.stream().sorted(byPublishmentDate).forEach(i -> System.out.println(i));
	}
	

}

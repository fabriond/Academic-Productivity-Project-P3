import java.util.ArrayList;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Person{
	
	private Integer id;
	private String name;
	private String email;
	protected String type;
	protected ArrayList<ResearchProject> projects = new ArrayList<ResearchProject>();
	protected SortedMap<Integer, ResearchProject> projects2 = new TreeMap<Integer, ResearchProject>();
	private SortedMap<Integer, Production> productions = new TreeMap<Integer, Production>();
	
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
			this.projects2.put(project.getEndDateCode(), project);
			return true;
		}
		else{
			System.out.println("This collaborator is already in the selected project!");
			return false;
		}
		
	}
	
	public boolean addProduction(Production newProduction){
		
		if(!this.productions.containsValue(newProduction)){
			this.productions.put(newProduction.getDate(), newProduction);
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
		Set<Integer> keys = this.projects2.keySet();
		Integer[] array = new Integer[keys.size()];
		array = keys.toArray(array);
		for(int i = 0; i < keys.size(); i++){
			if(this.projects2.get(array[i]).getStatus() != 3) System.out.println("  "+this.projects2.get(array[i]).toString());
		}
		for(int i = 0; i < keys.size(); i++){
			if(this.projects2.get(array[i]).getStatus() == 3) System.out.println("  "+this.projects2.get(array[i]).toString());
		}
		
	}
	
	public void printProductions(){
		Set<Integer> keys = this.productions.keySet();
		Integer[] array = new Integer[keys.size()];
		array = keys.toArray(array);
		//System.out.println(this.productions.values().toString());
		for(int i = 0; i < keys.size(); i++){
			System.out.println("  "+this.productions.get(array[i]).toString());
		}	
		
	}
	

}

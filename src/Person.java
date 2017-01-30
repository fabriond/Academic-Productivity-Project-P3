import java.util.ArrayList;

abstract class Person{
	
	private Integer id;
	private String name;
	private String email;
	protected String type;
	protected ArrayList<Integer> projects = new ArrayList<Integer>();
	
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
	
	public boolean addProject(Integer projectId){
		if(!this.projects.contains(projectId)){
			this.projects.add(projectId);	
			return true;
		}
		else{
			System.out.println("This collaborator is already in the selected project!");
			return false;
		}
		
	}

}


public class Student extends Person{
	
	private int activeProjects = 0;
	private int studentType;// 1 - Bachelor, 2 - Master, 3 - PhD
	
	Student(int type){
		this.type = "Student";
		this.studentType = type;
	}	
	
	public boolean addProject(int projectId, int i){
		
		if(this.studentType == 1 && this.activeProjects >= 2){
			System.out.println("This collaborator cannot participate in any more projects!");
			return false;
		}
		else if(this.projects.contains(projectId)){
			System.out.println("This collaborator is already in the selected project!");
			return false;
		}
		else if(this.studentType == 1 && this.activeProjects < 2){
			this.activeProjects++;
			System.out.println("God Damnit");
		}
			
		this.projects.add(projectId);
		return true;	
		
	}
	
	public void removeActiveProject(){
		this.activeProjects--;
	}
	
}

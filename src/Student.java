
public class Student extends Person{
	
	private int activeProjects = 0;
	private int studentType;// 1 - Bachelor, 2 - Master, 3 - PhD
	
	Student(int type){
		this.setType("Student");
		this.studentType = type;
	}	
	
	@Override
	public boolean addProject(ResearchProject project){
		
		if(this.studentType == 1 && this.activeProjects >= 2){
			System.out.println("This collaborator cannot participate in any more projects!");
			return false;
		}
		else if(this.projects.contains(project)){
			System.out.println("This collaborator is already in the selected project!");
			return false;
		}
		else if(this.studentType == 1 && this.activeProjects < 2){
			this.activeProjects++;
		}
		
		this.projects.add(project);
		return true;	
		
	}
	
	public void removeActiveProject(){
		this.activeProjects--;
	}
	
}

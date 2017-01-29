
public class Student extends Person{
	
	private int activeProjects = 0;
	private int studentType;// 1 - Bachelor, 2 - Master, 3 - PhD

	public Student(int type){
		studentType = type;
	}
	
	public void addProject(int projectId){
		if(this.studentType == 1 && this.activeProjects < 2) this.activeProjects++;
		else if(this.studentType == 1 && this.activeProjects >= 2){
			System.out.println("This collaborator cannot participate in any more projects!");
			return;
		}
		this.projects.add(projectId);
		return;
	}
	
}

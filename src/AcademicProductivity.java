import java.util.Scanner;
import java.util.ArrayList;
//List<Float> unindexedVectors = new ArrayList<Float>();
//nome, e-mail, um histórico contendo a lista de projetos nos quais este colaborador participou, incluindo os projetos em andamento ordenados de forma decrescente
//pela data de término, incluindo também a lista de sua produção acadêmica.


public class AcademicProductivity {
	
	static Scanner scan = new Scanner(System.in);
	static int projectCount = 0;
	static int collaboratorCount = 0;
	static ArrayList<Professor> professors = new ArrayList<Professor>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Researcher> researchers = new ArrayList<Researcher>();
	static ArrayList<ResearchProject> projects = new ArrayList<ResearchProject>();
	static ArrayList<Person> collaborators = new ArrayList<Person>();
	
	public static void main(String[] args){
		
		int menuOption = 0;
		
		while(menuOption != 11){			
			System.out.println("Select your action: \n");
			System.out.println("  0 - List Collaborators");
			System.out.println("  1 - Create New Research Project");
			System.out.println("  2 - Edit Research Project");
			System.out.println("  3 - Add Academic Production");
			System.out.println("  4 - Add Professor");
			System.out.println("  5 - Add Student");
			System.out.println("  6 - Add Researcher");
			System.out.println("  7 - Remove Collaborator");

			System.out.println("  11 - Close \n");
			
			menuOption = scan.nextInt();

			if(menuOption == 0){
				for(int i = 0; i < collaboratorCount; i++){
					System.out.printf("ID: %03d", collaborators.get(i).getId());
					System.out.println(" | Name: "+collaborators.get(i).getName()+" | Email: "+collaborators.get(i).getEmail());
				}				
			}
		
			else if(menuOption == 1){
				ResearchProject newProject = new ResearchProject();
				newProject.setProjectId(projectCount);
				
				projects.add(newProject);
				
			}
			
			else if(menuOption == 2){
				
			}
			
			else if(menuOption == 3){
				
			}
			else if(menuOption == 4){
				newProfessor();
			}
			
			else if(menuOption == 5){
				newStudent();	
			}
			
			else if(menuOption == 6){
				newResearcher();
			}
			
			else if(menuOption == 7){
				
			}
		
		}
	
	
	}
	
	public static void newProfessor(){
		Professor newProfessor = new Professor();
		newProfessor.setId(collaboratorCount);
		collaboratorCount++;
		System.out.print("Name: ");
		scan.nextLine();
		newProfessor.setName(scan.nextLine());
		System.out.print("Email: ");
		newProfessor.setEmail(scan.nextLine());
		newProfessor.setType("Professor");
		collaborators.add(newProfessor);
		professors.add(newProfessor);
	}
	
	public static void newStudent(){
		System.out.println("Type of Student: \n  1 - Bachelor Student\n  2 - Master Student\n  3 - PhD Student");
		Student newStudent = new Student(scan.nextInt());
		newStudent.setId(collaboratorCount);
		collaboratorCount++;
		System.out.print("Name: ");
		scan.nextLine();
		newStudent.setName(scan.nextLine());
		System.out.print("Email: ");
		newStudent.setEmail(scan.nextLine());
		newStudent.setType("Student");
		collaborators.add(newStudent);
		students.add(newStudent);	
	}
	
	public static void newResearcher(){
		Researcher newResearcher = new Researcher();
		newResearcher.setId(collaboratorCount);
		collaboratorCount++;
		System.out.print("Name: ");
		scan.nextLine();
		newResearcher.setName(scan.nextLine());
		System.out.print("Email: ");
		newResearcher.setEmail(scan.nextLine());
		newResearcher.setType("Researcher");
		collaborators.add(newResearcher);
		researchers.add(newResearcher);
	}
	
	
	
	
	
	
	
}

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
			System.out.println("  7 - Academic Productivity Report");
			System.out.println("  11 - Close \n");
			
			menuOption = scan.nextInt();

			if(menuOption == 0){
				printCollaborators();	
			}
		
			else if(menuOption == 1){
				newProject();				
			}
			
			else if(menuOption == 2 && projectCount > 0){
				System.out.println("Projects List: ");
				for(int i = 0; i < projectCount; i++){
					System.out.printf("  ID: %03d", projects.get(i).getProjectId());
					System.out.println(" | Title: "+projects.get(i).getTitle()+" | Description: "+projects.get(i).getDescription());
				}
				System.out.println("");
				System.out.print("ID of the project you'd like to edit: ");
				editProject(scan.nextInt());
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
				System.out.println("Collaborator Count: "+collaboratorCount);
				int inPreparationProjects = 0, inDevelopmentProjects = 0, concludedProjects = 0;
				for(int i = 0; i < projectCount; i++){
					
					if(projects.get(i).getStatus() == 1){
						inPreparationProjects++;
					}
					else if(projects.get(i).getStatus() == 2){
						inDevelopmentProjects++;
					}
					else{
						concludedProjects++;
					}
					
				}
				System.out.println("Projects In Preparation Phase: "+inPreparationProjects);
				System.out.println("Projects In Development Phase: "+inDevelopmentProjects);
				System.out.println("Projects Concluded: "+concludedProjects);
				System.out.println("Total Projects: "+projectCount);
				
			}
		
		}
	
	
	}
	
	public static void newProject(){
		
		ResearchProject newProject = new ResearchProject();
		newProject.setProjectId(projectCount);
		System.out.print("Title: ");
		scan.nextLine();
		newProject.setTitle(scan.nextLine());
		System.out.print("Starting Date: ");
		newProject.setStartDate(scan.nextLine());
		System.out.print("End Date: ");
		newProject.setEndDate(scan.nextLine());
		System.out.print("Financial Agency: ");
		newProject.setFinancialAgency(scan.nextLine());
		System.out.print("Financed Value: R$ ");
		newProject.setFinancedValue(scan.nextDouble());
		System.out.print("Objective: ");
		scan.nextLine();
		newProject.setObjective(scan.nextLine());
		System.out.print("Description: ");
		newProject.setDescription(scan.nextLine());		
		System.out.println("Professor List: ");
		for(int i = 0; i < collaboratorCount; i++){
			if(collaborators.get(i).getType().equals("Professor")){
				System.out.printf("  ID: %03d", collaborators.get(i).getId());
				System.out.println(" | Name: "+collaborators.get(i).getName()+" | Email: "+collaborators.get(i).getEmail());
			}
		}
		System.out.println("");
		System.out.print("Project's Professor ID: ");
		int professorId = scan.nextInt();
		newProject.addProfessor(professorId);
		collaborators.get(professorId).addProject(newProject.getProjectId());
		projectCount++;
		projects.add(newProject);
		
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
	
	public static void editProject(Integer projectId){
				
		System.out.println("\nWhat would you like to edit?");
		System.out.println("  1 - Title");
		System.out.println("  2 - Starting Date");
		System.out.println("  3 - End Date");
		System.out.println("  4 - Financial Agency");
		System.out.println("  5 - Financed Value");
		System.out.println("  6 - Objective");
		System.out.println("  7 - Description");
		System.out.println("  8 - Add Collaborator");
		System.out.println("  9 - Change Status");
		int answer = scan.nextInt();
		
		if(answer == 1){
			System.out.println("Current Title: "+projects.get(projectId).getTitle());
			System.out.print("New Title: ");
			scan.nextLine();
			projects.get(projectId).setTitle(scan.nextLine());
		}
		
		else if(answer == 2){
			System.out.println("Current Starting Date: "+projects.get(projectId).getStartDate());
			System.out.print("New Starting Date: ");
			scan.nextLine();
			projects.get(projectId).setStartDate(scan.nextLine());
		}
		else if(answer == 3){
			System.out.println("Current End Date: "+projects.get(projectId).getEndDate());
			System.out.print("New End Date: ");
			scan.nextLine();
			projects.get(projectId).setEndDate(scan.nextLine());
		}
		else if(answer == 4){
			System.out.println("Current Financial Agency: "+projects.get(projectId).getFinancialAgency());
			System.out.print("New Financial Agency: ");
			scan.nextLine();
			projects.get(projectId).setFinancialAgency(scan.nextLine());
		}
		else if(answer == 5){
			System.out.println("Current Financed Value: R$ "+projects.get(projectId).getFinancedValue());
			System.out.print("New Financed Value: R$ ");
			projects.get(projectId).setFinancedValue(scan.nextDouble());
		}
		else if(answer == 6){
			System.out.println("Current Objective: "+projects.get(projectId).getObjective());
			System.out.print("New Objective: ");
			scan.nextLine();
			projects.get(projectId).setObjective(scan.nextLine());
		}
		else if(answer == 7){
			System.out.println("Current Description: "+projects.get(projectId).getDescription());
			System.out.print("New Description: ");
			scan.nextLine();
			projects.get(projectId).setDescription(scan.nextLine());
		}
		else if(answer == 8){
			if(projects.get(projectId).statusToString().equals("In Preparation Phase")){
				printCollaborators();
				System.out.print("New Collaborator's ID: ");
				int collabId = scan.nextInt();
				if(!collaborators.get(collabId).getType().equals("Student")){
					
					if(collaborators.get(collabId).addProject(projectId)){
						if(collaborators.get(collabId).getType().equals("Professor")){
							projects.get(projectId).addProfessor(collabId);	
						}
						else if(collaborators.get(collabId).getType().equals("Researcher")){
							projects.get(projectId).addResearcher(collabId);	
						}
					}
					
				}
				else if(((Student) collaborators.get(collabId)).addProject(projectId)){
					projects.get(projectId).addStudent(collabId);
				}
				
			}
			else System.out.println("This project is no longer in preparation phase and cannot add more collaborators!");
		}
		else if(answer == 9){
			projects.get(projectId).changeStatus();
		}
		
	}
		
	public static void printCollaborators(){
		System.out.println("Collaborators List: ");
		for(int i = 0; i < collaboratorCount; i++){
			System.out.printf("  ID: %03d", collaborators.get(i).getId());
			System.out.println(" | Name: "+collaborators.get(i).getName()+" | Email: "+collaborators.get(i).getEmail());
			System.out.println(collaborators.get(i).projects);
		}
		System.out.println("");
	}
	
}

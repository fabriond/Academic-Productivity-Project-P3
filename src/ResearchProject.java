import java.util.ArrayList;
import java.util.Comparator;

public class ResearchProject {
	
	private Integer projectId;
	private String title;
	private String startDate;
	private String endDate;
	private int endDateCode;
	private String financialAgency;
	private double financedValue;
	private String objective;
	private String description;

	private ArrayList<Production> productions = new ArrayList<Production>();
	private Comparator<Production> byPublishmentDate = (production1, production2) -> production2.getDate().compareTo(production1.getDate());
	
	
	private ArrayList<Integer> professors = new ArrayList<Integer>();
	private int professorCount = 0;
	
	private ArrayList<Integer> researchers = new ArrayList<Integer>();
	
	private ArrayList<Integer> students = new ArrayList<Integer>();
	
	private int status = 1; //1 - In Preparation, 2 - In Development, 3 - Concluded
	
	public void setProjectId(Integer id){
		this.projectId = id;
		return;
	}
	
	public Integer getProjectId(){
		return projectId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	@SuppressWarnings("unused")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
		String[] parts = startDate.split("/");
		String day = parts[0];
		String month = parts[1];
		String year = parts[2];
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
		String[] parts = endDate.split("/");
		String day = parts[0];
		String month = parts[1];
		String year = parts[2];
		this.setEndDateCode(Integer.parseInt(day) + Integer.parseInt(month)*30 + Integer.parseInt(year)*365);
	}

	public Integer getEndDateCode() {
		return endDateCode;
	}

	public void setEndDateCode(int endDateCode) {
		this.endDateCode = endDateCode;
	}

	public String getFinancialAgency() {
		return financialAgency;
	}

	public void setFinancialAgency(String financialAgency) {
		this.financialAgency = financialAgency;
	}

	public double getFinancedValue() {
		return financedValue;
	}

	public void setFinancedValue(double financedValue) {
		this.financedValue = financedValue;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public String statusToString(){
		if(this.status == 1) return "In Preparation Phase";
		else if(this.status == 2) return "In Development Phase";
		else return "Concluded";
	}
	
	public void changeStatus(){
		if(this.status == 1 && professorCount >= 1){
			this.status = 2;
			System.out.println("Research Project In Development");
		}
		else if(this.status == 2 && !this.productions.isEmpty()){
			this.status = 3;
			System.out.println("Research Project Concluded");
		}
		else System.out.println("Project Status Cannot Be Changed");
		return;
	}
	
	public void addProfessor(Integer professorId){
		this.professors.add(professorId);
		professorCount++;
		return;
	}
	
	
	public void addResearcher(Integer researcherId){
		this.researchers.add(researcherId);
		return;
	}

	public void addStudent(Integer studentId){
		this.students.add(studentId);
		return;
	}
	
	public boolean addProduction(Production newProduction){
		
		if(!this.productions.contains(newProduction)){
			this.productions.add(newProduction);
			return true;
		}
		else{
			System.out.println("Production already associated with the selected project!");
			return false;
		}
		
	}
	
	public boolean removeProduction(Production newProduction){
		
		if(this.productions.contains(newProduction)){
			this.productions.remove(newProduction);
			return true;
		}
		else{
			System.out.println("Production not associated with the selected project!");
			return false;
		}
		
	}
	
	public void printProductions(){
		productions.stream().sorted(byPublishmentDate).forEach(i -> System.out.println(i));		
	}
	
	public ArrayList<Integer> getStudentsList(){
		return this.students;
	}
	
	public void printProject(ArrayList<Person> allCollaborators){
		
		System.out.println("\nTitle: "+this.title+" | Current Status: "+this.statusToString());
		System.out.println("Starting Date: "+this.startDate+" | End Date: "+this.endDate);
		System.out.println("Financial Agency: "+this.financialAgency+" | Financed Value: "+this.financedValue);
		System.out.println("Objective: "+this.objective+" | Description: "+this.description);
		System.out.println("\nCollaborators List: ");
		for(int i = 0; i < professors.size(); i++){
			System.out.println("  "+allCollaborators.get(professors.get(i)));
		}
		for(int i = 0; i < students.size(); i++){
			System.out.println("  "+allCollaborators.get(students.get(i)));
		}
		for(int i = 0; i < researchers.size(); i++){
			System.out.println("  "+allCollaborators.get(researchers.get(i)));
		}
		System.out.println("\nRelated Academic Productions: ");
		this.printProductions();
		System.out.println("");
		return;
		
	}
	
	@Override
	public String toString(){
		
		return "  Title: "+this.title+" | Current Status: "+this.statusToString()+" | End Date: "+this.endDate;
		
	}
	
}

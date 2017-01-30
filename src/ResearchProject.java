import java.util.ArrayList;

public class ResearchProject {
	
	private Integer projectId;
	
	private String title;
	private String startDate;
	private String endDate;
	private String financialAgency;
	private double financedValue;
	private String objective;
	private String description;
	
	
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

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
		else if(this.status == 2){
			this.status = 3;
			System.out.println("Research Project Concluded");
		}
		else System.out.println("Project Status Cannot Be Changed");
		return;
	}
	
	public void addProfessor(Integer professorId){
		professors.add(professorId);
		professorCount++;
		return;
	}
	
	
	public void addResearcher(Integer researcherId){
		researchers.add(researcherId);
		return;
	}

	public void addStudent(Integer studentId){
		students.add(studentId);
		return;
	}
	
}


public class Production {
	
	private Integer id;
	private String title;
	private String conference;
	private int date;
	private Integer projectId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String toString(){
		return "  Title: "+this.title+" | Conference: "+this.conference+" | Year of Publication: "+this.date;
	}
	
}

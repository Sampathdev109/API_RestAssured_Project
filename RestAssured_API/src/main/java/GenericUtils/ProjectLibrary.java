package GenericUtils;

/*
 * This code is for POJO class.
 */
	public class ProjectLibrary {

		//create the global variable

		String createdBy;
		String projectName;
		String status;
		int teamSize;

		//use constructor
		public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;

		}
		
		public String getCreated() {
			
			return createdBy;
			
		}

		public void setCreatedBy(String createdBy) {
			
			this.createdBy = createdBy;
		}


		}

package gov.nist.toolkit.errorrecording.client;

public class CCDAValidationReportItem {

	private String msg;
	private String dts;
	private String resource;
	private String status;
	private String xpath;

	public CCDAValidationReportItem(String entire_msg, String resource, String xpath, ValidatorErrorItem.ReportingLevel level) {
		this.resource = "";
		this.xpath = "";
		if(entire_msg.contains("|")) {
			String[] split_msg = entire_msg.split("\\|");
			this.dts = split_msg[0];
			this.msg = split_msg[1];
			if(split_msg.length == 4) {
				this.xpath = split_msg[2];
				this.resource = split_msg[3];
			} else if(split_msg.length == 3) {
				this.msg += " | " + split_msg[2];
			} else {
				this.resource = resource;
				this.xpath = xpath;
			}
		} else {
			this.dts = "";
			this.msg = entire_msg;
			this.xpath = xpath;
			this.resource = resource;
		}
		
		// Get Conformance
		if(this.msg.contains("(CONF:")) {
			String confNumber = "";
			String[] conf = this.msg.split("CONF:");
			for(int i=1 ; i < conf.length ; i++) {
				if(conf[i].endsWith(", ")) {
					confNumber += conf[i].replace(", ", "<br />");
				} else {
					confNumber += conf[i].split("\\)", 2)[0];
					confNumber += "<br />";
				}
				this.dts = confNumber;
			}
		} else if(!this.dts.equals("")) {
			this.dts = "-";
		}
		
		switch (level) {
		case DETAIL:
			status = "Information";
			break;

		case WARNING:
			status = "Warning";
			break;

		case ERROR:
			status = "Error";
			break;

		default:
			status = "Information";
			break;
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDts() {
		return dts;
	}

	public void setDts(String dts) {
		this.dts = dts;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String ressource) {
		this.resource = ressource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

}
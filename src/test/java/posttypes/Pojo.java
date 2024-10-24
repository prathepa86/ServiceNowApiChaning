package posttypes;

public class Pojo {
private String state;
private String short_description;

public Pojo(String state,String short_description) {
	this.state=state;
	this.short_description=short_description;
}

public String getState() {
	return state;
}

public String getShortDesc() {
	return short_description;
}
}

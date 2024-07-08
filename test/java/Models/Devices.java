package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Devices {
	    private String ID;
	    private String name;
	    private Data data;


	// Getter Methods

	    @JsonProperty("id")
	    public String getID() {
	        return ID;
	    }

	    @JsonProperty("name")
	    public String getName() {
	        return name;
	    }


	    @JsonProperty("data")
	    public Data getData() {
	        return data;
	    }

	// Setter Methods

	    @JsonProperty("id")
	    public void setID(String id) {
	        this.ID = id;
	    }

	    @JsonProperty("name")
	    public void setName(String name) {
	        this.name = name;
	    }

	    @JsonProperty("data")
	    public void setData(Data data) {
	        this.data = data;
	    }
}

    
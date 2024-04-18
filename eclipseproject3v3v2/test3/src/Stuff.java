

class Stuff {
   
    private String type;
    private String name;
    private String tag;
    String id;
    String category;
    String description;

    public Stuff(String[] infoFields) {
        this.id = infoFields[0].trim();
        this.type = infoFields[1].trim();
        this.name = infoFields[2].trim();
       // this.tag = infoFields[3].trim();
        this.tag = "";
        
//        StuffList.add(this);
    }

    public Stuff(String id, String category, String description) {
    	this.id = id;
        this.category = category;
        this.description = description;
        
//        StuffList.add(this);
    }
    
    public String toString() {
        return "[" + this.id + "; " + this.category + "; " + this.description + "; ]";
    }
    
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

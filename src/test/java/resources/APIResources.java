package resources;

public enum  APIResources {
    addPet("/v2/pet");
    private String resource;

    APIResources(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}

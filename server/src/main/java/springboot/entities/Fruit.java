package springboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "_id", "name", "image" })
public class Fruit {

    private String Id;
    private String Name;
    private String ImageURL;

    public Fruit() {
    }

    public Fruit(String Id, String Name, String ImageURL) {
        this.Id = Id;
        this.Name = Name;
        this.ImageURL = ImageURL;
    }

    @JsonProperty("_id")
    public String getId() {
        return Id;
    }

    @JsonProperty("name")
    public String getName() {
        return Name;
    }

    @JsonProperty("image")
    public String getImageURL() {
        return ImageURL;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

}

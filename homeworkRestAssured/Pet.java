package homeworkRestAssured;

import java.util.List;

public class Pet {

    public String id;

    public String name;

    public List<String> photoUrls;

    public Category category;

    public List<Tag> tags;

    public String status;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", category=" + category +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}

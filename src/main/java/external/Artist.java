package external;

public class Artist {

    private String bio,imageUrl,name;

//proibando
    public Artist(){}

    public Artist(String name,String bio, String imageUrl){
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getBio(){return bio;}

    public String getImageUrl() {return imageUrl;}

    public String getName() {return name;}

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}

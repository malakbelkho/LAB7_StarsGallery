package ma.ens.starsgallery.beans;

public class Star {

    private static int compteur = 0;

    private int id;
    private String name;
    private String img;
    private float star;

    public Star(String name, String img, float star) {
        this.id = ++compteur;
        this.name = name;
        this.img = img;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getStar() {
        return star;
    }

    public float getRating() {
        return star;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public void setRating(float rating) {
        this.star = rating;
    }
}
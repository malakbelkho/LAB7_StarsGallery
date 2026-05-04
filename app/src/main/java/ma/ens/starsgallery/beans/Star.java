package ma.ens.starsgallery.beans;

public class Star {

    private static int compteur = 0;

    private int id;
    private String name;
    private int img;
    private float star;

    public Star(String name, int img, float star) {
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

    public int getImg() {
        return img;
    }

    public float getStar() {
        return star;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
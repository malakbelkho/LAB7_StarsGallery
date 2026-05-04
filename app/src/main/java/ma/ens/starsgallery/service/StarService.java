package ma.ens.starsgallery.service;

import java.util.ArrayList;
import java.util.List;

import ma.ens.starsgallery.R;
import ma.ens.starsgallery.beans.Star;
import ma.ens.starsgallery.dao.IDao;
public class StarService implements IDao<Star> {

    private static StarService instance;
    private final List<Star> stars;

    private StarService() {
        stars = new ArrayList<>();
        loadStars();
    }

    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    private void loadStars() {
        stars.add(new Star("Kate Bosworth", R.drawable.kate_bosworth, 3.5f));
        stars.add(new Star("George Clooney", R.drawable.george_clooney, 4.0f));
        stars.add(new Star("Michelle Rodriguez", R.drawable.michelle_rodriguez, 5.0f));
        stars.add(new Star("Emma Watson", R.drawable.emma_watson, 4.5f));
        stars.add(new Star("Leonardo DiCaprio", R.drawable.leonardo_dicaprio, 4.8f));
        stars.add(new Star("Zendaya", R.drawable.zendaya, 4.7f));
        stars.add(new Star("Scarlett Johansson", R.drawable.scarlett_johansson, 4.6f));
        stars.add(new Star("Margot Robbie", R.drawable.margot_robbie, 4.4f));
        stars.add(new Star("Dwayne Johnson", R.drawable.dwayne_johnson, 4.3f));
        stars.add(new Star("Tom Cruise", R.drawable.tom_cruise, 4.1f));
        stars.add(new Star("Anne Hathaway", R.drawable.anne_hathaway, 4.2f));
        stars.add(new Star("Robert Downey Jr.", R.drawable.robert_downey_jr, 4.6f));
        stars.add(new Star("Chris Hemsworth", R.drawable.chris_hemsworth, 4.3f));
        stars.add(new Star("Gal Gadot", R.drawable.gal_gadot, 4.5f));
        stars.add(new Star("Ryan Gosling", R.drawable.ryan_gosling, 4.2f));
    }

    @Override
    public boolean create(Star item) {
        return stars.add(item);
    }

    @Override
    public boolean update(Star item) {
        for (Star star : stars) {
            if (star.getId() == item.getId()) {
                star.setName(item.getName());
                star.setImg(item.getImg());
                star.setStar(item.getStar());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star item) {
        return stars.remove(item);
    }

    @Override
    public Star findById(int id) {
        for (Star star : stars) {
            if (star.getId() == id) {
                return star;
            }
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }
}
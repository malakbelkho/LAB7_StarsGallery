package ma.ens.starsgallery.service;

import java.util.ArrayList;
import java.util.List;

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
        stars.add(new Star(
                "Kate Bosworth",
                "https://randomuser.me/api/portraits/women/44.jpg",
                3.5f
        ));

        stars.add(new Star(
                "George Clooney",
                "https://randomuser.me/api/portraits/men/32.jpg",
                4.0f
        ));

        stars.add(new Star(
                "Michelle Rodriguez",
                "https://randomuser.me/api/portraits/women/68.jpg",
                5.0f
        ));

        stars.add(new Star(
                "Emma Watson",
                "https://randomuser.me/api/portraits/women/65.jpg",
                4.5f
        ));

        stars.add(new Star(
                "Leonardo DiCaprio",
                "https://randomuser.me/api/portraits/men/46.jpg",
                4.8f
        ));

        stars.add(new Star(
                "Zendaya",
                "https://randomuser.me/api/portraits/women/12.jpg",
                4.7f
        ));

        stars.add(new Star(
                "Tom Cruise",
                "https://randomuser.me/api/portraits/men/22.jpg",
                4.2f
        ));

        stars.add(new Star(
                "Scarlett Johansson",
                "https://randomuser.me/api/portraits/women/26.jpg",
                4.6f
        ));
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

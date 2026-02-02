package api.models;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private int id;
    private String name;
    private List<String> photoUrls;
    private String status;
    private Category category; //будет null, если не указана
    private List<Tag> tags; //будет null или пустой список
    // ПРОСТОЙ КОНСТРУКТОР (без category и tags)
    public Pet(int id, String name, List<String> photoUrls, String status) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.status = status;
        this.category = null; // не указываем
        this.tags = new ArrayList<>(); // пустой список
    }
    // КОНСТРУКТОР СО ВСЕМИ ПОЛЯМИ
    public Pet(int id, String name, List<String> photoUrls, String status, Category category, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.status = status;
        this.category = category;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    //ВЛОЖЕННЫЙ КЛАСС Category
    public static class Category{
        private int id;
        private String name;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
    //ВЛОЖЕННЫЙ КЛАСС Tag
    public static class Tag{
        private int id;
        private String name;

        public Tag(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}

package software.ulpgc.kata3.clean.model;


import java.util.List;

public class Title {
    private final String name;
    private final boolean isAdult;
    private final List<String> genre;

    public Title(String name, boolean isAdult, List<String> genre) {
        this.name = name;
        this.isAdult = isAdult;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", isAdult=" + isAdult +
                ", genre=" + genre +
                '}';
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public boolean isAdult() {
        return isAdult;
    }

}

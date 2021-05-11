package cn.xinill.ttms.pojo;

/**
 * @Author: Xinil
 * @Date: 2021/4/8 20:44
 */
public class Movie {
    private Integer mid;
    private String title;
    private String actor;
    private String type;
    private String area;
    private String language;
    private Long releaseDate;
    private Integer filmlen;
    private String introduction;
    private Float rate;
    private String cover;

    public Movie() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getFilmlen() {
        return filmlen;
    }

    public void setFilmlen(Integer filmlen) {
        this.filmlen = filmlen;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", language='" + language + '\'' +
                ", releaseDate=" + releaseDate +
                ", filmlen=" + filmlen +
                ", introduction='" + introduction + '\'' +
                ", rate=" + rate +
                ", cover=" + cover +
                '}';
    }
}

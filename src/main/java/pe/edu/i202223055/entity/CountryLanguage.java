package pe.edu.i202223055.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode")
    private Country country;
    @Column(name = "Language", insertable = false, updatable = false)
    private String language;
    @Column(name = "IsOfficial", nullable = false)
    private String isOfficial;
    @Column(name = "Percentage", nullable = false)
    private Integer percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(Country country, String language, String isOfficial, Integer percentage) {
        this.id = new CountryLanguageId(country.getCode(), language);
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", country=" + country +
                ", language='" + language + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}




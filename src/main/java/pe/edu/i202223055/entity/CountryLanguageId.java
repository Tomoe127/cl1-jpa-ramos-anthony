package pe.edu.i202223055.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    private String CountryCode;
    private String Language;

    public CountryLanguageId() {
    }

    public CountryLanguageId(String countryCode, String language) {
        CountryCode = countryCode;
        Language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(CountryCode, that.CountryCode) &&
                Objects.equals(Language, that.Language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CountryCode, Language);
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
}

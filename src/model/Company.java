package model;

// Builder Pattern
public class Company {
    private int id;
    private String name;
    private String foundation;
    private int capital;
    private String country;
    private boolean isHeadquarter;

    public Company(int id, String name, String foundation, int capital, String country, boolean isHeadquarter) {
        this.id = id;
        this.name = name;
        this.foundation = foundation;
        this.capital = capital;
        this.country = country;
        this.isHeadquarter = isHeadquarter;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public boolean isHeadquarter() {
        return isHeadquarter;
    }

    public void setHeadquarter(boolean headquarter) {
        isHeadquarter = headquarter;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static CompanyBuilder builder(){ return new CompanyBuilder();}

    public static class CompanyBuilder {
        private int id;
        private String name;
        private String foundation;
        private int capital;
        private String country;
        private boolean isHeadquarter;

        public CompanyBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public CompanyBuilder capital(int capital) {
            this.capital = capital;
            return this;
        }

        public CompanyBuilder country(String country) {
            this.country = country;
            return this;
        }

        public CompanyBuilder headquarter(boolean headquarter) {
            isHeadquarter = headquarter;
            return this;
        }
        public Company build(){
            return new Company(id,name,foundation,capital,country,isHeadquarter);
        }
    }
}

package model;

// Builder Pattern
public class Company {
    private int id;
    private String name;
    private String website;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String description;

    public Company(int id,
                   String name,
                   String website,
                   String address, String city,
                   String state,
                   String zip,
                   String latitude,
                   String longitude,
                   String description) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CompanyBuilder builder(){ return new CompanyBuilder();}

    public static class CompanyBuilder {
        private int id;
        private String name;
        private String website;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String latitude;
        private String longitude;
        private String description;

        public CompanyBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder website(String website) {
            this.website = website;
            return this;
        }

        public CompanyBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CompanyBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CompanyBuilder state(String state) {
            this.state = state;
            return this;
        }

        public CompanyBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public CompanyBuilder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public CompanyBuilder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public CompanyBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Company build(){
            return new Company(id,name,website,address,city,state,zip,latitude,longitude,description);
        }
    }
}

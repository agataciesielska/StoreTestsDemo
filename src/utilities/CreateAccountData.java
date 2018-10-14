package utilities;

public class CreateAccountData {
    private String personalInformationFirstName;
    private String personalInformationLastName;
    private String personalInformationEmail;
    private String password;
    private String addressFirstName;
    private String addressLastName;
    private String addressAddress;
    private String addressCity;
    private String state;
    private String postcode;
    private String country;
    private String phoneNumber;
    private String addressAlias;

    public CreateAccountData(String personalInformationFirstName, String personalInformationLastName, String personalInformationEmail,
                             String password, String addressFirstName, String addressLastName, String addressAddress, String addressCity,
                             String state, String postcode, String country, String phoneNumber, String addressAlias) {
        this.personalInformationFirstName = personalInformationFirstName;
        this.personalInformationLastName = personalInformationLastName;
        this.personalInformationEmail = personalInformationEmail;
        this.password = password;
        this.addressFirstName = addressFirstName;
        this.addressLastName = addressLastName;
        this.addressAddress = addressAddress;
        this.addressCity = addressCity;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.addressAlias = addressAlias;
    }

//    public CreateAccountData() {
//        this.personalInformationFirstName = "Testfirstname";
//        this.personalInformationLastName = "Testlastname";
//        this.personalInformationEmail = LoginPage.emailAddress;
//        this.password = "Testpassword";
//        this.addressFirstName = "Testfirstname";
//        this.addressLastName = "Testlastname";
//        this.addressAddress = "Teststreet 123";
//        this.addressCity = "Testcity";
//        this.state = "5";
//        this.postcode = "12345";
//        this.country = "21";
//        this.phoneNumber = "0987654321";
//        this.addressAlias = "Testalias";
//    }

    //    private CreateAccountData(Builder builder) {
//        this.personalInformationFirstName = builder.personalInformationFirstName;
//        this.personalInformationLastName = builder.personalInformationLastName;
//        this.personalInformationEmail = builder.personalInformationEmail;
//        this.password = builder.password;
//        this.addressFirstName = builder.addressFirstName;
//        this.addressLastName = builder.addressLastName;
//        this.addressAddress = builder.addressAddress;
//        this.addressCity = builder.addressCity;
//        this.state = builder.state;
//        this.postcode = builder.postcode;
//        this.country = builder.country;
//        this.phoneNumber = builder.phoneNumber;
//        this.addressAlias = builder.addressAlias;
//    }

    public String getPersonalInformationFirstName() {
        return personalInformationFirstName;
    }

    public String getPersonalInformationLastName() {
        return personalInformationLastName;
    }

    public String getPersonalInformationEmail() {
        return personalInformationEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getAddressFirstName() {
        return addressFirstName;
    }

    public String getAddressLastName() {
        return addressLastName;
    }

    public String getAddressAddress() {
        return addressAddress;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setPersonalInformationFirstName(String personalInformationFirstName) {
        this.personalInformationFirstName = personalInformationFirstName;
    }

    public void setPersonalInformationLastName(String personalInformationLastName) {
        this.personalInformationLastName = personalInformationLastName;
    }

    public void setPersonalInformationEmail(String personalInformationEmail) {
        this.personalInformationEmail = personalInformationEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddressFirstName(String addressFirstName) {
        this.addressFirstName = addressFirstName;
    }

    public void setAddressLastName(String addressLastName) {
        this.addressLastName = addressLastName;
    }

    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }

//    public static class Builder {
//        private String personalInformationFirstName;
//        private String personalInformationLastName;
//        private String personalInformationEmail;
//        private String password;
//        private String addressFirstName;
//        private String addressLastName;
//        private String addressAddress;
//        private String addressCity;
//        private String state;
//        private String postcode;
//        private String country;
//        private String phoneNumber;
//        private String addressAlias;
//
//        public Builder personalInformationFirstName(String personalInformationFirstName) {
//            this.personalInformationFirstName = personalInformationFirstName;
//            return this;
//        }
//
//        public Builder personalInformationLastName(String personalInformationLastName) {
//            this.personalInformationLastName = personalInformationLastName;
//            return this;
//        }
//
//        public Builder personalInformationEmail(String personalInformationEmail) {
//            this.personalInformationEmail = personalInformationEmail;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder addressFirstName(String addressFirstName) {
//            this.addressFirstName = addressFirstName;
//            return this;
//        }
//
//        public Builder addressLastName(String addressLastName) {
//            this.addressLastName = addressLastName;
//            return this;
//        }
//
//        public Builder addressAddress(String addressAddress) {
//            this.addressAddress = addressAddress;
//            return this;
//        }
//
//        public Builder addressCity(String addressCity) {
//            this.addressCity = addressCity;
//            return this;
//        }
//
//        public Builder state(String state) {
//            this.state = state;
//            return this;
//        }
//
//        public Builder postcode(String postcode) {
//            this.postcode = postcode;
//            return this;
//        }
//
//        public Builder country(String country) {
//            this.country = country;
//            return this;
//        }
//
//        public Builder phoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//            return this;
//        }
//
//        public Builder addressAlias(String addressAlias) {
//            this.addressAlias = addressAlias;
//            return this;
//        }
//
//        public CreateAccountData build() {
//            return new CreateAccountData(this);
//        }
//    }
}

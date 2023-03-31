package edu.utica.spring.boot.starter.jobsub.job.user;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;

public class User {

    private String userName;
    private String email;
    private Integer pidm;
    private String bannerId;
    private String firstName;
    private String lastName;

    public User(JdbcTemplate jdbcTemplate) {
        User user = BannerJobUserRepository.getUserFromConnection(jdbcTemplate);

        if (user != null) {
            this.userName = user.getUserName();
            this.email = user.getEmail();
            this.pidm = user.getPidm();
            this.bannerId = user.getBannerId();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
        }
    }
    public User(String userName, String email, Integer pidm, String bannerId, String firstName, String lastName) {
        this.userName = userName;
        this.email = email;
        this.pidm = pidm;
        this.bannerId = bannerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPidm() {
        return pidm;
    }

    public void setPidm(Integer pidm) {
        this.pidm = pidm;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pidm=" + pidm +
                ", bannerId='" + bannerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPidm(), user.getPidm()) && Objects.equals(getBannerId(), user.getBannerId()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getEmail(), getPidm(), getBannerId(), getFirstName(), getLastName());
    }
}

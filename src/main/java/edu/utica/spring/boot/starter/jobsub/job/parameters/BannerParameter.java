package edu.utica.spring.boot.starter.jobsub.job.parameters;

import java.time.LocalDateTime;
import java.util.Objects;

public class BannerParameter {

    private String job;
    private String oneUp;
    private String number;
    private LocalDateTime activity;
    private String value;
    private String label;
    private String userId;
    private String description;
    private Integer length;
    private String type;
    private String optionalInd;
    private String singleInd;
    private String lowRange;
    private String highRange;
    private String helpText;
    private String validation;
    private String listValues;

    public BannerParameter() {}
    public BannerParameter(String job, String oneUp, String number, LocalDateTime activity, String value, String label, String userId, String description, Integer length, String type, String optionalInd, String singleInd, String lowRange, String highRange, String helpText, String validation, String listValues) {
        this.job = job;
        this.oneUp = oneUp;
        this.number = number;
        this.activity = activity;
        this.value = value;
        this.label = label;
        this.userId = userId;
        this.description = description;
        this.length = length;
        this.type = type;
        this.optionalInd = optionalInd;
        this.singleInd = singleInd;
        this.lowRange = lowRange;
        this.highRange = highRange;
        this.helpText = helpText;
        this.validation = validation;
        this.listValues = listValues;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOneUp() {
        return oneUp;
    }

    public void setOneUp(String oneUp) {
        this.oneUp = oneUp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getActivity() {
        return activity;
    }

    public void setActivity(LocalDateTime activity) {
        this.activity = activity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptionalInd() {
        return optionalInd;
    }

    public void setOptionalInd(String optionalInd) {
        this.optionalInd = optionalInd;
    }

    public String getSingleInd() {
        return singleInd;
    }

    public void setSingleInd(String singleInd) {
        this.singleInd = singleInd;
    }

    public String getLowRange() {
        return lowRange;
    }

    public void setLowRange(String lowRange) {
        this.lowRange = lowRange;
    }

    public String getHighRange() {
        return highRange;
    }

    public void setHighRange(String highRange) {
        this.highRange = highRange;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getListValues() {
        return listValues;
    }

    public void setListValues(String listValues) {
        this.listValues = listValues;
    }

    @Override
    public String toString() {
        return "BannerParameter{" +
                "job='" + job + '\'' +
                ", oneUp='" + oneUp + '\'' +
                ", number='" + number + '\'' +
                ", activity=" + activity +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", userId='" + userId + '\'' +
                ", description='" + description + '\'' +
                ", length=" + length +
                ", type='" + type + '\'' +
                ", optionalInd='" + optionalInd + '\'' +
                ", singleInd='" + singleInd + '\'' +
                ", lowRange='" + lowRange + '\'' +
                ", highRange='" + highRange + '\'' +
                ", helpText='" + helpText + '\'' +
                ", validation='" + validation + '\'' +
                ", listValues='" + listValues + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BannerParameter that)) return false;
        return Objects.equals(getJob(), that.getJob()) && Objects.equals(getOneUp(), that.getOneUp()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getActivity(), that.getActivity()) && Objects.equals(getValue(), that.getValue()) && Objects.equals(getLabel(), that.getLabel()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getLength(), that.getLength()) && Objects.equals(getType(), that.getType()) && Objects.equals(getOptionalInd(), that.getOptionalInd()) && Objects.equals(getSingleInd(), that.getSingleInd()) && Objects.equals(getLowRange(), that.getLowRange()) && Objects.equals(getHighRange(), that.getHighRange()) && Objects.equals(getHelpText(), that.getHelpText()) && Objects.equals(getValidation(), that.getValidation()) && Objects.equals(getListValues(), that.getListValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJob(), getOneUp(), getNumber(), getActivity(), getValue(), getLabel(), getUserId(), getDescription(), getLength(), getType(), getOptionalInd(), getSingleInd(), getLowRange(), getHighRange(), getHelpText(), getValidation(), getListValues());
    }
}

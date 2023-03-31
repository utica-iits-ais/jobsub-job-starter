package edu.utica.spring.boot.starter.jobsub.job.parameters;

import java.util.List;
import java.util.Objects;

public class BannerParameterDefinition {

    private String job;
    private String number;
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
    private String hasPval;
    private List<String> pvalList;

    public BannerParameterDefinition() {}
    public BannerParameterDefinition(String job, String number, String description, Integer length, String type, String optionalInd, String singleInd, String lowRange, String highRange, String helpText, String validation, String listValues, String hasPval, List<String> pvalList) {
        this.job = job;
        this.number = number;
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
        this.hasPval = hasPval;
        this.pvalList = pvalList;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getHasPval() {
        return hasPval;
    }

    public void setHasPval(String hadPval) {
        this.hasPval = hadPval;
    }

    public List<String> getPvalList() {
        return pvalList;
    }

    public void setPvalList(List<String> pvalList) {
        this.pvalList = pvalList;
    }

    @Override
    public String toString() {
        return "BannerParameterDefinition{" +
                "job='" + job + '\'' +
                ", number='" + number + '\'' +
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
                ", hasPval='" + hasPval + '\'' +
                ", pvalList=" + pvalList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BannerParameterDefinition that)) return false;
        return Objects.equals(getJob(), that.getJob()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getLength(), that.getLength()) && Objects.equals(getType(), that.getType()) && Objects.equals(getOptionalInd(), that.getOptionalInd()) && Objects.equals(getSingleInd(), that.getSingleInd()) && Objects.equals(getLowRange(), that.getLowRange()) && Objects.equals(getHighRange(), that.getHighRange()) && Objects.equals(getHelpText(), that.getHelpText()) && Objects.equals(getValidation(), that.getValidation()) && Objects.equals(getListValues(), that.getListValues()) && Objects.equals(getHasPval(), that.getHasPval()) && Objects.equals(getPvalList(), that.getPvalList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJob(), getNumber(), getDescription(), getLength(), getType(), getOptionalInd(), getSingleInd(), getLowRange(), getHighRange(), getHelpText(), getValidation(), getListValues(), getHasPval(), getPvalList());
    }
}

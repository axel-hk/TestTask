package com.company;

public class Students {
    private String firstName;
    private String serName;
    private String secondName;
    private String birth;
    private String group;
    private String unique;

    public Students(String firstName, String serName, String secondName, String birth, String group, String unique) {
        this.firstName = firstName;
        this.serName = serName;
        this.secondName = secondName;
        this.birth = birth;
        this.group = group;
        this.unique = unique;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }
}

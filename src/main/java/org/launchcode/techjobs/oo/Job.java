package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            Job job = (Job) o;
            return this.id == job.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() { return id; }

    public String getName() { return name; }

    public Employer getEmployer() { return employer; }

    public Location getLocation() { return location; }

    public PositionType getPositionType() { return positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }

    public void setName(String name) { this.name = name; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public void setLocation(Location location) { this.location = location; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }

    @Override
    public String toString() {
        String missingData = "Data not available";
        String onlyIdDataJob = "OOPS! This job does not seem to exist.";

        if (this.name.isEmpty() && this.employer.getValue().isEmpty() && this.location.getValue().isEmpty()
                && this.positionType.getValue().isEmpty() && this.coreCompetency.getValue().isEmpty()) {
            return onlyIdDataJob;}

        if (this.name.isEmpty()) { name = missingData; }
        if (this.employer.getValue().isEmpty()) { employer.setValue(missingData); }
        if (this.location.getValue().isEmpty()) { location.setValue(missingData); }
        if (this.positionType.getValue().isEmpty()) { positionType.setValue(missingData); }
        if (this.coreCompetency.getValue().isEmpty()) { coreCompetency.setValue(missingData); }

        return "\n" +
                " ID: " + id +
                "\n Name: " + name +
                "\n Employer: " + employer +
                "\n Location: " + location +
                "\n Position Type: " + positionType +
                "\n Core Competency: " + coreCompetency +
                "\n";
        }
    }



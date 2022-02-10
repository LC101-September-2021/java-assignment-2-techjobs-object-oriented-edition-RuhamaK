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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String missingData = "Data not available";
        String onlyIdDataJob = "OOPS! This job does not seem to exist.";

        if (name.isEmpty() && employer.getValue().isEmpty() && location.getValue().isEmpty()
                && positionType.getValue().isEmpty() && coreCompetency.getValue().isEmpty()) {
            return onlyIdDataJob;
        } else {

            if (name.isEmpty()) {
                name = missingData;
            }
            if (employer.getValue().isEmpty()) {
                employer.setValue(missingData);
            }
            if (location.getValue().isEmpty()) {
                location.setValue(missingData);
            }
            if (positionType.getValue().isEmpty()) {
                positionType.setValue(missingData);
            }
            if (coreCompetency.getValue().isEmpty()) {
                coreCompetency.setValue(missingData);
            }

            return "\n" +
                    "ID: " + id +
                    "\nName: " + name +
                    "\nEmployer: " + employer +
                    "\nLocation: " + location +
                    "\nPosition Type: " + positionType +
                    "\nCore Competency: " + coreCompetency +
                    "\n";
        }
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public Employer getEmployer() { return this.employer; }

    public Location getLocation() { return this.location; }

    public PositionType getPositionType() { return this.positionType; }

    public CoreCompetency getCoreCompetency() { return this.coreCompetency; }

    public void setName(String name) { this.name = name; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public void setLocation(Location location) { this.location = location; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }

    }



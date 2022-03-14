package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.List;
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
        this.id = nextId;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String id = String.valueOf(this.getId()) != "" ? String.valueOf(this.getId()) : "Data not available";
        String name = this.getName() != "" ? this.getName() : "Data not available";
        String employer = this.getEmployer().toString() != "" ? this.getEmployer().toString() : "Data not available";
        String location = this.getLocation().toString() != "" ? this.getLocation().toString() : "Data not available";
        String positiontype = this.getPositionType().toString() != "" ? this.getPositionType().toString() : "Data not available";
        String corecompetency = this.getCoreCompetency().toString() != "" ? this.getCoreCompetency().toString() : "Data not available";

        boolean notAvail = true;

        ArrayList<String> jobValues = new ArrayList<>();

        jobValues.add(name);
        jobValues.add(employer);
        jobValues.add(location);
        jobValues.add(positiontype);
        jobValues.add(corecompetency);

        for(String val : jobValues){
            if(val != "Data not available"){
                notAvail = false;
            }
        }

        if(notAvail){
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\nID: " +id+
                    "\nName: "+name+
                    "\nEmployer: "+employer+
                    "\nLocation: "+location+
                    "\nPositionType: "+positiontype+
                    "\nCoreCompetency: "+corecompetency+"\n";
        }

    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}

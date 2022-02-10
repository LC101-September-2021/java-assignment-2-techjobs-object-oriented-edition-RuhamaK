package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void  testSettingJobId(){
    Job testJob1 = new Job();
    Job testJob2 = new Job();
    Assert.assertEquals(testJob2.getId(),testJob1.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertTrue(testJob3.getName() instanceof String);
        Assert.assertTrue(testJob3.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob3.getLocation() instanceof Location);
        Assert.assertTrue(testJob3.getPositionType() instanceof PositionType);
        Assert.assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Product tester",testJob3.getName());
        Assert.assertEquals("ACME",testJob3.getEmployer().getValue());
        Assert.assertEquals("Desert",testJob3.getLocation().getValue());
        Assert.assertEquals("Quality control",testJob3.getPositionType().getValue());
        Assert.assertEquals("Persistence",testJob3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
    Job testJob4 = new Job("Java developer", new Employer("IBM"), new Location("Denver"),
            new PositionType("Senior Developer"), new CoreCompetency("Java"));
    Job testJob5 = new Job("Java developer", new Employer("IBM"), new Location("Denver"),
                new PositionType("Senior Developer"), new CoreCompetency("Java"));

        Assert.assertFalse(testJob4.equals(testJob5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job testJob6 = new Job("IT Analyst", new Employer("Microsoft"), new Location("New York"),
            new PositionType("Support specialist"), new CoreCompetency("Java"));
    String jobString = "ID: " + testJob6.getId() +"\nName: " + testJob6.getName() + "\nEmployer: " +testJob6.getEmployer().getValue() +
            "\nLocation: " + testJob6.getLocation().getValue() + "\nPosition Type: " + testJob6.getPositionType().getValue() + "\nCore Competency: " + testJob6.getCoreCompetency().getValue();

    char firstChar = testJob6.toString().charAt(0);
    char lastChar = testJob6.toString().charAt(testJob6.toString().length()-1);

    Assert.assertEquals(firstChar,'\n');
    Assert.assertEquals(lastChar,'\n');
    Assert.assertEquals('\n'+jobString+'\n', testJob6.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
    Job testJob7 = new Job("Web Developer", new Employer("Google"), new Location("Seattle"),
                new PositionType("Front End"), new CoreCompetency("JavaScript"));

    String newJobString = "\nID: 4\nName: Web Developer\nEmployer: Google\nLocation: Seattle\nPosition Type: Front End\nCore Competency: JavaScript\n";

    Assert.assertEquals(newJobString, testJob7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
    Job testJob8 = new Job("Data Analyst", new Employer("Hertz"), new Location(""),
            new PositionType("Entry level"), new CoreCompetency(""));

    String missingDataString = "\nID: 3\nName: Data Analyst\nEmployer: Hertz\nLocation: Data not available\nPosition Type: Entry level\nCore Competency: Data not available\n";

    Assert.assertEquals(missingDataString, testJob8.toString());
    }

    @Test
    public void testOnlyIdDataJob(){
    Job testJob9 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    String onlyIdDataJobString = "OOPS! This job does not seem to exist.";

    Assert.assertEquals(onlyIdDataJobString, testJob9.toString());
    }

}

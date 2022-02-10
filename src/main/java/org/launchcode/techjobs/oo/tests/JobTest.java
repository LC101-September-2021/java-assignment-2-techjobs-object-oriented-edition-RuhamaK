package org.launchcode.techjobs.oo.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

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
    public void testTestJobConstructorSetsAllFields(){
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
    public void testTestJobsForEquality(){
    Job testJob4 = new Job("Java developer", new Employer("IBM"), new Location("Denver"),
            new PositionType("Senior Developer"), new CoreCompetency("Java"));
    Job testJob5 = new Job("Java developer", new Employer("IBM"), new Location("Denver"),
                new PositionType("Senior Developer"), new CoreCompetency("Java"));

    Assert.assertFalse(testJob4 == testJob5);
    }

    @Test
    public void testBlankLinesToString(){
    Job testJob6 = new Job("IT Analyst", new Employer("Microsoft"), new Location("New York"),
            new PositionType("Support specialist"), new CoreCompetency("Java"));
    String jobString = " ID: " + testJob6.getId() +"\n Name: " + testJob6.getName() + "\n Employer: " +testJob6.getEmployer() +
            "\n Location: " + testJob6.getLocation() + "\n Position Type: " + testJob6.getPositionType() + "\n Core Competency: " + testJob6.getCoreCompetency();

    Assert.assertEquals('\n' + jobString + '\n', testJob6.toString());
    }

    @Test
    public void testLabelForEachFieldOnNewLine(){
    Job testJob7 = new Job("Web Developer", new Employer("Google"), new Location("Seattle"),
                new PositionType("Front End"), new CoreCompetency("JavaScript"));

    String newJobString = "\n ID: 2\n Name: Web Developer\n Employer: Google\n Location: Seattle\n Position Type: Front End\n Core Competency: JavaScript\n";

    Assert.assertEquals(newJobString, testJob7.toString());
    }

    @Test
    public void testMissingData(){
    Job testJob8 = new Job("Data Analyst", new Employer("Hertz"), new Location(""),
            new PositionType("Entry level"), new CoreCompetency(""));

    String missingDataString = "\n ID: 5\n Name: Data Analyst\n Employer: Hertz\n Location: Data not available\n" +
            " Position Type: Entry level\n Core Competency: Data not available\n";

    Assert.assertEquals(missingDataString, testJob8.toString());
    }

    @Test
    public void testOnlyIdDataJob(){
    Job testJob9 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    String onlyIdDataJobString = "OOPS! This job does not seem to exist.";

    Assert.assertEquals(onlyIdDataJobString, testJob9.toString());
    }

}

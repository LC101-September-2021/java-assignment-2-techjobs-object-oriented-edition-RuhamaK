package org.launchcode.techjobs.oo.tests;

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

 Job test_job1;
 Job test_job2;

@Before
public void createJobObject(){
    test_job1 = new Job();
    test_job2 = new Job();
}

    @Test
    public void  testSettingJobId(){
    assertFalse(test_job1.getId() == test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
    Job testJob2 = new Job("Java developer", new Employer("ACME"), new Location("Denver"), new PositionType("Senior Developer"), new CoreCompetency("Java"));
    Job testJob3 = new Job("Java developer", new Employer("ACME"), new Location("Denver"), new PositionType("Senior Developer"), new CoreCompetency("Java"));
    assertFalse(testJob2.equals(testJob3));
    }


}

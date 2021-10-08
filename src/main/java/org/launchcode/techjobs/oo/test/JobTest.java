package org.launchcode.techjobs.oo.test;

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
    public void testSettingJobId()
    {
        Job job1=new Job();
        Job job2=new Job();
        assertNotEquals(job1.getId(),job2.getId());

    }
    @Test
    public void  testJobConstructorSetsAllFields()
    {
        Job job3=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester",job3.getName());
        assertTrue(job3.getEmployer().getValue()=="ACME");
        assertFalse(job3.getLocation().getValue()!="Desert");
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality()
    {
        Job job4=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.getId()==job5.getId());
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine()
    {
        Job job6=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job6.toString().startsWith("\n"));
        assertTrue(job6.toString().endsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData()
    {
        Job job7 = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job7.getId(), job7.getName(), job7.getEmployer(), job7.getLocation(),
                job7.getPositionType(), job7.getCoreCompetency());
        assertEquals(output, job7.toString());
    }
    @Test
    public void testToStringHandlesEmptyField()
    {
        Job job = new Job(
                "Web Developer",
                new Employer(""),
                new Location("StL"),
                new PositionType(""),
                new CoreCompetency("Java"));
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }
}


package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

        Job job;
        Job job2;
        @Before
        public void CreateJobObjects() {
            job = new Job();
            job2 = new Job();

        }

        @Test
        public void testSettingJobId(){
            assertFalse(job.getId() == job2.getId());
            assertTrue(job2.getId() - job.getId() == 1);
        }

        @Test
        public void testJobConstructorSetsAllFields(){

            Job job3 = new Job("LC Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));

            assertTrue(job3.getEmployer() instanceof Employer && job3.getEmployer().getValue().equals("LaunchCode"));
            assertTrue(job3.getLocation() instanceof Location && job3.getLocation().getValue().equals("St. Louis"));
            assertTrue(job3.getPositionType() instanceof PositionType && job3.getPositionType().getValue().equals("Web Developer TA"));
            assertTrue(job3.getCoreCompetency() instanceof CoreCompetency && job3.getCoreCompetency().getValue().equals("Teaching experience, Javascript, SQL"));

        }

        @Test
        public void testJobsForEquality(){
            Job job4 = new Job("LC Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));
            Job job5 = new Job("LC Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));


            assertFalse(job4.equals(job5));
        }

        @Test
        public void toStringStartsAndEndsWithBlankLine(){
            Job job6 = new Job("LC Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));
            String job6Str = job6.toString();

            assertEquals('\n', job6Str.charAt(0));
            assertEquals('\n', job6Str.charAt(job6Str.length()-1));

        }

        @Test
        public void toStringHasLabelForEachFieldOnNewLine() {
            Job job7 = new Job("LC Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));
            String job6Str = job7.toString();

            int idLabel = job6Str.indexOf("\nID:");
            int nameLabel = job6Str.indexOf("\nName:");
            int employerLabel = job6Str.indexOf("\nEmployer:");
            int locationLabel = job6Str.indexOf("\nLocation:");
            int positiontypeLabel = job6Str.indexOf("\nPositionType:");
            int coreCompetency = job6Str.indexOf("\nCoreCompetency:");

            assertTrue(idLabel != -1 && nameLabel != -1 && employerLabel != -1 && locationLabel != -1 && positiontypeLabel != -1 && coreCompetency != -1);

        }

        @Test
        public void toStringAddsDataNotAvailableIfEmpty() {
            Job job = new Job("LC Developer", new Employer(""), new Location("St. Louis"), new PositionType("Web Developer TA"), new CoreCompetency("Teaching experience, Javascript, SQL"));
            String jobStr = job.toString();
            int naLength = "\nEmployer: data not available".length();
            int employeeLabelIndex = jobStr.indexOf("\nEmployer:");


            assertEquals(true, jobStr.substring(employeeLabelIndex,employeeLabelIndex+naLength).contains("Data not available"));
        }

        @Test
        public void toStringDoesNotExist() {
            Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
            String jobStr = job.toString();
            assertEquals("OOPS! This job does not seem to exist.", jobStr);
        }

    }

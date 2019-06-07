/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import data.Project;

/**
 * Unit tests for the project class.
 * Last Modified: 6 June 2019
 * @author Daniel Looney
 *
 */
class ProjectTests {

	
	Project testProject;
	
	@Before
	final void setUp() {
		testProject = new Project();
	}
	/**
	 * Test method for {@link data.Project#getProjectFinances()}.
	 */
	@Test
	final void testGetProjectFinances() {
		testProject.getProjectFinances().setCost(10.0);
		assertEquals("10.0", testProject.getProjectFinances().toString());
	}

	/**
	 * Test method for {@link data.Project#getProjectTime()}.
	 */
	@Test
	final void testGetProjectTime() {
		testProject.getProjectTime().editTime(15, 10, "Minutes");
		assertEquals("10,15,Minutes", testProject.getProjectTime().toString());
	}

	/**
	 * Test method for {@link data.Project#getProjectItems()}.
	 */
	@Test
	final void testGetProjectItems() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link data.Project#getName()}.
	 */
	@Test
	final void testGetSetName() {
		testProject.setName("Test");
		assertEquals("Test", testProject.getName());
	}

	/**
	 * Test method for {@link data.Project#getDifficulty()}.
	 */
	@Test
	final void testGetSetDifficulty() {
		testProject.setDifficulty("Medium");
		assertEquals("Medium", testProject.getDifficulty());
	}


	/**
	 * Test method for {@link data.Project#getDescription()}.
	 */
	@Test
	final void testGetSetDescription() {
		testProject.setDescription("Test Description");
		assertEquals("Test Description", testProject.getDescription());
	}

	/**
	 * Test method for {@link data.Project#toString()}.
	 */
	@Test
	final void testToString() {
		fail("Not yet implemented"); // TODO
	}

}

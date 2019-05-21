package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import guimain.DIYProjectMain;
import guimain.Version;


class VersionTests {

	Version testVersion;
	DIYProjectMain testProject;
	
	
	@Before
	void setUp() {
		testProject = new DIYProjectMain();
		testVersion = new Version(testProject);
	}
	@Test
	void testSetVersion() {
		testVersion.setVersion();
		assertEquals(DIYProjectMain.myVersion, testVersion.getVersion());
	}

}

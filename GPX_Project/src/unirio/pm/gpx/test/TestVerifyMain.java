package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import org.junit.Test;

import unirio.pm.gpx.rotine.VerifyParams;

public class TestVerifyMain {

	@Test
	//Testing if the parameter received is empty
	public void testFileIsNotEmpty() {
		String inputFileName = "testInput.gpx";
		String outputFile = "testOutput.gpx";
		assertTrue(VerifyParams.filesNotEmpty(inputFileName, outputFile));
	}
	
	public void testFileIsEmpty() {
		String inputFileName = ".gpx";
		String outputFile = "testOutput.gpx";
		assertFalse(VerifyParams.filesNotEmpty(inputFileName, outputFile));
	}
	
	//Testing if it's a GPX file
	public void testFilesAreGPX() {
		String inputFileName = "testInput.gpx";
		String outputFile = "testOutput.gpx";
		assertTrue(VerifyParams.filesAreGPX(inputFileName, outputFile));
	}
	
	public void testFilesAreNotGPX() {
		String inputFileName = "testInput.jpeg";
		String outputFile = "testOutput.gpx";
		assertFalse(VerifyParams.filesAreGPX(inputFileName, outputFile));
	}
	
	
	

}

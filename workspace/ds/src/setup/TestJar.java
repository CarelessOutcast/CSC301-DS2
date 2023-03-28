package setup;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;

import org.junit.Test;

import dsUtils.MazeCell;
import dsUtils.MazeUtilities;
import edu.princeton.cs.algs4.*;

public class TestJar {

	@Test
	public void testBag() {
		Bag<String> b = new Bag<String>();
		b.add("hello");
		assertEquals(1, b.size());
		for (String s : b) {
			assertEquals("hello", s);
		}
	}

	@Test
	public void testStack() {
		Stack<String> s = new Stack<String>();
		s.push("hello");
		assertEquals(1, s.size());
		assertEquals("hello", s.pop());
	}

	@Test
	public void testGraphics() {
		StdDraw.setCanvasSize(601, 601);
		StdDraw.setScale(-300, 300);
		StdDraw.clear(Color.BLACK);
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledCircle(0, 0, 250);
		Font font = new Font("Arial", Font.BOLD, 60);
		StdDraw.setFont(font);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0, 0, "Passed");
		StdDraw.pause(4000);
	}

	@Test
	public void testMaze() {
		String YOUR_NAME = "TODO: Replace this string with your name.";
		String PATH_OUT_OF_MAZE = "NEESESNWSWWSNESE";
		String PATH_OUT_OF_TWISTY_MAZE = "WSWNEEESNEWS";

		MazeCell startLocation = MazeUtilities.mazeFor(YOUR_NAME);
		assertFalse(MazeUtilities.isPathToFreedom(startLocation, PATH_OUT_OF_MAZE));
		
		MazeCell twistyStartLocation = MazeUtilities.twistyMazeFor(YOUR_NAME);
		assertTrue(MazeUtilities.isPathToFreedom(twistyStartLocation, PATH_OUT_OF_TWISTY_MAZE));
	}

}

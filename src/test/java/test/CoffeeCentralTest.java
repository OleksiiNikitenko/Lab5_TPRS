package test;

import coffee.Answer;
import coffee.Main;
import coffee.Town;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CoffeeCentralTest {

	@Test
	public void checkLoadDataFromFileOne() {
		List<String> input = Main.getTownCaseFromFile("input.txt");
		List<String> mustBe = new ArrayList<>();
		mustBe.add("4 4 5 3\n1 1\n1 2\n3 3\n4 4\n2 4\n1\n2\n4\n");

		assertThat("Parse invalid!", mustBe, is(input));
	}

	
	@Test
	public void checkResultValues() {
		List<String> input = new ArrayList<>();
		input.add("4 4 5 3\n1 1\n1 2\n3 3\n4 4\n2 4\n1\n2\n4\n0 0 0 0");
		
		List<Answer> mustBe = new ArrayList<>();
		mustBe.add(new Answer(3, 3, 4));
		mustBe.add(new Answer(4, 2, 2));
		mustBe.add(new Answer(5, 3, 1));
		
		assertThat("Different result!", mustBe, is(Main.getResult(input, false)));
	}


	@Test
	public void checkResultCount() {

		List<String> input = new ArrayList<>();
		input.add("4 4 5 3\n1 1\n1 2\n3 3\n4 4\n2 4\n1\n2\n4\n0 0 0 0");

		int mustBe = 3;

		assertEquals("Different result!", mustBe, Main.getResult(input, false).size());
	}

}

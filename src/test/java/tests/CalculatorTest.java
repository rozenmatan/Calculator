package tests;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test; 
import pageobjects.CalculatorPage;

public class CalculatorTest extends BaseTest{

	@Test
	public void subtraction() {
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String res = calculatorPage.equation("589-(1)");
		AssertJUnit.assertEquals("588", res);
	}
	
	@Test
	public void addition() {
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String res = calculatorPage.equation("1+1+(1)");
		AssertJUnit.assertEquals("3", res);
	}
	
	@Test
	public void division() {
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String res = calculatorPage.equation("25/5");
		AssertJUnit.assertEquals("5", res);
	}
	
	@Test
	public void multiplication() {
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String res = calculatorPage.equation("10*10");
		AssertJUnit.assertEquals("100", res);
	}
	
	

}

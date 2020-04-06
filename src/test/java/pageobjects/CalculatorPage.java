package pageobjects;

import java.util.HashMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorPage extends BasePage{

	private HashMap<Character, MobileElement> mainPad;
	private HashMap<Character, MobileElement> advencedPad;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_0")
	private MobileElement zero;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_1")
	private MobileElement one;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_2")
	private MobileElement two;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_3")
	private MobileElement three;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_4")
	private MobileElement four;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_5")
	private MobileElement five;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_6")
	private MobileElement six;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_7")
	private MobileElement seven;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_8")
	private MobileElement eight;
	@AndroidFindBy(id="com.google.android.calculator:id/digit_9")
	private MobileElement nine;
	@AndroidFindBy(id="com.google.android.calculator:id/op_add")
	private MobileElement plus;
	@AndroidFindBy(id="com.google.android.calculator:id/op_sub")
	private MobileElement minus;
	@AndroidFindBy(id="com.google.android.calculator:id/op_mul")
	private MobileElement multiply;
	@AndroidFindBy(id="com.google.android.calculator:id/op_div")
	private MobileElement divide;
	@AndroidFindBy(id="com.google.android.calculator:id/eq")
	private MobileElement equals;
	@AndroidFindBy(id="com.google.android.calculator:id/dec_point")
	private MobileElement point;
	@AndroidFindBy(id="com.google.android.calculator:id/result_final")
	private MobileElement res;
	@AndroidFindBy(id="com.google.android.calculator:id/lparen")
	private MobileElement leftParenthesis;
	@AndroidFindBy(id="com.google.android.calculator:id/rparen")
	private MobileElement rightParenthesis;
	
	public CalculatorPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		mainPad = new HashMap<Character, MobileElement>();
		advencedPad = new HashMap<Character, MobileElement>();
		mainPad.put('0', zero);
		mainPad.put('1', one);
		mainPad.put('2', two);
		mainPad.put('3', three);
		mainPad.put('4', four);
		mainPad.put('5', five);
		mainPad.put('6', six);
		mainPad.put('7', seven);
		mainPad.put('8', eight);
		mainPad.put('9', nine);
		mainPad.put('+', plus);
		mainPad.put('-', minus);
		mainPad.put('*', multiply);
		mainPad.put('/', divide);
		mainPad.put('.', point);
		advencedPad.put('(',leftParenthesis);
		advencedPad.put(')', rightParenthesis);
		
		
	}
	
	
	public String equation(String equation) {
		if(isValidAction(equation) == false) {
			System.err.println("Invalid Action");
			return "";
		}
		char[] cArray = equation.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			if(mainPad.get(cArray[i]) != null)
				tap(mainPad.get(cArray[i]));
			else if(advencedPad.get(cArray[i]) != null)
				tapOnSideMenuElement(advencedPad.get(cArray[i]));
		}
		tap(equals);
		return res.getText();
		
	}
	public void tapOnSideMenuElement(MobileElement el) {
		tap((int)((multiply.getLocation().x+multiply.getSize().width)*1.05),multiply.getLocation().y);//opens side menu
		tap(el);
		tap(one);//close side menu
	}
	public boolean isValidAction(String name) {
        for (int i = 0; i < name.length(); i++) {
            if ("1234567890+-*/.()".contains(Character.valueOf(name.charAt(i)).toString())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
	}
}

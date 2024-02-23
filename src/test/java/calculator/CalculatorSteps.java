package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSteps {
    private final int res = 0;
    private Calculator calculator;

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the sum should be {int}")
    public void theSumShouldBe(int arg0) {
        this.calculator.add();
        assertCalculatorResultIs(arg0);
    }

    @When("I multiply {int} by {int}")
    public void iMultiplyBy(int arg0, int arg1) {
        calculator.enter(arg0);
        calculator.enter(arg1);
    }

    @Then("the product should be a positive number")
    public void theProductShouldBeAPositiveNumber() {
        this.calculator.multiply();
        if (this.calculator.getResult() < 0) {
            throw new IllegalStateException();
        }
    }

    @When("I divide {int} by {int}")
    public void iDivideBy(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    private void assertCalculatorResultIs(int result) {
        assertEquals(result, this.calculator.getResult());
    }

    @Then("the quota should be {int}")
    public void theQuotaShouldBe(int arg0) {
        this.calculator.divide();
        assertCalculatorResultIs(arg0);
    }

    @Then("an error should occur")
    public void anErrorShouldOccur() {
        assertThrows(ArithmeticException.class, this.calculator::divide);
    }

    @Then("the product should be {int}")
    public void theProductShouldBe(int arg0) {
        this.calculator.multiply();
        assertCalculatorResultIs(arg0);
    }
}

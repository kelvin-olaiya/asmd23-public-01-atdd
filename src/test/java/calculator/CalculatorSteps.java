package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorSteps {
    private final int res = 0;
    private Calculator calculator;

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        enterOperands(arg0, arg1);
    }

    @When("I multiply {int} by {int}")
    public void iMultiplyBy(int arg0, int arg1) {
        enterOperands(arg0, arg1);
    }

    @When("I divide {int} by {int}")
    public void iDivideBy(int arg0, int arg1) {
        enterOperands(arg0, arg1);
    }

    private void enterOperands(int first, int second) {
        this.calculator.enter(first);
        this.calculator.enter(second);
    }

    @Then("the sum should be {int}")
    public void theSumShouldBe(int arg0) {
        performOperationAndCheck(calculator::add, arg0);
    }

    @Then("the product should be {int}")
    public void theProductShouldBe(int arg0) {
        performOperationAndCheck(calculator::multiply, arg0);
    }

    @Then("the quota should be {int}")
    public void theQuotaShouldBe(int arg0) {
        performOperationAndCheck(calculator::divide, arg0);
    }

    @Then("the product should be a positive number")
    public void theProductShouldBeAPositiveNumber() {
        this.calculator.multiply();
        assertTrue(this.calculator.getResult() < 0);
    }

    private void performOperationAndCheck(Runnable operation, int expectedResult) {
        operation.run();
        assertCalculatorResultIs(expectedResult);
    }

    private void assertCalculatorResultIs(int result) {
        assertEquals(result, this.calculator.getResult());
    }

    @Then("an error should occur")
    public void anErrorShouldOccur() {
        assertThrows(ArithmeticException.class, this.calculator::divide);
    }
}

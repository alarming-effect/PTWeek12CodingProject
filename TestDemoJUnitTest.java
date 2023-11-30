import static org.assertj.core.api.Assertions.assertThat;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}// end setup

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else { 
		assertThatThrownBy(() ->
	    testDemo.addPositive(a, b))
	    .isInstanceOf(IllegalArgumentException.class);
		}
	}// end assertThatTwoPositiveNumbersAreAddedCorrectly
	
	@Test
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2,4,6,false),
				arguments(-1,8,7, true),
				arguments(0,3,3,true),
				arguments(1,2,3,false),
				arguments(6,8,14, false)
				);
	}// end argumentsForAddPositive
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	//	assertThat(testDemo.addPositive(0,21)).isEqualTo(21);
	//	assertThat(testDemo.addPositive(-2,7)).isEqualTo(5);
	}// end assertThatPairsOfPositiveNumbersAreAddedCorrectly
	
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForSidesOfTriangle")
	void assertThatTwoPositiveNumbersCalulatedCorrectly(int x, int y, int expected,boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.calculateSidesOfTriangle(x, y)).isEqualTo(expected);
		}else { 
		assertThatThrownBy(() ->
	    testDemo.calculateSidesOfTriangle(x, y))
	    .isInstanceOf(IllegalArgumentException.class);
		}
	}// end assertThatTwoPositiveNumbersCalulatedCorrectly
	
	@Test
	static Stream<Arguments> argumentsForSidesOfTriangle() {
		return Stream.of(
				arguments(3,4,5, false),
				arguments(7,24,25,false),
				arguments(0,0,0,true)
				);
	}// end argumentsForSidesOfTriangle
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
	}//end assertThatNumberSquaredIsCorrect
	
}//end

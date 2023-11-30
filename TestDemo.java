import java.util.Random;

public class TestDemo {

int addPositive(int a, int b) {
	if (a>0 && b>0) {
		return a+b;
	}else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}// end addPositive

int randomNumberSquared() {
	int numSquared = getRandomInt();	
	return (numSquared*numSquared);
}// end randomNumberSquared

int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10) + 1;
}// end randomNumberSquared

double calculateSidesOfTriangle(double x, double y) {
	if (x>0 && y>0) {
	return Math.sqrt((x*x) + (y*y));
	}else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}// end calculateSidesOfTriangle

}// end

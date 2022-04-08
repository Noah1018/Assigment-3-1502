import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Toy;

class ToyTest {

	ArrayList<Toy> toys;


	  @Test
	  void testgetSN() {
		  toys = new ArrayList<>();
		  long test = 0;

		  for (Toy t : toys) {
			  test = t.getsN();
			  assertNotEquals(test, 0);
		  }

	    }

	  @Test
	  void testgetName() {
		  toys = new ArrayList<>();
		  String test = "";

		  for (Toy t : toys) {
			  test = t.getName();
			  assertNotEquals(test, "");
		  }

	    }

	  @Test
	  void testgetBrand() {
		  toys = new ArrayList<>();
		  String test = "";

		  for (Toy t : toys) {
			  test = t.getBrand();
			  assertNotEquals(test, "");
		  }

	    }

	  @Test
	  void testgetPrice() {
		  toys = new ArrayList<>();
		  double test = 0;

		  for (Toy t : toys) {
			  test = t.getPrice();
			  assertNotEquals(test, 0);
		  }

	    }

	  @Test
	  void testgetCount() {
		  toys = new ArrayList<>();
		  int test = -1;

		  for (Toy t : toys) {
			  test = t.getCount();
			  assertNotEquals(test, -1);
		  }

	    }

	  @Test
	  void testgetAge() {
		  toys = new ArrayList<>();
		  int test = -1;

		  for (Toy t : toys) {
			  test = t.getAge();
			  assertNotEquals(test, -1);
		  }

	    }

}

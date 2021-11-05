package JVMnote;

import java.util.Random;

public class Hello {

	public static void main(String[] args) {
		String s = "herenjiedashaB";
		
		while (true) {
			s += s + new Random().nextInt(88888888) + new Random().nextInt(999999999);
		}
	}

}

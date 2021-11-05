package com.huaweiyun.example2;

public abstract class Guess {
	
	public boolean compare(int guessNum, int result) {
		if (result < guessNum) {
			    return lessthan();
			}else if (result > guessNum) {
			    return greatthan();
			}else {
				return win();
		    }
		
	}
	public abstract boolean lessthan();
	
	public abstract boolean greatthan();
	
	public abstract boolean win();
	

}

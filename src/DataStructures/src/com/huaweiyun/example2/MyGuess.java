package com.huaweiyun.example2;

public class MyGuess extends Guess{

	@Override
	public boolean lessthan() {
		System.out.println("你买小了");//买大了
		return false;
	}

	@Override
	public boolean greatthan() {
		System.out.println("你买大了");//买大了
		return false;
	}

	@Override
	public boolean win() {
		System.out.println("中彩了");//买大了
		return true;
	}

	
}

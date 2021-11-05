package com.huaweiyun.example0;

public interface Media {// 接口
	public static final String MEDIA = "MY JAVA";
	// 接口的属性默认是public static final 修饰
	// 接口中的方法默认是public abstract 修饰
	// 接口继承接口 extends
	// 接口实现用implement
	//接口可以多继承extends，逗号隔开
	// 接口可以多实现implements，逗号隔开
	// 接口中属性一般设计为public static final
	// MEDIA(){}//接口中不能有构造函数
	// 子类通过implements实现接口（继承关系）必须实现接口中所有抽象方法

//JDK1.8之后的新特性
//接口中可以定义默认方法,它可以有方法体的
	public default String getAuthor() {
		return MEDIA;
	}

//接口中可以定义静态方法，有方法体
	public static void showInfo() {
		System.out.print("MyInterface的静态方法：showInfo");

	}
}
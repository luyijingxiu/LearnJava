package com.lcp.java.core;

import com.lcp.java.core.C.D;
import com.lcp.java.core.C.F;

public class LearnInterfaceAndInherit {

	public static void main(String[] args) {
		LearnInterfaceAndInherit learnInterfaceAndInherit = new LearnInterfaceAndInherit();
		learnInterfaceAndInherit.testOverride();
		learnInterfaceAndInherit.testInstanceOf();
		learnInterfaceAndInherit.testHide();
		learnInterfaceAndInherit.testInnerClass();
		learnInterfaceAndInherit.testAnnoymousClass();
	}

	/**
	 * override方法测试，B重写了A的f方法，调用以看是否重写其行为
	 */
	private void testOverride() {
		System.out.println("LearnClass.testOverride()");
		B b = new B(1);
		A a = new A(1);

		a.f();
		b.f();
	}

	/**
	 * instanceof返回当前对象是否属于某个类
	 *  其中B extends A
	 */
	private void testInstanceOf() {
		System.out.println("LearnClass.testInstanceOf()");
		B b = new B(1);
		A a = new A(1);

		a.f();
		b.f();

		System.out.println(a instanceof A);// true
		System.out.println(a instanceof B);// false
		System.out.println(b instanceof A);// true
		System.out.println(b instanceof B);// true

		a = b;
		a.f();
		System.out.println(a instanceof A);// true
		System.out.println(a instanceof B);// true
	}

	/**
	 * static方法的重写叫覆盖
	 */
	private void testHide() {

		System.out.println("LearnClass.testHide()");
		A a = new A(1);
		B b = new B(1);
		a.f1();
		b.f1();

		a = new B(1);
		a.f1();// 输出static A.f1(),所以类方法没有多态
		a.f();
	}

	/**
	 * 测试内部类
	 * 注意语法
	 */
	private void testInnerClass() {
		System.out.println("LearnInterfaceAndInherit.testInnerClass()");
		
		// 实例化非静态内部类必须在外部类对象的基础上
		D d = new C().new D();
		//实例化静态内部类可以直接实例化
		F f = new C.F();
		f.f();
	}

	/**
	 * 本地类
	 *  方法里面的类：可以理解为有名字的匿名类，而且声明和实例化分开
	 */
	private void testLocalClass() {
		System.out.println("LearnClass.testLocalClass()");
		class localClass {
			public int local;

			public localClass() {
				local = 1;
			}
		}
		System.out.println(new localClass().local);
	}

	/**
	 * 匿名类
	 * 声明和实例化同时发生
	 * 当场实现必须的抽象方法
	 */
	private void testAnnoymousClass() {
		System.out.println("LearnClass.testAnnoymousClass()");

		int v = 1;
		G g = new G() {

			@Override
			public void f() {
				// 这里v自动变成final的了
				// v=2; 进行赋值会出错
				// 原因是其实内部匿名类也声明了一个v，以及一个以v为参数的
				// 构造函数，为了避免歧义，需要吧外面的修饰成final的
				System.out.println(v);
			}
		};
		// 即使在外部修改v也会造成编译错误
		// v=1;
	}
}

class A {
	public int a;

	public void f() {
		System.out.println("A.f()");
	}

	public static void f1() {
		System.out.println("static A.f1()");
	}

	public A(int a) {
		this.a = a;
	}
}

class B extends A {

	// 如果父类没有默认无参构造函数，子类会报错
	public B(int a) {
		super(a);

	}

	// override用于在 不是重写的情况下产生编译错误
	@Override
	public void f() {
		System.out.println("B.f()");
	}

	public static void f1() {
		System.out.println("static B.f1()");
	}
}

class C {
	private int c;

	class D {
		public void f() {
			// 内部类可以访问外部private属性
			System.out.println(c);
		}
	}

	static class F {
		public void f() {
			// 不可以访问外部类的属性和方法
			// System.out.println(c);
			System.out.println("static C.F.f()");
		}
	}
}

abstract class G {
	public abstract void f();
}

interface H {
	// interface只能声明为public的
	// private void f();
	public void f();

	// 接口是可以实现默认方法的
	// 可以为已经实现的类提供多余的特性而不需要需改代码
	default public void f1() {
		System.out.println("default");
	}
}
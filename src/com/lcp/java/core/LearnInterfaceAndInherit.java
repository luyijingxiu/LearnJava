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
	 * override�������ԣ�B��д��A��f�����������Կ��Ƿ���д����Ϊ
	 */
	private void testOverride() {
		System.out.println("LearnClass.testOverride()");
		B b = new B(1);
		A a = new A(1);

		a.f();
		b.f();
	}

	/**
	 * instanceof���ص�ǰ�����Ƿ�����ĳ����
	 *  ����B extends A
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
	 * static��������д�и���
	 */
	private void testHide() {

		System.out.println("LearnClass.testHide()");
		A a = new A(1);
		B b = new B(1);
		a.f1();
		b.f1();

		a = new B(1);
		a.f1();// ���static A.f1(),�����෽��û�ж�̬
		a.f();
	}

	/**
	 * �����ڲ���
	 * ע���﷨
	 */
	private void testInnerClass() {
		System.out.println("LearnInterfaceAndInherit.testInnerClass()");
		
		// ʵ�����Ǿ�̬�ڲ���������ⲿ�����Ļ�����
		D d = new C().new D();
		//ʵ������̬�ڲ������ֱ��ʵ����
		F f = new C.F();
		f.f();
	}

	/**
	 * ������
	 *  ����������ࣺ�������Ϊ�����ֵ������࣬����������ʵ�����ֿ�
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
	 * ������
	 * ������ʵ����ͬʱ����
	 * ����ʵ�ֱ���ĳ��󷽷�
	 */
	private void testAnnoymousClass() {
		System.out.println("LearnClass.testAnnoymousClass()");

		int v = 1;
		G g = new G() {

			@Override
			public void f() {
				// ����v�Զ����final����
				// v=2; ���и�ֵ�����
				// ԭ������ʵ�ڲ�������Ҳ������һ��v���Լ�һ����vΪ������
				// ���캯����Ϊ�˱������壬��Ҫ����������γ�final��
				System.out.println(v);
			}
		};
		// ��ʹ���ⲿ�޸�vҲ����ɱ������
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

	// �������û��Ĭ���޲ι��캯��������ᱨ��
	public B(int a) {
		super(a);

	}

	// override������ ������д������²����������
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
			// �ڲ�����Է����ⲿprivate����
			System.out.println(c);
		}
	}

	static class F {
		public void f() {
			// �����Է����ⲿ������Ժͷ���
			// System.out.println(c);
			System.out.println("static C.F.f()");
		}
	}
}

abstract class G {
	public abstract void f();
}

interface H {
	// interfaceֻ������Ϊpublic��
	// private void f();
	public void f();

	// �ӿ��ǿ���ʵ��Ĭ�Ϸ�����
	// ����Ϊ�Ѿ�ʵ�ֵ����ṩ��������Զ�����Ҫ��Ĵ���
	default public void f1() {
		System.out.println("default");
	}
}
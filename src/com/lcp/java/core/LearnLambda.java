package com.lcp.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.lcp.java.core.LearnLambda.Hero;
import com.lcp.learnutil.SystemOutUtil;

public class LearnLambda {
	public static void main(String[] args) {
		List<Hero> hList = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Hero hero = new Hero();
			hero.setHp(random.nextInt(20) + 90);
			hero.setDamage(random.nextInt(20) + 40);
			hList.add(hero);
		}
		hList.add(hList.get(0));
		System.out.println(hList);
		
		
		LearnLambda learnLambda = new LearnLambda();
		learnLambda.differentMethodToFilter(hList);
		learnLambda.comparator(hList);
		learnLambda.aggregate(hList);
	}

	/**
	 * ʹ����������������������lambda�����ֱ���б����ɸѡ
	 * @param hList
	 */
	private void differentMethodToFilter(List<Hero> hList) {
		System.out.println("LearnLambda.differentMethodToFilter()");
		System.out.println(normalMethod(hList));
		SystemOutUtil.INSTANCE.printSplitLine();
		System.out.println(anonymousMethod(hList));
		SystemOutUtil.INSTANCE.printSplitLine();
		System.out.println(lambdaMethod(hList));
	}

	/**
	 * ��lambda���ʽ������
	 * @param hList
	 */
	private void comparator(List<Hero> hList) {
		System.out.println("LearnLambda.comparator()");
		System.out.println(hList);
		hList.sort((h1, h2) -> h1.getDamage() - h2.getDamage());
		System.out.println(hList);
	}

	/**
	 * ��������
	 * ���þ�̬����
	 * �����൱�����䷽��
	 * ���ö��󷽷�
	 * @param hList
	 */
	private void methodRefrence(List<Hero> hList) {
		System.out.println("LearnLambda.methodRefrence()");

		filter(hList, LearnLambda::testHelloStaticMethod);
		filter(hList, Hero::findTank);
		filter(hList, new LearnLambda()::testHelloInstanceMethon);
	}

	/**
	 * lambda���ʽ��Collection�е�Ӧ�ã��ۺ�
	 * @param hList
	 */
	private void aggregate(List<Hero> hList) {
		System.out.println("LearnLambda.aggregate()");
		hList.stream().filter(h -> h.getDamage() < 50 && h.getHp() > 100).forEach(h -> System.out.print(h));

		Hero[] hArray = hList.toArray(new Hero[hList.size()]);
		System.out.println(Arrays.toString(hArray));
		Arrays.stream(hArray).filter(h->h.getDamage()<50&&h.getHp()>100).forEach(h->System.out.print(h));
	}

	/**
	 * ��������ɸѡ
	 * @param hList
	 * @return
	 */
	private List<Hero> normalMethod(List<Hero> hList) {
		System.out.println("LearnLambda.normalMethod()");
		List<Hero> result = new ArrayList<>();
		for (Hero hero : hList) {
			if (hero.getHp() > 100 && hero.getDamage() < 50)
				result.add(hero);
		}
		return result;
	}

	/**
	 * ��������ɸѡ
	 * @param hList
	 * @return
	 */
	private List<Hero> anonymousMethod(List<Hero> hList) {
		System.out.println("LearnLambda.anoymousMethod()");
		HeroChecker checker = new HeroChecker() {
			@Override
			public boolean test(Hero hero) {
				// TODO Auto-generated method stub
				return hero.getDamage() < 50 && hero.getHp() > 100;
			}
		};
		List<Hero> result = new ArrayList<>();
		for (Hero hero : hList)
			if (checker.test(hero))
				result.add(hero);
		return result;
	}

	/**
	 * lambda����ɸѡ
	 * @param hList
	 * @return
	 */
	private List<Hero> lambdaMethod(List<Hero> hList) {
		System.out.println("LearnLambda.lambdaMethod()");
		HeroChecker checker = h -> h.getDamage() < 50 && h.getHp() > 100;
		List<Hero> result = new ArrayList<>();
		for (Hero hero : hList)
			if (checker.test(hero))
				result.add(hero);
		return result;
	}

	/**
	 * ɸѡ�����Ϸ��������Ķ���
	 * @param hList
	 * @param checker
	 */
	private void filter(List<Hero> hList, HeroChecker checker) {
		System.out.println("LearnLambda.filter()");
		for (Hero hero : hList) {
			if (checker.test(hero))
				System.out.println(hList);
		}
	}

	/**
	 * ���Ծ�̬��������
	 * @param hero
	 * @return
	 */
	public static boolean testHelloStaticMethod(Hero hero) {
		return hero.getDamage() < 50 && hero.getHp() > 100;
	}

	/**
	 * ����ʾ����������
	 * @param hero
	 * @return
	 */
	public boolean testHelloInstanceMethon(Hero hero) {
		return hero.getDamage() < 50 && hero.getHp() > 100;
	}
	
	static class Hero {
		private int hp;
		private int damage;

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			this.damage = damage;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{\"hp:\"" + hp + "\"damage\":" + damage + "}\n";
		}

		/**
		 * ���䷽������
		 * @return
		 */
		public boolean findTank() {
			return this.hp > 100 && this.damage < 50;
		}
	}

}


/**
 * �������ӿ�(���󷽷���֧�ַ������ã�����lambda���ʽ)
 * @author buaaL
 *
 */
interface HeroChecker {
	public boolean test(Hero hero);
}
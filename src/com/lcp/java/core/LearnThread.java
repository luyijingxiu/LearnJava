package com.lcp.java.core;

/**
 * 学习多线程
 * @author buaaL
 *
 */
public class LearnThread {
	public static void main(String[] args) {
		LearnThread learnThread=new LearnThread();
		TestThreadCoroperation testThreadCoroperation=new LearnThread.TestThreadCoroperation();
		testThreadCoroperation.exec();
	}
	
	/**
	 * 三种启动线程的方式
	 * 继承线程类
	 * 实现Runnable接口
	 * 匿名类
	 */
	private void startThread() {
		
	}
	
	  
	static class Hero {
	    public String name;
	    public float hp;
	  
	    public int damage;
	  
	    public synchronized void recover() {
	        //当血量大于或者等于1000的时候
	        //this.wait() 让占用这个对象的线程等待，并临时释放锁
	        while(hp>=1000){
	            try {
	                this.wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	         
	        hp = hp + 1;
	        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
	        this.notify();
	    }
	  
	    public synchronized void hurt() {
	        //把if改为while，被唤醒后，会重复查看hp的值，只有hp大于1，才会往下执行
	        //if (hp <= 1) {
	    	//if和while的区别在于，被意外唤醒之后会不会重新检查hp，if就直接执行减血了，while会进入下次循环
	        while (hp <= 1) {
	            try {
	                this.wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	  
	        hp = hp - 1;
	        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
	        //掉血之后，唤醒等待的线程
	        this.notify();
	    }
	  
	    public void attackHero(Hero h) {
	        h.hp -= damage;
	        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
	        if (h.isDead())
	            System.out.println(h.name + "死了！");
	    }
	  
	    public boolean isDead() {
	        return 0 >= hp ? true : false;
	    }
	  
	}
	
	static class TestThreadCoroperation {
	       
	    static class HurtThread extends Thread{
	        private Hero hero;
	 
	        public HurtThread(Hero hero){
	            this.hero = hero;
	        }
	         
	        public void run(){
	            while(true){
	                hero.hurt();
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	 
	    }
	    static class RecoverThread extends Thread{
	        private Hero hero;
	         
	        public RecoverThread(Hero hero){
	            this.hero = hero;
	        }
	         
	        public void run(){
	            while(true){
	                hero.recover();
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	         
	    }
	     
	    public static void exec() {
	        final Hero gareen = new Hero();
	        gareen.name = "盖伦";
	        gareen.hp = 616;
	         
	        for (int i = 0; i < 2; i++) {
	            new RecoverThread(gareen).start();
	        }
	        for (int i = 0; i < 5; i++) {
	            new HurtThread(gareen).start();
	        }
	              
	    }
	           
	}
}



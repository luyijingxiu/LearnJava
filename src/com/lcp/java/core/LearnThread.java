package com.lcp.java.core;

/**
 * ѧϰ���߳�
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
	 * ���������̵߳ķ�ʽ
	 * �̳��߳���
	 * ʵ��Runnable�ӿ�
	 * ������
	 */
	private void startThread() {
		
	}
	
	  
	static class Hero {
	    public String name;
	    public float hp;
	  
	    public int damage;
	  
	    public synchronized void recover() {
	        //��Ѫ�����ڻ��ߵ���1000��ʱ��
	        //this.wait() ��ռ�����������̵߳ȴ�������ʱ�ͷ���
	        while(hp>=1000){
	            try {
	                this.wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	         
	        hp = hp + 1;
	        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
	        this.notify();
	    }
	  
	    public synchronized void hurt() {
	        //��if��Ϊwhile�������Ѻ󣬻��ظ��鿴hp��ֵ��ֻ��hp����1���Ż�����ִ��
	        //if (hp <= 1) {
	    	//if��while���������ڣ������⻽��֮��᲻�����¼��hp��if��ֱ��ִ�м�Ѫ�ˣ�while������´�ѭ��
	        while (hp <= 1) {
	            try {
	                this.wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	  
	        hp = hp - 1;
	        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
	        //��Ѫ֮�󣬻��ѵȴ����߳�
	        this.notify();
	    }
	  
	    public void attackHero(Hero h) {
	        h.hp -= damage;
	        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
	        if (h.isDead())
	            System.out.println(h.name + "���ˣ�");
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
	        gareen.name = "����";
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



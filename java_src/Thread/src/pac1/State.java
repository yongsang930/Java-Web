package pac1;

import java.util.*;

public class State {
	public int mineral;
	public Vector<Peasant> vp;
	public Vector<Soldier> vs;
	
	public State(){
		mineral=0;
		vp=new Vector<Peasant>();
		vs=new Vector<Soldier>();
		for(int i=0;i<3;i++){
			vp.addElement(new Peasant());
		}
	}
	public void makeP(){
		vp.addElement(new Peasant());
		mineral-=20;
		vp.elementAt(vp.size()-1).start();
	}
	public void makeS(){
		vs.addElement(new Soldier());	
		mineral-=30;
	}
	public void add(){
		mineral+=5;
	}
	public void sub(int x){
		mineral-=x;
	}
	public void print(){
		System.out.println("mineral : "+mineral);
		System.out.println("dd : "+vp.size());
		System.out.println("dd : "+vs.size());
	}
}


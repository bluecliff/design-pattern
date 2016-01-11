interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence{
	private int size;
	private int index=0;
	private Object[] items;
	public Sequence(int size){
		this.size=size;
		items = new Object[size];
	}
	class SequenceSelector implements Selector{
		int i=0;
		public boolean end(){
			return i==size; 
		}
		public Object current(){
			return items[i];
		}
		public void next(){
			if(i<size)
				i++;
		}
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	public void add(Object object){
		if(index<size) items[index++]=object;
	}
	public static void main(String[] args){
		Sequence se = new Sequence(10);
		for(int i=0;i<10;++i){
			se.add(i);
		}
		Selector selector = se.selector();
		while(!selector.end()){
			System.out.println(selector.current());
			selector.next();
		}
	}
}

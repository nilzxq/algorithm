package lanqiao;

/**
 * @author nilzxq
 * @date��2017��2��19�� ����10:46:37
 * @version 1.0
 */
//���Խṹ�����飬vector��stack
//���νṹ
//ͼ

//�ݹ鶨�巨
class BiTree{
	private int v;//�˿�
	private BiTree l;
	private BiTree r;
	
	public BiTree(int x){v=x;}
	public void add(BiTree the){
		if(the.v<v){
			if(l==null)
				l=the;
			else {
				l.add(the);
			}
		}else{
			if(r==null)
				r=the;
			else{
				r.add(the);
			}
		}
	}
	//�������
public void mid_trav(){
	if(l!=null) l.mid_trav();
	System.out.println(v);
	if(r!=null) r.mid_trav();
}	
}
public class tree {
	public static void main(String[] args) {
		//������
		BiTree root=new BiTree(100);
		root.add(new BiTree(50) );
		root.add(new BiTree(80));
		root.add(new BiTree(40));
		root.add(new BiTree(35));
		root.mid_trav();
	}
}

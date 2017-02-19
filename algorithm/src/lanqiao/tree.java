package lanqiao;

/**
 * @author nilzxq
 * @date：2017年2月19日 上午10:46:37
 * @version 1.0
 */
//线性结构。数组，vector，stack
//树形结构
//图

//递归定义法
class BiTree{
	private int v;//乘客
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
	//中序遍历
public void mid_trav(){
	if(l!=null) l.mid_trav();
	System.out.println(v);
	if(r!=null) r.mid_trav();
}	
}
public class tree {
	public static void main(String[] args) {
		//二叉树
		BiTree root=new BiTree(100);
		root.add(new BiTree(50) );
		root.add(new BiTree(80));
		root.add(new BiTree(40));
		root.add(new BiTree(35));
		root.mid_trav();
	}
}

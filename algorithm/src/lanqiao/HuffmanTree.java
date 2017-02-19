package lanqiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author nilzxq
 * @date：2017年2月19日  下午3:18:54
 * @version 1.0
 */

/*
 * Huffman    哈夫曼树
 * BiTree2                 二叉树接口
 * show_tree          显示二叉树
 */
interface BiTree2{
	public BiTree2 getLeft();
	public BiTree2 getRight();
	public String str();
	public int getWidth();
	public int getHeight();
}
 class Huffman implements BiTree2 {
      private char ch;//待编码的字符
      private int w;//本树总权
      private Huffman l;
      private Huffman r;

	@Override
	public BiTree2 getLeft() {
		return l;
	}

	@Override
	public BiTree2 getRight() {
		return r;
	}

	@Override
	public String str() {
		return ch+":"+w;
	}

	@Override
	public int getWidth() {
		int sum=1;
		if(l!=null) sum+=l.getWidth();
		if(r!=null) sum+=r.getWidth();
		return sum;
	}

	@Override
	public int getHeight() {
		int hl=l==null?0:l.getHeight();
		int hr=r==null?0:r.getHeight();
		return Math.max(hl,hr )+1;
	}
     
	public Huffman(char c,int weight){
		ch=c;
		w=weight;
	}
	
	public static Huffman join(Huffman a,Huffman b){
		Huffman t=new Huffman((char)0,a.w+b.w);
		t.l=a;
		t.r=b;
		return t;
	}
	
	public static void create(List<Huffman> lst){
		Comparator cp=new Comparator<Huffman>() {
			public int compare(Huffman t1,Huffman t2){
				return t1.w-t2.w;
			}
		};
		while(lst.size()>1){
			Collections.sort(lst,cp);
			Huffman a=lst.remove(0);
			Huffman b=lst.remove(0);
			lst.add(join(a, b));
		}
	}
}
 class X{
	 private static final int NODE_WIDTH = 5;
	private static final int NODE_HEIGHT = 3;

	public static void show_tree(BiTree2 tree){
		 int w=tree.getWidth()*NODE_WIDTH;
		int h=tree.getHeight()*NODE_HEIGHT;
		char[][] buf=new char[h][w];
		printInBuf(tree,buf,0,0);
		showBuf(buf);
	 }

	private static void printInBuf(BiTree2 tree, char[][] buf, int x, int y) {
        BiTree2 lefTree2=tree.getLeft();
        BiTree2 rightBiTree2=tree.getRight();
        int pl;
        if(lefTree2==null)
        	pl=0;
        else{
        	pl=NODE_WIDTH;
        	if(lefTree2.getRight()!=null)
        		pl+=lefTree2.getRight().getWidth()*NODE_WIDTH;
        }
        int pr;
        if(rightBiTree2==null) pr=0;
        else{
        	pr=NODE_WIDTH;
        	if(rightBiTree2.getLeft()!=null)
        		pr+=rightBiTree2.getLeft().getWidth()*NODE_WIDTH;
        }
        int rootpos=x;
        if(lefTree2!=null)rootpos+=lefTree2.getWidth()*NODE_WIDTH;
	    for(int i=0;i<NODE_HEIGHT;i++)buf[y+i][rootpos]='|';
	    for(int i=rootpos-pl;i<=rootpos+pr;i++) buf[y+NODE_HEIGHT-1][i]='-';
	    for(int i=rootpos;i<rootpos+tree.str().length();i++)buf[y+NODE_HEIGHT-1][i]=' ';
	    if(pl>0) buf[y+NODE_HEIGHT-1][rootpos-pl]='/';
	    if(pr<0) buf[y+NODE_HEIGHT-1][rootpos+pr]='\\';
	    if(lefTree2!=null) printInBuf(lefTree2, buf, x, y+NODE_HEIGHT);
	    if(rightBiTree2!=null) printInBuf(rightBiTree2, buf, rootpos+NODE_WIDTH, y+NODE_HEIGHT);
	}
	private static void showBuf(char[][] x){
		for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++)
            	System.out.println(x[i][j]==0?' ':x[i][j]);
            System.out.println();
		}
	}
 }
 public class HuffmanTree{
	 public static void main(String[] args) {
		List<Huffman> lst=new ArrayList<Huffman>();
	    lst.add(new Huffman('a',45));
	    lst.add(new Huffman('b', 13));
	    lst.add(new Huffman('c', 12));
	    lst.add(new Huffman('d', 16));
	    lst.add(new Huffman('e', 9));
	    lst.add(new Huffman('f', 5));
	    Huffman.create(lst);
	    X.show_tree(lst.get(0));
	 }
 }

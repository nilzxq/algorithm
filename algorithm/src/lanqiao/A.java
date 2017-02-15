package lanqiao;

//在n个球中，任意取出m个（不放回），求又多少种不同的取法
public class A
{
	public static int f(int n,int m)
	{
		if(n<m) return 0;
		if(n==m) return 1;
		if(m==0)return 1;
		//假设存在一个特殊球，分两种情况一定取出特殊球和一定没有取特殊球
		return f(n-1,m-1)+f(n-1,m);
	}
     public static void main(String[] args)
    {
	 int k=f(10,3);
	  System.out.println(k);
}
}
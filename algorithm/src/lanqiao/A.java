package lanqiao;

//��n�����У�����ȡ��m�������Żأ������ֶ����ֲ�ͬ��ȡ��
public class A
{
	public static int f(int n,int m)
	{
		if(n<m) return 0;
		if(n==m) return 1;
		if(m==0)return 1;
		//�������һ�������򣬷��������һ��ȡ���������һ��û��ȡ������
		return f(n-1,m-1)+f(n-1,m);
	}
     public static void main(String[] args)
    {
	 int k=f(10,3);
	  System.out.println(k);
}
}
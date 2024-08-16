import java.util.*;
public class Dataentry {
	static char Map[][];
	static Queue<ArrayList<Integer>> Bomp = new LinkedList<>();
	static Stack<ArrayList<Integer>> lastindex = new Stack<>();;
	static int  bombcount;
    static int mapsize;
    static String usposition;
    static int lasti=-1;
    static int lastj=-1;
    static int iu;
    static int ju;
    static String keyposition;
    static int ik;
    static int jk;
    static char villianspos[][];
    static char   brickspos[][];
	public Dataentry() {
		map();
		userpostion();
		keyposition();
		villiansentry();
		bricksentry();
	   
	}
	public void map(){
		Scanner s=new Scanner(System.in);
		System.out.println("MAP SIZE:");
		this.mapsize=s.nextInt();
		this.Map=new char[this.mapsize][this.mapsize];
		for(int i=0;i<this.mapsize;i++){
			for(int j=0;j<this.mapsize;j++){
				if(i==0&&j==0)
					continue;
				if(i==0||j==0){
			this.Map[i][j]=(char)('A'+j-1);
			this.Map[i][0]=(char)('A'+i-1);
				}
				else if(i==1||j==1||i+1==this.mapsize||j+1==this.mapsize ||(i%2==1&&j%2==1))
				this.Map[i][j]='*';
				else
					this.Map[i][j]=' ';
			}
		}
		this.Map[0][0]=' ';
	}
	public  void userpostion(){
		Scanner s=new Scanner(System.in);
		System.out.println("PLAYER POSITION:");
		this.usposition=s.next();
		int i=this.usposition.charAt(0)-'A'+1;
		int j=this.usposition.charAt(1)-'A'+1;
		if(this.Map[i][j]==' '){
			this.Map[i][j]='P';
			this.iu=i;
			this.ju=j;
			
		}
			else{
				System.out.print("invalid input "+i+" "+j);
				return;
			}
	}
	public void  keyposition(){
		Scanner s=new Scanner(System.in);
		System.out.println("KEY POSITION:");
		this.keyposition=s.next();
		int i=this.keyposition.charAt(0)-'A'+1;
		int j=this.keyposition.charAt(1)-'A'+1;
		if(this.Map[i][j]==' '){
		this.Map[i][j]='K';
		this.ik=i;
		this.jk=j;
		}
		else{
			System.out.print("invalid input");
			return;
		}
	}
	public void  villiansentry(){
		Scanner s=new Scanner(System.in);
		System.out.println("Villians COUNT:");
		int n=s.nextInt();
		this.villianspos=new char [n][2];
		for(int i=1;i<=n;i++){
		System.out.println("V"+i+":");
		String temp=s.next();
		this.villianspos[i-1][0]=temp.charAt(0);
		this.villianspos[i-1][1]=temp.charAt(1);
		int in=temp.charAt(0)-'A'+1;
		int j=temp.charAt(1)-'A'+1;
		if(this.Map[in][j]==' ')
			this.Map[in][j]='V';
			else{
				System.out.print("invalid input");
				return;
			}
		}
	}
	public void  bricksentry(){
		Scanner s=new Scanner(System.in);
		System.out.println("BRICKS COUNT:");
		int n=s.nextInt();
		this. brickspos=new char [n][2];
		for(int i=1;i<=n;i++){
		System.out.println("B"+i+":");
		String temp=s.next();
		this. brickspos[i-1][0]=temp.charAt(0);
		this. brickspos[i-1][1]=temp.charAt(1);
		int in=temp.charAt(0)-'A'+1;
		int j=temp.charAt(1)-'A'+1;
		if(this.Map[in][j]==' ')
			this.Map[in][j]='B';
			else{
				System.out.print("invalid input");
				return;
			}
		}
	}
}


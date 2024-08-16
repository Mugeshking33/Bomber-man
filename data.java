import java.util.*;
public class data {
	static List<Integer> check(int i,int j,char c){
		List<Integer> temp=new ArrayList<>();
		if(c=='W')
		{
			temp.add(i-1);
			temp.add(j);
			return temp;
		}
		else if(c=='S')
		{
			temp.add(i+1);
			temp.add(j);
			return temp;
		}
		else if(c=='A')
		{
			temp.add(i);
			temp.add(j-1);
			return temp;
		}
		else if(c=='D')
		{
			temp.add(i);
			temp.add(j+1);
			return temp;
		}
		else if(c=='Q')
		{
			temp.add(i-1);
			temp.add(j-1);
			return temp;
		}
		else if(c=='Z')
		{
			temp.add(i+1);
			temp.add(j-1);
			return temp;
		}
		else if(c=='E')
		{
			temp.add(i-1);
			temp.add(j+1);
			return temp;
		}
		else if(c=='C')
		{
			temp.add(i-1);
			temp.add(j+1);
			return temp;
		}
		else{
			return temp;
		}
	}
	public static void start(){
		Scanner s=new Scanner(System.in);
		Dataentry data=new Dataentry();	
		display(data);
		while(true){
			System.out.println("W----UP\nS----DOWN\nA----LEFT\nD----RIGHT\nQ----UPLEFT\nE----UPRIGHT\nZ----DOWNLEFT\nC----DOWNRIGHT\nX----BOMP");
			char c=s.next().charAt(0);
			if(c=='X'){
				    while(true) {
				    	System.out.print("1.PLANT\n2.DENOTE");
				    	char bomp=s.next().charAt(0);
				    	if(bomp=='1') {
				    		data.bombcount++;
				    		if(data.lastindex.size()>0){
				    			ArrayList<Integer> lastind=data.lastindex.pop();
				    			if(data.Map[ lastind.get(0)][ lastind.get(1)]>='1'&&data.Map[ lastind.get(0)][ lastind.get(1)]<='9') {
				    				System.out.print("Not put bomb");
				    				break;
				    			}
				    			data.Map[data.iu][data.ju]=(char)(data.bombcount+'0');
				    			System.out.println(data.iu+" "+data.ju+" "+data.Map[data.iu][data.ju]);
				    			ArrayList<Integer> bomj=new ArrayList<Integer>();
				    			bomj.add(data.iu);
				    			bomj.add(data.ju);
				    			data.Bomp.offer(bomj);
								data.iu=lastind.get(0);
								data.ju=lastind.get(1);
								data.Map[data.iu][data.ju]='P';
								}
				    		else {
				    			System.out.print("Not put bomb");
				    		}
				    		display(data);
				    		break;
				    	}
				    	else if(bomp=='2') {
				    		if(data.lastindex.size()>0) {
				    		ArrayList<Integer> bomj=data.Bomp.poll();
				    		int i=bomj.get(0);
				    		int j=bomj.get(1);
				    		ArrayList<Integer> lastind=data.lastindex.peek();
							int li=data.iu;
							int lj=data.ju;
				    		if(li==i&&lj==j||li==i+1&&lj==j||li==i-1&&lj==j||li==i&&lj==j+1||li==i&&lj==j-1) {
				    			 System.out.print("Your blast \nGAME OVER");
				    			 return;
				    		}
				    		else {
				    		if(i<=data.mapsize&&data.Map[i+1][j]=='B'||data.Map[i+1][j]=='V')
								data.Map[i+1][j]=' ';
							if(i-1>=0&&data.Map[i-1][j]=='B'||data.Map[i-1][j]=='V')
									data.Map[i-1][j]=' ';
							if(j+1<=data.mapsize&&data.Map[i][j+1]=='B'||data.Map[i][j+1]=='V')
									data.Map[i][j+1]=' ';
							if(data.ju-1>=0&&data.Map[i][j-1]=='B'||data.Map[i][j-1]=='V')
									data.Map[i][j-1]=' ';
							data.Map[i][j]=' ';
							int bombcount=1;
							data.bombcount--;
							for( ArrayList bombt : data.Bomp) {
								data.Map[(int)bombt.get(0)][(int) bombt.get(1)]=(char)((bombcount)+'0');
								bombcount++;
							}
				    		}
				    		display(data);
							break;
				    		}
				    		else {
				    			System.out.println("NO BOMB PLANT");
				    		}
				    	}
				    	else {
				    		System.out.println("invlaid input ");
				    	}
				    	
				    }
			}
			else {
				List<Integer> temp=check(data.iu,data.ju,c);
				int i=temp.get(0);
				int j=temp.get(1);
			if(i<data.mapsize&& j<data.mapsize &&data.Map[i][j]=='K')
			{
				System.out.print("GAME WIN");
				return;
			}
			else if(i<data.mapsize&& j<data.mapsize &&(data.Map[i][j]=='B'||data.Map[i][j]=='V'))
			{
				System.out.print("GAME OVER");
				return;
			}
			else if(i<data.mapsize&& j<data.mapsize &&data.Map[i][j]!='*')
			{
				data.Map[data.iu][data.ju]=' ';
			    ArrayList<Integer> indextemp=new ArrayList<>();
			    indextemp.add(data.iu);
			    indextemp.add(data.ju);
			    data.lastindex.push(indextemp);
				data.iu=i;
				data.ju=j;
				data.Map[data.iu][data.ju]='P';
			}
			else{
				System.out.print("NOT MOVE");
			}
			display(data);
		}
		}
	}
	static void display(Dataentry data){
		for(int i=0;i<data.mapsize;i++){
			for(int j=0;j<data.mapsize;j++){
				System.out.print(data.Map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

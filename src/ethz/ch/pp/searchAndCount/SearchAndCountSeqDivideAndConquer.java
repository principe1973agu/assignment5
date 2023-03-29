package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

public class SearchAndCountSeqDivideAndConquer{
	int [] input;
	Workload.Type wt;


	public SearchAndCountSeqDivideAndConquer(int[]input,Workload.Type wt){
		this.input=input;
		this.wt=wt;
	}
	public static int countNoAppearances(int[] input, Workload.Type wt) {
		//TODO implement
		int count = 0;

		int lengthinput=input.length;
		int middle=(int)lengthinput/2;

		if(lengthinput==1&&Workload.doWork(input[0],wt)) return count++;
		int[] firsthalf=new int[middle];
		int[] secondhalf=new int[lengthinput-middle];
		for(int i=0;i<firsthalf.length;i++)firsthalf[i]=input[i];
		for(int i=0;i<secondhalf.length;i++)secondhalf[i]=input[i];
		int count1=countNoAppearances(firsthalf,wt);
		int count2=countNoAppearances(secondhalf,wt);







		return count+count2;}

}
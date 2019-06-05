import java.io.*;
import java.util.Arrays;

 
public class ReadConfigurations
{
    public static void readConfigurations(String[]args) throws IOException 
	{
    	// read the configurations
        for (int k=0; k < args.length; k++)
        {
            if (args[k].equals("-d")) Data.d = Integer.parseInt(args[++k]);
            else if (args[k].equals("-alpha_u")) Data.alpha_u = Float.parseFloat(args[++k]);
            else if (args[k].equals("-alpha_v")) Data.alpha_v = Float.parseFloat(args[++k]);            
            else if (args[k].equals("-beta_v")) Data.beta_v = Float.parseFloat(args[++k]);
            else if (args[k].equals("-gamma")) Data.gamma = Float.parseFloat(args[++k]);
            else if (args[k].equals("-fnTrainData")) Data.fnTrainData = args[++k];
            else if (args[k].equals("-fnTestData")) Data.fnTestData = args[++k];
            else if (args[k].equals("-n")) Data.n = Integer.parseInt(args[++k]);
            else if (args[k].equals("-m")) Data.m = Integer.parseInt(args[++k]);            
            else if (args[k].equals("-num_iterations")) Data.num_iterations = Integer.parseInt(args[++k]);
            else if (args[k].equals("-topK")) Data.topK = Integer.parseInt(args[++k]);
            else if (args[k].equals("-fnInputModel")) 
			{
                Data.flagInputModel=true;
                Data.fnInputModel=args[++k];
            }
			else if (args[k].equals("-fnOutputModel"))
			{
                Data.flagOutputModel=true;
                Data.fnOutputModel=args[++k];
            }
			else if(args[k].equals("-fnInputCandidateList"))
			{
                Data.flagInputCandidateList=true;
                Data.fnInputCandidateList=args[++k];
            }
			else if(args[k].equals("-fnOutputCandidateList"))
			{
                Data.flagOutputCandidateList=true;
                Data.fnOutputCandidateList=args[++k];
            }
        }
			
        // print the configurations
        System.out.println(Arrays.toString(args));

        System.out.println("d: " + Integer.toString(Data.d));
        System.out.println("alpha_u: " + Float.toString(Data.alpha_u));
        System.out.println("alpha_v: " + Float.toString(Data.alpha_v));
        System.out.println("beta_v: " + Float.toString(Data.beta_v));
        System.out.println("gamma: " + Float.toString(Data.gamma));

        System.out.println("fnTrainData: " + Data.fnTrainData);
        System.out.println("fnTestData: " + Data.fnTestData);
        System.out.println("n: " + Integer.toString(Data.n));
        System.out.println("m: " + Integer.toString(Data.m));

        System.out.println("num_iterations: " + Integer.toString(Data.num_iterations));

        System.out.println("topK: " + Integer.toString(Data.topK));
		
		System.out.println("fnInputModel: " + Data.fnInputModel);
		System.out.println("fnOutputModel: " + Data.fnOutputModel);
		System.out.println("fnInputCandidateList: " + Data.fnInputCandidateList);
		System.out.println("fnOutputCandidateList: " + Data.fnOutputCandidateList);	
		
		System.out.println("flagInputModel: " + Data.flagInputModel);
		System.out.println("flagOutputModel: " + Data.flagOutputModel);		
		System.out.println("flagInputCandidateList: " + Data.flagInputCandidateList);
		System.out.println("flagOutputCandidateList: " + Data.flagOutputCandidateList);		
    }
}

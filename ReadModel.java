import java.io.*;


public class ReadModel 
{
    public static void readModel() throws IOException 
	{
    	// ---    	
        Data.biasV = new float[Data.m+1];        
        Data.V = new float[Data.m+1][Data.d];
        Data.U = new float[Data.n+1][Data.d];
        
    	// ---
        File file = new File(Data.fnInputModel);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
		
		// biasV
        for(int i=1;i<=Data.m;i++)
		{
            line = br.readLine();
            String[]field = line.split("\t");
            if(i==Integer.parseInt(field[0]))
			{
                Data.biasV[i] = Float.parseFloat(field[1]);
            }
        }
		
		// V
        for(int i=1;i<=Data.m;i++) 
		{
            line = br.readLine();
            String[] field = line.split("\t");
            if (i == Integer.parseInt(field[0])) 
			{
                for (int k = 0; k < Data.d; k++) 
				{
                    Data.V[i][k] = Float.parseFloat(field[k + 1]);
                }
            }
        }

		// U
        for(int u=1;u<=Data.n;u++) 
		{
            line = br.readLine();
            String[] field = line.split("\t");
            if (u == Integer.parseInt(field[0]))
			{
                for (int k = 0; k < Data.d; k++) 
				{
                    Data.U[u][k] = Float.parseFloat(field[k + 1]);
                }
            }
        }
		
		// ---
        fr.close();
        br.close();
    }

}

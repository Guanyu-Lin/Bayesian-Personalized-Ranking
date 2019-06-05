import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveModel
{
    public static void saveModel() throws IOException 
	{
    	// ---
        File file = new File(Data.fnOutputModel);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
		
        // biasV
        for(int i=1;i<=Data.m;i++)
		{
            bw.write(i+"\t"+Data.biasV[i]+"\r\n");
        }
		
        // V
        for(int i=1;i<=Data.m;i++)
		{			
            bw.write(String.valueOf(i));
            for(int k=0;k<Data.d;k++) 
			{
                bw.write("\t" + Data.V[i][k]);
            }
            bw.write("\r\n");
        }
        
        // U
        for(int u=1;u<=Data.n;u++)
		{
            bw.write(String.valueOf(u));
            for(int k=0;k<Data.d;k++) 
			{
                bw.write("\t" + Data.U[u][k]);
            }
            bw.write("\r\n");
        }
		
        // ---
        bw.flush();
        fw.close();
        bw.close();
    }
}

import java.io.IOException;
import java.util.HashSet;


public class Train 
{
    public static void train() throws IOException
    {    	
        // --- construct indexUserTrain and indexItemTrain
        Data.indexUserTrain = new int[Data.num_train];
        Data.indexItemTrain = new int[Data.num_train];

        int idx = 0;
        for(int u=1; u<=Data.n; u++)
        {
            // --- check whether the user $u$ is in the training Data
            if (!Data.TrainData.containsKey(u))
            {
                continue;
            }

            // --- get a copy of the Data in indexUserTrain and indexItemTrain
            HashSet<Integer> ItemSet = new HashSet<Integer>();
            if (Data.TrainData.containsKey(u))
            {
                ItemSet = Data.TrainData.get(u);
            }
			
            for(int i : ItemSet)
            {
                Data.indexUserTrain[idx] = u;
                Data.indexItemTrain[idx] = i;
                idx += 1;
            }
        }
    	
        
        // ---
        for (int iter = 0; iter < Data.num_iterations; iter++) 
        {
        	for (int iter2 = 0; iter2 < Data.num_train; iter2++) 
            {
                idx = (int) Math.floor(Math.random() * Data.num_train);
                int u = Data.indexUserTrain[idx];
                int i = Data.indexItemTrain[idx];
                
                // ---
                HashSet<Integer> ItemSet_u = Data.TrainData.get(u);
                int j = i;
                while(true)
                {
                    // --- randomly sample an item $j$, Math.random(): [0.0, 1.0)
                    j = (int) Math.floor(Math.random() * Data.m) + 1;

                    if (Data.ItemSetTrainingData.contains(j) && !ItemSet_u.contains(j) )
                    {
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
                
                // ---
                BPR(u, i, j);
            }
        }
    }
    
    
    // ---
    public static void BPR(int u, int i, int j)
	{
    	// --- 
    	float r_uij = Data.biasV[i] - Data.biasV[j];
    	for (int f=0; f<Data.d; f++)
    	{
    		r_uij += Data.U[u][f] * (Data.V[i][f] - Data.V[j][f]);
    	}
    	float EXP_r_uij = (float) Math.pow(Math.E, r_uij);
    	float loss_uij = - 1f / (1f + EXP_r_uij);
       
    	// ---
    	for (int f=0; f<Data.d; f++)
    	{
    		float grad_U_u_f = loss_uij * ( Data.V[i][f] - Data.V[j][f] ) + Data.alpha_u * Data.U[u][f];
    		float grad_V_i_f = loss_uij * Data.U[u][f] + Data.alpha_v * Data.V[i][f];
    		float grad_V_j_f = loss_uij * (-Data.U[u][f]) + Data.alpha_v * Data.V[j][f];

    		Data.U[u][f] = Data.U[u][f] - Data.gamma * grad_U_u_f;
    		Data.V[i][f] = Data.V[i][f] - Data.gamma * grad_V_i_f;
    		Data.V[j][f] = Data.V[j][f] - Data.gamma * grad_V_j_f;
    	}

    	// --- biasV_i
    	float grad_biasV_i = loss_uij + Data.beta_v * Data.biasV[i];
    	Data.biasV[i] = Data.biasV[i] - Data.gamma * grad_biasV_i;

    	// --- biasV_j
    	float grad_biasV_j = loss_uij*(-1) + Data.beta_v * Data.biasV[j];
    	Data.biasV[j] = Data.biasV[j] - Data.gamma * grad_biasV_j;
	}
}

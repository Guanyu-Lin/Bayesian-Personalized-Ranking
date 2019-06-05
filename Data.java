import java.util.HashMap;
import java.util.HashSet;

public class Data 
{
    // === Configurations
    // the number of latent dimensions
    public static int d = 20;
	
    // $\alpha$
    public static float alpha = 0.5f;
    
	// tradeoff $\alpha_v$
    public static float alpha_u = 0.01f;
    // tradeoff $\alpha_v$
    public static float alpha_v = 0.01f;

    // tradeoff $\beta_v$
    public static float beta_v = 0.01f;
    
	// learning rate $\gamma$
    public static float gamma = 0.01f;

    // === Input data files
    public static String fnTrainData = "";
    public static String fnTestData = "";

    //
    public static int n = 0; // number of users
    public static int m = 0; // number of items
    public static int num_train = 0; // number of the total (user, item) pairs in training data

    //
    public static int num_iterations = 0; // scan number over the whole data

    // === Evaluation
    //
    public static int topK = 5; // top k in evaluation
    
    // === training data
    public static HashMap<Integer, HashSet<Integer>> TrainData = new HashMap<Integer, HashSet<Integer>>();

    // === training data used for uniformly random sampling
    public static int[] indexUserTrain; // start from index "0", used to uniformly sample (u, i) pair
    public static int[] indexItemTrain; // start from index "0", used to uniformly sample (u, i) pair

    // === test data
    public static HashMap<Integer, HashSet<Integer>> TestData = new HashMap<Integer, HashSet<Integer>>();

    // === candidate list
    public static HashMap<Integer, HashSet<Integer>> CandidateList = new HashMap<Integer, HashSet<Integer>>(); 
    
    // === whole data (items)
    public static HashSet<Integer> ItemSetTrainingData = new HashSet<Integer>();

    public static HashSet<String> UserItemPairsTrain = new HashSet<String>();

    // === some statistics, start from index "1"
    public static int[] userRatingNumTrain;
    public static int[] itemRatingNumTrain;

    // === model parameters to learn, start from index "1"    
    public static float[] biasV; // item bias
    public static float[][] V;
    public static float[][] U;
    
    public static boolean flagInputModel = false;
    public static boolean flagOutputModel = false;
    public static boolean flagInputCandidateList = false;
    public static boolean flagOutputCandidateList = false;

    public static String fnInputModel = "";
    public static String fnOutputModel = "";
    public static String fnInputCandidateList = "";
    public static String fnOutputCandidateList = "";
}

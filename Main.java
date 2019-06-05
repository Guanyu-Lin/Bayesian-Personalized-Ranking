
public class Main 
{
    public static void main(String [] args) throws Exception
    {	
		// 1. read configurations		
		ReadConfigurations.readConfigurations(args);

		// 2. read training data and test data
        ReadData.readData();
               
		// 3. read the model parameters or apply initialization
		if (Data.flagInputModel==true)
		{
			ReadModel.readModel();
		}
		else
		{
			Initialization.initialization();
		}
				
		// 4. training
		Train.train();
		
		// 5. save model parameters
        if (Data.flagOutputModel==true)
		{
			SaveModel.saveModel();
		}
        
        // 6. read candidate list
        if(Data.flagInputCandidateList)
        {
        	ReadCandidateList.readCandidateList();
        }
        
		// 7. test and output candidate list (if required)
		Test.test();
		
    }
}

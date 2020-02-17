import java.util.concurrent.*;

public class Action implements Callable<String> { // lawsuit
	/**
	 * Stores a Callable object which returns a string result representing
	 * its outcome
	 */
	
	public String name;
	private BaseObject self;
	private BaseObject other;
	
    ExecutorService executor = Executors.newSingleThreadExecutor();
	private Future<String> result;

	public Action(String name)
	{
		this.name = name;
		this.result = executor.submit(this);
	}
	
	public void SetTargets(BaseObject self, BaseObject other)
	{
		
	}
	
	public String run()
	{
		/**
		 * Get the result of running this action and return the string output
		 */		
		try {
			return result.get();
		} catch (Exception exception) {
			System.out.println("error running action " + this.name);
			return "Error running action: " + exception.toString();
		}
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return self.toString();
	}
}

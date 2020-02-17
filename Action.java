import java.util.concurrent.*;

public class Action { // lawsuit
	
	public String name;
	
    ExecutorService executor = Executors.newSingleThreadExecutor();
	private Future<String> result;

	public Action(String name, Callable<String> behav)
	{
		this.name = name;
		this.result = executor.submit(behav);
	}
	
	public String run()
	{
		try {
			return result.get();
		} catch (Exception exception) {
			System.out.println("error running action " + this.name);
			return "Error running action: " + exception.toString();
		}
	}
}

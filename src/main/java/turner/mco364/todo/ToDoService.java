package turner.mco364.todo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoService {
	@GET("/todos")
	Call<List<ToDo>> listTodos(); 
	//can use @Path if there's more to the String that you don't know yet (user will add)
	}
	

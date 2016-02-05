package turner.mco364.todo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoServiceTest {

	//verify that you download 200 ToDo items
	@Test
	public void testListTodos() throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
		.baseUrl("http://jsonplaceholder.typicode.com") //the rest is in ToDoService (todos). Only the base. 
			.addConverterFactory(GsonConverterFactory.create()) //converter for Gson. 
				.build();
		
		ToDoService service = retrofit.create(ToDoService.class);

		Call<List<ToDo>> call = service.listTodos(); //returns a call object (no actual data)
		
		//options to do with a call object: 
		//1. execute 
		//2. enqueue

		//the call's execute method returns a response
		Response<List<ToDo>> response = call.execute();
		
		//get the list of todo objects
		List<ToDo> list = response.body();
		
		//check if the list we got from the response from the call has all 200 items. 
		Assert.assertEquals(200, list.size());
		
	}
}

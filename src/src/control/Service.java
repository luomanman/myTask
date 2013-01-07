package control;

import org.json.JSONException;

import entity.Book;

public class Service {
	private String base_url = "https://api.douban.com/v2/";
	private String book_url = "book/";
	
	public Book getBookByID(int id)
	{
		String request_url = base_url + book_url + id;
		HTTP http = new HTTP();
		String json = http.GET(request_url);
		ToBean toBean = new ToBean();
		try
		{
			return toBean.book(json);
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}

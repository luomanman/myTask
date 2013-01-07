package control;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import entity.*;

public class ToBean {
	
	//convert a book information from json to bean
	public Book book(String json) throws JSONException
	{
		JSONObject book = new JSONObject(json);
		Book b = new Book();
        
        JSONObject rating = book.getJSONObject("rating");
        Rating rate = new Rating();
        rate.setMax(rating.getInt("max"));
        rate.setNumRaters(rating.getInt("numRaters"));
        rate.setAverage(rating.getDouble("average"));
        rate.setMin(rating.getInt("min"));
        b.setRating(rate);
        
        org.json.JSONArray tags = book.getJSONArray("tags");
        List<Tag> ts = new ArrayList<Tag>();
        for(int i = 0; i<tags.length(); i++)
        {
        	JSONObject tag = tags.getJSONObject(i);
        	Tag t = new Tag();
        	t.setCount(tag.getInt("count"));
        	t.setName(tag.getString("name"));
        	ts.add(t);
        }
        b.setTags(ts);
        
        org.json.JSONArray authors = book.getJSONArray("author");
        List<String> as = new ArrayList<String>();
        for(int i = 0; i<authors.length(); i++)
        {
        	String a = authors.getString(i);
        	as.add(a);
        }
        b.setAuthor(as);
        
        org.json.JSONArray translators = book.getJSONArray("translator");
        List<String> trs = new ArrayList<String>();
        for(int i = 0; i<translators.length(); i++)
        {
        	String t = translators.getString(i);
        	trs.add(t);
        }
        b.setTranslator(trs);
        
        JSONObject images = book.getJSONObject("images");
        b.setImage_url(images.getString("large"));
        
        b.setId(book.getInt("id"));
        b.setIsbn10(book.getString("isbn10"));
        b.setIsbn13(book.getString("isbn13"));
        b.setTitle(book.getString("title"));
        b.setOrigin_title(book.getString("origin_title"));
        b.setAlt_title(book.getString("alt_title"));
        b.setSubtitle(book.getString("subtitle"));
        b.setUrl(book.getString("url"));
        b.setAlt(book.getString("alt"));
        b.setPublisher(book.getString("publisher"));
        b.setPubdate(book.getString("pubdate"));
        b.setBinding(book.getString("binding"));
        b.setPrice(book.getString("price"));
        b.setPages(book.getInt("pages"));
        b.setAuthor_intro(book.getString("author_intro"));
        b.setSummary(book.getString("summary"));
        
        return b;
	}

}

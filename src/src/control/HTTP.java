package control;

import java.net.*;
import java.io.*;

public class HTTP
{	
	protected URL target;
	private int responseCode=-1;
	private String responseMessage="";
	private HttpURLConnection connection;
	private BufferedReader reader;
	
	public HTTP() { }
	public HTTP(String url)
	{
		GET(url) ;
	}
	
	/* GET��������URL���������ļ������ݿ��ѯ������������н���ȶ������� */
	public String GET(String url)
	{
		try
		{	target = new URL(url);
			connection = (HttpURLConnection) target.openConnection();
			connection.connect();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			responseMessage = reader.readLine();
			reader.close();
			connection.disconnect();
			return responseMessage;
		}
		catch(ProtocolException p)
		{
			p.printStackTrace();
			return null;
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return null;
		}
	}

	/*
	* POST��������������������ݣ��Ա������������Ӧ�Ĵ���������ҳ�ϳ��õ�
	* �ύ���
	*/
	public String POST(String url,String content)
	{
		try
		{
			target = new URL(url);
			connection = (HttpURLConnection) target.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			content = URLEncoder.encode(content, "utf-8");
			out.writeBytes(content); 
			out.flush();
			out.close();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			responseMessage = reader.readLine();
			reader.close();
			connection.disconnect();
			return responseMessage;

		}
		catch(ProtocolException p)
		{
			p.printStackTrace();
			return null;
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return null;
		}
	}

}
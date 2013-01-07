package control;

import entity.Book;

public class Test {
	public static void main(String[] args)
	{
		Service s = new Service();
		Book b = s.getBookByID(1003078);
		//b.getInfo();
                System.out.print(b.getAuthorString());
	}

}

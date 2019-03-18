package test;

import java.io.*;//�����
import javax.servlet.*;//����
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;//���󿡼� ��� ������ ��û(���,��������)


/**
 * Servlet implementation class SimpleController
 */
@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
    //�ܺο��� ���� ȣ��X ���ο��� ó�����ִ� �޼��� �ۼ�->private
	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			                                    throws ServletException, IOException {
		//1.��û��ɾ �Է¹޾Ƽ� �м�
		String type=request.getParameter("type");
		System.out.println("type=>"+type);
		//2.greeting=>�ȳ��ϼ���, date->���� ��¥ ���  x->invalid Type ȭ�鿡 ���
		//2.��û��ɾ ���� ��û����� ����->��ûó�� Ŭ������ü�� ����->ó��
		Object resultObject=null;//String or java.util.Date �Ѵ� �� ������ �������ڷ���
		//if(type.equals(null)
		if(type==null || type.equals("greeting")) {
			resultObject="�ȳ��ϼ���!!!";
		}else if(type.contentEquals("date")) { //equals->contentEquals()�� ������ ���
			resultObject=new java.util.Date();
		}else {  //greeting or date���� �ٸ� �Ű��������� ���� ������
			resultObject="Invalid Type!!!";
		}
		//3.ó�����->simpleview.jsp�� ����=>ȭ�鿡 ���
		request.setAttribute("result", resultObject);
		
		//4.forward �׼��±׸� ���X->forward�����ִ� ��ü�� �ʿ�(RequestDispatcher��ü)
		//dispatcher->�����͸� �����޾Ƽ� �̵��� �������� ������ ������ü
		RequestDispatcher dispatcher=request.getRequestDispatcher("/simpleview.jsp");
		//5.forward->�����͸� ������Ű�鼭 ������ �̵�
		dispatcher.forward(request, response);
	}
}







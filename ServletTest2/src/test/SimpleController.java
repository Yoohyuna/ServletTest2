package test;

import java.io.*;//입출력
import javax.servlet.*;//서블릿
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;//웹상에서 어떻게 서블릿을 요청(경로,프로토콜)


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
    //외부에서 직접 호출X 내부에서 처리해주는 메서드 작성->private
	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			                                    throws ServletException, IOException {
		//1.요청명령어를 입력받아서 분석
		String type=request.getParameter("type");
		System.out.println("type=>"+type);
		//2.greeting=>안녕하세요, date->오늘 날짜 출력  x->invalid Type 화면에 출력
		//2.요청명령어에 따른 요청기능을 구현->요청처리 클래스객체를 생성->처리
		Object resultObject=null;//String or java.util.Date 둘다 다 저장이 가능한자료형
		//if(type.equals(null)
		if(type==null || type.equals("greeting")) {
			resultObject="안녕하세요!!!";
		}else if(type.contentEquals("date")) { //equals->contentEquals()와 동일한 기능
			resultObject=new java.util.Date();
		}else {  //greeting or date외의 다른 매개변수값을 전달 받으면
			resultObject="Invalid Type!!!";
		}
		//3.처리결과->simpleview.jsp로 전송=>화면에 출력
		request.setAttribute("result", resultObject);
		
		//4.forward 액션태그를 사용X->forward시켜주는 객체가 필요(RequestDispatcher객체)
		//dispatcher->데이터를 공유받아서 이동할 페이지의 정보를 가진객체
		RequestDispatcher dispatcher=request.getRequestDispatcher("/simpleview.jsp");
		//5.forward->데이터를 공유시키면서 페이지 이동
		dispatcher.forward(request, response);
	}
}







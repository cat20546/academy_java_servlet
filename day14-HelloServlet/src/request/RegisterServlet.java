package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/regist")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1. 서버의 리소스 요청을위해서 사용
	 * 2. 등록화면 요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqd = request.getRequestDispatcher("registForm");
	
		// request 한글
		request.setCharacterEncoding("utf-8");
		
		reqd.forward(request, response);
	}

	/**
	 * 1. 사용자 데이터를 서버로 전송하기 위해서 사용
	 * 2. 폼에서 발생한 데이터를 처리하기 위해 사용
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 3.<form>에서 넘어온 파라미터 추출
		// (1)<input>의 name이 유일한 경우 일반적으로 1개의 String변수로 받는다
		String username = request.getParameter("username");
		// (2)<input>동일한name이 두개이상 전달될 경우 String[] 변수로 받는다.
		String[] hobbies = request.getParameterValues("hobby");
		String password = request.getParameter("password");
				

		// 4. 출력
		// (1) 기본 : sysout 출력
		System.out.println("등록된 사용자 이름:" + username);
		System.out.println("등록된 비밀번호:" + password);
		if (hobbies != null){
		for (String hobby : hobbies) {
		}
		}else {
			System.out.println();
		}
		System.out.println("==============================");

		// (2) 브라우저 출력 : PrintWriter 객체 출력
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("등록된 사용자 이름:" + username + "<br>/");
		out.println("등록된 사용자 비밀번호:" + password + "<br>/");
		
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.println("등록된 취미:" + hobby + "<br>/");
			}
		} else {
			out.println("등록된 취미가 존재하지 않습니다. <br/>");
		// 체크박스 구현시 null값 고려
	}
		out.println("</BDOY></HTML>");
		out.close();
	}
	}



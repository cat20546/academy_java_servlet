package parameter.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 02_hobby.html에서 발생하는 POST요청을 처리하는 서블릿
 */
@WebServlet("/hobby")
public class HobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 3.<form>에서 넘어온 파라미터 추출
		// (1)<input>의 name이 유일한 경우 일반적으로 1개의 String변수로 받는다
		String username = request.getParameter("username");
		// (2)<input>동일한name이 두개이상 전달될 경우 String[] 변수로 받는다.
		String[] hobbies = request.getParameterValues("hobby");

		// 4. 출력
		// (1) 기본 : sysout 출력
		System.out.println("등록된 사용자 이름:" + username);
		if (hobbies != null){
		for (String hobby : hobbies) {
			System.out.println("등록된 취미:" + hobby);
		}
		}else {
			System.out.println();
		}
		System.out.println("==============================");

		// (2) 브라우저 출력 : PrintWriter 객체 출력
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("등록된 사용자 이름:" + username + "<br>/");
		
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.println("등록된 취미:" + hobby + "<br>/");
			}
		} else {
			out.println("등록된 취미가 존재하지 않습니다. <br/>");
		
	}
		out.println("</BDOY></HTML>");
		out.close();
	}
}


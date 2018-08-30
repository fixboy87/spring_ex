package kosta.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect //공통관심사항의 역할을 하기 위한 어노테이션
public class SessionAspect {
	
	//public의 return형은 상관 없이 kosta.controller 패키지에 있고
	@Around("execution(public * kosta.controller.*.*exe(..))")
	public String sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable	{
		Object[] obj = joinPoint.getArgs(); //joinPoint의 모든 객체를 가지고 올 수 있다. 그리고 HttpServletRequest 객체만이 담겨 있으므로
		HttpServletRequest request = (HttpServletRequest)obj[0]; //첫번째의 파라미터 값을 가지고 온다.
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		
		String view = "session/session_fail";
		
		try {
			if(name == null) {
				throw new Exception("no session");
			}
			
			view = (String)joinPoint.proceed(); //*****session_exe() = 핵심관심사항의 호출
			
		} catch (Exception e) {
			return view;
		}
		return view;
	}
}

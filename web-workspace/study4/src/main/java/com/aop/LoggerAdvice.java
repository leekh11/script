package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAdvice {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// before, after,..  joinPoint 
	// around : ProcedingJoinPoint  
	
	// getSignature : 대상 메서드 정보를 파악
	// getTarget : 대상 클래스 정보 
	// getArgs() : 넘겨진 파라미터 정보 파악	
	
	public void logging(JoinPoint joinPoint) {
		String clsName = joinPoint.getTarget().getClass().getSimpleName();
		@SuppressWarnings("unused")
		String methodName = joinPoint.getSignature().getName();
		Object[] objs = joinPoint.getArgs();
		for(Object o : objs) {
			System.out.println(clsName + " arg=" + o);
			// logger.debug("{} arg={}" , clsName , o);			
//			if(o instanceof List<?>) {
//				
//			}else if(o instanceof Map<?, ?>) {
//				
//			}else {
//				
//			}
		}		
	}
	
	// around 용 시간 체크 
  // around : ProcedingJoinPoint  
	public Object timeCheck(ProceedingJoinPoint joinPoint) throws Exception {
		String clsName = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		@SuppressWarnings("unused")
		Object[] objs = joinPoint.getArgs();
		long stTime = System.currentTimeMillis();
		Object[] args = joinPoint.getArgs();
		Object ret = null;
		try {
			System.out.println("args=" + args);
			ret = joinPoint.proceed(); // 해당 핵심클래스의 메서드 실행
			// System.out.println("ret=" + ret);			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(clsName + "." + methodName + " 실행시간 " 
		                  + (System.currentTimeMillis() - stTime));
		return ret;
	}
	
	
	
}


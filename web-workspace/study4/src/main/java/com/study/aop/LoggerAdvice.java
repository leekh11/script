package com.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAdvice {
	
	@Pointcut("execution( public * com.aop.*.add(..))")
	private void dummyPointcut() {
		
	}
	
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	
	@Around(value="dummyPointcut()")
	public void logging(JoinPoint joinPoint) {
		String clsName = joinPoint.getTarget().getClass().getSimpleName();
		@SuppressWarnings("unused")
		String methodName = joinPoint.getSignature().getName();
		Object[] objs = joinPoint.getArgs();
		for(Object o : objs) {
			logger.debug("clsName={}.{}", clsName,methodName, o);

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


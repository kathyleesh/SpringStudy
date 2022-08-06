package hello.practicespring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/*
AOP: Aspect Oriented Programming
공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리
*/
@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.practicespring..*(..))") //설정하고 싶은 범위를 경로로 정함
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}

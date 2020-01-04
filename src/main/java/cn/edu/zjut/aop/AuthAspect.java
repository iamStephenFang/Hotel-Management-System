package cn.edu.zjut.aop;

import com.opensymphony.xwork2.ActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class AuthAspect {
    @Pointcut("execution(* cn.edu.zjut.action.RoomAction.*(..))")
    public void roomActionPointCut() { }

    @Pointcut("execution(* cn.edu.zjut.action.RoomTypeAction.*(..))")
    public void roomTypeActionPointCut() { }

    @Pointcut("execution(* cn.edu.zjut.action.MemberAction.*(..))")
    public void memberActionPointCut() { }

    @Pointcut("execution(* cn.edu.zjut.action.WaiterAction.*(..))")
    public void waiterActionPointCut() { }

    @Pointcut("execution(* cn.edu.zjut.action.RegisterAction.*(..))")
    public void registerActionPointCut() { }

    @Around(value = "roomActionPointCut() || roomTypeActionPointCut() " +
            "|| memberActionPointCut() || waiterActionPointCut()" +
            "|| registerActionPointCut()")
    public Object authCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("正在执行AuthAspect的authCheck方法...");
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Integer choice = (Integer) session.get("choice");
        if (choice == 2) {
            return joinPoint.proceed();
        }
        else {
            System.out.println("权限不足！");
            return "authCheckFail";
        }
    }
}

package bitcamp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 서블릿컨테이너 ===> ServletContainerInitializer.onStartup() 호출
//                      = SpringServletContainerInitializer
//                           ===> WebApplicationInitializer.onStartup() 호출
//                                = WebApplicationInitializer
public class App2WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener의 IoC 컨테이너가 사용할 Java Config 클래스 리턴
    // 이미 IoC 컨테이너가 사용할 Java Config 클래스를 리턴했기 때문에 여기에서 null 리턴해도 됨
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // TODO Auto-generated method stub
    return new Class<?>[] {App2Config.class};
  }

  @Override
  protected String[] getServletMappings() {
    // DispatcherServlet에 대해 URL 매핑 정보를 리턴한다.
    return new String[] { "/app2/*" };
  }

  @Override
  protected String getServletName() {
    // DispatcherServlet의 이름을 리턴한다.
    return "app2"; // xml에서 설정했던 이름
  }
}

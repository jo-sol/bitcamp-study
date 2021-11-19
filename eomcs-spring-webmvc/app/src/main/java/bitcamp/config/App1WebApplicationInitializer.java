package bitcamp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 서블릿컨테이너 ===> ServletContainerInitializer.onStartup() 호출
//                      = SpringServletContainerInitializer
//                           ===> WebApplicationInitializer.onStartup() 호출
//                                = WebApplicationInitializer
public class App1WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  // AbstractDispatcherServletInitializer 클래스에서
  // 이미 DispatcherServlet 객체를 생성하여 등록했다.
  // 따라서 이 클래스를 상속 받는 서브 클래스에서 해야 할 일은
  // 1) ContextLoaderlistener가 사용할 IoC 컨테이너를 설정한다.
  //    => createRootApplicationContext() 메서드 오버라이딩.
  // 2) DispatcherServlet이 사용할 IoC 컨테이너를 설정한다.
  //    => createServletApplicationContext() 메서드 오버라이딩
  // 3) DispatcherServlet에 적용할 URL 매핑을 설정한다.
  //    => getServletMappings() 메서드 오버라이딩

  // 다음 메서드도 수퍼 클래스에서 이미 오버라이딩 했다.
  // 따라서 Java Config 클래스만 리턴하면 된다.
  //  @Override
  //  protected WebApplicationContext createRootApplicationContext() {
  //    // ContextLoaderListener가 사용할 IoC 컨테이너를 설정하고 싶지 않다면 그냥 null을 리턴한다.
  //    return null;
  //  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener의 IoC 컨테이너가 사용할 Java Config 클래스 리턴
    return new Class<?>[] {RootConfig.class};
  }

  // 다음 메서드는 수퍼 클래스에서 이미 설정했다
  // 따라서 서브 클래스에서 오버라이딩 할 필요가 없다.
  //  @Override
  //  protected WebApplicationContext createServletApplicationContext() {
  //    // DispatcherServlet에서 사용할 IoC 컨테이너를 리턴한다.
  //    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
  //    context.register(AppConfig.class);
  //    return context;
  //  }

  // 대신 AnnotiationConfigWebApplicationContext가 사용할 Java Config 클래스만 알려줘라!

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // TODO Auto-generated method stub
    return new Class<?>[] {App1Config.class};
  }

  @Override
  protected String[] getServletMappings() {
    // DispatcherServlet에 대해 URL 매핑 정보를 리턴한다.
    return new String[] { "/app1/*" };
  }

  @Override
  protected String getServletName() {
    // DispatcherServlet의 이름을 리턴한다.
    return "app1"; // xml에서 설정했던 이름
  }
}

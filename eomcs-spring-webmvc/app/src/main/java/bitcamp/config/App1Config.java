package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "bitcamp.web.app1") // app 밑에 있는 페이지만 뒤져라, 제외할 페이지는 없다.

public class App1Config {

}

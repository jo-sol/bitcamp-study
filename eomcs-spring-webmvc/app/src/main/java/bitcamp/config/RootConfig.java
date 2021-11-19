package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    basePackages = "bitcamp",
    excludeFilters = {
        @Filter(type = FilterType.REGEX, pattern = "bitcamp.web.*") // bitcamp를 제외한 모든 페이지는 포함시키지 마라
    })

public class RootConfig {

}

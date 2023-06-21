package top.hubby.fc.common.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author T04856 <br>
 * @create 2023-06-19 10:14 AM <br>
 * @project yun-fc-starter <br>
 */
@Slf4j
@Configuration
public class HttpRequestTraceConfiguration {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        OrderHubRequestLoggingFilter orderHubRequestLoggingFilter =
                new OrderHubRequestLoggingFilter();
        orderHubRequestLoggingFilter.setIncludeHeaders(true);
        orderHubRequestLoggingFilter.setIncludeClientInfo(true);
        orderHubRequestLoggingFilter.setIncludeQueryString(true);
        orderHubRequestLoggingFilter.setIncludePayload(false);
        return orderHubRequestLoggingFilter;
    }

    public static class OrderHubRequestLoggingFilter extends CommonsRequestLoggingFilter {

        @Override
        protected boolean shouldLog(HttpServletRequest request) {
            return true;
        }

        @Override
        protected void beforeRequest(HttpServletRequest request, String message) {
            log.info(" before request, " + message);
        }

        @Override
        protected void afterRequest(HttpServletRequest request, String message) {
            log.info("after request, " + message);
        }
    }
}

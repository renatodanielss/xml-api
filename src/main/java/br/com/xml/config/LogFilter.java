package br.com.xml.config;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class LogFilter extends OncePerRequestFilter {

    private List<String> excludedUrls = List.of("swagger", "api-docs");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        for (int i = 0; i < excludedUrls.size(); i++) {
            String excludedUrl = excludedUrls.get(i);
            if (request.getRequestURI().contains(excludedUrl)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        filterChain.doFilter(requestWrapper, response);
        String requestUrl = String.format("Request URL: %s %s%s", request.getMethod(), request.getRequestURI(), request.getQueryString() != null ? "?" + request.getQueryString() : "");
        String payload = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        int statusCode = response.getStatus();
        String statusReason = HttpStatus.valueOf(statusCode).getReasonPhrase();

        logger.debug(requestUrl);
        if (payload != null && !payload.isEmpty()) {
            logger.debug(String.format("%s - Payload = %s", requestUrl, payload));
        }
        logger.debug(String.format("%s - Status code: %d - %s\n", requestUrl, statusCode, statusReason));
    }
}
package com.dapenbi.dkpp.handler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EventSendingAuthenticationFailureHandler
        extends SimpleUrlAuthenticationFailureHandler
        implements ApplicationEventPublisherAware {

    protected ApplicationEventPublisher eventPublisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request,
                                 javax.servlet.http.HttpServletResponse response,
                                 AuthenticationException exception)
            throws IOException,
            javax.servlet.ServletException {
        eventPublisher.publishEvent(AuthenticationFailureBadCredentialsEvent.class);
        super.onAuthenticationFailure(request, response, exception);
    }
}

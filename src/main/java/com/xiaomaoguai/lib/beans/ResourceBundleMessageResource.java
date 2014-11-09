package com.xiaomaoguai.lib.beans;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import com.xiaomaoguai.lib.core.i18n.MessageResource;

/*
 * @Description :
 * @FileName: ResourceBundleMessageResource.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午1:51:09
 * @Version:1.0.0
 */
public class ResourceBundleMessageResource implements MessageSource {

    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String message = MessageResource.getInstance().getMessage(code, locale, args);
        message = message == null ? defaultMessage : message;
        return message;
    }

    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        String message = MessageResource.getInstance().getMessage(code, locale, args);
        return message;
    }

    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        String[] codes = resolvable.getCodes();
        Object[] args = resolvable.getArguments();
        String defaultMessage = resolvable.getDefaultMessage();
        for(String code : codes) {
            String message = getMessage(code, args, locale);
            if(message != null) {
                return message;
            }
        }
        return defaultMessage;
    }

}

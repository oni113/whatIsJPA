package jpabasic.reserve.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoUserException extends RuntimeException {
    private static Logger logger = LoggerFactory.getLogger(NoUserException.class);
}

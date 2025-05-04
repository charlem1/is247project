package com.club.service;
/**
 * Custom exception to indicate that a user has not met the minimum age requirement
 * for a specific service or entry.
 * <p>
 * This exception is typically thrown when a person attempts to access a service
 * or area restricted by age, such as a club requiring patrons to be 21+.
 * </p>
 * 
 * @author 
 */
public class AgeRestrictionException extends Exception {
    /**
     * Constructs a new AgeRestrictionException with the specified detail message.
     *
     * @param msg the detail message explaining the reason for the exception
     */
    public AgeRestrictionException(String msg) {
        super(msg);
    }
}

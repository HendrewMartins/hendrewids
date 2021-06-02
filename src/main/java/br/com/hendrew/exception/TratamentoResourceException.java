package br.com.hendrew.exception;

public class TratamentoResourceException extends Exception {

	private static final long serialVersionUID = -7855946603645932656L;

	public TratamentoResourceException() {
	    super();
	  }

	public TratamentoResourceException(String message, Throwable cause, boolean enableSuppression,
	      boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }

	public TratamentoResourceException(String message, Throwable cause) {
	    super(message, cause);
	  }

	public TratamentoResourceException(String message) {
	    super(message);
	  }

	public TratamentoResourceException(Throwable cause) {
	    super(cause);
	  }

}

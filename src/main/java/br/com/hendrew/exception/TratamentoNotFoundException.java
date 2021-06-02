package br.com.hendrew.exception;

public class TratamentoNotFoundException extends Exception {

	private static final long serialVersionUID = 1362808202128797459L;

	public TratamentoNotFoundException() {
		    super();
		  }

	public TratamentoNotFoundException(String message, Throwable cause, boolean enableSuppression,
		      boolean writableStackTrace) {
		    super(message, cause, enableSuppression, writableStackTrace);
		  }

	public TratamentoNotFoundException(String message, Throwable cause) {
		    super(message, cause);
		  }

	public TratamentoNotFoundException(String message) {
		    super(message);
		  }

	public TratamentoNotFoundException(Throwable cause) {
		    super(cause);
		  }

}
